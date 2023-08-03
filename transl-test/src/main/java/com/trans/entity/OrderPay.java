package com.trans.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: ZouJiaJun
 * @Title: Order
 * @Package: com.trans.entity
 * @Description:
 * @Date: 2023/8/3 - 12:05
 */
@Data
@TableName(value = "order_pay")
public class OrderPay implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String orderId;

    private String skuId;

    private Integer status;

    private Long userId;

    private Date createTime;
}
