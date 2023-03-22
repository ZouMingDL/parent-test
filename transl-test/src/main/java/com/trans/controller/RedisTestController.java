package com.trans.controller;

import com.trans.entity.Student;
import com.trans.service.IRedisTestService;
import com.trans.service.IStudentService;
import com.trans.until.R;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ZouJiaJun
 * @Title: RedisTestController
 * @Package: com.trans.controller
 * @Description:
 * @Date: 2022/12/7 - 16:57
 */
@Api(tags = "redis测试模块")
@RestController
@RequestMapping("v1/redis")
public class RedisTestController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/getById/{id}")
    public R getById(@PathVariable("id") String id){
        Student student = studentService.getFormRedis(id);
        return R.success(student);
    }
}
