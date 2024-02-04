package com.trans.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: ZouJiaJun
 * @Title: ThreadConfig
 * @Package: com.trans.thread
 * @Description:
 * @Date: 2023/12/5 - 10:56
 */
@Configuration
@Slf4j
public class ThreadTestConfig {

    private static final Integer CORE_POOL_SIZE = 5;
    private static final Integer MAX_POOL_SIZE = 50;
    private static final Integer QUEUE_CAPACITY = 50;

    @Bean(destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor textProcessExecutor(){
        log.info("当前主机CPU个数:{}",Runtime.getRuntime().availableProcessors());
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.setThreadNamePrefix("textProcess-thread-");
        //拒绝策略,交给主线程处理
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
