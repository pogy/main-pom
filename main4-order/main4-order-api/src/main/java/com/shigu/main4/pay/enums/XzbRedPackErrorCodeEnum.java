package com.shigu.main4.pay.enums;

/**
 * 类名：XzbRedPackErrorCodeEnum
 * 类路径： com.shigu.main4.pay.enums.XzbRedPackErrorCodeEnum
 * 创建者： whx
 * 创建时间： 8/10/18 6:59 PM
 * 项目： main-pom
 * 描述：
 */
public enum XzbRedPackErrorCodeEnum {
    RED_PACK_NONE_BONUS(1, "RED_PACK_NONE_BONUS", "当前账号下没有红包"),
    RED_PACK_NEQ_BALANCE(2, "RED_PACK_NEQ_BALANCE", "当前红包总额与充值金额不匹配"),
    RED_PACK_NONE_ACCOUNT(2, "RED_PACK_NONE_ACCOUNT", "未查询到账户信息"),
    RED_PACK_FAILED_REDUCE(2, "RED_PACK_FAILED_REDUCE", "红包余额更新失败"),
    RED_PACK_FAILED_ADD(2, "RED_PACK_FAILED_ADD", "账户余额更新失败"),


    ;
    // 成员变量
    private int index;
    private String code;
    private String msg;

    // 构造方法
    private XzbRedPackErrorCodeEnum(int index, String code, String msg) {
        this.msg = msg;
        this.index = index;
        this.code = code;
    }

    // 普通方法
    public static String getmsg(int index) {
        for (XzbRedPackErrorCodeEnum c : XzbRedPackErrorCodeEnum.values()) {
            if (c.getIndex() == index) {
                return c.msg;
            }
        }
        return null;
    }

    // get set 方法
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
