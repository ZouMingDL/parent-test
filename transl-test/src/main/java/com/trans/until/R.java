package com.trans.until;

import java.io.Serializable;

/**
 * @Author: ZouJiaJun
 * @Title: R
 * @Package: com.trans.until
 * @Description:
 * @Date: 2022/6/21 - 9:58
 */

public class R<T> implements Serializable {
    private static final long serialVersionUID = 3222181463833620638L;
    static final String FAIL = "操作失败";
    static final String SUCCESS = "操作成功";
    static final String OK_STR = "ok";
    static final String FAIL_STR = "fail";
    private String msg = "";
    private int code = 200;
    private Integer errCode;
    private String state = "ok";
    private T data;

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return this.code;






    }

    public void setCode(int code) {
        this.code = code;
    }

    public Integer getErrCode() {
        return this.errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public R() {
    }

    public R(T data) {
        this.data = data;
    }

    public R(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public R(String msg, int code, String state) {
        this.msg = msg;
        this.code = code;
        this.state = state;
    }

    public R(String msg, int code, String state, Integer errCode) {
        this.msg = msg;
        this.code = code;
        this.state = state;
        this.errCode = errCode;
    }

    public static <T> R success() {
        return new R();
    }

    public static <T> R success(T data) {
        return new R(data);
    }

    public static <T> R successMsg(String msg) {
        R r = new R();
        r.setMsg(msg);
        return r;
    }

    public static R fail() {
        return fail("操作失败");
    }

    public static R fail(String msg) {
        return fail(msg, 500, "fail");
    }

    public static R fail(String msg, Integer code) {
        return fail(msg, code, "fail", 539999);
    }

    public static R fail(String msg, Integer code, String state) {
        return fail(msg, code, state, 539999);
    }

    public static R fail(String msg, Integer code, String state, Integer errCode) {
        return new R(msg, code, state, errCode);
    }
}
