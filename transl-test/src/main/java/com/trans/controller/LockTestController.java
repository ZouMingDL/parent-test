package com.trans.controller;

import com.trans.service.ICommodityService;
import com.trans.service.IOrderPayService;
import com.trans.until.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ZouJiaJun
 * @Title: LockTestController
 * @Package: com.trans.controller
 * @Description:
 * @Date: 2023/8/3 - 14:07
 */
@RestController
@RequestMapping("v1/lock")
@Api(tags = "测试锁")
public class LockTestController {

    @Autowired
    private ICommodityService commodityService;

    @Autowired
    private IOrderPayService orderPayService;


    @GetMapping("/test")
    @ApiOperation("测试锁")
    public R testLock(@RequestParam("skuId") String skuId){

        return commodityService.testLock(skuId);
    }

    @GetMapping("/testOther")
    @ApiOperation("测试锁")
    public R testLockOther(@RequestParam("skuId") String skuId){

        return orderPayService.testLockOther(skuId);
    }
}
