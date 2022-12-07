package com.trans.service.impl;

import com.trans.service.IRedisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: ZouJiaJun
 * @Title: RedisTestServiceImpl
 * @Package: com.trans.service.impl
 * @Description:
 * @Date: 2022/12/7 - 16:59
 */
@Service
public class RedisTestServiceImpl implements IRedisTestService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

}
