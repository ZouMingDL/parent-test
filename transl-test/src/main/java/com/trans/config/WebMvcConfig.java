package com.trans.config;

import com.trans.config.interceptor.WebInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * @Author: ZouJiaJun
 * @Title: WebMvcConfig
 * @Package: com.trans.config
 * @Description:
 * @Date: 2023/1/11 - 17:32
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${spring.servlet.multipart.location}")
    private String filePath;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!filePath.endsWith(File.separator)) {
            filePath = filePath + File.separator;
        }
        registry.addResourceHandler("/static/**").addResourceLocations("file:" + filePath);
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new WebInterceptor()).addPathPatterns("/**");

        // 排除配置
        //addInterceptor.excludePathPatterns("/error");
        //addInterceptor.excludePathPatterns("/login**");

        // 拦截配置
        // addInterceptor.addPathPatterns("/**");
    }


}
