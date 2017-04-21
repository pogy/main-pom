package com.shigu.main4.item.enums;

/**
 * 商品来源
 * Created by zhaohongbo on 17/2/16.
 */
public enum ItemFrom {
    TAOBAO("来自淘宝","taobao"),
    PACKAGE("来自数据包","package"),
    MEMBER("来自用户自己编辑","editor"),
    NONE("其他", "none"),
    ;

    ItemFrom(String title, String value) {
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
