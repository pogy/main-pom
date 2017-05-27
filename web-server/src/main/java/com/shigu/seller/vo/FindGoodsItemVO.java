package com.shigu.seller.vo;

import com.shigu.main4.vo.ItemShowBlock;

/**
 * Created by zhaohongbo on 17/5/27.
 */
public class FindGoodsItemVO {

    public FindGoodsItemVO() {
    }

    public FindGoodsItemVO(ItemShowBlock isb) {
        this.setGoodsId(isb.getItemId());
        this.setGoodsNo(isb.getGoodsNo());
        this.setPicUrl(isb.getImgUrl());
        this.setTitle(isb.getTitle());
        this.setPrice(isb.getPrice());
    }

    private String picUrl;

    private String title;

    private String goodsNo;

    private String price;

    private Long goodsId;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
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
