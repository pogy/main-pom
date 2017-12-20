package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DaifaAfterSaleSub implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long afterSaleSubId;

    /**
     * ID
     */
	private Long afterSaleId;

    /**
     * 交易Id
     */
	private Long dfTradeId;

    /**
     * 
     */
	private String tradeCode;

    /**
     * 订单ID
     */
	private Long dfOrderId;

    /**
     * 
     */
	private String orderCode;

    /**
     * 
     */
	private String orderPartitionId;

    /**
     * 退货ID
     */
	private Long refundId;

    /**
     * 代发ID
     */
	private Long sellerId;

    /**
     * 售后类型@1退货2换货
     */
	private Integer afterType;

    /**
     * 售后状态@0无售后1售后申请2申请处理3客户发货4收到货5档口退换货完成6客户确认7客户拒绝10协商解决
     */
	private Integer afterStatus;

    /**
     * 申请时间
     */
	private Date applyTime;

    /**
     * 售后申请状态@1同意并发送售后收货地址2拒绝
     */
	private Integer applyDealStatus;

    /**
     * 申请处理时间
     */
	private Date applyDealTime;

    /**
     * 拒绝申请的原因
     */
	private String applyRefuseReason;

    /**
     * 收货时间
     */
	private Date receivedTime;

    /**
     * 档口处理状态@1档口退换货完成2拒绝
     */
	private Integer storeDealStatus;

    /**
     * 档口处理的时间
     */
	private Date storeDealTime;

    /**
     * 档口拒绝的原因
     */
	private String storeRefuseReason;

    /**
     * 档口退回的金额@以元为单位
     */
	private String storeReturnMoney;

    /**
     * 最后的操作时间
     */
	private Date lastDoTime;

    /**
     * 寄回的快递名@退换货信息
     */
	private String applyExpressName;

    /**
     * 寄回的快递号@退换货信息
     */
	private String applyExpressCode;

    /**
     * 创建日期@ YYYYMMDD
     */
	private String createDate;

    /**
     * 退货发回的快递单号
     */
	private String returnExpressCode;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 换回的快递单号
     */
	private String changeExpressCode;

    /**
     * 退货发回的快递名
     */
	private String returnExpressName;

    /**
     * 换货发回快递名
     */
	private String changeExpressName;

    /**
     * 发回日期@ YYYYMMDD
     */
	private String sendReturnDate;

    /**
     * 发回时间
     */
	private Date sendReturnTime;

    /**
     * 市场ID
     */
	private Long marketId;

    /**
     * 市场名
     */
	private String marketName;

    /**
     * 楼层Id
     */
	private Long floorId;

    /**
     * 楼层
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
     * 商家编码
     */
	private String storeGoodsCode;

    /**
     * 货号
     */
	private String goodsCode;

    /**
     * 标题
     */
	private String title;

    /**
     * 
     */
	private String webSite;

    /**
     * 颜色尺码
     */
	private String propStr;

    /**
     * 图片地址
     */
	private String picPath;

    /**
     * 批发价@以元为单位
     */
	private String singlePiPrice;

    /**
     * 零售价@以元为单位
     */
	private String singlePrice;

    /**
     * 商品数量
     */
	private Integer goodsNum;

    /**
     * 已拿数量
     */
	private Integer hasNum;

    /**
     * 入库类型@1售后退货入库2退货失败入库
     */
	private Integer inStock;

    /**
     * 入库后存储的货架
     */
	private String stockLocation;

    /**
     * 卖家备注
     */
	private String remark;

    /**
     * 买家ID
     */
	private Integer buyerId;

    /**
     * 买家姓名
     */
	private String buyerName;

    /**
     * 买家电话
     */
	private String buyerTelephone;

    /**
     * 买家QQ
     */
	private String buyerQq;

    /**
     * 买家旺旺
     */
	private String buyerWw;

    /**
     * 备用1
     */
	private String remark1;

    /**
     * 备用2
     */
	private String remark2;

	public void setAfterSaleSubId(Long afterSaleSubId) {
		this.afterSaleSubId = afterSaleSubId;
	}

	public Long getAfterSaleSubId() {
		return this.afterSaleSubId;
	}

	public void setAfterSaleId(Long afterSaleId) {
		this.afterSaleId = afterSaleId;
	}

	public Long getAfterSaleId() {
		return this.afterSaleId;
	}

	public void setDfTradeId(Long dfTradeId) {
		this.dfTradeId = dfTradeId;
	}

	public Long getDfTradeId() {
		return this.dfTradeId;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getTradeCode() {
		return this.tradeCode;
	}

	public void setDfOrderId(Long dfOrderId) {
		this.dfOrderId = dfOrderId;
	}

	public Long getDfOrderId() {
		return this.dfOrderId;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderPartitionId(String orderPartitionId) {
		this.orderPartitionId = orderPartitionId;
	}

	public String getOrderPartitionId() {
		return this.orderPartitionId;
	}

	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}

	public Long getRefundId() {
		return this.refundId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getSellerId() {
		return this.sellerId;
	}

	public void setAfterType(Integer afterType) {
		this.afterType = afterType;
	}

	public Integer getAfterType() {
		return this.afterType;
	}

	public void setAfterStatus(Integer afterStatus) {
		this.afterStatus = afterStatus;
	}

	public Integer getAfterStatus() {
		return this.afterStatus;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setApplyDealStatus(Integer applyDealStatus) {
		this.applyDealStatus = applyDealStatus;
	}

	public Integer getApplyDealStatus() {
		return this.applyDealStatus;
	}

	public void setApplyDealTime(Date applyDealTime) {
		this.applyDealTime = applyDealTime;
	}

	public Date getApplyDealTime() {
		return this.applyDealTime;
	}

	public void setApplyRefuseReason(String applyRefuseReason) {
		this.applyRefuseReason = applyRefuseReason;
	}

	public String getApplyRefuseReason() {
		return this.applyRefuseReason;
	}

	public void setReceivedTime(Date receivedTime) {
		this.receivedTime = receivedTime;
	}

	public Date getReceivedTime() {
		return this.receivedTime;
	}

	public void setStoreDealStatus(Integer storeDealStatus) {
		this.storeDealStatus = storeDealStatus;
	}

	public Integer getStoreDealStatus() {
		return this.storeDealStatus;
	}

	public void setStoreDealTime(Date storeDealTime) {
		this.storeDealTime = storeDealTime;
	}

	public Date getStoreDealTime() {
		return this.storeDealTime;
	}

	public void setStoreRefuseReason(String storeRefuseReason) {
		this.storeRefuseReason = storeRefuseReason;
	}

	public String getStoreRefuseReason() {
		return this.storeRefuseReason;
	}

	public void setStoreReturnMoney(String storeReturnMoney) {
		this.storeReturnMoney = storeReturnMoney;
	}

	public String getStoreReturnMoney() {
		return this.storeReturnMoney;
	}

	public void setLastDoTime(Date lastDoTime) {
		this.lastDoTime = lastDoTime;
	}

	public Date getLastDoTime() {
		return this.lastDoTime;
	}

	public void setApplyExpressName(String applyExpressName) {
		this.applyExpressName = applyExpressName;
	}

	public String getApplyExpressName() {
		return this.applyExpressName;
	}

	public void setApplyExpressCode(String applyExpressCode) {
		this.applyExpressCode = applyExpressCode;
	}

	public String getApplyExpressCode() {
		return this.applyExpressCode;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setReturnExpressCode(String returnExpressCode) {
		this.returnExpressCode = returnExpressCode;
	}

	public String getReturnExpressCode() {
		return this.returnExpressCode;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setChangeExpressCode(String changeExpressCode) {
		this.changeExpressCode = changeExpressCode;
	}

	public String getChangeExpressCode() {
		return this.changeExpressCode;
	}

	public void setReturnExpressName(String returnExpressName) {
		this.returnExpressName = returnExpressName;
	}

	public String getReturnExpressName() {
		return this.returnExpressName;
	}

	public void setChangeExpressName(String changeExpressName) {
		this.changeExpressName = changeExpressName;
	}

	public String getChangeExpressName() {
		return this.changeExpressName;
	}

	public void setSendReturnDate(String sendReturnDate) {
		this.sendReturnDate = sendReturnDate;
	}

	public String getSendReturnDate() {
		return this.sendReturnDate;
	}

	public void setSendReturnTime(Date sendReturnTime) {
		this.sendReturnTime = sendReturnTime;
	}

	public Date getSendReturnTime() {
		return this.sendReturnTime;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Long getMarketId() {
		return this.marketId;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getMarketName() {
		return this.marketName;
	}

	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}

	public Long getFloorId() {
		return this.floorId;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getFloorName() {
		return this.floorName;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getStoreId() {
		return this.storeId;
	}

	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

	public String getStoreNum() {
		return this.storeNum;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setStoreGoodsCode(String storeGoodsCode) {
		this.storeGoodsCode = storeGoodsCode;
	}

	public String getStoreGoodsCode() {
		return this.storeGoodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsCode() {
		return this.goodsCode;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setPropStr(String propStr) {
		this.propStr = propStr;
	}

	public String getPropStr() {
		return this.propStr;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getPicPath() {
		return this.picPath;
	}

	public void setSinglePiPrice(String singlePiPrice) {
		this.singlePiPrice = singlePiPrice;
	}

	public String getSinglePiPrice() {
		return this.singlePiPrice;
	}

	public void setSinglePrice(String singlePrice) {
		this.singlePrice = singlePrice;
	}

	public String getSinglePrice() {
		return this.singlePrice;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Integer getGoodsNum() {
		return this.goodsNum;
	}

	public void setHasNum(Integer hasNum) {
		this.hasNum = hasNum;
	}

	public Integer getHasNum() {
		return this.hasNum;
	}

	public void setInStock(Integer inStock) {
		this.inStock = inStock;
	}

	public Integer getInStock() {
		return this.inStock;
	}

	public void setStockLocation(String stockLocation) {
		this.stockLocation = stockLocation;
	}

	public String getStockLocation() {
		return this.stockLocation;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerName() {
		return this.buyerName;
	}

	public void setBuyerTelephone(String buyerTelephone) {
		this.buyerTelephone = buyerTelephone;
	}

	public String getBuyerTelephone() {
		return this.buyerTelephone;
	}

	public void setBuyerQq(String buyerQq) {
		this.buyerQq = buyerQq;
	}

	public String getBuyerQq() {
		return this.buyerQq;
	}

	public void setBuyerWw(String buyerWw) {
		this.buyerWw = buyerWw;
	}

	public String getBuyerWw() {
		return this.buyerWw;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark2() {
		return this.remark2;
	}

}