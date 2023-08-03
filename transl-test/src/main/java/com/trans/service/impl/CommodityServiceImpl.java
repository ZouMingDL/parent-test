package com.trans.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trans.aop.ServiceLock;
import com.trans.entity.Commodity;
import com.trans.entity.OrderPay;
import com.trans.mapper.CommodityMapper;
import com.trans.mapper.OrderPayMapper;
import com.trans.service.ICommodityService;
import com.trans.until.CustomException;
import com.trans.until.IDUtils;
import com.trans.until.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ZouJiaJun
 * @Title: CommodityServiceImpl
 * @Package: com.trans.service.impl
 * @Description:
 * @Date: 2023/8/3 - 14:11
 */
@Service
@Slf4j
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {


    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private OrderPayMapper orderMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    @ServiceLock
    public R testLock(String skuId) {
        try {
            //检查是否有库存
            Commodity commodity = commodityMapper.selectOne(Wrappers.lambdaQuery(Commodity.class)
                    .eq(Commodity::getSkuId, skuId));
            Integer inventory = commodity.getInventory();
            if (inventory > 0) {
                //模拟修改库存
                commodity.setInventory(inventory - 1);
                commodityMapper.updateById(commodity);
                //模拟插入订单
                OrderPay order = new OrderPay();
                order.setOrderId(IDUtils.genContractNo(1));
                order.setSkuId(skuId);
                order.setStatus(1);
                order.setCreateTime(new Date());
                order.setUserId(Thread.currentThread().getId());
                orderMapper.insert(order);
            } else {
                return R.fail("该商品库存不足！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("请稍后再试！");
        }
        return R.success("下单成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @ServiceLock
    public R testLockOther(String skuId) {
        try {
            //检查是否有库存
            Commodity commodity = commodityMapper.selectOne(Wrappers.lambdaQuery(Commodity.class)
                    .eq(Commodity::getSkuId, skuId));
            Integer inventory = commodity.getInventory();
            if (inventory > 0) {
                //模拟修改库存
                commodity.setInventory(inventory - 1);
                commodityMapper.updateById(commodity);
                //模拟插入订单
                OrderPay order = new OrderPay();
                order.setOrderId(IDUtils.genContractNo(1));
                order.setSkuId(skuId);
                order.setStatus(1);
                order.setCreateTime(new Date());
                order.setUserId(Thread.currentThread().getId());
                orderMapper.insert(order);
            } else {
                return R.fail("该商品库存不足！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("请稍后再试！");
        }
        return R.success("下单成功");
    }
}
