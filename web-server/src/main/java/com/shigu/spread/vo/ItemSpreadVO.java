package com.shigu.spread.vo;

import com.opentae.data.mall.beans.ItemForList;
import com.shigu.tools.KeyWordsUtil;

import java.io.Serializable;

/**
 * 商品式广告
 * Created by zhaohongbo on 17/4/10.
 */
public class ItemSpreadVO implements Serializable{

    private String id;

    private String imgSrc;

    private String piprice;

    private String shopId;

    private String shopNo;

    private String storeNum;

    //发布时间
    private String time;

    /**
     * 市场
     */
    private String marketName;

    private String marketText;

    private String styleText;

    private String elementText;
    /**
     * 店铺小标题
     */
    private String userText;
//
    private String title;

    public ItemSpreadVO() {
    }

    public ItemSpreadVO(ItemForList item) {
        setId(item.getGoodsId()+"");
        setImgSrc(item.getPicUrl());
        setPiprice(item.getPiPriceString());
        setShopId(item.getStoreId()+"");
        setShopNo(item.getStoreNum());
        setMarketName(item.getMarket());
        setTitle(KeyWordsUtil.duleKeyWords(item.getTitle()));
        setMarketText(item.getMarket());
        setStoreNum(item.getStoreNum());
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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStyleText() {
        return styleText;
    }

    public void setStyleText(String styleText) {
        this.styleText = styleText;
    }

    public String getElementText() {
        return elementText;
    }

    public void setElementText(String elementText) {
        this.elementText = elementText;
    }

    public String getUserText() {
        return userText;
    }

    public void setUserText(String userText) {
        this.userText = userText;
    }

    public String getMarketText() {
        return this.marketText;
    }

    public void setMarketText(String marketText) {
        this.marketText = marketText;
    }

    public String getStoreNum() {
        return this.storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }
}
