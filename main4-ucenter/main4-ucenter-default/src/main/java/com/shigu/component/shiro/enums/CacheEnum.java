package com.shigu.component.shiro.enums;

/**
 * 缓存
 * Created by zhaohongbo on 17/2/15.
 */
public enum CacheEnum {
    MEMBERUSER_CACHE("登陆用户数据","memberuserCache");

    CacheEnum(String title, String value) {
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
