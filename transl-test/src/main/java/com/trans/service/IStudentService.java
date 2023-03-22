package com.trans.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trans.entity.Student;
import com.trans.until.ObsProperties;

import java.util.List;

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

    Student getFormRedis(String id);

    Student updateName(Integer id);

    List<Student> selectByName(List<String> names);
}
