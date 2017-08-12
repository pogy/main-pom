package com.shigu.component.shiro.enums;

/**
 * 登陆类型
 * Created by zhaohongbo on 17/2/10.
 */
public enum UserType {

    MEMBER("普通用户登陆","member_login"),SYSTEM("系统管理员登陆","sys_login");

    UserType(String title, String value) {
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
