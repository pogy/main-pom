package com.opentae.data.daifa.custom.beans;

import com.opentae.core.mybatis.config.Column;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.Date;

public class DaifaGgoodsJoinOrder implements Serializable {
    /**子订单ID@从daifa_order中获得*/
    @Column("daifa_order.df_order_id")
    private Long dfOrderId;
    @Column("daifa_ggoods.take_goods_id")
    private Long takeGoodsId;
    /**标题*/
    @Column("daifa_ggoods.title")
    private String title;
    /**颜色尺码*/
    @Column("daifa_ggoods.prop_str")
    private String propStr;
    /**图片地址*/
    @Column("daifa_ggoods.pic_path")
    private String picPath;
    /**商家编码*/
    @Column("daifa_ggoods.store_goods_code")
    private String storeGoodsCode;
    /**批发价@单位元*/
    @Column("daifa_order.single_pi_price")
    private String singlePiPrice;
    /**单件支付价single_price+single_fuwu_fee-orderdiscount_fee*/
    @Column("daifa_order.single_pay")
    private String singlePay;
    /**减免费用*/
    @Column("daifa_order.order_discount_fee")
    private String orderDiscountFee;
    /**单件的代发服务费*/
    @Column("daifa_order.single_services_fee")
    private String singleServicesFee;
    /**商品数量*/
    @Column("daifa_ggoods.goods_num")
    private Integer goodsNum;
    /**子订单备注*/
    @Column("daifa_order.order_remark")
    private String orderRemark;
    /**代发类型@1在线下单2淘宝同步订单3代拿4淘宝商户下单*/
    @Column("daifa_trade.daifa_type")
    private Integer daifaType;
    /**拿货状态@1未拿2已拿3缺货（默认为1）*/
    @Column("daifa_ggoods.take_goods_status")
    private Integer takeGoodsStatus;
    /**有货日期*/
    @Column("daifa_ggoods.youhuo_date")
    private java.util.Date youhuoDate;
    /**是否下架@0可售1下架*/
    @Column("daifa_ggoods.delist_is")
    private Integer delistIs;
    @Column("daifa_ggoods.daifa_worker_id")
    private Long daifaWorkerId;

    public Long getDaifaWorkerId() {
        return daifaWorkerId;
    }

    public void setDaifaWorkerId(Long daifaWorkerId) {
        this.daifaWorkerId = daifaWorkerId;
    }

    public Long getTakeGoodsId() {
        return takeGoodsId;
    }

    public void setTakeGoodsId(Long takeGoodsId) {
        this.takeGoodsId = takeGoodsId;
    }

    public Long getDfOrderId() {
        return dfOrderId;
    }

    public void setDfOrderId(Long dfOrderId) {
        this.dfOrderId = dfOrderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPropStr() {
        return propStr;
    }

    public void setPropStr(String propStr) {
        this.propStr = propStr;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getStoreGoodsCode() {
        return storeGoodsCode;
    }

    public void setStoreGoodsCode(String storeGoodsCode) {
        this.storeGoodsCode = storeGoodsCode;
    }

    public String getSinglePiPrice() {
        return singlePiPrice;
    }

    public void setSinglePiPrice(String singlePiPrice) {
        this.singlePiPrice = singlePiPrice;
    }

    public String getSinglePay() {
        return singlePay;
    }

    public void setSinglePay(String singlePay) {
        this.singlePay = singlePay;
    }

    public String getOrderDiscountFee() {
        return orderDiscountFee;
    }

    public void setOrderDiscountFee(String orderDiscountFee) {
        this.orderDiscountFee = orderDiscountFee;
    }

    public String getSingleServicesFee() {
        return singleServicesFee;
    }

    public void setSingleServicesFee(String singleServicesFee) {
        this.singleServicesFee = singleServicesFee;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Integer getDaifaType() {
        return daifaType;
    }

    public void setDaifaType(Integer daifaType) {
        this.daifaType = daifaType;
    }

    public Integer getTakeGoodsStatus() {
        return takeGoodsStatus;
    }

    public void setTakeGoodsStatus(Integer takeGoodsStatus) {
        this.takeGoodsStatus = takeGoodsStatus;
    }

    public Date getYouhuoDate() {
        return youhuoDate;
    }

    public void setYouhuoDate(Date youhuoDate) {
        this.youhuoDate = youhuoDate;
    }

    public Integer getDelistIs() {
        return delistIs;
    }

    public void setDelistIs(Integer delistIs) {
        this.delistIs = delistIs;
    }
}
