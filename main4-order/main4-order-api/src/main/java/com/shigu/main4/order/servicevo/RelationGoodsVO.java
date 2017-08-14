package com.shigu.main4.order.servicevo;

import java.io.Serializable;

/**
 * Created by zf on 2017/7/21.
 */
public class RelationGoodsVO implements Serializable{
    private Long goodsId;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 星座价格
     */
    private String price;
    private Long priceLong;

    private String webSite;

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
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
     * 获取 星座价格
     */
    public String getPrice() {
        return this.price;
    }

    /**
     * 设置 星座价格
     */
    public void setPrice(String price) {
        this.price = price;
    }

    public Long getPriceLong() {
        return this.priceLong;
    }

    public void setPriceLong(Long priceLong) {
        this.priceLong = priceLong;
    }

    public Long getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
