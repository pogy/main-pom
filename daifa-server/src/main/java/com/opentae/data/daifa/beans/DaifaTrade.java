package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DaifaTrade implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long dfTradeId;

    /**
     * 代发ID
     */
	private Long sellerId;

    /**
     * 商品数
     */
	private Integer goodsNum;

    /**
     * 重量
     */
	private String goodsWeight;

    /**
     * 体积
     */
	private String goodsVolume;

    /**
     * 收件人姓名
     */
	private String receiverName;

    /**
     * 收件人电话
     */
	private String receiverPhone;

    /**
     * 收件人省
     */
	private String receiverState;

    /**
     * 收件人详细地址
     */
	private String receiverAddress;

    /**
     * 代发类型@1在线下单2淘宝同步订单3代拿4淘宝商户下单
     */
	private Integer daifaType;

    /**
     * 快递ID
     */
	private Long expressId;

    /**
     * 快递名
     */
	private String expressName;

    /**
     * 快递单号
     */
	private String expressCode;

    /**
     * 1已付款待分配，2、拿货中，3、已发货，4、交易完成，10、交易关闭
     */
	private Integer tradeStatus;

    /**
     * 商品总费用@以元为单位
     */
	private String goodsFee;

    /**
     * 快递费用@以元为单位
     */
	private String expressFee;

    /**
     * 服务费：代发费@以元为单位
     */
	private String servicesFee;

    /**
     * vip要减面的费用=所有子单里的order_discount_fee@以元为单位
     */
	private String tradeDiscountFee;

    /**
     * 减免前总费用（包含快递，代发费）＝goods_fee+post_fee+services_fee
     */
	private String totalFee;

    /**
     * 总钱数（包含快递，代发费）＝total_fee-trade_discount_fee
     */
	private String money;

    /**
     * 实付钱数＝money
     */
	private String realPayMoney;

    /**
     * 条形码上的特有编号
     */
	private String barCodeKey;

    /**
     * 交易编号（订单系统订单ID）
     */
	private String tradeCode;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 最后修改时间
     */
	private Date lastDoTime;

    /**
     * 发货时间
     */
	private Date sendTime;

    /**
     * 完成时间@发货后15天未退货时写入
     */
	private Date finishTime;

    /**
     * 发货状态@1未发2发货
     */
	private Integer sendStatus;

    /**
     * 订单截单时间
     */
	private Date closeTime;

    /**
     * 买家留言
     */
	private String buyerRemark;

    /**
     * 分销商ID@可为空
     */
	private Long buyerId;

    /**
     * 分销商名称@可为空
     */
	private String buyerName;

    /**
     * 买家昵称
     */
	private String buyerNick;

    /**
     * 分销商旺旺@可为空
     */
	private String buyerWw;

    /**
     * 打印快递单@1未打印2已打印
     */
	private Integer printExpressStatus;

    /**
     * 收件人邮编
     */
	private String receiverZip;

    /**
     * 收件人手机（废弃）
     */
	private String receiverMobile;

    /**
     * 
     */
	private String remark1;

    /**
     * 
     */
	private String remark2;

    /**
     * 售后备注
     */
	private String afterRemark;

    /**
     * 淘宝订单号tid@可为空
     */
	private Long taobaoTid;

    /**
     * 下拉订单的淘宝账户的昵称@可为空
     */
	private String taobaoUserNick;

    /**
     * 分销商QQ@可为空
     */
	private String buyerQq;

    /**
     * 分销商微信@可为空
     */
	private String buyerWx;

    /**
     * 分销商电话@可为空
     */
	private String buyerTelephone;

    /**
     * 代发名称
     */
	private String sellerName;

    /**
     * 付款状态@ 1未付款2已付款
     */
	private Integer payStatus;

    /**
     * 支付时间
     */
	private Date payTime;

    /**
     * 收货人QQ
     */
	private String receiverQq;

    /**
     * 1:老代发数据
     */
	private Integer isOld;

	public void setDfTradeId(Long dfTradeId) {
		this.dfTradeId = dfTradeId;
	}

	public Long getDfTradeId() {
		return this.dfTradeId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getSellerId() {
		return this.sellerId;
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

	public void setGoodsVolume(String goodsVolume) {
		this.goodsVolume = goodsVolume;
	}

	public String getGoodsVolume() {
		return this.goodsVolume;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverPhone() {
		return this.receiverPhone;
	}

	public void setReceiverState(String receiverState) {
		this.receiverState = receiverState;
	}

	public String getReceiverState() {
		return this.receiverState;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverAddress() {
		return this.receiverAddress;
	}

	public void setDaifaType(Integer daifaType) {
		this.daifaType = daifaType;
	}

	public Integer getDaifaType() {
		return this.daifaType;
	}

	public void setExpressId(Long expressId) {
		this.expressId = expressId;
	}

	public Long getExpressId() {
		return this.expressId;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	public String getExpressName() {
		return this.expressName;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public String getExpressCode() {
		return this.expressCode;
	}

	public void setTradeStatus(Integer tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public Integer getTradeStatus() {
		return this.tradeStatus;
	}

	public void setGoodsFee(String goodsFee) {
		this.goodsFee = goodsFee;
	}

	public String getGoodsFee() {
		return this.goodsFee;
	}

	public void setExpressFee(String expressFee) {
		this.expressFee = expressFee;
	}

	public String getExpressFee() {
		return this.expressFee;
	}

	public void setServicesFee(String servicesFee) {
		this.servicesFee = servicesFee;
	}

	public String getServicesFee() {
		return this.servicesFee;
	}

	public void setTradeDiscountFee(String tradeDiscountFee) {
		this.tradeDiscountFee = tradeDiscountFee;
	}

	public String getTradeDiscountFee() {
		return this.tradeDiscountFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getTotalFee() {
		return this.totalFee;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMoney() {
		return this.money;
	}

	public void setRealPayMoney(String realPayMoney) {
		this.realPayMoney = realPayMoney;
	}

	public String getRealPayMoney() {
		return this.realPayMoney;
	}

	public void setBarCodeKey(String barCodeKey) {
		this.barCodeKey = barCodeKey;
	}

	public String getBarCodeKey() {
		return this.barCodeKey;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getTradeCode() {
		return this.tradeCode;
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

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Date getFinishTime() {
		return this.finishTime;
	}

	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
	}

	public Integer getSendStatus() {
		return this.sendStatus;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public Date getCloseTime() {
		return this.closeTime;
	}

	public void setBuyerRemark(String buyerRemark) {
		this.buyerRemark = buyerRemark;
	}

	public String getBuyerRemark() {
		return this.buyerRemark;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerName() {
		return this.buyerName;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	public String getBuyerNick() {
		return this.buyerNick;
	}

	public void setBuyerWw(String buyerWw) {
		this.buyerWw = buyerWw;
	}

	public String getBuyerWw() {
		return this.buyerWw;
	}

	public void setPrintExpressStatus(Integer printExpressStatus) {
		this.printExpressStatus = printExpressStatus;
	}

	public Integer getPrintExpressStatus() {
		return this.printExpressStatus;
	}

	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}

	public String getReceiverZip() {
		return this.receiverZip;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverMobile() {
		return this.receiverMobile;
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

	public void setAfterRemark(String afterRemark) {
		this.afterRemark = afterRemark;
	}

	public String getAfterRemark() {
		return this.afterRemark;
	}

	public void setTaobaoTid(Long taobaoTid) {
		this.taobaoTid = taobaoTid;
	}

	public Long getTaobaoTid() {
		return this.taobaoTid;
	}

	public void setTaobaoUserNick(String taobaoUserNick) {
		this.taobaoUserNick = taobaoUserNick;
	}

	public String getTaobaoUserNick() {
		return this.taobaoUserNick;
	}

	public void setBuyerQq(String buyerQq) {
		this.buyerQq = buyerQq;
	}

	public String getBuyerQq() {
		return this.buyerQq;
	}

	public void setBuyerWx(String buyerWx) {
		this.buyerWx = buyerWx;
	}

	public String getBuyerWx() {
		return this.buyerWx;
	}

	public void setBuyerTelephone(String buyerTelephone) {
		this.buyerTelephone = buyerTelephone;
	}

	public String getBuyerTelephone() {
		return this.buyerTelephone;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerName() {
		return this.sellerName;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getPayStatus() {
		return this.payStatus;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getPayTime() {
		return this.payTime;
	}

	public void setReceiverQq(String receiverQq) {
		this.receiverQq = receiverQq;
	}

	public String getReceiverQq() {
		return this.receiverQq;
	}

	public void setIsOld(Integer isOld) {
		this.isOld = isOld;
	}

	public Integer getIsOld() {
		return this.isOld;
	}

}