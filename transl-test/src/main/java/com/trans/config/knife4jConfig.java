package com.trans.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.List;

/**
 * @Author: ZouJiaJun
 * @Title: knife4jConfig
 * @Package: com.trans.config
 * @Description:
 * @Date: 2022/12/7 - 16:43
 */
@Configuration
@EnableKnife4j
@EnableSwagger2WebMvc
@Import(BeanValidatorPluginsConfiguration.class)
public class knife4jConfig {

    @Value("${server.port}")
    private String port;

    @Bean("contractApi")
    public Docket contractApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("邹佳骏测试-v1.0.0")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.trans.controller"))
                .paths(PathSelectors.any())
                .build();

    }


    private ApiInfo apiInfo() {
        Contact c = new Contact("邹佳骏", "https://github.com/ZouMingDL/parent-test", "ming_zoudl@163.com");
        String url = String.format("http://localhost:%s/", port);
        return new ApiInfoBuilder()
                .title("邹佳骏测试项目")
                .description("邹佳骏测试项目接口文档")
                .termsOfServiceUrl(url)
                .contact(c)
                .version("1.0")
                .build();
    }


    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }
}
