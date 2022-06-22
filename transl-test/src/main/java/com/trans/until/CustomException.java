package com.trans.until;

/**
 * @author zenghaibin
 * @version v1.0.0
 * @Package : net.zhongjunkeji.common.exception
 * @Description : TODO
 * @Create on : 2021/7/7 11:48
 **/
public class CustomException extends RuntimeException {

    private Integer code;

    private Integer errCode;

    public CustomException(){
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Integer code) {
        super(message);
        this.code = code;
    }
    public CustomException(String message, Integer code, Integer errCode) {
        super(message);
        this.code = code;
        this.errCode=errCode;
    }

    public CustomException(String message, Throwable cause){
        super(message,cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }
}