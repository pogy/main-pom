package com.opentae.data.mall.beans;

/**
 * 产品ID信息
 * Created by bugzy on 2017/6/13 0013.
 */
public class ItemProductInfo {

    private Long pid;

    private Long skuId;

    private Long price;

    private Long superPrice;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getSuperPrice() {
        return this.superPrice;
    }

    public void setSuperPrice(Long superPrice) {
        this.superPrice = superPrice;
    }
}
