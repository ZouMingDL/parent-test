package com.trans.controller;

import com.trans.until.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/trans")
public class TransTestController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/test")
    public R test() throws Exception{

        return R.success(port);
    }
}
