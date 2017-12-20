package com.openJar.exception.enums;

/**
 * Created by pc on 2017-02-20.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
public enum ShortCompleteEnum {
    SUCCESS(1, "SUCCESS", "成功"),
    PARAMERROR(4,"PARAM_ERROR","参数错误");


    // 成员变量
    private int index;
    private String code;
    private String msg;

    // 构造方法
    private ShortCompleteEnum(int index, String code, String msg) {
        this.msg = msg;
        this.index = index;
        this.code = code;
    }

    // 普通方法
    public static String getmsg(int index) {
        for (ShortCompleteEnum c : ShortCompleteEnum.values()) {
            if (c.getIndex() == index) {
                return c.msg;
            }
        }
        return null;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
