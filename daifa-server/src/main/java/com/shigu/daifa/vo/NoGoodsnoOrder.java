package com.shigu.daifa.vo;

public class NoGoodsnoOrder {
    //子单id
    private Long childOrderId;
    //商品图片
    private String imgSrc;
    //商品标题
    private String title;
    //商品属性（颜色尺码）
    private String goodsProperty;
    //子单服务费
    private String childServersFee;

    private Long goodsId;

    //子单id
    public Long getChildOrderId() {
        return this.childOrderId;
    }

    //子单id
    public void setChildOrderId(Long childOrderId) {
        this.childOrderId = childOrderId;
    }

    //商品图片
    public String getImgSrc() {
        return this.imgSrc;
    }

    //商品图片
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    //商品标题
    public String getTitle() {
        return this.title;
    }

    //商品标题
    public void setTitle(String title) {
        this.title = title;
    }

    //商品属性（颜色尺码）
    public String getGoodsProperty() {
        return this.goodsProperty;
    }

    //商品属性（颜色尺码）
    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty;
    }

    //子单服务费
    public String getChildServersFee() {
        return this.childServersFee;
    }

    //子单服务费
    public void setChildServersFee(String childServersFee) {
        this.childServersFee = childServersFee;
    }

    public Long getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
