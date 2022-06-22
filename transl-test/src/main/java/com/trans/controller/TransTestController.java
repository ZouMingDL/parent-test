package com.trans.controller;

import com.trans.until.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/trans")
public class TransTestController {

    @GetMapping("/test")
    public R test() throws Exception{
        int a = 2;
        int b = 0;
        int c= a/b;
        return R.success(c);
    }
}
