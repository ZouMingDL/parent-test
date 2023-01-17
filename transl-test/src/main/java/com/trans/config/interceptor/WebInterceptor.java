package com.trans.config.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * @Author: ZouJiaJun
 * @Title: WebInterceptor
 * @Package: com.trans.config.interceptor
 * @Description:
 * @Date: 2023/1/16 - 11:51
 */
public class WebInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Locale locale = request.getLocale();
        System.out.println("语言："+locale);
        return true;
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        System.out.println(new Date()+":"+response);
        System.out.println(response.getHeader("data"));
        response.getOutputStream().println();
    }



}
