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
@Builder
@TableName(value = "student")
public class Student implements Serializable {

    @TableId
    private int id;

    private String name;

    private Integer age;

    private Integer classId;

}
