package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * 商品简要信息
 * Created by zhaohongbo on 17/4/5.
 */
public class SearchItemSimple implements Serializable{

    private Long itemId;

    private String piPrice;

    private String title;

    private String picUrl;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
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
}
