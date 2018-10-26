package com.shigu.main4.pay.enums;

/**
 * 类名：XzbRchargeAlipayErrorCodeEnum
 * 类路径： com.shigu.main4.pay.enums.XzbRchargeAlipayErrorCodeEnum
 * 创建者： whx
 * 创建时间： 8/10/18 3:09 PM
 * 项目： main-pom
 * 描述：
 */
public enum XzbRchargeAlipayErrorCodeEnum {
    PAY_REMARK_IS_NULL(1, "PAY_REMARK_IS_NULL", "充值备注为空"),
    NO_INQUIRY_INTO_TRANSACTIONS(2, "NO_INQUIRY_INTO_TRANSACTIONS", "未查询到相关备注的交易记录"),
    USER_INFO_ID_IS_NULL(3, "USER_INFO_ID_IS_NULL", "xzUserId 和 accountId 必须有一个有值"),
    PAY_ACCOUNT_IS_ERROR(4, "PAY_ACCOUNT_IS_ERROR", "充值金额"),
    NO_FOUND_ALIPAY_TRADE(5, "NO_FOUND_ALIPAY_TRADE", "未查询到相关交易记录信息"),
    ORDER_STAUTS_IS_OTHERS(6, "ORDER_STAUTS_IS_OTHERS", "存在订单状态为OTHERS，请联系客服进行人工充值"),
    TRADE_IS_NOT_IN(7, "TRADE_IS_NOT_IN", "该交易不是进账，请检查交易信息"),
    THIS_ALIPAY_NO_IS_SY(8, "THIS_ALIPAY_NO_IS_SY", "该支付宝交易号已经被使用"),
    ALIPAY_NO_IS_ERROR(9, "ALIPAY_NO_IS_ERROR", "支付宝交易号错误");

    private int index;
    private String code;
    private String msg;

    private XzbRchargeAlipayErrorCodeEnum(int index, String code, String msg) {
        this.msg = msg;
        this.index = index;
        this.code = code;
    }

    public static String getmsg(int index) {
        for (XzbRchargeAlipayErrorCodeEnum c : XzbRchargeAlipayErrorCodeEnum.values()) {
            if (c.getIndex() == index) {
                return c.msg;
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
