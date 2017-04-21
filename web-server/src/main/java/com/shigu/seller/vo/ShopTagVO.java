package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * 店铺服务类别
 * Created by zhaohongbo on 17/3/18.
 */
public class ShopTagVO implements Serializable{
    private String color;

    private String text;

    private String value;

    public ShopTagVO(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
