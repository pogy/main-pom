package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DaifaAfterSale implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long afterSaleId;

    /**
     * 交易Id
     */
	private Long dfTradeId;

    /**
     * 代发ID
     */
	private Long sellerId;

    /**
     * 代发名称
     */
	private String sellerName;

    /**
     * 售后类型@1退货2换货
     */
	private Integer afterType;

    /**
     * 快递状态@1客户已发货2收到货物
     */
	private Integer sendStatus;

    /**
     * 售后状态@默认为0等待处理1处理中，2处理完成:当所有子单return_status为1或change_status为1时或其中有的子单return_status和change_status为null时sale_after_status为0；当所有子单return_status为2，3，4或change_status为2，3时或其中有的子单return_status和change_status为null的时候sale_after_status为1，return_status为5，6，7或change_st
     */
	private Integer saleAfterStatus;

    /**
     * 售后创建日期@ YYYYMMDD
     */
	private String createDate;

    /**
     * 售后创建时间
     */
	private Date createTime;

    /**
     * 支付时间
     */
	private Date payTime;

    /**
     * 总钱数@单位元
     */
	private String money;

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
     * 收件人省份
     */
	private String receiverState;

    /**
     * 收件人详细地址
     */
	private String receiverAddress;

    /**
     * 收件人姓名
     */
	private String receiverName;

    /**
     * 收件人邮编
     */
	private String receiverZip;

    /**
     * 收件人手机号
     */
	private String receiverMobile;

    /**
     * 买家留言
     */
	private String buyerRemark;

    /**
     * 淘宝订单号tid
     */
	private Long taobaoTid;

    /**
     * 淘宝账户的昵称
     */
	private String taobaoUserNick;

    /**
     * 收货人QQ
     */
	private String receiverQq;

    /**
     * 备用1
     */
	private String remark1;

    /**
     * 备用2
     */
	private String remark2;

    /**
     * 
     */
	private String remark3;

    /**
     * 备用4
     */
	private String remark4;

    /**
     * 备用5
     */
	private String remark5;

    /**
     * 备用6
     */
	private String remark6;

    /**
     * 备用7
     */
	private String remark7;

    /**
     * 
     */
	private String remark8;

    /**
     * 备用9
     */
	private String remark9;

    /**
     * 备用10
     */
	private String remark10;

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

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getSellerId() {
		return this.sellerId;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerName() {
		return this.sellerName;
	}

	public void setAfterType(Integer afterType) {
		this.afterType = afterType;
	}

	public Integer getAfterType() {
		return this.afterType;
	}

	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
	}

	public Integer getSendStatus() {
		return this.sendStatus;
	}

	public void setSaleAfterStatus(Integer saleAfterStatus) {
		this.saleAfterStatus = saleAfterStatus;
	}

	public Integer getSaleAfterStatus() {
		return this.saleAfterStatus;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getPayTime() {
		return this.payTime;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMoney() {
		return this.money;
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

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverName() {
		return this.receiverName;
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

	public void setBuyerRemark(String buyerRemark) {
		this.buyerRemark = buyerRemark;
	}

	public String getBuyerRemark() {
		return this.buyerRemark;
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

	public void setReceiverQq(String receiverQq) {
		this.receiverQq = receiverQq;
	}

	public String getReceiverQq() {
		return this.receiverQq;
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

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public String getRemark4() {
		return this.remark4;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getRemark5() {
		return this.remark5;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}

	public String getRemark6() {
		return this.remark6;
	}

	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}

	public String getRemark7() {
		return this.remark7;
	}

	public void setRemark8(String remark8) {
		this.remark8 = remark8;
	}

	public String getRemark8() {
		return this.remark8;
	}

	public void setRemark9(String remark9) {
		this.remark9 = remark9;
	}

	public String getRemark9() {
		return this.remark9;
	}

	public void setRemark10(String remark10) {
		this.remark10 = remark10;
	}

	public String getRemark10() {
		return this.remark10;
	}

}