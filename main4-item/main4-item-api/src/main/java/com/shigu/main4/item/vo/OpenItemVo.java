package com.shigu.main4.item.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.shigu.opensearchsdk.anno.FetchApp;

import java.io.Serializable;
import java.util.Date;

/**
 * 开放搜索商品数据
 * Created by whx on 2017/6/13 0013.
 */
@FetchApp("goods_search_hz")
public class OpenItemVo  implements Serializable {
    @JSONField(name = "goods_id")
    private Long goodsId;
    private String title;
    private Date created;
    private Long cid;
    @JSONField(name = "cid_all")
    private String cidAll;
    @JSONField(name = "pic_url")
    private String picUrl;
    private Long price;
    @JSONField(name = "pi_price")
    private Long piPrice;
    @JSONField(name = "parent_market_id")
    private Long parentMarketId;
    @JSONField(name = "store_id")
    private Long storeId;
    @JSONField(name = "is_closed")
    private Long isClosed;
    @JSONField(name = "goods_no")
    private String goodsNo;
    @JSONField(name = "is_showcase")
    private Long isShowcase;
    @JSONField(name = "is_showcase")
    private Long isExcelImp;
    @JSONField(name = "goods_level")
    private String goodsLevel;
    @JSONField(name = "relation_level_id")
    private Long relationLevelId;
    @JSONField(name = "sort_order")
    private Long sortOrder;
    @JSONField(name = "web_site")
    private String webSite;

    @JSONField(name = "search_id")
    private Long searchId;
    private Long click;
    private Long trade;
    private Long up;

    public Long getSearchId() {
        return searchId;
    }

    public void setSearchId(Long searchId) {
        this.searchId = searchId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getClick() {
        return click;
    }

    public void setClick(Long click) {
        this.click = click;
    }

    public Long getTrade() {
        return trade;
    }

    public void setTrade(Long trade) {
        this.trade = trade;
    }

    public Long getUp() {
        return up;
    }

    public void setUp(Long up) {
        this.up = up;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String website) {
        this.webSite = website;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCidAll() {
        return cidAll;
    }

    public void setCidAll(String cidAll) {
        this.cidAll = cidAll;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(Long piPrice) {
        this.piPrice = piPrice;
    }

    public Long getParentMarketId() {
        return parentMarketId;
    }

    public void setParentMarketId(Long parentMarketId) {
        this.parentMarketId = parentMarketId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsLevel() {
        return goodsLevel;
    }

    public void setGoodsLevel(String goodsLevel) {
        this.goodsLevel = goodsLevel;
    }

    public Long getRelationLevelId() {
        return relationLevelId;
    }

    public void setRelationLevelId(Long relationLevelId) {
        this.relationLevelId = relationLevelId;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Long getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Long isClosed) {
        this.isClosed = isClosed;
    }

    public Long getIsShowcase() {
        return isShowcase;
    }

    public void setIsShowcase(Long isShowCase) {
        this.isShowcase = isShowCase;
    }

    public Long getIsExcelImp() {
        return isExcelImp;
    }

    public void setIsExcelImp(Long isExcelImp) {
        this.isExcelImp = isExcelImp;
    }
}
