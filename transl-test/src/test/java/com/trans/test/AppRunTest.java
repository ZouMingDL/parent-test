package com.trans.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppRunTest {

    @Test
    public void test01(){
        System.out.println(get());
    }

    public String get(){
        String str ;
        try {
            str = "1";
        }catch (Exception e){
            str = "2";
            return str;
        }
        return str;
    }
}
