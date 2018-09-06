package com.shigu.search.vo;

import java.io.Serializable;

/**
 * 推荐商品
 * Created by zhaohongbo on 17/4/6.
 */
public class TjGoods implements Serializable{
    private String id;

    private String imgSrc;

    private String piprice;

    private String fullStoreName;

    private String storeid;

    private String storeId;

    private String storeText;
    /**
     * 市场
     */
    private String marketText;
    /**
     * 档口
     */
    private String storeNum;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.setStoreid(storeId);
        this.storeId = storeId;
    }

    public String getStoreText() {
        return storeText;
    }

    public void setStoreText(String storeText) {
        this.setFullStoreName(storeText);
        this.storeText = storeText;
    }

    public String getMarketText() {
        return marketText;
    }

    public void setMarketText(String marketText) {
        this.marketText = marketText;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }

    public String getFullStoreName() {
        return fullStoreName;
    }

    public void setFullStoreName(String fullStoreName) {
        if (fullStoreName != null) {
            this.fullStoreName = fullStoreName;
        }

    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        if (storeid != null) {
            this.storeid = storeid;
        }

    }

    public String getImgSrc() {
        return this.imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
