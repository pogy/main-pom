package com.shigu.daifa.vo;

import com.opentae.data.daifa.beans.DaifaAfterSale;
import com.opentae.data.daifa.beans.DaifaAfterSaleSub;
import com.shigu.main4.common.util.DateUtil;

public class OrdersVO {

	private String orderId;
	/**
	 * 售后时间
	 */
	private String afterSaleTime;

	private String imWw;

	private String imTel;

	private String imQq;
	/**
	 * 收货人姓名
	 */
	private String receiverName;
	/**
	 * 收货人电话
	 */
	private String receiverPhone;
	/**
	 * 收件人详细地址
	 */
	private String receiverAddress;
	/**
	 * 买家留言
	 */
	private String buyerRemark;

	private String totalFee;

	private String expressFee;

	private String expressName;

	private String expressCode;
	/**
	 * 减免费用
	 */
	private String discountFee;
	/**
	 * 服务费用
	 */
	private String serversFee;
	/**
	 * 子单数量
	 */
	private String childOrderNum;
	/**
	 * 子单全备注
	 */
	private String allChildRemark;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAfterSaleTime() {
		return afterSaleTime;
	}

	public void setAfterSaleTime(String afterSaleTime) {
		this.afterSaleTime = afterSaleTime;
	}

	public String getImWw() {
		return imWw;
	}

	public void setImWw(String imWw) {
		this.imWw = imWw;
	}

	public String getImTel() {
		return imTel;
	}

	public void setImTel(String imTel) {
		this.imTel = imTel;
	}

	public String getImQq() {
		return imQq;
	}

	public void setImQq(String imQq) {
		this.imQq = imQq;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getBuyerRemark() {
		return buyerRemark;
	}

	public void setBuyerRemark(String buyerRemark) {
		this.buyerRemark = buyerRemark;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getExpressFee() {
		return expressFee;
	}

	public void setExpressFee(String expressFee) {
		this.expressFee = expressFee;
	}

	public String getExpressName() {
		return expressName;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public String getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(String discountFee) {
		this.discountFee = discountFee;
	}

	public String getServersFee() {
		return serversFee;
	}

	public void setServersFee(String serversFee) {
		this.serversFee = serversFee;
	}

	public String getChildOrderNum() {
		return childOrderNum;
	}

	public void setChildOrderNum(String childOrderNum) {
		this.childOrderNum = childOrderNum;
	}

	public String getAllChildRemark() {
		return allChildRemark;
	}

	public void setAllChildRemark(String allChildRemark) {
		this.allChildRemark = allChildRemark;
	}

	public OrdersVO DaifaAfterSale2OrdersVO(DaifaAfterSaleSub from) {
		OrdersVO vo  = new OrdersVO();
//		vo.orderId = orderId;
		vo.afterSaleTime = from.getCreateDate();
		vo.imWw = from.getBuyerWw();
		vo.imTel = from.getBuyerTelephone();
		vo.imQq = from.getBuyerQq();
		vo.receiverName = from.getBuyerName();
		vo.receiverPhone = from.getBuyerTelephone();
//		vo.receiverAddress = ;
		vo.buyerRemark = from.getRemark();
//		vo.totalFee =;
//		vo.expressFee = ;
		vo.expressName = expressName;
		vo.expressCode = expressCode;
		vo.discountFee = discountFee;
		vo.serversFee = serversFee;
		vo.childOrderNum = childOrderNum;
		vo.allChildRemark = allChildRemark;
		return vo;
	}
}