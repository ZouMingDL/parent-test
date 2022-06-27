package com.trans.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: ZouJiaJun
 * @Title: Test01
 * @Package: com.trans.test
 * @Description:
 * @Date: 2022/6/22 - 16:05
 */

@SpringBootTest
@Slf4j
public class Test01 {

    @Test
    public void test(){
        Integer a = new Integer(2);
        Integer b = 2;
        log.error("a==?{}",a==b);
        log.error("a.equals(b)?{}",a.equals(b));
        //System.out.println(a.equals(b));
    }

    @Test
    public void test01(){
        int a= 15;
        int b = 015;
        int c = 0xAB;
        System.out.println(a);
        System.out.println(c);
    }

    @Test
    public void test02(){
        int a = 2147483647;
        int b = 1;
        int c = a+b;
        System.out.println(c);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    @Test
    public void test03(){
        String a = "abc";
        String b = "aba";
        System.out.println(a.compareTo(b));
        System.out.println(a.length());
    }
}
