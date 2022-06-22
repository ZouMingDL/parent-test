package com.trans.test;

import cn.hutool.core.util.StrUtil;
import com.trans.until.CustomException;
import com.trans.until.R;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class AppRunTest {

    @Test
    public void test01(){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        String join = StrUtil.join(",", objects);
        System.out.println(join);
    }

    public String get(){
        String str ;
        try {
            str = "1";
        }catch (Exception e){
            str = "2";
            return str;
        }
        return str;
    }

    @Test
    public void testException() throws Exception {
        R r = testXXX();
        System.out.println(r);
    }

    public R testXXX() throws Exception{
        int a = 1;
        int b = 0;

        int c = a/b;

        return R.success();
    }
}
