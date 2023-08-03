package com.trans.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trans.entity.OrderPay;
import com.trans.until.R;

/**
 * @Author: ZouJiaJun
 * @Title: IOrderService
 * @Package: com.trans.service
 * @Description:
 * @Date: 2023/8/3 - 12:10
 */

public interface IOrderPayService extends IService<OrderPay> {
    R testLockOther(String skuId);
}
