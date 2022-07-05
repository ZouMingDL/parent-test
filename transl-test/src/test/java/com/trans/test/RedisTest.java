package com.trans.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ZouJiaJun
 * @Title: RedisTest
 * @Package: com.trans.test
 * @Description:
 * @Date: 2022/7/5 - 10:20
 */

@SpringBootTest
public class RedisTest {

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test01() throws InterruptedException {
        redisTemplate.opsForValue().set("key","*",3, TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().getOperations().getExpire("key"));
        TimeUnit.SECONDS.sleep(3);
        System.out.println(redisTemplate.opsForValue().getOperations().getExpire("key"));
    }
}
