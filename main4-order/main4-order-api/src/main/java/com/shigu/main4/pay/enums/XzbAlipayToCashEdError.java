package com.shigu.main4.pay.enums;

/**
 * 类名：XzbAlipayToCashEdError
 * 类路径： com.shigu.main4.pay.enums.XzbAlipayToCashEdError
 * 创建者： whx
 * 创建时间： 8/10/18 3:01 PM
 * 项目： main-pom
 * 描述： 提现
 */
public enum XzbAlipayToCashEdError {
    CASH_AMOUNT_IS_NULL(1, "CASH_AMOUNT_IS_NULL", "提现金额数据为空"),
    CASH_AMOUNT_FOMCAT_IS_ERROR(2, "CASH_AMOUNT_FOMCAT_IS_ERROR", "提现金额数据格式有误"),
    ALIPAY_USER_ID_IS_NULL(3, "ALIPAY_USER_ID_IS_NULL", "支付宝账号不能为空"),
    CASH_AMOUNT_UP_TO_LIMMIT(4, "CASH_AMOUNT_UP_TO_LIMMIT", "申请金额超过单次提现上限"),
    ;

    private int index;
    private String code;
    private String msg;

    private XzbAlipayToCashEdError(int index, String code, String msg) {
        this.msg = msg;
        this.index = index;
        this.code = code;
    }

    public static String getmsg(int index) {
        for (XzbAlipayToCashEdError c : XzbAlipayToCashEdError.values()) {
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
