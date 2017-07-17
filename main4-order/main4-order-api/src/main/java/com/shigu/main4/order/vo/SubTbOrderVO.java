package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * Created by zf on 2017/7/17.
 */
public class SubTbOrderVO implements Serializable {
    /**
     * 子单id
     */
    private Long oid;
    /**
     * 淘宝商品id
     */
    private Long numIid;
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 标题
     */
    private String title;
    /**
     * 颜色
     */
    private String skuColor;
    /**
     * 尺码
     */
    private String skuSize;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 淘宝子单价格
     */
    private String oldTbPrice;
    /**
     * 淘宝子单优惠后价格
     */
    private String newTbPrice;
    /**
     * 星座网价格
     */
    private String xzPrice;
    /**
     * 数量
     */
    private Integer num;

    /**
     * 获取 子单id
     */
    public Long getOid() {
        return this.oid;
    }

    /**
     * 设置 子单id
     */
    public void setOid(Long oid) {
        this.oid = oid;
    }

    /**
     * 获取 淘宝商品id
     */
    public Long getNumIid() {
        return this.numIid;
    }

    /**
     * 设置 淘宝商品id
     */
    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    /**
     * 获取 图片地址
     */
    public String getImgUrl() {
        return this.imgUrl;
    }

    /**
     * 设置 图片地址
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 获取 标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取 颜色
     */
    public String getSkuColor() {
        return this.skuColor;
    }

    /**
     * 设置 颜色
     */
    public void setSkuColor(String skuColor) {
        this.skuColor = skuColor;
    }

    /**
     * 获取 尺码
     */
    public String getSkuSize() {
        return this.skuSize;
    }

    /**
     * 设置 尺码
     */
    public void setSkuSize(String skuSize) {
        this.skuSize = skuSize;
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
     * 获取 淘宝子单价格
     */
    public String getOldTbPrice() {
        return this.oldTbPrice;
    }

    /**
     * 设置 淘宝子单价格
     */
    public void setOldTbPrice(String oldTbPrice) {
        this.oldTbPrice = oldTbPrice;
    }

    /**
     * 获取 淘宝子单优惠后价格
     */
    public String getNewTbPrice() {
        return this.newTbPrice;
    }

    /**
     * 设置 淘宝子单优惠后价格
     */
    public void setNewTbPrice(String newTbPrice) {
        this.newTbPrice = newTbPrice;
    }

    /**
     * 获取 星座网价格
     */
    public String getXzPrice() {
        return this.xzPrice;
    }

    /**
     * 设置 星座网价格
     */
    public void setXzPrice(String xzPrice) {
        this.xzPrice = xzPrice;
    }

    /**
     * 获取 数量
     */
    public Integer getNum() {
        return this.num;
    }

    /**
     * 设置 数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }
}
