package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaOrder.java
 *@文件路径：com.opentae.data.daifa.beans.DaifaOrder
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:18:56
 *@comments:
 *
 *=========================================================
 */
public class DaifaOrder implements Serializable {
	
	/**子订单ID*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long dfOrderId;
	/**代发ID*/
	private Long dfTradeId;
	/**市场ID*/
	private Long marketId;
	/**市场名*/
	private String marketName;
	/**楼层ID*/
	private Long floorId;
	/**楼层名*/
	private String floorName;
	/**店铺ID*/
	private Long storeId;
	/**档口号*/
	private String storeNum;
	/**商品ID*/
	private Long goodsId;
	/**货号*/
	private String goodsCode;
	/**标题*/
	private String title;
	/**图片地址*/
	private String picPath;
	/**商家编码*/
	private String storeGoodsCode;
	/**sku信息@颜色尺码*/
	private String propStr;
	/**需要的货数量*/
	private Integer goodsNum;
	/**淘宝类目ID*/
	private Long cid;
	/**单件拿货价*/
	private String singlePiPrice;
	/**单件支付价single_price+single_fuwu_fee-orderdiscount_fee*/
	private String singlePay;
	/**单件零售价*/
	private String singlePrice;
	/**减免费用*/
	private String orderDiscountFee;
	/**单件的代发服务费*/
	private String singleServicesFee;
	/**总代发费＝single_services_fee*goods_num*/
	private String totalServiceFee;
	/**支付总款=single_pay*goods_num+single_services_fee*goods_num*/
	private String totalFee;
	/**订单状态@1、已付款（等待分配），2、配货中，3、发货*/
	private Long orderStatus;
	/**配货状态@1待分配2已分配*/
	private Integer allocatStatus;
	/**缺货处理协议@1有货先发*/
	private Integer aggrement;
	/**拿货条码打印状态@1未打印2已打印，分配完才会有这个值*/
	private Integer printBarcodeStatus;
	/**拿货状态@0开始拿货状态1已拿到2缺货*/
	private Integer takeGoodsStatus;
	/**拿货日期*/
	private java.util.Date takeGoodsDate;
	/**拿货识别码*/
	private String cdkey;
	/**创建时间*/
	private java.util.Date createTime;
	/**最后操作时间*/
	private java.util.Date lastDoTime;
	/**条形码上的数量编号@比如10-1总共10件这是第一件*/
	private String barCodeKeyNum;
	/**外部交易编号@订单ID*/
	private String tradeCode;
	/**外部子订单编号@子订单ID*/
	private String orderCode;
	/**子订单分拆的ID*/
	private String orderPartitionId;
	/**入库状态@1入库2出库*/
	private Integer stockStatus;
	/**缺货周期状态@1星缺货2星缺货*/
	private Integer stockoutCycleStatus;
	/**子订单备注*/
	private String orderRemark;
	/**礼品类型*/
	private String giftCode;
	/**有货日期*/
	private java.util.Date haveGoodsDate;
	/**是否下架@0可售1下架*/
	private Integer delistIs;
	/**退款外部ID*/
	private Long refundId;
	/**退款状态@1等待退款2已退款*/
	private Integer refundStatus;
	/**退款时间*/
	private java.util.Date refundApplyTime;
	/**退款/退货原因*/
	private String reCause;
	/**退款完成时间*/
	private java.util.Date refundFinishTime;
	/**退货状态@1等待退货2已退货3退货失败*/
	private Integer returnGoodsStatus;
	/**退货成功所退款的金额*/
	private String returnGoodsFee;
	/**退货申请时间*/
	private java.util.Date returnGoodsApplyTime;
	/**退货完成时间*/
	private java.util.Date returnGoodsFinishTime;
	/**换货时间*/
	private java.util.Date changeTime;
	/**1申请换货2已换货3换货失败发回4换货失败不发回*/
	private Integer changeStatus;
	/**换货原因*/
	private String changeReason;
	/***/
	private String remark1;
	/***/
	private String remark2;
	/**商品重量*/
	private String goodsWeight;//

	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*子订单ID
 	*自动生成
  	*/
    public Long getDfOrderId() {
        return dfOrderId;
    }

    /**
  	* 
  	*set方法
	*子订单ID
 	*自动生成
  	*/
    public void setDfOrderId(Long dfOrderId) {
        this.dfOrderId = dfOrderId;
    }
	/**
  	* 
	*get方法
  	*代发ID
 	*自动生成
  	*/
    public Long getDfTradeId() {
        return dfTradeId;
    }

    /**
  	* 
  	*set方法
	*代发ID
 	*自动生成
  	*/
    public void setDfTradeId(Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }
	/**
  	* 
	*get方法
  	*市场ID
 	*自动生成
  	*/
    public Long getMarketId() {
        return marketId;
    }

    /**
  	* 
  	*set方法
	*市场ID
 	*自动生成
  	*/
    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }
	/**
  	* 
	*get方法
  	*市场名
 	*自动生成
  	*/
    public String getMarketName() {
        return marketName;
    }

    /**
  	* 
  	*set方法
	*市场名
 	*自动生成
  	*/
    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
	/**
  	* 
	*get方法
  	*楼层ID
 	*自动生成
  	*/
    public Long getFloorId() {
        return floorId;
    }

    /**
  	* 
  	*set方法
	*楼层ID
 	*自动生成
  	*/
    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }
	/**
  	* 
	*get方法
  	*楼层名
 	*自动生成
  	*/
    public String getFloorName() {
        return floorName;
    }

    /**
  	* 
  	*set方法
	*楼层名
 	*自动生成
  	*/
    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }
	/**
  	* 
	*get方法
  	*店铺ID
 	*自动生成
  	*/
    public Long getStoreId() {
        return storeId;
    }

    /**
  	* 
  	*set方法
	*店铺ID
 	*自动生成
  	*/
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
	/**
  	* 
	*get方法
  	*档口号
 	*自动生成
  	*/
    public String getStoreNum() {
        return storeNum;
    }

    /**
  	* 
  	*set方法
	*档口号
 	*自动生成
  	*/
    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }
	/**
  	* 
	*get方法
  	*商品ID
 	*自动生成
  	*/
    public Long getGoodsId() {
        return goodsId;
    }

    /**
  	* 
  	*set方法
	*商品ID
 	*自动生成
  	*/
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
	/**
  	* 
	*get方法
  	*货号
 	*自动生成
  	*/
    public String getGoodsCode() {
        return goodsCode;
    }

    /**
  	* 
  	*set方法
	*货号
 	*自动生成
  	*/
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
	/**
  	* 
	*get方法
  	*标题
 	*自动生成
  	*/
    public String getTitle() {
        return title;
    }

    /**
  	* 
  	*set方法
	*标题
 	*自动生成
  	*/
    public void setTitle(String title) {
        this.title = title;
    }
	/**
  	* 
	*get方法
  	*图片地址
 	*自动生成
  	*/
    public String getPicPath() {
        return picPath;
    }

    /**
  	* 
  	*set方法
	*图片地址
 	*自动生成
  	*/
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
	/**
  	* 
	*get方法
  	*商家编码
 	*自动生成
  	*/
    public String getStoreGoodsCode() {
        return storeGoodsCode;
    }

    /**
  	* 
  	*set方法
	*商家编码
 	*自动生成
  	*/
    public void setStoreGoodsCode(String storeGoodsCode) {
        this.storeGoodsCode = storeGoodsCode;
    }
	/**
  	* 
	*get方法
  	*sku信息@颜色尺码
 	*自动生成
  	*/
    public String getPropStr() {
        return propStr;
    }

    /**
  	* 
  	*set方法
	*sku信息@颜色尺码
 	*自动生成
  	*/
    public void setPropStr(String propStr) {
        this.propStr = propStr;
    }
	/**
  	* 
	*get方法
  	*需要的货数量
 	*自动生成
  	*/
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
  	* 
  	*set方法
	*需要的货数量
 	*自动生成
  	*/
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
	/**
  	* 
	*get方法
  	*淘宝类目ID
 	*自动生成
  	*/
    public Long getCid() {
        return cid;
    }

    /**
  	* 
  	*set方法
	*淘宝类目ID
 	*自动生成
  	*/
    public void setCid(Long cid) {
        this.cid = cid;
    }
	/**
  	* 
	*get方法
  	*单件拿货价
 	*自动生成
  	*/
    public String getSinglePiPrice() {
        return singlePiPrice;
    }

    /**
  	* 
  	*set方法
	*单件拿货价
 	*自动生成
  	*/
    public void setSinglePiPrice(String singlePiPrice) {
        this.singlePiPrice = singlePiPrice;
    }
	/**
  	* 
	*get方法
  	*单件支付价single_price+single_fuwu_fee-orderdiscount_fee
 	*自动生成
  	*/
    public String getSinglePay() {
        return singlePay;
    }

    /**
  	* 
  	*set方法
	*单件支付价single_price+single_fuwu_fee-orderdiscount_fee
 	*自动生成
  	*/
    public void setSinglePay(String singlePay) {
        this.singlePay = singlePay;
    }
	/**
  	* 
	*get方法
  	*单件零售价
 	*自动生成
  	*/
    public String getSinglePrice() {
        return singlePrice;
    }

    /**
  	* 
  	*set方法
	*单件零售价
 	*自动生成
  	*/
    public void setSinglePrice(String singlePrice) {
        this.singlePrice = singlePrice;
    }
	/**
  	* 
	*get方法
  	*减免费用
 	*自动生成
  	*/
    public String getOrderDiscountFee() {
        return orderDiscountFee;
    }

    /**
  	* 
  	*set方法
	*减免费用
 	*自动生成
  	*/
    public void setOrderDiscountFee(String orderDiscountFee) {
        this.orderDiscountFee = orderDiscountFee;
    }
	/**
  	* 
	*get方法
  	*单件的代发服务费
 	*自动生成
  	*/
    public String getSingleServicesFee() {
        return singleServicesFee;
    }

    /**
  	* 
  	*set方法
	*单件的代发服务费
 	*自动生成
  	*/
    public void setSingleServicesFee(String singleServicesFee) {
        this.singleServicesFee = singleServicesFee;
    }
	/**
  	* 
	*get方法
  	*总代发费＝single_services_fee*goods_num
 	*自动生成
  	*/
    public String getTotalServiceFee() {
        return totalServiceFee;
    }

    /**
  	* 
  	*set方法
	*总代发费＝single_services_fee*goods_num
 	*自动生成
  	*/
    public void setTotalServiceFee(String totalServiceFee) {
        this.totalServiceFee = totalServiceFee;
    }
	/**
  	* 
	*get方法
  	*支付总款=single_pay*goods_num+single_services_fee*goods_num
 	*自动生成
  	*/
    public String getTotalFee() {
        return totalFee;
    }

    /**
  	* 
  	*set方法
	*支付总款=single_pay*goods_num+single_services_fee*goods_num
 	*自动生成
  	*/
    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }
	/**
  	* 
	*get方法
  	*订单状态@1、已付款（等待分配），2、配货中，3、发货
 	*自动生成
  	*/
    public Long getOrderStatus() {
        return orderStatus;
    }

    /**
  	* 
  	*set方法
	*订单状态@1、已付款（等待分配），2、配货中，3、发货
 	*自动生成
  	*/
    public void setOrderStatus(Long orderStatus) {
        this.orderStatus = orderStatus;
    }
	/**
  	* 
	*get方法
  	*配货状态@1待分配2已分配
 	*自动生成
  	*/
    public Integer getAllocatStatus() {
        return allocatStatus;
    }

    /**
  	* 
  	*set方法
	*配货状态@1待分配2已分配
 	*自动生成
  	*/
    public void setAllocatStatus(Integer allocatStatus) {
        this.allocatStatus = allocatStatus;
    }
	/**
  	* 
	*get方法
  	*缺货处理协议@1有货先发
 	*自动生成
  	*/
    public Integer getAggrement() {
        return aggrement;
    }

    /**
  	* 
  	*set方法
	*缺货处理协议@1有货先发
 	*自动生成
  	*/
    public void setAggrement(Integer aggrement) {
        this.aggrement = aggrement;
    }
	/**
  	* 
	*get方法
  	*拿货条码打印状态@1未打印2已打印，分配完才会有这个值
 	*自动生成
  	*/
    public Integer getPrintBarcodeStatus() {
        return printBarcodeStatus;
    }

    /**
  	* 
  	*set方法
	*拿货条码打印状态@1未打印2已打印，分配完才会有这个值
 	*自动生成
  	*/
    public void setPrintBarcodeStatus(Integer printBarcodeStatus) {
        this.printBarcodeStatus = printBarcodeStatus;
    }
	/**
  	* 
	*get方法
  	*拿货状态@0开始拿货状态1已拿到2缺货
 	*自动生成
  	*/
    public Integer getTakeGoodsStatus() {
        return takeGoodsStatus;
    }

    /**
  	* 
  	*set方法
	*拿货状态@0开始拿货状态1已拿到2缺货
 	*自动生成
  	*/
    public void setTakeGoodsStatus(Integer takeGoodsStatus) {
        this.takeGoodsStatus = takeGoodsStatus;
    }
	/**
  	* 
	*get方法
  	*拿货日期
 	*自动生成
  	*/
    public java.util.Date getTakeGoodsDate() {
        return takeGoodsDate;
    }

    /**
  	* 
  	*set方法
	*拿货日期
 	*自动生成
  	*/
    public void setTakeGoodsDate(java.util.Date takeGoodsDate) {
        this.takeGoodsDate = takeGoodsDate;
    }
	/**
  	* 
	*get方法
  	*拿货识别码
 	*自动生成
  	*/
    public String getCdkey() {
        return cdkey;
    }

    /**
  	* 
  	*set方法
	*拿货识别码
 	*自动生成
  	*/
    public void setCdkey(String cdkey) {
        this.cdkey = cdkey;
    }
	/**
  	* 
	*get方法
  	*创建时间
 	*自动生成
  	*/
    public java.util.Date getCreateTime() {
        return createTime;
    }

    /**
  	* 
  	*set方法
	*创建时间
 	*自动生成
  	*/
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
	/**
  	* 
	*get方法
  	*最后操作时间
 	*自动生成
  	*/
    public java.util.Date getLastDoTime() {
        return lastDoTime;
    }

    /**
  	* 
  	*set方法
	*最后操作时间
 	*自动生成
  	*/
    public void setLastDoTime(java.util.Date lastDoTime) {
        this.lastDoTime = lastDoTime;
    }
	/**
  	* 
	*get方法
  	*条形码上的数量编号@比如10-1总共10件这是第一件
 	*自动生成
  	*/
    public String getBarCodeKeyNum() {
        return barCodeKeyNum;
    }

    /**
  	* 
  	*set方法
	*条形码上的数量编号@比如10-1总共10件这是第一件
 	*自动生成
  	*/
    public void setBarCodeKeyNum(String barCodeKeyNum) {
        this.barCodeKeyNum = barCodeKeyNum;
    }
	/**
  	* 
	*get方法
  	*外部交易编号@订单ID
 	*自动生成
  	*/
    public String getTradeCode() {
        return tradeCode;
    }

    /**
  	* 
  	*set方法
	*外部交易编号@订单ID
 	*自动生成
  	*/
    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }
	/**
  	* 
	*get方法
  	*外部子订单编号@子订单ID
 	*自动生成
  	*/
    public String getOrderCode() {
        return orderCode;
    }

    /**
  	* 
  	*set方法
	*外部子订单编号@子订单ID
 	*自动生成
  	*/
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
	/**
  	* 
	*get方法
  	*子订单分拆的ID
 	*自动生成
  	*/
    public String getOrderPartitionId() {
        return orderPartitionId;
    }

    /**
  	* 
  	*set方法
	*子订单分拆的ID
 	*自动生成
  	*/
    public void setOrderPartitionId(String orderPartitionId) {
        this.orderPartitionId = orderPartitionId;
    }
	/**
  	* 
	*get方法
  	*入库状态@1入库2出库
 	*自动生成
  	*/
    public Integer getStockStatus() {
        return stockStatus;
    }

    /**
  	* 
  	*set方法
	*入库状态@1入库2出库
 	*自动生成
  	*/
    public void setStockStatus(Integer stockStatus) {
        this.stockStatus = stockStatus;
    }
	/**
  	* 
	*get方法
  	*缺货周期状态@1星缺货2星缺货
 	*自动生成
  	*/
    public Integer getStockoutCycleStatus() {
        return stockoutCycleStatus;
    }

    /**
  	* 
  	*set方法
	*缺货周期状态@1星缺货2星缺货
 	*自动生成
  	*/
    public void setStockoutCycleStatus(Integer stockoutCycleStatus) {
        this.stockoutCycleStatus = stockoutCycleStatus;
    }
	/**
  	* 
	*get方法
  	*子订单备注
 	*自动生成
  	*/
    public String getOrderRemark() {
        return orderRemark;
    }

    /**
  	* 
  	*set方法
	*子订单备注
 	*自动生成
  	*/
    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }
	/**
  	* 
	*get方法
  	*礼品类型
 	*自动生成
  	*/
    public String getGiftCode() {
        return giftCode;
    }

    /**
  	* 
  	*set方法
	*礼品类型
 	*自动生成
  	*/
    public void setGiftCode(String giftCode) {
        this.giftCode = giftCode;
    }
	/**
  	* 
	*get方法
  	*有货日期
 	*自动生成
  	*/
    public java.util.Date getHaveGoodsDate() {
        return haveGoodsDate;
    }

    /**
  	* 
  	*set方法
	*有货日期
 	*自动生成
  	*/
    public void setHaveGoodsDate(java.util.Date haveGoodsDate) {
        this.haveGoodsDate = haveGoodsDate;
    }
	/**
  	* 
	*get方法
  	*是否下架@0可售1下架
 	*自动生成
  	*/
    public Integer getDelistIs() {
        return delistIs;
    }

    /**
  	* 
  	*set方法
	*是否下架@0可售1下架
 	*自动生成
  	*/
    public void setDelistIs(Integer delistIs) {
        this.delistIs = delistIs;
    }
	/**
  	* 
	*get方法
  	*退款外部ID
 	*自动生成
  	*/
    public Long getRefundId() {
        return refundId;
    }

    /**
  	* 
  	*set方法
	*退款外部ID
 	*自动生成
  	*/
    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }
	/**
  	* 
	*get方法
  	*退款状态@1等待退款2已退款
 	*自动生成
  	*/
    public Integer getRefundStatus() {
        return refundStatus;
    }

    /**
  	* 
  	*set方法
	*退款状态@1等待退款2已退款
 	*自动生成
  	*/
    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }
	/**
  	* 
	*get方法
  	*退款时间
 	*自动生成
  	*/
    public java.util.Date getRefundApplyTime() {
        return refundApplyTime;
    }

    /**
  	* 
  	*set方法
	*退款时间
 	*自动生成
  	*/
    public void setRefundApplyTime(java.util.Date refundApplyTime) {
        this.refundApplyTime = refundApplyTime;
    }
	/**
  	* 
	*get方法
  	*退款/退货原因
 	*自动生成
  	*/
    public String getReCause() {
        return reCause;
    }

    /**
  	* 
  	*set方法
	*退款/退货原因
 	*自动生成
  	*/
    public void setReCause(String reCause) {
        this.reCause = reCause;
    }
	/**
  	* 
	*get方法
  	*退款完成时间
 	*自动生成
  	*/
    public java.util.Date getRefundFinishTime() {
        return refundFinishTime;
    }

    /**
  	* 
  	*set方法
	*退款完成时间
 	*自动生成
  	*/
    public void setRefundFinishTime(java.util.Date refundFinishTime) {
        this.refundFinishTime = refundFinishTime;
    }
	/**
  	* 
	*get方法
  	*退货状态@1等待退货2已退货3退货失败
 	*自动生成
  	*/
    public Integer getReturnGoodsStatus() {
        return returnGoodsStatus;
    }

    /**
  	* 
  	*set方法
	*退货状态@1等待退货2已退货3退货失败
 	*自动生成
  	*/
    public void setReturnGoodsStatus(Integer returnGoodsStatus) {
        this.returnGoodsStatus = returnGoodsStatus;
    }
	/**
  	* 
	*get方法
  	*退货成功所退款的金额
 	*自动生成
  	*/
    public String getReturnGoodsFee() {
        return returnGoodsFee;
    }

    /**
  	* 
  	*set方法
	*退货成功所退款的金额
 	*自动生成
  	*/
    public void setReturnGoodsFee(String returnGoodsFee) {
        this.returnGoodsFee = returnGoodsFee;
    }
	/**
  	* 
	*get方法
  	*退货申请时间
 	*自动生成
  	*/
    public java.util.Date getReturnGoodsApplyTime() {
        return returnGoodsApplyTime;
    }

    /**
  	* 
  	*set方法
	*退货申请时间
 	*自动生成
  	*/
    public void setReturnGoodsApplyTime(java.util.Date returnGoodsApplyTime) {
        this.returnGoodsApplyTime = returnGoodsApplyTime;
    }
	/**
  	* 
	*get方法
  	*退货完成时间
 	*自动生成
  	*/
    public java.util.Date getReturnGoodsFinishTime() {
        return returnGoodsFinishTime;
    }

    /**
  	* 
  	*set方法
	*退货完成时间
 	*自动生成
  	*/
    public void setReturnGoodsFinishTime(java.util.Date returnGoodsFinishTime) {
        this.returnGoodsFinishTime = returnGoodsFinishTime;
    }
	/**
  	* 
	*get方法
  	*换货时间
 	*自动生成
  	*/
    public java.util.Date getChangeTime() {
        return changeTime;
    }

    /**
  	* 
  	*set方法
	*换货时间
 	*自动生成
  	*/
    public void setChangeTime(java.util.Date changeTime) {
        this.changeTime = changeTime;
    }
	/**
  	* 
	*get方法
  	*1申请换货2已换货3换货失败发回4换货失败不发回
 	*自动生成
  	*/
    public Integer getChangeStatus() {
        return changeStatus;
    }

    /**
  	* 
  	*set方法
	*1申请换货2已换货3换货失败发回4换货失败不发回
 	*自动生成
  	*/
    public void setChangeStatus(Integer changeStatus) {
        this.changeStatus = changeStatus;
    }
	/**
  	* 
	*get方法
  	*换货原因
 	*自动生成
  	*/
    public String getChangeReason() {
        return changeReason;
    }

    /**
  	* 
  	*set方法
	*换货原因
 	*自动生成
  	*/
    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark1() {
        return remark1;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark2() {
        return remark2;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

	public String getGoodsWeight () {
		return goodsWeight;
	}

	public void setGoodsWeight (String goodsWeight) {
		this.goodsWeight = goodsWeight;
	}
}
