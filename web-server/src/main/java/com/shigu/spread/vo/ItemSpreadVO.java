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

    private String imgsrc;

    private String piprice;

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

    private String styleText;

    private String elementText;
    /**
     * 店铺小标题
     */
    private String userText;

    private String title;

    public ItemSpreadVO() {
    }

    public ItemSpreadVO(ItemForList item) {
        setId(item.getGoodsId()+"");
        setImgsrc(item.getPicUrl());
        setPiprice(item.getPiPriceString());
        setStoreId(item.getStoreId()+"");
        setStoreNum(item.getStoreNum());
        setMarketText(item.getMarket());
        setStoreText(getMarketText()+" "+getStoreNum());
        setTitle(KeyWordsUtil.duleKeyWords(item.getTitle()));
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

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreText() {
        return storeText;
    }

    public void setStoreText(String storeText) {
        this.storeText = storeText;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
