package com.shigu.main4.newcdn.vo;

/**
 * Created by zf on 2017/7/25.
 */
public class CdnSimpleGoodsVO {
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 标题
     */
    private String title;
    /**
     * 首图
     */
    private String imgSrc;
    /**
     * 价格
     */
    private String price;

    /**
     * 获取 商品ID
     */
    public Long getGoodsId() {
        return this.goodsId;
    }

    /**
     * 设置 商品ID
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取 标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取 首图
     */
    public String getImgSrc() {
        return this.imgSrc;
    }

    /**
     * 设置 首图
     */
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    /**
     * 获取 价格
     */
    public String getPrice() {
        return this.price;
    }

    /**
     * 设置 价格
     */
    public void setPrice(String price) {
        this.price = price;
    }
}
