package com.trans.controller;

import com.trans.aop.TestAnnotation;
import com.trans.service.IStudentService;
import com.trans.until.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("v1/trans")
@Api(tags = "测试数据库")
public class TransTestController {

    @Autowired
    private IStudentService studentServiceImpl;

    @Value("${server.port}")
    private Integer port;

    @Value("${config.test}")
    private String test;

    @GetMapping("/test/{id}")
    @ApiOperation("根据ID插入学生信息")
    @TestAnnotation
    public R test(@ApiParam("id编号") @PathVariable("id") Integer id) {

        return R.success(studentServiceImpl.insertStudent(id));
    }

    @GetMapping("/test")
    @ApiOperation("获取OBS信息")
    public R test01() {

        return R.success(studentServiceImpl.getObs());
    }
}
