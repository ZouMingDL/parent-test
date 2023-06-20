package com.trans.common;

import io.swagger.models.auth.In;

/**
 * @Author: ZouJiaJun
 * @Title: User
 * @Package: com.trans.common
 * @Description:
 * @Date: 2023/6/20 - 10:42
 */

public class User {

    private Integer age;

    private String name;

    private User(){

    }

    private User(Integer age,String name){
        this.age = age;
        this.name = name;
    }

    static enum UserEnum{

        INSTANCE;

        private User user;

        private UserEnum(){
            user = new User(1,"张飒");
        }

        public User getInstnce(){
            return user;
        }
    }

    //对外暴露一个获取User对象的静态方法
    public static User getInstance(){
        return UserEnum.INSTANCE.getInstnce();
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(User.getInstance());
    }
}
