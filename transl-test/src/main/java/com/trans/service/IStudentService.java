package com.trans.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trans.entity.Student;
import com.trans.until.ObsProperties;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

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

    Boolean testLongLink(String stuId) throws ExecutionException, InterruptedException;

    void localHutool(MultipartFile file) throws IOException;
}
