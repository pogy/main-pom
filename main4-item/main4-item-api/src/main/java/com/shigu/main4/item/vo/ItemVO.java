package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * 淘宝上传成功后返回的商品数据信息
 */
public class ItemVO implements Serializable{
    private Long numIid;

    private String title;

    private String picUrl;

    private String price;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }
}
