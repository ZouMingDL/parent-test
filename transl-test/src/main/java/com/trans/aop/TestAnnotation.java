package com.trans.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: ZouJiaJun
 * @Title: TestAop
 * @Package: com.trans.aop
 * @Description:
 * @Date: 2023/1/16 - 17:06
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {

}
