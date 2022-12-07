package com.trans.controller;

import com.trans.service.IStudentService;
import com.trans.until.R;
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
public class TransTestController {

    @Autowired
    private IStudentService studentServiceImpl;

    @Value("${server.port}")
    private Integer port;

    @Value("${config.test}")
    private String test;

    @GetMapping("/test/{id}")
    public R test(@PathVariable("id") Integer id) {

        return R.success(studentServiceImpl.insertStudent(id));
    }

    @GetMapping("/test")
    public R test01() {

        return R.success(studentServiceImpl.getObs());
    }
}
