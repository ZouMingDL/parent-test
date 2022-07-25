package com.trans.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trans.entity.Student;
import com.trans.mapper.StudentMapper;
import com.trans.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: ZouJiaJun
 * @Title: StudentServiceImpl
 * @Package: com.trans.service.impl
 * @Description:
 * @Date: 2022/7/25 - 11:37
 */

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired(required = false)
    private StudentMapper studentMapper;

    @Override
    public Student insertStudent() {
        Student student = Student.builder()
                .id(1)
                .age(25)
                .classId(2)
                .name("张珊")
                .build();
        this.save(student);
        return student;
    }
}
