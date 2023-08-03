package com.trans.aop;

import java.lang.annotation.*;

/**
 * @Author: ZouJiaJun
 * @Title: ServiceLock
 * @Package: com.trans.aop
 * @Description:
 * @Date: 2023/8/3 - 10:40
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLock {
}
