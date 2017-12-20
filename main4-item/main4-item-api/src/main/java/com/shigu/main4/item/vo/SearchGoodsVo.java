package com.shigu.main4.item.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.shigu.opensearchsdk.anno.FetchApp;

import java.io.Serializable;
import java.util.Date;

/**
 * OpenSearch Goods Item
 * Created by bugzy on 2017/6/19 0019.
 */
@FetchApp("goods_search_hz")
public class SearchGoodsVo  implements Serializable {

    @JSONField(name = "goods_id")
    private Long goodsId;

    private String title;

    @JSONField(name = "pic_url")
    private String picUrl;

    @JSONField(name = "web_site")
    private String webSite;

    @JSONField(name = "goods_no")
    private String goodsNo;

    @JSONField(name = "cid_all")
    private String cidAll;

    private String sids;

    private Long cid;

    private Long price;

    @JSONField(name = "pi_price")
    private Long piPrice;

    @JSONField(name = "parent_market_id")
    private Long marketId;

    @JSONField(name = "store_id")
    private Long storeId;

    @JSONField(name = "is_closed")
    private Long isClosed;

    @JSONField(name = "is_showcase")
    private Long isShowcase;

    @JSONField(name = "is_excel_imp")
    private Long isExcelImp;

    @JSONField(name = "relation_level_id")
    private Long relationLevelId;

    @JSONField(name = "goods_level")
    private String goodsLevel;

    private Date created;

    @JSONField(name = "sort_order")
    private Long sortOrder;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
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

    public String getCidAll() {
        return cidAll;
    }

    public void setCidAll(String cidAll) {
        this.cidAll = cidAll;
    }

    public String getSids() {
        return sids;
    }

    public void setSids(String sids) {
        this.sids = sids;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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

    public void setIsShowcase(Long isShowcase) {
        this.isShowcase = isShowcase;
    }

    public Long getIsExcelImp() {
        return isExcelImp;
    }

    public void setIsExcelImp(Long isExcelImp) {
        this.isExcelImp = isExcelImp;
    }

    public Long getRelationLevelId() {
        return relationLevelId;
    }

    public void setRelationLevelId(Long relationLevelId) {
        this.relationLevelId = relationLevelId;
    }

    public String getGoodsLevel() {
        return goodsLevel;
    }

    public void setGoodsLevel(String goodsLevel) {
        this.goodsLevel = goodsLevel;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }
}
