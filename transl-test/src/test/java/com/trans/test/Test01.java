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
        String str1 = new String("str")+new String("01");
        str1.intern();
        String str01 = new String("str01");
        String str2 = "str01";
        System.out.println(str2==str1);
        System.out.println(str01==str2);
    }

    @Test
    public void test04(){
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc"); //不走常量池
        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
    }
}
