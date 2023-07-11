package com.trans.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trans.entity.DistrictCode;
import com.trans.entity.Student;
import com.trans.mapper.DistrictCodeMapper;
import com.trans.mapper.StudentMapper;
import com.trans.service.IDistrictCodeService;
import com.trans.service.IStudentService;
import org.springframework.stereotype.Service;

/**
 * @Author: ZouJiaJun
 * @Title: DistrictCodeServiceImpl
 * @Package: com.trans.service.impl
 * @Description:
 * @Date: 2023/7/10 - 15:25
 */
@Service
public class DistrictCodeServiceImpl extends ServiceImpl<DistrictCodeMapper, DistrictCode> implements IDistrictCodeService {
}
