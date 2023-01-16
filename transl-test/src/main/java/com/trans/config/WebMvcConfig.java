package com.trans.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
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
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Value("${spring.servlet.multipart.location}")
    private String filePath;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!filePath.endsWith(File.separator)) {
            filePath = filePath + File.separator;
        }
        registry.addResourceHandler("/static/upload/**").addResourceLocations("file:" + filePath);
    }


}
