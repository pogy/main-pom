package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 子订单
 * Created by zhaohongbo on 17/6/1.
 */
public class SubOrderVO implements Serializable{

    /**
     * 产品ID
     */
    private Long pid;

    /**
     * sku信息
     */
    private Long skuId;

    /**
     * 件数
     */
    private Integer num;

    /**
     * 备注
     */
    private String mark;

    /**
     * 交易信息ID
     */
    private Long logisticsId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品链接
     */
    private String picUrl;

    /**
     * 分站
     */
    private String webSite;

    /**
     *
     */
    private String title;

    /**
     * 单价
     */
    private Long price;

    /**
     * 重量
     */
    private Long weight;

    /**
     * 尺码
     */
    private String size;

    /**
     * 颜色
     */
    private String color;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Long getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
