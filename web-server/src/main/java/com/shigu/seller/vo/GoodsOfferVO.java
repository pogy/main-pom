package com.shigu.seller.vo;
public class GoodsOfferVO {
    /**
     * 首图
     */
    private String picPath;
    /**
     * 5张图,不包含首图
     */
    private String allimg;
    /**
     * 自定义的pid
     */
    private String inputPids;
    /**
     * 自定义的值
     */
    private String inputStr;
    /**
     * 所有属性ID串
     */
    private String paramstr;
    /**
     * 属性值重定义
     */
    private String propertyAlias;
    /**
     * 批发价
     */
    private String piPrice;
    /**
     * 零售价
     */
    private String buynow;
    /**
     * 卖点
     */
    private String sellPoint;
    /**
     * 商品数量
     */
    private Long quantity;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品详情
     */
    private String deschtml;
    /**
     * 店内类目ID串
     */
    private String sellerids;
    /**
     * 淘宝类目ID
     */
    private Long cid;
    /**
     * 面料
     */
    private String fabric;
    /**
     * 里料
     */
    private String inFabric;

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getAllimg() {
        return allimg;
    }

    public void setAllimg(String allimg) {
        this.allimg = allimg;
    }

    public String getInputPids() {
        return inputPids;
    }

    public void setInputPids(String inputPids) {
        this.inputPids = inputPids;
    }

    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    public String getParamstr() {
        return paramstr;
    }

    public void setParamstr(String paramstr) {
        this.paramstr = paramstr;
    }

    public String getPropertyAlias() {
        return propertyAlias;
    }

    public void setPropertyAlias(String propertyAlias) {
        this.propertyAlias = propertyAlias;
    }

    public String getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    public String getBuynow() {
        return buynow;
    }

    public void setBuynow(String buynow) {
        this.buynow = buynow;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeschtml() {
        return deschtml;
    }

    public void setDeschtml(String deschtml) {
        this.deschtml = deschtml;
    }

    public String getSellerids() {
        return sellerids;
    }

    public void setSellerids(String sellerids) {
        this.sellerids = sellerids;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    /**
     * 货号
     */

    private String goodsNo;
}
