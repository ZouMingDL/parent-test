package com.trans.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trans.entity.Commodity;
import com.trans.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ZouJiaJun
 * @Title: CommodityMapper
 * @Package: com.trans.mapper
 * @Description:
 * @Date: 2023/8/3 - 12:07
 */
@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {
}
