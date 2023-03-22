package com.trans.config;

import com.trans.entity.Child;
import com.trans.entity.Woman;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: ZouJiaJun
 * @Title: Human
 * @Package: com.trans.config
 * @Description:
 * @Date: 2023/2/8 - 10:30
 */

@Component
public class Human {

    @Bean
    public Child getChild(){

        return new Child();
    }

    @Bean
    public Woman getWoman(){
        Woman woman = new Woman();
        woman.setChild(getChild());
        return woman;
    }
}
