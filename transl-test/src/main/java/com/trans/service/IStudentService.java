package com.trans.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trans.entity.Student;
import com.trans.until.ObsProperties;

/**
 * @Author: ZouJiaJun
 * @Title: StudentService
 * @Package: com.trans.service
 * @Description:
 * @Date: 2022/7/25 - 11:35
 */

public interface IStudentService extends IService<Student> {

    Student insertStudent(Integer id);

    ObsProperties.OssSecret getObs();
}
