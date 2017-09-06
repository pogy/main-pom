package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaTrade.java
 *@文件路径：com.opentae.data.daifa.beans.DaifaTrade
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-11 01:14:15
 *@comments:
 *
 *=========================================================
 */
public class DaifaTrade implements Serializable {
	
	/***/
	@Id
@GeneratedValue(generator="JDBC")
	private Long dfTradeId;
	/**代发ID*/
	private Long sellerId;
	/**商品数*/
	private Long goodsNum;
	/**重量*/
	private String goodsWeight;
	/**体积*/
	private String goodsVolume;
	/**收件人姓名*/
	private String receiverName;
	/**收件人电话*/
	private String receiverPhone;
	/**收件人省*/
	private String receiverState;
	/**收件人详细地址*/
	private String receiverAddress;
	/**代发类型@1在线下单2淘宝同步订单3代拿4淘宝商户下单*/
	private Integer daifaType;
	/**快递ID*/
	private Long expressId;
	/**快递名*/
	private String expressName;
	/**快递单号*/
	private String expressCode;
	/**1已付款待分配，2、拿货中，3、已发货，4、交易完成，10、交易关闭*/
	private Integer tradeStatus;
	/**商品总费用@以元为单位*/
	private String goodsFee;
	/**快递费用@以元为单位*/
	private String expressFee;
	/**服务费：代发费@以元为单位*/
	private String servicesFee;
	/**vip要减面的费用=所有子单里的order_discount_fee@以元为单位*/
	private String tradeDiscountFee;
	/**减免前总费用（包含快递，代发费）＝goods_fee+post_fee+services_fee*/
	private String totalFee;
	/**总钱数（包含快递，代发费）＝total_fee-trade_discount_fee*/
	private String money;
	/**实付钱数＝money*/
	private String realPayMoney;
	/**条形码上的特有编号*/
	private String barCodeKey;
	/**交易编号（订单系统订单ID）*/
	private String tradeCode;
	/**创建时间*/
	private java.util.Date createTime;
	/**最后修改时间*/
	private java.util.Date lastDoTime;
	/**发货时间*/
	private java.util.Date sendTime;
	/**完成时间@发货后15天未退货时写入*/
	private java.util.Date finishTime;
	/**发货状态@0未开始1未发2发货*/
	private Integer sendStatus;
	/**订单关闭时间*/
	private java.util.Date closeTime;
	/**买家留言*/
	private String buyerRemark;
	/**分销商ID@可为空*/
	private Long buyerId;
	/**分销商名称@可为空*/
	private String buyerName;
	/**分销商旺旺@可为空*/
	private String buyerWw;
	/**打印快递单@1未打印2已打印*/
	private Integer printExpressStatus;
	/**收件人邮编*/
	private String receiverZip;
	/**收件人手机（废弃）*/
	private String receiverMobile;
	/***/
	private String remark1;
	/***/
	private String remark2;
	/**淘宝订单号tid@可为空*/
	private Long taobaoTid;
	/**下拉订单的淘宝账户的昵称@可为空*/
	private String taobaoUserNick;
	/**分销商QQ@可为空*/
	private String buyerQq;
	/**分销商微信@可为空*/
	private String buyerWx;
	/**分销商电话@可为空*/
	private String buyerTelephone;
	/**代发名称*/
	private String sellerName;
	/**付款状态@ 1未付款2已付款*/
	private Integer payStatus;
	/**支付时间*/
	private java.util.Date payTime;
	/**收货人QQ*/
	private String receiverQq;
	/**买家昵称*/
	private String buyerNick;
	/**
	 * 售后备注
	 */
	private String afterRemark;
	private Integer isOld;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getDfTradeId() {
        return dfTradeId;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setDfTradeId(Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }
	/**
  	* 
	*get方法
  	*代发ID
 	*自动生成
  	*/
    public Long getSellerId() {
        return sellerId;
    }

    /**
  	* 
  	*set方法
	*代发ID
 	*自动生成
  	*/
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
	/**
  	* 
	*get方法
  	*商品数
 	*自动生成
  	*/
    public Long getGoodsNum() {
        return goodsNum;
    }

    /**
  	* 
  	*set方法
	*商品数
 	*自动生成
  	*/
    public void setGoodsNum(Long goodsNum) {
        this.goodsNum = goodsNum;
    }
	/**
  	* 
	*get方法
  	*重量
 	*自动生成
  	*/
    public String getGoodsWeight() {
        return goodsWeight;
    }

    /**
  	* 
  	*set方法
	*重量
 	*自动生成
  	*/
    public void setGoodsWeight(String goodsWeight) {
        this.goodsWeight = goodsWeight;
    }
	/**
  	* 
	*get方法
  	*体积
 	*自动生成
  	*/
    public String getGoodsVolume() {
        return goodsVolume;
    }

    /**
  	* 
  	*set方法
	*体积
 	*自动生成
  	*/
    public void setGoodsVolume(String goodsVolume) {
        this.goodsVolume = goodsVolume;
    }
	/**
  	* 
	*get方法
  	*收件人姓名
 	*自动生成
  	*/
    public String getReceiverName() {
        return receiverName;
    }

    /**
  	* 
  	*set方法
	*收件人姓名
 	*自动生成
  	*/
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
	/**
  	* 
	*get方法
  	*收件人电话
 	*自动生成
  	*/
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
  	* 
  	*set方法
	*收件人电话
 	*自动生成
  	*/
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
	/**
  	* 
	*get方法
  	*收件人省
 	*自动生成
  	*/
    public String getReceiverState() {
        return receiverState;
    }

    /**
  	* 
  	*set方法
	*收件人省
 	*自动生成
  	*/
    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }
	/**
  	* 
	*get方法
  	*收件人详细地址
 	*自动生成
  	*/
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
  	* 
  	*set方法
	*收件人详细地址
 	*自动生成
  	*/
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
	/**
  	* 
	*get方法
  	*代发类型@1在线下单2淘宝同步订单3代拿4淘宝商户下单
 	*自动生成
  	*/
    public Integer getDaifaType() {
        return daifaType;
    }

    /**
  	* 
  	*set方法
	*代发类型@1在线下单2淘宝同步订单3代拿4淘宝商户下单
 	*自动生成
  	*/
    public void setDaifaType(Integer daifaType) {
        this.daifaType = daifaType;
    }
	/**
  	* 
	*get方法
  	*快递ID
 	*自动生成
  	*/
    public Long getExpressId() {
        return expressId;
    }

    /**
  	* 
  	*set方法
	*快递ID
 	*自动生成
  	*/
    public void setExpressId(Long expressId) {
        this.expressId = expressId;
    }
	/**
  	* 
	*get方法
  	*快递名
 	*自动生成
  	*/
    public String getExpressName() {
        return expressName;
    }

    /**
  	* 
  	*set方法
	*快递名
 	*自动生成
  	*/
    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }
	/**
  	* 
	*get方法
  	*快递单号
 	*自动生成
  	*/
    public String getExpressCode() {
        return expressCode;
    }

    /**
  	* 
  	*set方法
	*快递单号
 	*自动生成
  	*/
    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }
	/**
  	* 
	*get方法
  	*1已付款待分配，2、拿货中，3、已发货，4、交易完成，10、交易关闭
 	*自动生成
  	*/
    public Integer getTradeStatus() {
        return tradeStatus;
    }

    /**
  	* 
  	*set方法
	*1已付款待分配，2、拿货中，3、已发货，4、交易完成，10、交易关闭
 	*自动生成
  	*/
    public void setTradeStatus(Integer tradeStatus) {
        this.tradeStatus = tradeStatus;
    }
	/**
  	* 
	*get方法
  	*商品总费用@以元为单位
 	*自动生成
  	*/
    public String getGoodsFee() {
        return goodsFee;
    }

    /**
  	* 
  	*set方法
	*商品总费用@以元为单位
 	*自动生成
  	*/
    public void setGoodsFee(String goodsFee) {
        this.goodsFee = goodsFee;
    }
	/**
  	* 
	*get方法
  	*快递费用@以元为单位
 	*自动生成
  	*/
    public String getExpressFee() {
        return expressFee;
    }

    /**
  	* 
  	*set方法
	*快递费用@以元为单位
 	*自动生成
  	*/
    public void setExpressFee(String expressFee) {
        this.expressFee = expressFee;
    }
	/**
  	* 
	*get方法
  	*服务费：代发费@以元为单位
 	*自动生成
  	*/
    public String getServicesFee() {
        return servicesFee;
    }

    /**
  	* 
  	*set方法
	*服务费：代发费@以元为单位
 	*自动生成
  	*/
    public void setServicesFee(String servicesFee) {
        this.servicesFee = servicesFee;
    }
	/**
  	* 
	*get方法
  	*vip要减面的费用=所有子单里的order_discount_fee@以元为单位
 	*自动生成
  	*/
    public String getTradeDiscountFee() {
        return tradeDiscountFee;
    }

    /**
  	* 
  	*set方法
	*vip要减面的费用=所有子单里的order_discount_fee@以元为单位
 	*自动生成
  	*/
    public void setTradeDiscountFee(String tradeDiscountFee) {
        this.tradeDiscountFee = tradeDiscountFee;
    }
	/**
  	* 
	*get方法
  	*减免前总费用（包含快递，代发费）＝goods_fee+post_fee+services_fee
 	*自动生成
  	*/
    public String getTotalFee() {
        return totalFee;
    }

    /**
  	* 
  	*set方法
	*减免前总费用（包含快递，代发费）＝goods_fee+post_fee+services_fee
 	*自动生成
  	*/
    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }
	/**
  	* 
	*get方法
  	*总钱数（包含快递，代发费）＝total_fee-trade_discount_fee
 	*自动生成
  	*/
    public String getMoney() {
        return money;
    }

    /**
  	* 
  	*set方法
	*总钱数（包含快递，代发费）＝total_fee-trade_discount_fee
 	*自动生成
  	*/
    public void setMoney(String money) {
        this.money = money;
    }
	/**
  	* 
	*get方法
  	*实付钱数＝money
 	*自动生成
  	*/
    public String getRealPayMoney() {
        return realPayMoney;
    }

    /**
  	* 
  	*set方法
	*实付钱数＝money
 	*自动生成
  	*/
    public void setRealPayMoney(String realPayMoney) {
        this.realPayMoney = realPayMoney;
    }
	/**
  	* 
	*get方法
  	*条形码上的特有编号
 	*自动生成
  	*/
    public String getBarCodeKey() {
        return barCodeKey;
    }

    /**
  	* 
  	*set方法
	*条形码上的特有编号
 	*自动生成
  	*/
    public void setBarCodeKey(String barCodeKey) {
        this.barCodeKey = barCodeKey;
    }
	/**
  	* 
	*get方法
  	*交易编号（订单系统订单ID）
 	*自动生成
  	*/
    public String getTradeCode() {
        return tradeCode;
    }

    /**
  	* 
  	*set方法
	*交易编号（订单系统订单ID）
 	*自动生成
  	*/
    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
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
  	*最后修改时间
 	*自动生成
  	*/
    public java.util.Date getLastDoTime() {
        return lastDoTime;
    }

    /**
  	* 
  	*set方法
	*最后修改时间
 	*自动生成
  	*/
    public void setLastDoTime(java.util.Date lastDoTime) {
        this.lastDoTime = lastDoTime;
    }
	/**
  	* 
	*get方法
  	*发货时间
 	*自动生成
  	*/
    public java.util.Date getSendTime() {
        return sendTime;
    }

    /**
  	* 
  	*set方法
	*发货时间
 	*自动生成
  	*/
    public void setSendTime(java.util.Date sendTime) {
        this.sendTime = sendTime;
    }
	/**
  	* 
	*get方法
  	*完成时间@发货后15天未退货时写入
 	*自动生成
  	*/
    public java.util.Date getFinishTime() {
        return finishTime;
    }

    /**
  	* 
  	*set方法
	*完成时间@发货后15天未退货时写入
 	*自动生成
  	*/
    public void setFinishTime(java.util.Date finishTime) {
        this.finishTime = finishTime;
    }
	/**
  	* 
	*get方法
  	*发货状态@0未开始1未发2发货
 	*自动生成
  	*/
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
  	* 
  	*set方法
	*发货状态@0未开始1未发2发货
 	*自动生成
  	*/
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }
	/**
  	* 
	*get方法
  	*订单关闭时间
 	*自动生成
  	*/
    public java.util.Date getCloseTime() {
        return closeTime;
    }

    /**
  	* 
  	*set方法
	*订单关闭时间
 	*自动生成
  	*/
    public void setCloseTime(java.util.Date closeTime) {
        this.closeTime = closeTime;
    }
	/**
  	* 
	*get方法
  	*买家留言
 	*自动生成
  	*/
    public String getBuyerRemark() {
        return buyerRemark;
    }

    /**
  	* 
  	*set方法
	*买家留言
 	*自动生成
  	*/
    public void setBuyerRemark(String buyerRemark) {
        this.buyerRemark = buyerRemark;
    }
	/**
  	* 
	*get方法
  	*分销商ID@可为空
 	*自动生成
  	*/
    public Long getBuyerId() {
        return buyerId;
    }

    /**
  	* 
  	*set方法
	*分销商ID@可为空
 	*自动生成
  	*/
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
	/**
  	* 
	*get方法
  	*分销商名称@可为空
 	*自动生成
  	*/
    public String getBuyerName() {
        return buyerName;
    }

    /**
  	* 
  	*set方法
	*分销商名称@可为空
 	*自动生成
  	*/
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
	/**
  	* 
	*get方法
  	*分销商旺旺@可为空
 	*自动生成
  	*/
    public String getBuyerWw() {
        return buyerWw;
    }

    /**
  	* 
  	*set方法
	*分销商旺旺@可为空
 	*自动生成
  	*/
    public void setBuyerWw(String buyerWw) {
        this.buyerWw = buyerWw;
    }
	/**
  	* 
	*get方法
  	*打印快递单@1未打印2已打印
 	*自动生成
  	*/
    public Integer getPrintExpressStatus() {
        return printExpressStatus;
    }

    /**
  	* 
  	*set方法
	*打印快递单@1未打印2已打印
 	*自动生成
  	*/
    public void setPrintExpressStatus(Integer printExpressStatus) {
        this.printExpressStatus = printExpressStatus;
    }
	/**
  	* 
	*get方法
  	*收件人邮编
 	*自动生成
  	*/
    public String getReceiverZip() {
        return receiverZip;
    }

    /**
  	* 
  	*set方法
	*收件人邮编
 	*自动生成
  	*/
    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }
	/**
  	* 
	*get方法
  	*收件人手机（废弃）
 	*自动生成
  	*/
    public String getReceiverMobile() {
        return receiverMobile;
    }

    /**
  	* 
  	*set方法
	*收件人手机（废弃）
 	*自动生成
  	*/
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
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
	/**
  	* 
	*get方法
  	*淘宝订单号tid@可为空
 	*自动生成
  	*/
    public Long getTaobaoTid() {
        return taobaoTid;
    }

    /**
  	* 
  	*set方法
	*淘宝订单号tid@可为空
 	*自动生成
  	*/
    public void setTaobaoTid(Long taobaoTid) {
        this.taobaoTid = taobaoTid;
    }
	/**
  	* 
	*get方法
  	*下拉订单的淘宝账户的昵称@可为空
 	*自动生成
  	*/
    public String getTaobaoUserNick() {
        return taobaoUserNick;
    }

    /**
  	* 
  	*set方法
	*下拉订单的淘宝账户的昵称@可为空
 	*自动生成
  	*/
    public void setTaobaoUserNick(String taobaoUserNick) {
        this.taobaoUserNick = taobaoUserNick;
    }
	/**
  	* 
	*get方法
  	*分销商QQ@可为空
 	*自动生成
  	*/
    public String getBuyerQq() {
        return buyerQq;
    }

    /**
  	* 
  	*set方法
	*分销商QQ@可为空
 	*自动生成
  	*/
    public void setBuyerQq(String buyerQq) {
        this.buyerQq = buyerQq;
    }
	/**
  	* 
	*get方法
  	*分销商微信@可为空
 	*自动生成
  	*/
    public String getBuyerWx() {
        return buyerWx;
    }

    /**
  	* 
  	*set方法
	*分销商微信@可为空
 	*自动生成
  	*/
    public void setBuyerWx(String buyerWx) {
        this.buyerWx = buyerWx;
    }
	/**
  	* 
	*get方法
  	*分销商电话@可为空
 	*自动生成
  	*/
    public String getBuyerTelephone() {
        return buyerTelephone;
    }

    /**
  	* 
  	*set方法
	*分销商电话@可为空
 	*自动生成
  	*/
    public void setBuyerTelephone(String buyerTelephone) {
        this.buyerTelephone = buyerTelephone;
    }
	/**
  	* 
	*get方法
  	*代发名称
 	*自动生成
  	*/
    public String getSellerName() {
        return sellerName;
    }

    /**
  	* 
  	*set方法
	*代发名称
 	*自动生成
  	*/
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
	/**
  	* 
	*get方法
  	*付款状态@ 1未付款2已付款
 	*自动生成
  	*/
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
  	* 
  	*set方法
	*付款状态@ 1未付款2已付款
 	*自动生成
  	*/
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }
	/**
  	* 
	*get方法
  	*支付时间
 	*自动生成
  	*/
    public java.util.Date getPayTime() {
        return payTime;
    }

    /**
  	* 
  	*set方法
	*支付时间
 	*自动生成
  	*/
    public void setPayTime(java.util.Date payTime) {
        this.payTime = payTime;
    }
	/**
  	* 
	*get方法
  	*收货人QQ
 	*自动生成
  	*/
    public String getReceiverQq() {
        return receiverQq;
    }

    /**
  	* 
  	*set方法
	*收货人QQ
 	*自动生成
  	*/
    public void setReceiverQq(String receiverQq) {
        this.receiverQq = receiverQq;
    }
	/**
  	* 
	*get方法
  	*买家昵称
 	*自动生成
  	*/
    public String getBuyerNick() {
        return buyerNick;
    }

    /**
  	* 
  	*set方法
	*买家昵称
 	*自动生成
  	*/
    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

	public String getAfterRemark() {
		return afterRemark;
	}

	public void setAfterRemark(String afterRemark) {
		this.afterRemark = afterRemark;
	}

	public Integer getIsOld () {
		return isOld;
	}

	public void setIsOld (Integer isOld) {
		this.isOld = isOld;
	}
}
