package com.shigu.main4.item.vo;

import com.shigu.main4.item.enums.ItemFrom;

import java.io.Serializable;
import java.util.Date;

/**
 * 修复宝贝时,需要提供的列信息
 * Created by zhaohongbo on 17/3/16.
 */
public class XiufuItem implements Serializable{
    /**
     * 商品ID
     */
    private Long itemId;
    /**
     * 标题
     */
    private String title;
    /**
     * 首图
     */
    private String picUrl;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 字符型的批发价
     * 以元为单位
     */
    private String piPrice;
    /**
     * 字符型的零售价
     * 以元为单位
     */
    private String price;
    /**
     * 商品来源
     */
    private ItemFrom itemFrom;
    /**
     * 是否橱窗推荐,1是    0不是
     */
    private Integer isShowCase;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 上货量
     */
    private Integer goodsUpNum;
    /**
     * 分站标识
     */
    private String webSite;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ItemFrom getItemFrom() {
        return itemFrom;
    }

    public void setItemFrom(ItemFrom itemFrom) {
        this.itemFrom = itemFrom;
    }

    public Integer getIsShowCase() {
        return isShowCase;
    }

    public void setIsShowCase(Integer isShowCase) {
        this.isShowCase = isShowCase;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getGoodsUpNum() {
        return goodsUpNum;
    }

    public void setGoodsUpNum(Integer goodsUpNum) {
        this.goodsUpNum = goodsUpNum;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
