package com.shigu.daifa.vo;

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
public class AllSubOrderVO implements Serializable{
    @Transient
    private static final long serialVersionUID = -4039183803628953148L;
    private String childOrderId;//子单id
    private String imgSrc;//商品图片
    private String title;//商品标题
    private String goodsProperty;//商品属性 颜色 尺码
    private String goodsNo;//商品货号
    private String piPrice;//商品批发价
    private String payPrice;//商品实际支付价
    private String num;//商品数量
    private String childServersFee;//字的那服务费用
    private String childRemark;//子弹备注
    private Integer allotState;//分配状态 1待分配2已分配
    private Integer takeGoodsState;//拿货状态 0拿货中 1已拿到 2缺货
    private String haveGoodsTime;//有货时间
    private Boolean noSaleIs;//是否下架true不卖了下架 false还在卖 注：该处为是否标记下架
    private Integer refundState;
    private Integer afterSaleState;//售后子单状态 2申请退款 3已受理退款
    // 4退款完成 5拒绝退款 6申请换货 7换货中 8换货完成 9拒绝换货


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(String childOrderId) {
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getChildServersFee() {
        return childServersFee;
    }

    public void setChildServersFee(String childServersFee) {
        this.childServersFee = childServersFee;
    }

    public String getChildRemark() {
        return childRemark;
    }

    public void setChildRemark(String childRemark) {
        this.childRemark = childRemark;
    }

    public Integer getAllotState() {
        return allotState;
    }

    public void setAllotState(Integer allotState) {
        this.allotState = allotState;
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

    public Integer getAfterSaleState() {
        return afterSaleState;
    }

    public void setAfterSaleState(Integer afterSaleState) {
        this.afterSaleState = afterSaleState;
    }

    public Integer getRefundState() {
        return refundState;
    }

    public void setRefundState(Integer refundState) {
        this.refundState = refundState;
    }
}
