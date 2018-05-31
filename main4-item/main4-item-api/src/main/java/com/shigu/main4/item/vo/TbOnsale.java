package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * 淘宝在售商品
 * Created by zhaohongbo on 17/2/28.
 */
public class TbOnsale implements Serializable{
    /**
     * 淘宝的商品ID
     */
    private Long numIid;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品首图
     */
    private String picUrl;
    /**
     * 价格
     */
    private String price;
    /**
     * 商品ID
     */
    private Long goodsId;

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
