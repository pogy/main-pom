package com.shigu.main4.monitor.vo;

import java.io.Serializable;

/**
 * 未被上传过的宝贝
 * Created by zhaohongbo on 17/3/15.
 */
public class NoUpItem implements Serializable {
    private String imgUrl;

    private String price;

    private Long goodsId;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
