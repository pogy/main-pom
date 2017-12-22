package com.shigu.seller.vo;

import java.util.List;

public class GoodsInfoVO {
    /**
     * 商品标题
     */
    private String goodsTitle;
    /**
     * 批发价
     */
    private String piPrice;

    /**
     * 最低零售价
     */
    private String lowestLiPrice;

    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 面料
     */
    private String fabric;
    /**
     * 里料
     */
    private String inFabric;

    /**
     * 商品属性数据
     */
    private FormAttribute formAttribute;

    /**
     *SKU列表
     */
    private List<SkuAttribute>  skuAttribute;


    /**
     * 首图
     */
    private String picPath;
    /**
     * 5张图,不包含首图 字符串数组
     */
    private List<String> allimg;

    /**
     * 商品详情
     */
    private String deschtml;

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    public String getLowestLiPrice() {
        return lowestLiPrice;
    }

    public void setLowestLiPrice(String lowestLiPrice) {
        this.lowestLiPrice = lowestLiPrice;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getInFabric() {
        return inFabric;
    }

    public void setInFabric(String inFabric) {
        this.inFabric = inFabric;
    }

    public FormAttribute getFormAttribute() {
        return formAttribute;
    }

    public void setFormAttribute(FormAttribute formAttribute) {
        this.formAttribute = formAttribute;
    }


    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public List<String> getAllimg() {
        return allimg;
    }

    public void setAllimg(List<String> allimg) {
        this.allimg = allimg;
    }

    public String getDeschtml() {
        return deschtml;
    }

    public void setDeschtml(String deschtml) {
        this.deschtml = deschtml;
    }
    public List<SkuAttribute> getSkuAttribute() {
        return skuAttribute;
    }

    public void setSkuAttribute(List<SkuAttribute> skuAttribute) {
        this.skuAttribute = skuAttribute;
    }

}
