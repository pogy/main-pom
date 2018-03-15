package com.shigu.main4.order.servicevo;

import java.io.Serializable;

/**
 * Created by zf on 2017/7/17.
 */
public class SubTbOrderVO implements Serializable {
    /**
     * 子单id
     */
    private String tbChildOrderId;
    /**
     * 淘宝商品id
     */
    private Long numiid;
    /**
     * 图片地址
     */
    private String imgSrc;
    /**
     * 标题
     */
    private String title;
    /**
     * 颜色
     */
    private String color;
    /**
     * 尺码
     */
    private String size;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 淘宝子单价格
     */
    private String oldTbPrice;
    private Long oldTbPriceLong;
    /**
     * 淘宝子单优惠后价格
     */
    private String newTbPrice;
    private Long newTbPriceLong;
    /**
     * 星座网价格
     */
    private String xzPrice;
    private Long xzPriceLong;
    /**
     * 数量
     */
    private Integer num;

    private String webSite;

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    /**
     * 获取 子单id
     */
    public String getTbChildOrderId() {
        return this.tbChildOrderId;
    }

    /**
     * 设置 子单id
     */
    public void setTbChildOrderId(String tbChildOrderId) {
        this.tbChildOrderId = tbChildOrderId;
    }

    /**
     * 获取 图片地址
     */
    public String getImgSrc() {
        return this.imgSrc;
    }

    /**
     * 设置 图片地址
     */
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
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

    public Long getOldTbPriceLong() {
        return this.oldTbPriceLong;
    }

    public void setOldTbPriceLong(Long oldTbPriceLong) {
        this.oldTbPriceLong = oldTbPriceLong;
    }

    public Long getNewTbPriceLong() {
        return this.newTbPriceLong;
    }

    public void setNewTbPriceLong(Long newTbPriceLong) {
        this.newTbPriceLong = newTbPriceLong;
    }

    public Long getXzPriceLong() {
        return this.xzPriceLong;
    }

    public void setXzPriceLong(Long xzPriceLong) {
        this.xzPriceLong = xzPriceLong;
    }

    /**
     * 获取 淘宝商品id
     */
    public Long getNumiid() {
        return this.numiid;
    }

    /**
     * 设置 淘宝商品id
     */
    public void setNumiid(Long numiid) {
        this.numiid = numiid;
    }
}
