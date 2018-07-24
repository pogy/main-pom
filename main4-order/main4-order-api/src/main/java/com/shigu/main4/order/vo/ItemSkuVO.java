package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 商品的sku
 * Created by zhaohongbo on 17/6/1.
 */
public class ItemSkuVO implements Serializable{
    private Long skuId;

    private Long pid;

    private String color;

    private String size;

    private Long price;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
