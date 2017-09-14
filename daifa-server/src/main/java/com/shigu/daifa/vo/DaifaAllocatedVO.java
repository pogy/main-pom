package com.shigu.daifa.vo;

import java.io.Serializable;

public class DaifaAllocatedVO implements Serializable {
    /**
     * 子单id
     */
    private Long childOrderId;
    /**
     * 已分配ID
     */
    private Long takeGoodsId;
    /**
     * 商品图片
     */
    private String imgSrc;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品属性（颜色尺码）
     */
    private String goodsProperty;
    /**
     * 商品货号
     */
    private String goodsNo;
    /**
     * 商品批发价
     */
    private String piPrice;
    /**
     * 商品实际支付价
     */
    private String payPrice;
    /**
     * 商品数量
     */
    private Integer num;
    /**
     * 子单备注
     */
    private String childRemark;
    /**
     * 代发方式 1普通代发
     */
    private Integer dffs;
    /**
     * 	拿货状态 0拿货中 1已拿到 2缺货
     */
    private Integer takeGoodsState;
    /**
     * 	有货时间
     */
    private String haveGoodsTime;
    /**
     * 	是否下架 true不卖了下架 false还在卖 注：该处为是否标记下架
     */
    private Boolean noSaleIs;
    /**
     * 是否未自己任务
     */
    private Boolean isMyTask;

    public Long getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(Long childOrderId) {
        this.childOrderId = childOrderId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    public String getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(String payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getChildRemark() {
        return childRemark;
    }

    public void setChildRemark(String childRemark) {
        this.childRemark = childRemark;
    }

    public Integer getDffs() {
        return dffs;
    }

    public void setDffs(Integer dffs) {
        this.dffs = dffs;
    }

    public Integer getTakeGoodsState() {
        return takeGoodsState;
    }

    public void setTakeGoodsState(Integer takeGoodsState) {
        this.takeGoodsState = takeGoodsState;
    }

    public String getHaveGoodsTime() {
        return haveGoodsTime;
    }

    public void setHaveGoodsTime(String haveGoodsTime) {
        this.haveGoodsTime = haveGoodsTime;
    }

    public Boolean getNoSaleIs () {
        return noSaleIs;
    }

    public void setNoSaleIs (Boolean noSaleIs) {
        this.noSaleIs = noSaleIs;
    }

    /**
     * 获取 已分配ID
     */
    public Long getTakeGoodsId() {
        return this.takeGoodsId;
    }

    /**
     * 设置 已分配ID
     */
    public void setTakeGoodsId(Long takeGoodsId) {
        this.takeGoodsId = takeGoodsId;
    }

    /**
     * 获取 是否未自己任务
     */
    public Boolean getIsMyTask() {
        return this.isMyTask;
    }

    /**
     * 设置 是否未自己任务
     */
    public void setIsMyTask(Boolean isMyTask) {
        this.isMyTask = isMyTask;
    }
}
