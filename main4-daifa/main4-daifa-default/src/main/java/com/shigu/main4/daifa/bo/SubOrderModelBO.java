package com.shigu.main4.daifa.bo;

import java.io.Serializable;

public class SubOrderModelBO implements Serializable {
    /**
     * 代发ID
     */
    private Long dfTradeId;
    /**
     * 市场ID
     */
    private Long marketId;
    /**
     * 市场名
     */
    private String marketName;
    /**
     * 楼层ID
     */
    private Long floorId;
    /**
     * 楼层名
     */
    private String floorName;
    /**
     * 店铺ID
     */
    private Long storeId;
    /**
     * 档口号
     */
    private String storeNum;
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 货号
     */
    private String goodsCode;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片地址
     */
    private String picPath;
    /**
     * 商家编码
     */
    private String storeGoodsCode;
    /**
     * sku信息@颜色尺码
     */
    private String propStr;
    /**
     * 需要的货数量
     */
    private Integer goodsNum;
    /**
     * 淘宝类目ID
     */
    private Long cid;
    /**
     * 单件拿货价
     */
    private String singlePiPrice;
    /**
     * 单件支付价single_price+single_fuwu_fee-orderdiscount_fee
     */
    private String singlePay;
    /**
     * 单件零售价
     */
    private String singlePrice;
    /**
     * 减免费用
     */
    private String orderDiscountFee;
    /**
     * 单件的代发服务费
     */
    private String singleServicesFee;
    /**
     * 总代发费＝single_services_fee*goods_num
     */
    private String totalServiceFee;
    /**
     * 支付总款=single_pay*goods_num+single_services_fee*goods_num
     */
    private String totalFee;
    /**
     * 订单状态@1、已付款（等待分配），2、配货中，3、发货
     */
    private Long orderStatus;
    /**
     * 缺货处理协议@1有货先发
     */
    private Integer aggrement;
    /**
     * 外部交易编号@订单ID
     */
    private String tradeCode;
    /**
     * 外部子订单编号@子订单ID
     */
    private String orderCode;
    /**
     * 子订单分拆的ID
     */
    private String orderPartitionId;
    /**
     * 条形码上的数量编号@比如10-1总共10件这是第一件
     */
    private String barCodeKeyNum;
    private String webSite;

    private Long sellerId;

    private String goodsWeight;//商品重量

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }


    public String getBarCodeKeyNum() {
        return barCodeKeyNum;
    }

    public void setBarCodeKeyNum(String barCodeKeyNum) {
        this.barCodeKeyNum = barCodeKeyNum;
    }

    public Long getDfTradeId() {
        return dfTradeId;
    }

    public void setDfTradeId(Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPropStr() {
        return propStr;
    }

    public void setPropStr(String propStr) {
        this.propStr = propStr;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

    public String getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(String singlePrice) {
        this.singlePrice = singlePrice;
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

    public String getTotalServiceFee() {
        return totalServiceFee;
    }

    public void setTotalServiceFee(String totalServiceFee) {
        this.totalServiceFee = totalServiceFee;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public Long getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Long orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getAggrement() {
        return aggrement;
    }

    public void setAggrement(Integer aggrement) {
        this.aggrement = aggrement;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderPartitionId() {
        return orderPartitionId;
    }

    public void setOrderPartitionId(String orderPartitionId) {
        this.orderPartitionId = orderPartitionId;
    }

    public String getGiftCode() {
        return giftCode;
    }

    public void setGiftCode(String giftCode) {
        this.giftCode = giftCode;
    }

    public String getGoodsWeight () {
        return goodsWeight;
    }

    public void setGoodsWeight (String goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    /**
     * 礼品类型
     */
    private String giftCode;
}
