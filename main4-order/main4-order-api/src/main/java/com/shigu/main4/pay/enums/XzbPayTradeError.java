package com.shigu.main4.pay.enums;

/**
 * 类名：XzbPayTradeError
 * 类路径： com.shigu.main4.pay.enums.XzbPayTradeError
 * 创建者： whx
 * 创建时间： 8/9/18 4:26 PM
 * 项目： main-pom
 * 描述：星座宝支付错误码
 */
public enum XzbPayTradeError {
    NO_ACCOUNT("xzb_pay_001","找不到对应的资金账户"),NOT_XZB("xzb_pay_002","非星座宝用户"),
    NO_YUER("xzb_pay_003","余额信息为空"),NO_MUSH_MONEY("xzb_pay_004","余额不足"),
    ERROR_VOLUME("xzb_pay_005","卷信息异常"),NO_MUSH_VOLUME("xzb_pay_006","卷可用金额不足"),
    HAS_PAYED("xzb_pay_007","外部交易ID已经存在");

    private String code;
    private String msg;

    XzbPayTradeError(String code,String msg) {
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
