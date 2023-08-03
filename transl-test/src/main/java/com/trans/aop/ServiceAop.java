package com.trans.aop;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ZouJiaJun
 * @Title: ServiceAop
 * @Package: com.trans.aop
 * @Description:
 * @Date: 2023/8/3 - 10:42
 */
@Aspect
@Slf4j
@Component
@AllArgsConstructor
@Order(1)
public class ServiceAop {

    private static ReentrantLock lock = new ReentrantLock() ;

    @Around("@annotation(ServiceLock)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;
        lock.lock();
        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally{
            lock.unlock();
        }
        return obj;
    }
}

