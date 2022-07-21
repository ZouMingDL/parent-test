package com.trans.controller;

import com.trans.until.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("v1/trans")
public class TransTestController {

    @Value("${server.port}")
    private Integer port;

    @Value("${config.test}")
    private String test;

    @GetMapping("/test")
    public R test() throws Exception{

        return R.success(test);
    }
}
