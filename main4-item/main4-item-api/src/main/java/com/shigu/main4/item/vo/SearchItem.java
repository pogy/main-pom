package com.shigu.main4.item.vo;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * 搜索商品块
 * Created by zhaohongbo on 17/4/4.
 */
public class SearchItem implements Serializable{
    /**
     * 展示图
     */
    private String picUrl;
    /**
     * 标题
     */
    private String title;
    /**
     * 高亮标题
     */
    private String highLightTitle;
    /**
     * 宝贝Id
     */
    private Long itemId;
    /**
     * 宝贝价格
     */
    private String price;
    /**
     * 档口号
     */
    private Long storeId;
    /**
     * 创建时间
      */
    private Date created;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 高亮货号
     */
    private String highLightGoodsNo;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getPrice() {
        return price;
    }

    public String parsePrice(Long priceLong){
        if(priceLong==null){
            return "--";
        }
        Double priceValue = priceLong.doubleValue()/100;
        DecimalFormat df=new DecimalFormat("0.00");
        return df.format(priceValue);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHighLightTitle() {
        return highLightTitle;
    }

    public void setHighLightTitle(String highLightTitle) {
        this.highLightTitle = highLightTitle;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getHighLightGoodsNo() {
        return highLightGoodsNo;
    }

    public void setHighLightGoodsNo(String highLightGoodsNo) {
        this.highLightGoodsNo = highLightGoodsNo;
    }
}
