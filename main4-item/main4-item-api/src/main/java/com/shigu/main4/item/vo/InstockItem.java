package com.shigu.main4.item.vo;

import com.shigu.main4.item.enums.ItemFrom;

import java.io.Serializable;
import java.util.Date;

/**
 * 仓库中的商品
 * Created by zhaohongbo on 17/3/2.
 */
public class InstockItem implements Serializable{
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
     * 商品来源
     */
    private ItemFrom itemFrom;
    /**
     * 创建时间
     */
    private Date created;
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

    public ItemFrom getItemFrom() {
        return itemFrom;
    }

    public void setItemFrom(ItemFrom itemFrom) {
        this.itemFrom = itemFrom;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
