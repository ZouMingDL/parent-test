package com.trans.entity;

/**
 * @Author: ZouJiaJun
 * @Title: Woman
 * @Package: com.trans.entity
 * @Description:
 * @Date: 2023/2/8 - 10:30
 */

public class Woman {
    private String name = "the woman";

    private Child child;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
