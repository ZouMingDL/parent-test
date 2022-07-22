package com.trans.entity;

/**
 * @Author: ZouJiaJun
 * @Title: helloB
 * @Package: com.trans.entity
 * @Description:
 * @Date: 2022/7/5 - 9:39
 */

public class helloB extends helloA{
    public helloB(){
        System.out.println("hello B");
    }
    {
        System.out.println("im b class");
    }
    static {
        System.out.println("static b");
    }

    public static void main(String[] args) {
        System.out.println("start");
        new helloB();
        new helloB();
        System.out.println("end");
    }


}
class helloA{
    public helloA(){
        System.out.println("hello A");
    }
    {
        System.out.println("im a class");
    }
    static {
        System.out.println("static a");
    }
}

