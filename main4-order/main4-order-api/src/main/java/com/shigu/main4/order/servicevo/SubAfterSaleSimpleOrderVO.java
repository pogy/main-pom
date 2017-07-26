package com.shigu.main4.order.servicevo;

/**
 * Created by zf on 2017/7/26.
 * 售后子单简要数据
 */
public class SubAfterSaleSimpleOrderVO {
    /**
     * 子单ID
     */
    private Long subOrderId;
    /**
     * 主图
     */
    private String picUrl;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 颜色
     */
    private String color;
    /**
     * 尺码
     */
    private String size;
    /**
     * 单价
     */
    private Long price;

    /**
     * 获取 子单ID
     */
    public Long getSubOrderId() {
        return this.subOrderId;
    }

    /**
     * 设置 子单ID
     */
    public void setSubOrderId(Long subOrderId) {
        this.subOrderId = subOrderId;
    }

    /**
     * 获取 主图
     */
    public String getPicUrl() {
        return this.picUrl;
    }

    /**
     * 设置 主图
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 获取 货号
     */
    public String getGoodsNo() {
        return this.goodsNo;
    }

    /**
     * 设置 货号
     */
    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

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
     * 获取 单价
     */
    public Long getPrice() {
        return this.price;
    }

    /**
     * 设置 单价
     */
    public void setPrice(Long price) {
        this.price = price;
    }
}
