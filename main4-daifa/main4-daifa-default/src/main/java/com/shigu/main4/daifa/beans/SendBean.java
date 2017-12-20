package com.shigu.main4.daifa.beans;

import java.io.Serializable;
import java.util.List;

public class SendBean implements Serializable {
	private String outTradeId;
	private String receiverName;//收件人
	private String receiverPhone;//收货人手机号
	private String receiverProv;//收货人省份
	private String receiverCity;//收货人城市
	private String receiverArea;//收货人区域
	private String receiverAddress;//收化人地址
	private List<String> titles;//商家编码集合
	private String sendName;//发件人
	private String sendPhone;//发件人手机号
	private String sendProv;//发件人省份
	private String sendCity;//发件人城市
	private String sendArea;//发件人区域
	private String sendAddress;//发件人地址
	private String expressName;//快递名
	private Integer payType;//邮费支付方式:1-现付，2-到付，3-月结，4-第三方支付
	private Integer isNotice;//是否通知快递员上门揽件：0-通知；1-不通知；不填则默认为0

	public String getOutTradeId () {
		return outTradeId;
	}

	public void setOutTradeId (String outTradeId) {
		this.outTradeId = outTradeId;
	}

	public String getReceiverName () {
		return receiverName;
	}

	public void setReceiverName (String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone () {
		return receiverPhone;
	}

	public void setReceiverPhone (String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverProv () {
		return receiverProv;
	}

	public void setReceiverProv (String receiverProv) {
		this.receiverProv = receiverProv;
	}

	public String getReceiverCity () {
		return receiverCity;
	}

	public void setReceiverCity (String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getReceiverArea () {
		return receiverArea;
	}

	public void setReceiverArea (String receiverArea) {
		this.receiverArea = receiverArea;
	}

	public String getReceiverAddress () {
		return receiverAddress;
	}

	public void setReceiverAddress (String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public List<String> getTitles () {
		return titles;
	}

	public void setTitles (List<String> titles) {
		this.titles = titles;
	}

	public String getSendName () {
		return sendName;
	}

	public void setSendName (String sendName) {
		this.sendName = sendName;
	}

	public String getSendPhone () {
		return sendPhone;
	}

	public void setSendPhone (String sendPhone) {
		this.sendPhone = sendPhone;
	}

	public String getSendProv () {
		return sendProv;
	}

	public void setSendProv (String sendProv) {
		this.sendProv = sendProv;
	}

	public String getSendCity () {
		return sendCity;
	}

	public void setSendCity (String sendCity) {
		this.sendCity = sendCity;
	}

	public String getSendArea () {
		return sendArea;
	}

	public void setSendArea (String sendArea) {
		this.sendArea = sendArea;
	}

	public String getSendAddress () {
		return sendAddress;
	}

	public void setSendAddress (String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public String getExpressName () {
		return expressName;
	}

	public void setExpressName (String expressName) {
		this.expressName = expressName;
	}

	public Integer getPayType () {
		return payType;
	}

	public void setPayType (Integer payType) {
		this.payType = payType;
	}

	public Integer getIsNotice () {
		return isNotice;
	}

	public void setIsNotice (Integer isNotice) {
		this.isNotice = isNotice;
	}
}
