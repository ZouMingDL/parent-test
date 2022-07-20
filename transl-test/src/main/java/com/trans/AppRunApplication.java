package com.trans;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@EnableDiscoveryClient
@MapperScan("com.trans.mapper.*")
@Slf4j
public class AppRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppRunApplication.class,args);
    }
}
