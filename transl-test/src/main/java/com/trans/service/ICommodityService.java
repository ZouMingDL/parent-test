package com.trans.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trans.entity.Commodity;
import com.trans.entity.Student;
import com.trans.until.R;

/**
 * @Author: ZouJiaJun
 * @Title: ICommodityService
 * @Package: com.trans.service
 * @Description:
 * @Date: 2023/8/3 - 12:09
 */

public interface ICommodityService extends IService<Commodity> {
    R testLock(String skuId);

    R testLockOther(String skuId);
}
