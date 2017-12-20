package com.shigu.component.shiro.enums;

/**
 * 登陆时的异常种类
 * Created by Licca on 17/2/20.
 */
public enum LoginErrorEnum {
    TO_BIND_XZUSER("请绑定星座账号","001"),
    NO_USER("账号不存在","002");

    LoginErrorEnum(String title, String value) {
        this.title = title;
        this.value = value;
    }

    /**
     * 标题
     */
    private String title;
    /**
     * 值
     */
    private String value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
