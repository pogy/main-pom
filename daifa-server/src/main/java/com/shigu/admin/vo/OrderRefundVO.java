package com.shigu.admin.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：OrderRefundVO
 * @文件路径：com.shigu.admin.vo.OrderRefundVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/12 18:09
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class OrderRefundVO implements Serializable{

    private Long dfTradeId;//代发主订单ID
    private Long dfOrderId;//代发子订单ID
    private String tradeCode;//订单ID
    private String orderCode;//子订单ID
    private String orderPartitionId;//折单ID
    private Integer orderStatus;//订单状态@1、已付款（等待分配），2、配货中，3、发货
    private Integer allocatStatus;//配货状态@0待分配1已分配
    private Integer takeGoodsStatus;//拿货状态@0未拿1已拿2缺货（默认为0）
    private Integer refundStatus;//退款状态@1等待退款2已退款
    private String propStr;//颜色尺码
    private String goodsNum;//商品数量
    private String goodsCode;//货号
    private String storeGoodsCode;//商家编码
    private String marketName;//市场名
    private String floorName;//楼层名
    private String storeNum;//档口号
    private String picPath;//商品图片
    private String title;//商品标题
    private String singlePiPrice;//批发价
    private Integer delistIs;//是否下架@0可售1下架
    private Long refundId;//退货ID

    public Long getDfTradeId () {
        return dfTradeId;
    }

    public void setDfTradeId (Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public Long getDfOrderId () {
        return dfOrderId;
    }

    public void setDfOrderId (Long dfOrderId) {
        this.dfOrderId = dfOrderId;
    }

    public String getTradeCode () {
        return tradeCode;
    }

    public void setTradeCode (String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public String getOrderCode () {
        return orderCode;
    }

    public void setOrderCode (String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderPartitionId () {
        return orderPartitionId;
    }

    public void setOrderPartitionId (String orderPartitionId) {
        this.orderPartitionId = orderPartitionId;
    }

    public Integer getOrderStatus () {
        return orderStatus;
    }

    public void setOrderStatus (Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getAllocatStatus () {
        return allocatStatus;
    }

    public void setAllocatStatus (Integer allocatStatus) {
        this.allocatStatus = allocatStatus;
    }

    public Integer getTakeGoodsStatus () {
        return takeGoodsStatus;
    }

    public void setTakeGoodsStatus (Integer takeGoodsStatus) {
        this.takeGoodsStatus = takeGoodsStatus;
    }

    public Integer getRefundStatus () {
        return refundStatus;
    }

    public void setRefundStatus (Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getPropStr () {
        return propStr;
    }

    public void setPropStr (String propStr) {
        this.propStr = propStr;
    }

    public String getGoodsNum () {
        return goodsNum;
    }

    public void setGoodsNum (String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsCode () {
        return goodsCode;
    }

    public void setGoodsCode (String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getStoreGoodsCode () {
        return storeGoodsCode;
    }

    public void setStoreGoodsCode (String storeGoodsCode) {
        this.storeGoodsCode = storeGoodsCode;
    }

    public String getMarketName () {
        return marketName;
    }

    public void setMarketName (String marketName) {
        this.marketName = marketName;
    }

    public String getFloorName () {
        return floorName;
    }

    public void setFloorName (String floorName) {
        this.floorName = floorName;
    }

    public String getStoreNum () {
        return storeNum;
    }

    public void setStoreNum (String storeNum) {
        this.storeNum = storeNum;
    }

    public String getPicPath () {
        return picPath;
    }

    public void setPicPath (String picPath) {
        this.picPath = picPath;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getSinglePiPrice () {
        return singlePiPrice;
    }

    public void setSinglePiPrice (String singlePiPrice) {
        this.singlePiPrice = singlePiPrice;
    }

    public Integer getDelistIs () {
        return delistIs;
    }

    public void setDelistIs (Integer delistIs) {
        this.delistIs = delistIs;
    }

    public Long getRefundId () {
        return refundId;
    }

    public void setRefundId (Long refundId) {
        this.refundId = refundId;
    }
}
