package com.shigu.main4.item.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 开放搜索商品数据
 * Created by whx on 2017/6/13 0013.
 */
public class OpenItemVo {
    private Long searchId;
    private Long goodsId;
    private Long click;
    private Long trade;
    private Long up;
    private String webSite;
    private String title;
    private Date created;
    private Long cid;
    private String cidAll;
    private String picUrl;
    private Long price;
    private Long piPrice;
    private Long parentMarketId;
    private Long storeId;
    private Long isClosed;
    private String goodsNo;
    private Long isShowcase;
    private Long isExcelImp;
    private String goodsLevel;
    private Long relationLevelId;
    private Long sortOrder;

    @JSONField(name = "search_id")
    public Long getSearchId() {
        return searchId;
    }

    public void setSearchId(Long searchId) {
        this.searchId = searchId;
    }

    @JSONField(name = "goods_id")
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @JSONField(name = "click")
    public Long getClick() {
        return click;
    }

    public void setClick(Long click) {
        this.click = click;
    }

    @JSONField(name = "trade")
    public Long getTrade() {
        return trade;
    }

    public void setTrade(Long trade) {
        this.trade = trade;
    }

    @JSONField(name = "up")
    public Long getUp() {
        return up;
    }

    public void setUp(Long up) {
        this.up = up;
    }

    @JSONField(name = "web_site")
    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String website) {
        this.webSite = website;
    }

    @JSONField(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JSONField(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @JSONField(name = "cid")
    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    @JSONField(name = "cid_all")
    public String getCidAll() {
        return cidAll;
    }

    public void setCidAll(String cidAll) {
        this.cidAll = cidAll;
    }

    @JSONField(name = "pic_url")
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @JSONField(name = "price")
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @JSONField(name = "pi_price")
    public Long getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(Long piPrice) {
        this.piPrice = piPrice;
    }

    @JSONField(name = "parent_market_id")
    public Long getParentMarketId() {
        return parentMarketId;
    }

    public void setParentMarketId(Long parentMarketId) {
        this.parentMarketId = parentMarketId;
    }

    @JSONField(name = "store_id")
    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @JSONField(name = "goods_no")
    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    @JSONField(name = "goods_level")
    public String getGoodsLevel() {
        return goodsLevel;
    }

    public void setGoodsLevel(String goodsLevel) {
        this.goodsLevel = goodsLevel;
    }

    @JSONField(name = "relation_level_id")
    public Long getRelationLevelId() {
        return relationLevelId;
    }

    public void setRelationLevelId(Long relationLevelId) {
        this.relationLevelId = relationLevelId;
    }

    @JSONField(name = "sort_order")
    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    @JSONField(name = "is_closed")
    public Long getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Long isClosed) {
        this.isClosed = isClosed;
    }

    @JSONField(name = "is_showcase")
    public Long getIsShowcase() {
        return isShowcase;
    }

    public void setIsShowcase(Long isShowCase) {
        this.isShowcase = isShowCase;
    }

    @JSONField(name = "is_excel_imp")
    public Long getIsExcelImp() {
        return isExcelImp;
    }

    public void setIsExcelImp(Long isExcelImp) {
        this.isExcelImp = isExcelImp;
    }

    @Override
    public String toString() {
        return "OpenItemVo{" +
                "searchId=" + searchId +
                ", goodsId=" + goodsId +
                ", click=" + click +
                ", trade=" + trade +
                ", up=" + up +
                ", webSite='" + webSite + '\'' +
                ", title='" + title + '\'' +
                ", created=" + created +
                ", cid=" + cid +
                ", cidAll='" + cidAll + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", price=" + price +
                ", piPrice=" + piPrice +
                ", parentMarketId=" + parentMarketId +
                ", storeId=" + storeId +
                ", isClosed=" + isClosed +
                ", goodsNo='" + goodsNo + '\'' +
                ", isShowcase=" + isShowcase +
                ", isExcelImp=" + isExcelImp +
                ", goodsLevel='" + goodsLevel + '\'' +
                ", relationLevelId=" + relationLevelId +
                ", sortOrder=" + sortOrder +
                '}';
    }
}
