package com.trans.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: ZouJiaJun
 * @Title: DistrictCode
 * @Package: com.trans.entity
 * @Description:
 * @Date: 2023/7/10 - 15:06
 */
@Data
@TableName("district_code")
public class DistrictCode implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String provinceName;

    private String provinceCode;

    private String cityName;

    private String cityCode;

    private String countryside;

    private String countrysideCode;
}
