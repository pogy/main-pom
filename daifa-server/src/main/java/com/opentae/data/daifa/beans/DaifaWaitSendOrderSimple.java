package com.opentae.data.daifa.beans;

import com.opentae.core.mybatis.config.Column;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by pc on 2017-08-14.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class DaifaWaitSendOrderSimple implements Serializable{
    @Transient
    private static final long serialVersionUID = -4039183803628953148L;
    private Long childOrderId;//子单id
    private String imgSrc;//商品图片
    private String title;//商品标题
    private String goodsProperty;//商品属性 颜色 尺码
    private String goodsNo;//商品货号
    private String piPrice;//商品批发价
    private String payPrice;//商品实际支付价
    private Integer num;//商品数量
    private Integer takeGoodsState;//拿货状态 0拿货中 1已拿到 2缺货
    private Integer refundStatus;
    private String storeGoodsCode; //商家编码
    private String barCodeKey;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

//    public String getChildServersFee() {
//        return childServersFee;
//    }
//
//    public void setChildServersFee(String childServersFee) {
//        this.childServersFee = childServersFee;
//    }

//    public String getChildRemark() {
//        return childRemark;
//    }
//
//    public void setChildRemark(String childRemark) {
//        this.childRemark = childRemark;
//    }

//    public Integer getAllotState() {
//        return allotState;
//    }
//
//    public void setAllotState(Integer allotState) {
//        this.allotState = allotState;
//    }

    public Integer getTakeGoodsState() {
        return takeGoodsState;
    }

    public void setTakeGoodsState(Integer takeGoodsState) {
        this.takeGoodsState = takeGoodsState;
    }

//    public String getHaveGoodsTime() {
//        return haveGoodsTime;
//    }
//
//    public void setHaveGoodsTime(String haveGoodsTime) {
//        this.haveGoodsTime = haveGoodsTime;
//    }

//    public Boolean getNoSaleIs () {
//        return noSaleIs;
//    }
//
//    public void setNoSaleIs (Boolean noSaleIs) {
//        this.noSaleIs = noSaleIs;
//    }

//    public Integer getReturnGoodsStatus() {
//        return returnGoodsStatus;
//    }
//
//    public void setReturnGoodsStatus(Integer returnGoodsStatus) {
//        this.returnGoodsStatus = returnGoodsStatus;
//    }

//    public Integer getChangeStatus() {
//        return changeStatus;
//    }
//
//    public void setChangeStatus(Integer changeStatus) {
//        this.changeStatus = changeStatus;
//    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getStoreGoodsCode() {
        return storeGoodsCode;
    }

    public void setStoreGoodsCode(String storeGoodsCode) {
        this.storeGoodsCode = storeGoodsCode;
    }

    public String getBarCodeKey() {
        return this.barCodeKey;
    }

    public void setBarCodeKey(String barCodeKey) {
        this.barCodeKey = barCodeKey;
    }
}
