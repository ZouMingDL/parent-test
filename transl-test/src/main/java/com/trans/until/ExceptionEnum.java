package com.trans.until;

/**
 * @author zenghaibin
 * @version v1.0.0
 * @Package : net.zhongjunkeji.common.enums
 * @Description :   errCode  格式：ABBXXX
 *                  这种格式：A=1 后端表单校验异常，2 业务操作不满足要求异常，4 权限异常，5 系统异常，6 需退出登录
 *                  BB=各自微服务的编号
 *                  XXX=自己服务的异常码
 * @Create on : 2021/7/7 11:53
 **/
public enum ExceptionEnum {
    //app保持一致 666未登录
    USER_NOT_LOGIN(666,"用户未登录"),
    SYSTEM_EXCEPTION(500,"服务器开小差，请稍后重试！"),

//    验证码相关的都返回 10000
    PARAM_ERROR(539100,"已超过签署截止日期,合同已失效！",539100),
    CONTRACT_EXPIRED(539101,"已超过签署截止日期,合同已失效！",539101),
    CONTRACT_STATUS_CHANGE(539102,"当前合同状态已发生变更",539102),
    CONTRACT_NOT_CONTENT(539103,"当前合同暂无内容\\n请在电脑端编辑后再操作！",539103),
    CONTRACT_SEND_FAIL(539104,"合同发送失败，请重新尝试！",539104),
    CONTRACT_SMS_LIMIT(539105,"已超出今天短信发送条数上限\\n请明天再试！",539105),
    CONTRACT_SMS_REPEAT(539106,"30s之内不能重复发送验证码",539106),
    IS_ADULT(539107,"经办人不设置为未成年人",539107),
    VALIDATE_CODE_ERROR(10000,"验证码错误",539108),
    VALIDATE_CODE_NOT_FIND(10000,"验证码不存在，请获取验证码",539109),
    CONTRACT_OPENED(539110,"当前企业已开户，请勿重复开户！",539110),
    ABNORMAL_PERMISSIONS(539111,"当前用户不能签署此合同",539111),
    OPEN_FAIL(539112,"开户失败",539112),
    OPEN_APPROVAL_FAIL(539113,"当前状态不能发起审批",539113),
    AUDIT_STATUS_CHANGE(539114,"当前合同审核状态已发生变更，请重新加载页面！",539114),
    SIGNATURE_REPEAT(539115,"请勿重复签字",539115)
    ;


    private Integer key;

    private String value;

    private Integer errCode;

    ExceptionEnum() {
    }
    ExceptionEnum(Integer key, String value){
        this.key=key;
        this.value=value;
    }
    ExceptionEnum(Integer key, String value, Integer errCode){
        this.key=key;
        this.value=value;
        this.errCode=errCode;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Integer getErrCode() {
        return errCode;
    }


}
