package com.trans.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZouMing
 */
@Data
public class Student implements Serializable {

    private Integer id;

    private String name;

    private Integer age;

    private Integer classId;
}
