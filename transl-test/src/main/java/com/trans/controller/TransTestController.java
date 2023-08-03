package com.trans.controller;

import com.trans.aop.TestAnnotation;
import com.trans.entity.Child;
import com.trans.entity.Student;
import com.trans.entity.Woman;
import com.trans.service.IStudentService;
import com.trans.until.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

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

    @Autowired
    Woman woman ;

    @Autowired
    Child child;

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

    @GetMapping("updateName/{id}")
    @ApiOperation("更新名字")
    public R update(@ApiParam("id编号") @PathVariable("id") Integer id){
        return R.success(studentServiceImpl.updateName(id));
    }

    @GetMapping("/log")
    @ApiOperation("测试对象")
    public String log() {
        System.out.println(woman.getChild());
        System.out.println(child);
        return woman.getChild() == child ? "是同一个对象":"不是同一个对象";
    }

    @PostMapping("/selectByName")
    @ApiOperation("多个名字查询")
    public List<Integer> selectByName(@RequestBody List<String> names){
        return studentServiceImpl.seletListByName(names);
    }

    @GetMapping("/longLink/{stuId}")
    @ApiOperation("测试长轮询")
    public Boolean testLongLink(@PathVariable("stuId") String stuId) throws ExecutionException, InterruptedException {
        Boolean a =  studentServiceImpl.testLongLink(stuId);
        return a;
    }
}
