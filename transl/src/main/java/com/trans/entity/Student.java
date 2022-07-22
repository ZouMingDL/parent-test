package com.trans.entity;

import lombok.Data;
import org.openjdk.jol.info.ClassLayout;

import java.io.Serializable;

/**
 * @author ZouMing
 */
@Data
public class Student implements Serializable {

    private int id;

    private String name;

    private Integer age;

    private Integer classId;
}
