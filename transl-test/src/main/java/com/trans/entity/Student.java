package com.trans.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openjdk.jol.info.ClassLayout;

import java.io.Serializable;

/**
 * @author ZouMing
 */
@Data
@TableName(value = "student")
public class Student implements Serializable {

    @TableId
    private Integer stuId;

    private String name;

    private Integer age;

    private Integer classId;

    private String sex;
}
