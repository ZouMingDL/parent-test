package com.trans.aop;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @Author: ZouJiaJun
 * @Title: TestAop
 * @Package: com.trans.aop
 * @Description:
 * @Date: 2023/1/16 - 17:08
 */
@Aspect
@Slf4j
@Component
@AllArgsConstructor
public class TestAop {

    @Around("@annotation(TestAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        System.out.println("args:++++++++++++++++++:"+args[0]);
        String name = joinPoint.getSignature().getName();
        System.out.println("getSignature:"+name);
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        System.out.println("signature.getMethod():"+signature.getMethod());
        Object result = joinPoint.proceed();

        System.out.println("result:"+result);
        return result;
    }
}
