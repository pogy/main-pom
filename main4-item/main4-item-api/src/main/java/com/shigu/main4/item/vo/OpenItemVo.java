package com.shigu.main4.item.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class OpenItemVo {
    /**
     * 展示图
     */
    @JSONField(name = "pic_url")
    private String picUrl;
    /**
     * 标题
     */
    private String title;
    /**
     * 高亮标题
     */
    @JSONField(name = "high_light_title")
    private String highLightTitle;
    /**
     * 宝贝Id
     */
    @JSONField(name = "goods_id")
    private Long itemId;
    /**
     * 宝贝价格
     */
    private String price;
    /**
     * 档口号
     */
    @JSONField(name = "store_id")
    private Long storeId;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 货号
     */
    @JSONField(name = "goods_no")
    private String goodsNo;
    /**
     * 高亮货号
     */
    @JSONField(name = "high_light_goods_no")
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
