package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DaifaOrder implements Serializable {
    /**
     * 子订单ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long dfOrderId;

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
     * 商家编码
     */
	private String storeGoodsCode;

    /**
     * 标题
     */
	private String title;

    /**
     * 图片地址
     */
	private String picPath;

    /**
     * sku信息@颜色尺码
     */
	private String propStr;

    /**
     * 需要的货数量
     */
	private Integer goodsNum;

    /**
     * 商品重量
     */
	private String goodsWeight;

    /**
     * 淘宝类目ID
     */
	private Long cid;

    /**
     * 单件拿货价
     */
	private String singlePiPrice;

    /**
     * 单件支付价single_price+single_services_fee-orderdiscount_fee
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
     * 支付总款=single_pay*goods_num
     */
	private String totalFee;

    /**
     * 订单状态@1、已付款（等待分配），2、配货中，3、发货
     */
	private Integer orderStatus;

    /**
     * 配货状态@0待分配1已分配
     */
	private Integer allocatStatus;

    /**
     * 缺货处理协议@1有货先发
     */
	private Integer aggrement;

    /**
     * 拿货条码打印状态@1未打印2已打印，分配完才会有这个值
     */
	private Integer printBarcodeStatus;

    /**
     * 拿货状态@0未拿1已拿2缺货（默认为0）
     */
	private Integer takeGoodsStatus;

    /**
     * 拿货日期
     */
	private Date takeGoodsDate;

    /**
     * 拿货识别码
     */
	private String cdkey;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 最后操作时间
     */
	private Date lastDoTime;

    /**
     * 条形码上的数量编号@比如10-1总共10件这是第一件
     */
	private String barCodeKeyNum;

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
     * 入库状态@1入库2出库
     */
	private Integer stockStatus;

    /**
     * 缺货周期状态@1星缺货2星缺货
     */
	private Integer stockoutCycleStatus;

    /**
     * 子订单备注
     */
	private String orderRemark;

    /**
     * 礼品类型
     */
	private String giftCode;

    /**
     * 有货日期
     */
	private Date haveGoodsDate;

    /**
     * 是否下架@0可售1下架
     */
	private Integer delistIs;

    /**
     * 退款外部ID
     */
	private Long refundId;

    /**
     * 退款状态@1等待退款2已退款
     */
	private Integer refundStatus;

    /**
     * 退款时间
     */
	private Date refundApplyTime;

    /**
     * 退款/退货原因
     */
	private String reCause;

    /**
     * 退款完成时间
     */
	private Date refundFinishTime;

    /**
     * 退货状态@1等待退货2已退货3退货失败
     */
	private Integer returnGoodsStatus;

    /**
     * 退货成功所退款的金额
     */
	private String returnGoodsFee;

    /**
     * 退货申请时间
     */
	private Date returnGoodsApplyTime;

    /**
     * 退货完成时间
     */
	private Date returnGoodsFinishTime;

    /**
     * 换货时间
     */
	private Date changeTime;

    /**
     * 1申请换货2已换货3换货失败发回4换货失败不发回
     */
	private Integer changeStatus;

    /**
     * 换货原因
     */
	private String changeReason;

    /**
     * 
     */
	private String remark1;

    /**
     * 
     */
	private String remark2;

    /**
     * 未发货款的金额
     */
	private String refundMoneyHasItem;

	public void setDfOrderId(Long dfOrderId) {
		this.dfOrderId = dfOrderId;
	}

	public Long getDfOrderId() {
		return this.dfOrderId;
	}

	public void setDfTradeId(Long dfTradeId) {
		this.dfTradeId = dfTradeId;
	}

	public Long getDfTradeId() {
		return this.dfTradeId;
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

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsCode() {
		return this.goodsCode;
	}

	public void setStoreGoodsCode(String storeGoodsCode) {
		this.storeGoodsCode = storeGoodsCode;
	}

	public String getStoreGoodsCode() {
		return this.storeGoodsCode;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getPicPath() {
		return this.picPath;
	}

	public void setPropStr(String propStr) {
		this.propStr = propStr;
	}

	public String getPropStr() {
		return this.propStr;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Integer getGoodsNum() {
		return this.goodsNum;
	}

	public void setGoodsWeight(String goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	public String getGoodsWeight() {
		return this.goodsWeight;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setSinglePiPrice(String singlePiPrice) {
		this.singlePiPrice = singlePiPrice;
	}

	public String getSinglePiPrice() {
		return this.singlePiPrice;
	}

	public void setSinglePay(String singlePay) {
		this.singlePay = singlePay;
	}

	public String getSinglePay() {
		return this.singlePay;
	}

	public void setSinglePrice(String singlePrice) {
		this.singlePrice = singlePrice;
	}

	public String getSinglePrice() {
		return this.singlePrice;
	}

	public void setOrderDiscountFee(String orderDiscountFee) {
		this.orderDiscountFee = orderDiscountFee;
	}

	public String getOrderDiscountFee() {
		return this.orderDiscountFee;
	}

	public void setSingleServicesFee(String singleServicesFee) {
		this.singleServicesFee = singleServicesFee;
	}

	public String getSingleServicesFee() {
		return this.singleServicesFee;
	}

	public void setTotalServiceFee(String totalServiceFee) {
		this.totalServiceFee = totalServiceFee;
	}

	public String getTotalServiceFee() {
		return this.totalServiceFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getTotalFee() {
		return this.totalFee;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setAllocatStatus(Integer allocatStatus) {
		this.allocatStatus = allocatStatus;
	}

	public Integer getAllocatStatus() {
		return this.allocatStatus;
	}

	public void setAggrement(Integer aggrement) {
		this.aggrement = aggrement;
	}

	public Integer getAggrement() {
		return this.aggrement;
	}

	public void setPrintBarcodeStatus(Integer printBarcodeStatus) {
		this.printBarcodeStatus = printBarcodeStatus;
	}

	public Integer getPrintBarcodeStatus() {
		return this.printBarcodeStatus;
	}

	public void setTakeGoodsStatus(Integer takeGoodsStatus) {
		this.takeGoodsStatus = takeGoodsStatus;
	}

	public Integer getTakeGoodsStatus() {
		return this.takeGoodsStatus;
	}

	public void setTakeGoodsDate(Date takeGoodsDate) {
		this.takeGoodsDate = takeGoodsDate;
	}

	public Date getTakeGoodsDate() {
		return this.takeGoodsDate;
	}

	public void setCdkey(String cdkey) {
		this.cdkey = cdkey;
	}

	public String getCdkey() {
		return this.cdkey;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setLastDoTime(Date lastDoTime) {
		this.lastDoTime = lastDoTime;
	}

	public Date getLastDoTime() {
		return this.lastDoTime;
	}

	public void setBarCodeKeyNum(String barCodeKeyNum) {
		this.barCodeKeyNum = barCodeKeyNum;
	}

	public String getBarCodeKeyNum() {
		return this.barCodeKeyNum;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getTradeCode() {
		return this.tradeCode;
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

	public void setStockStatus(Integer stockStatus) {
		this.stockStatus = stockStatus;
	}

	public Integer getStockStatus() {
		return this.stockStatus;
	}

	public void setStockoutCycleStatus(Integer stockoutCycleStatus) {
		this.stockoutCycleStatus = stockoutCycleStatus;
	}

	public Integer getStockoutCycleStatus() {
		return this.stockoutCycleStatus;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public String getOrderRemark() {
		return this.orderRemark;
	}

	public void setGiftCode(String giftCode) {
		this.giftCode = giftCode;
	}

	public String getGiftCode() {
		return this.giftCode;
	}

	public void setHaveGoodsDate(Date haveGoodsDate) {
		this.haveGoodsDate = haveGoodsDate;
	}

	public Date getHaveGoodsDate() {
		return this.haveGoodsDate;
	}

	public void setDelistIs(Integer delistIs) {
		this.delistIs = delistIs;
	}

	public Integer getDelistIs() {
		return this.delistIs;
	}

	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}

	public Long getRefundId() {
		return this.refundId;
	}

	public void setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
	}

	public Integer getRefundStatus() {
		return this.refundStatus;
	}

	public void setRefundApplyTime(Date refundApplyTime) {
		this.refundApplyTime = refundApplyTime;
	}

	public Date getRefundApplyTime() {
		return this.refundApplyTime;
	}

	public void setReCause(String reCause) {
		this.reCause = reCause;
	}

	public String getReCause() {
		return this.reCause;
	}

	public void setRefundFinishTime(Date refundFinishTime) {
		this.refundFinishTime = refundFinishTime;
	}

	public Date getRefundFinishTime() {
		return this.refundFinishTime;
	}

	public void setReturnGoodsStatus(Integer returnGoodsStatus) {
		this.returnGoodsStatus = returnGoodsStatus;
	}

	public Integer getReturnGoodsStatus() {
		return this.returnGoodsStatus;
	}

	public void setReturnGoodsFee(String returnGoodsFee) {
		this.returnGoodsFee = returnGoodsFee;
	}

	public String getReturnGoodsFee() {
		return this.returnGoodsFee;
	}

	public void setReturnGoodsApplyTime(Date returnGoodsApplyTime) {
		this.returnGoodsApplyTime = returnGoodsApplyTime;
	}

	public Date getReturnGoodsApplyTime() {
		return this.returnGoodsApplyTime;
	}

	public void setReturnGoodsFinishTime(Date returnGoodsFinishTime) {
		this.returnGoodsFinishTime = returnGoodsFinishTime;
	}

	public Date getReturnGoodsFinishTime() {
		return this.returnGoodsFinishTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeStatus(Integer changeStatus) {
		this.changeStatus = changeStatus;
	}

	public Integer getChangeStatus() {
		return this.changeStatus;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	public String getChangeReason() {
		return this.changeReason;
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

	public void setRefundMoneyHasItem(String refundMoneyHasItem) {
		this.refundMoneyHasItem = refundMoneyHasItem;
	}

	public String getRefundMoneyHasItem() {
		return this.refundMoneyHasItem;
	}

}