package com.trans.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: ZouJiaJun
 * @Title: Commodity
 * @Package: com.trans.entity
 * @Description:
 * @Date: 2023/8/3 - 12:03
 */
@Data
@TableName(value = "commodity")
public class Commodity implements Serializable {

    @TableId
    private Integer id;

    private String skuId;

    private String skuName;

    private Integer inventory;
}
