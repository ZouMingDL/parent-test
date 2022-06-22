package com.trans.until;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZouJiaJun
 * @Title: GlobalException
 * @Package: com.trans.until
 * @Description:
 * @Date: 2022/6/21 - 9:57
 */
@ControllerAdvice
@Slf4j
public class GlobalException {
    /**
     * 自定义提示返回
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public R exceptionHandler(Exception e) {
        log.error("系统异常：{}", ExceptionUtil.stacktraceToString(e));
        log.error(e.getMessage());
        if (e instanceof MethodArgumentNotValidException) {
            // 参数异常
            MethodArgumentNotValidException me = (MethodArgumentNotValidException) e;
            List<String> msg = new ArrayList<>();
            for (ObjectError error : me.getBindingResult().getAllErrors()) {
                //获取校验的信息
                msg.add(error.getDefaultMessage());
            }
            return R.fail(StrUtil.join(",",msg));
        } else if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            List<String> msg = new ArrayList<>();
            for (ObjectError error : bindException.getBindingResult().getAllErrors()) {
                //获取校验的信息
                msg.add(error.getDefaultMessage());
            }
            return R.fail(StrUtil.join(",",msg));
        } else if (e instanceof HttpMessageNotReadableException) {
            return R.fail("参数信息有误");
        } else if (e instanceof DataIntegrityViolationException) {
            return R.fail("数据有误请检查");
        } else {
            return R.fail(ExceptionEnum.SYSTEM_EXCEPTION.getValue(), ExceptionEnum.SYSTEM_EXCEPTION.getKey());
        }
    }

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public R customExceptionHandler(CustomException e) {
        String msg = "";
        String state = "fail";
        Integer code = 500;
        Integer errCode = 539999;

        if (null != e.getCode()) {
            code = e.getCode();
        }
        if (null != e.getErrCode()) {
            errCode = e.getErrCode();
        }
        if (StringUtils.isNotBlank(e.getMessage())) {
            msg = e.getMessage();
        }

        return R.fail(msg, code, state, errCode);
    }

}
