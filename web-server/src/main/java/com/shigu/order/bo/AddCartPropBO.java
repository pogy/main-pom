package com.shigu.order.bo;

import java.io.Serializable;

/**
 * Created by zf on 2017/7/25.
 */
public class AddCartPropBO implements Serializable {
    /**
     * 颜色
     */
    private String color;
    /**
     * 尺码
     */
    private String size;
    /**
     * 数量
     */
    private Integer count;
    /**
     * 获取 颜色
     */
    public String getColor() {
        return this.color;
    }

    /**
     * 设置 颜色
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取 尺码
     */
    public String getSize() {
        return this.size;
    }

    /**
     * 设置 尺码
     */
    public void setSize(String size) {
        this.size = size;
    }


    /**
     * 获取 数量
     */
    public Integer getCount() {
        return this.count;
    }

    /**
     * 设置 数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}
