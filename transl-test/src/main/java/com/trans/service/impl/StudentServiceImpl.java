package com.trans.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trans.common.Constant;
import com.trans.entity.Student;
import com.trans.mapper.StudentMapper;
import com.trans.service.IStudentService;
import com.trans.until.ChineseUntil;
import com.trans.until.ObsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: ZouJiaJun
 * @Title: StudentServiceImpl
 * @Package: com.trans.service.impl
 * @Description:
 * @Date: 2022/7/25 - 11:37
 */

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ObsProperties obsProperties;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public Student insertStudent(Integer id) {
        Student max = studentMapper.selectOne(Wrappers.lambdaQuery(Student.class)
                .orderByDesc(Student::getStuId)
                .last("limit 1"));

        Student student = new Student();
        student.setStuId(id < max.getStuId()? max.getStuId()+1:id);
        student.setAge(RandomUtil.randomInt(6,24));
        student.setClassId(2);
        student.setName(ChineseUntil.getRandomChineseName());
        this.save(student);
        return student;
    }

    @Override
    public ObsProperties.OssSecret getObs() {
        ObsProperties.OssSecret huawei = obsProperties.getOss().get(ObsProperties.Type.HUAWEI);
        System.out.println(huawei);
        return huawei;
    }

    @Override
    public Student getFormRedis(String id) {
        String key = Constant.RedisConstant.STUDENT_KEY+id;
        Student student =(Student) redisTemplate.opsForValue().get(key);
        if(ObjectUtil.isEmpty(student)){
            student = studentMapper.selectById(id);
            redisTemplate.opsForValue().set(key,student);
        }
        return student;
    }

    @Override
    public Student updateName(Integer id) {
        Student student = studentMapper.selectById(id);
        if(ObjectUtil.isNotEmpty(student)){
            student.setName(ChineseUntil.getRandomChineseName());
            student.setSex("男");
            studentMapper.updateById(student);
            return student;
        }
        return null;
    }

    @Override
    public List<Student> selectByName(List<String> names) {

        List<Student> students = studentMapper.selectByName(names);
        return students;
    }
}
