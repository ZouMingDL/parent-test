package com.trans.test;

import cn.hutool.core.util.StrUtil;
import com.trans.until.CustomException;
import com.trans.until.R;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

import java.util.ArrayList;

@SpringBootTest
public class AppRunTest {

    @Test
    public void test01(){
        String str = "https://shigongbang.oss-cn-hangzhou.aliyuncs.com/member_center/610000/20220514711522514725635.doc";
        str.substring(str.lastIndexOf("."),str.length());
        int i = str.lastIndexOf(".");
        System.out.println(str);
        String tmpdir = System.getProperty("java.io.tmpdir");
        System.out.println(tmpdir);
    }

    @Test
    public void test02(){
        File file = getFile();
        System.out.println(file.getPath());
        System.out.println(file.getName());
    }

    public File getFile(){
        InputStream is = null;
        OutputStream os = null;
        File file = new File("营业执照.jpg");
        File file1 = null;
        try {
            file1 = File.createTempFile("net_url", "dddddd.jpg");
            is = new FileInputStream(file);
            os = new FileOutputStream(file1);
            int bytesRead = -1;
            byte[] buffer = new byte[8192];
            while ((bytesRead = is.read(buffer, 0, buffer.length)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file1;
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