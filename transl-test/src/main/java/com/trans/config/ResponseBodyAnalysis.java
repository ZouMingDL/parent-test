package com.trans.config;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.trans.entity.Student;
import com.trans.until.R;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

/**
 * @Author: ZouJiaJun
 * @Title: ResponseBodyAnalysis
 * @Package: com.trans.config
 * @Description:
 * @Date: 2023/1/16 - 15:06
 */
@ControllerAdvice
public class ResponseBodyAnalysis implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if(body instanceof R){
            R result = (R) body;
            Object data = result.getData();
            Field[] fields = ReflectUtil.getFields(data.getClass());
            for (Field field: fields) {
                TableId annotation = field.getAnnotation(TableId.class);
                if(annotation == null){
                    System.out.println(field.getName()+":"+false);
                }else {
                    System.out.println(field.getName()+":"+true);
                }
            }
        }

        return body;
    }


}
