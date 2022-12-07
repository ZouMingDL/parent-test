package com.trans.test;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.trans.dto.TestDTO;
import com.trans.entity.Student;
import com.trans.until.ChineseUntil;
import com.trans.until.TwoPhaseTermination;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ZouJiaJun
 * @Title: Test01
 * @Package: com.trans.test
 * @Description:
 * @Date: 2022/6/22 - 16:05
 */

@SpringBootTest
@Slf4j
public class Test01 {

    @Test
    public void test(){
        Integer a = new Integer(2);
        Integer b = 2;
        log.error("a==?{}",a==b);
        log.error("a.equals(b)?{}",a.equals(b));
        //System.out.println(a.equals(b));
    }

    @Test
    public void test01(){
        int a= 15;
        int b = 015;
        int c = 0xAB;
        System.out.println(a);
        System.out.println(c);
    }

    @Test
    public void test02(){
        int a = 2147483647;
        int b = 1;
        int c = a+b;
        System.out.println(c);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    @Test
    public void test03(){
        String str1 = new String("str")+new String("01");
        str1.intern();
        String str01 = new String("str01");
        String str2 = "str01";
        System.out.println(str2==str1);
        System.out.println(str01==str2);
    }

    @Test
    public void test04(){
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc"); //不走常量池
        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
    }

    @Test
    public void test05(){
        String phone = "17713419875";
        String id = "511621199607222176";
        String s = DesensitizedUtil.mobilePhone(phone);
        String s1 = DesensitizedUtil.idCardNum(id, 1, 1);
        System.out.println(s);
        System.out.println(s1);
    }

    @Test
    public void test06(){
        Calendar instance = Calendar.getInstance();
        Date date = new Date();
        instance.setTime(date);
        System.out.println(DateUtil.formatDateTime(date));
        instance.add(Calendar.HOUR,72);
        System.out.println("sa：" + instance.getTime());
        String s = DateUtil.formatDateTime(instance.getTime());
        System.out.println(s);
    }
    @Test
    public void test07(){
        BigDecimal bigDecimal = new BigDecimal(0.01);
        int i = bigDecimal.compareTo(new BigDecimal(BigInteger.ZERO));
        System.out.println(i);
        String url = "https://shigongbang.obs.cn-east-3.myhuaweicloud.com:443/contract%2F20220821616565566855834.jpg";
        String replace = url.replace("%2F", "/");
        System.out.println(replace);
    }

    @Test
    public void test08(){
        Boolean a = false;
        System.out.println(a);
    }



    //查看object对象
//    public static void main(String[] args) {
////        String url = "https://shigongbang.obs.cn-east-3.myhuaweicloud.com:443/contract/20220821616565566855834.jpg";
////        String replace = url.replace("%2F", "/");
////        System.out.println(replace);
////        StringBuilder stringBuilder = new StringBuilder();
////        if(StrUtil.isNotBlank(stringBuilder)){
////            System.out.println(1);
////        }else {
////            System.out.println(2);
////        }
////        int k = 0;
////        for (int i = 0;i<5;i++){
////            if(k == 4){
////                stringBuilder.append("1");
////            }else {
////                stringBuilder.append("1,");
////            }
////            k++;
////        }
////        System.out.println(stringBuilder);
//
//    }
    public static void main(String[] args) throws URISyntaxException {
        System.out.println(getIP(new URI("http://www.baidu.com/system/verList")));
        System.out.println(getIP(new URI("https://gateway.jingyingbang.com/zjkj-contract/v1/contract/signCallBack")));
        System.out.println(getIP(new URI("http://127.0.0.1:9040/system/verList?loginName=1&password=AD07FB25AA2D3A9F96EE12F25E0BE902")));
    }

    private static URI getIP(URI uri) {
        URI effectiveURI = null;
        try {
            effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
        } catch (Throwable var4) {
            effectiveURI = null;
        }
        return effectiveURI;
    }




}
