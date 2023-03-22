package com.trans.config;

import com.trans.entity.Child;
import com.trans.entity.Woman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: ZouJiaJun
 * @Title: Man
 * @Package: com.trans.config
 * @Description:
 * @Date: 2023/2/8 - 10:32
 */
@Component
public class Man {

    @Autowired
    public Man(Woman woman, Child child){
        System.out.println("==========================配置类=======================");
        System.out.println(woman.getChild() == child?"是同一个对象":"不是同一个对象");
    }
}
