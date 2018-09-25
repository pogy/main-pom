package com.shigu.main4.pay.enums;

/**
 * 类名：XzbBaseErrorCodeEnum
 * 类路径： com.shigu.main4.pay.enums.XzbBaseErrorCodeEnum
 * 创建者： whx
 * 创建时间： 8/8/18 4:03 PM
 * 项目： main-pom
 * 描述：
 */
public enum XzbBaseErrorCodeEnum {
    SUCCESS(1, "SUCCESS", "成功"),
    PARTIAL_SUCCESS(2, "PARTIAL_SUCCESS", "部分成功"),
    FAILED(4, "FAILED", "失败"), ERROR(3, "ERROR", "系统错误"),
    INVALID_ARGUMENT(5, "INVALID_ARGUMENT", "参数无效"),
    USER_INFO_ID_IS_NOT_EXTIST(6, "USER_INFO_ID_IS_NOT_EXTIST", "未查询到用户信息"),
    OUT_TRADE_ID_IS_NULL(7, "OUT_TRADE_ID_IS_NULL", "外部订单号为空"),
    SUBJECT_IS_NULL(8, "SUBJECT_IS_NULL", "标题为空"),
    PAY_AMOUNT_IS_NULL(9, "PAY_AMOUNT_IS_NULL", "订单金额为空"),
    PAY_TIME_FOM_IS_OUT(12, "PAY_TIME_FOM_IS_OUT", "支付超时时间必须在1m~15d时间之内"),
    PAY_TIME_FOM_C_IS_ERROR(13, "PAY_TIME_FOM_C_IS_ERROR", "支付超时时间C标识只能为0或1"),
    PAY_OUTTIME_FOM_IS_ERROR(11, "PAY_OUTTIME_FOM_IS_ERROR", "支付宝超时时间格式存在问题"),
    AMOUNT_FOMCAT_IS_ERROR(10, "CASH_AMOUNT_FOMCAT_IS_ERROR", "金额数据格式有误"),
    PAY_IS_READY(12, "PAY_IS_READY", "该笔订单已经被支付");

    // 成员变量
    private int index;
    private String code;
    private String msg;

    // 构造方法
    private XzbBaseErrorCodeEnum(int index, String code, String msg) {
        this.msg = msg;
        this.index = index;
        this.code = code;
    }

    // 普通方法
    public static String getmsg(int index) {
        for (XzbBaseErrorCodeEnum c : XzbBaseErrorCodeEnum.values()) {
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
