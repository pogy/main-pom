package com.shigu.main4.item.vo;


import com.shigu.main4.item.enums.ItemFrom;

import java.io.Serializable;
import java.util.Date;

/**
 * 出售中的商品
 * Created by zhaohongbo on 17/3/2.
 */
public class OnsaleItem implements Serializable{
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
    /**
     * 总销量
     */
    private Integer saleCount;
    /**
     * 面料成分
     */
    private String fabric;
    /**
     * 里料成分
     */
    private String inFabric;
    /**
     * 是否已设置面料 1未设置 2已设置
     */
    private Integer constituentType;
    /**
     * 是否设置过最低零售价
     */
    private Boolean hasRetailPriceSet;
    /**
     * 主图链接
     */
    private String goodsVideoUrl;

    /**
     * 风格id
     * @return
     */
    private Long goodsStyleId;

    public Long getGoodsStyleId() {
        return goodsStyleId;
    }

    public void setGoodsStyleId(Long goodsStyleId) {
        this.goodsStyleId = goodsStyleId;
    }

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

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getInFabric() {
        return inFabric;
    }

    public void setInFabric(String inFabric) {
        this.inFabric = inFabric;
    }

    public Integer getConstituentType() {
        return constituentType;
    }

    public void setConstituentType(Integer constituentType) {
        this.constituentType = constituentType;
    }

    public Boolean getHasRetailPriceSet() {
        return hasRetailPriceSet;
    }

    public void setHasRetailPriceSet(Boolean hasRetailPriceSet) {
        this.hasRetailPriceSet = hasRetailPriceSet;
    }

    public String getGoodsVideoUrl() {
        return goodsVideoUrl;
    }

    public void setGoodsVideoUrl(String goodsVideoUrl) {
        this.goodsVideoUrl = goodsVideoUrl;
    }
}
