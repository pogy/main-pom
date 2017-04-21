package com.shigu.search.vo;

import java.io.Serializable;

/**
 * 搜索上品顶部匹配档口
 * Created by zhaohongbo on 17/4/6.
 */
public class TopShop implements Serializable{

    private Long storeId;

    private String storeNum;

    private String marketName;

    private String mainCate;

    private Integer goodsCount;

    private String goodsDataUrl;

    private String otherStoreUrl;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMainCate() {
        return mainCate;
    }

    public void setMainCate(String mainCate) {
        this.mainCate = mainCate;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsDataUrl() {
        return goodsDataUrl;
    }

    public void setGoodsDataUrl(String goodsDataUrl) {
        this.goodsDataUrl = goodsDataUrl;
    }

    public String getOtherStoreUrl() {
        return otherStoreUrl;
    }

    public void setOtherStoreUrl(String otherStoreUrl) {
        this.otherStoreUrl = otherStoreUrl;
    }
}
