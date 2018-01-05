package com.opentae.data.mall.beans;

import com.shigu.tools.KeyWordsUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * 给列表用的商品简单信息
 * Created by Licca on 17/4/10.
 */
public class ItemForList {

    private Long goodsId;

    private String picUrl;

    private String storeNum;

    private String title;

    private Long storeId;

    private String piPriceString;

    private String market;

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPiPriceString() {
        return piPriceString;
    }

    public void setPiPriceString(String piPriceString) {
        this.piPriceString = piPriceString;
    }

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

    public String getTitle() {
        //TODO Powell only kept here  111
        if(StringUtils.isNotBlank(title)){
            title= KeyWordsUtil.duleKeyWords(title);
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
