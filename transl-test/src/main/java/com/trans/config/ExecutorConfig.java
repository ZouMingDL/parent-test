package com.trans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: ZouJiaJun
 * @Title: ExecutorConfig
 * @Package: com.trans.config
 * @Description:
 * @Date: 2023/7/7 - 16:53
 */

@Configuration
public class ExecutorConfig {

    @Bean
    public ExecutorService longLinkExecutor(){
        return Executors.newFixedThreadPool(3);
    }
}
