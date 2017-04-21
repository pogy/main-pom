package com.shigu.component.shiro.enums;

/**
 * 角色枚举
 * Created by zhaohongbo on 17/2/10.
 */
public enum RoleEnum {

    MEMBER("普通用户","member"),STORE("有店的用户","store"),MORE_STORE("有多个店铺的","more_store");

    RoleEnum(String title, String value) {
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
