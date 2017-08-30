package com.shigu.main4.daifa.beans;

import java.io.Serializable;
import java.util.List;

/**
 * 面单
 * @author Administrator
 *
 */
public class EOrderInfo implements Serializable {
	private String OrderCode;//订单号
	private String ShipperCode;//快递公司编码(快递英文简称)
	private String CustomerName;//电子面单客户账号（与快递网点申请）
	private String CustomerPwd;//电子面单密码
	private String MonthCode;//月结编码
	private String SendSite;//收件网点标识
	private Integer PayType;//邮费支付方式:1-现付，2-到付，3-月结，4-第三方支付
	private Integer ExpType;//快递类型：1-标准快件
	private String Cost;//寄件费（运费）
	private String OtherCost;//其他费用
	private SeReBean Sender;//发件人信息
	private SeReBean Receiver;//收件人信息
	private List<Commodity> Commodity;//商品信息列表
	private Integer IsReturnPrintTemplate;//返回电子面单模板：0-不需要；1-需要
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public String getShipperCode() {
		return ShipperCode;
	}
	public void setShipperCode(String shipperCode) {
		ShipperCode = shipperCode;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerPwd() {
		return CustomerPwd;
	}
	public void setCustomerPwd(String customerPwd) {
		CustomerPwd = customerPwd;
	}
	public String getSendSite() {
		return SendSite;
	}
	public void setSendSite(String sendSite) {
		SendSite = sendSite;
	}
	public String getCost() {
		return Cost;
	}
	public void setCost(String cost) {
		Cost = cost;
	}
	public String getOtherCost() {
		return OtherCost;
	}
	public void setOtherCost(String otherCost) {
		OtherCost = otherCost;
	}
	public SeReBean getSender() {
		return Sender;
	}
	public void setSender(SeReBean sender) {
		Sender = sender;
	}
	public SeReBean getReceiver() {
		return Receiver;
	}
	public void setReceiver(SeReBean receiver) {
		Receiver = receiver;
	}
	public List<Commodity> getCommodity() {
		return Commodity;
	}
	public void setCommodity(List<Commodity> commodity) {
		Commodity = commodity;
	}
	public Integer getPayType() {
		return PayType;
	}
	public void setPayType(Integer payType) {
		PayType = payType;
	}
	public Integer getExpType() {
		return ExpType;
	}
	public void setExpType(Integer expType) {
		ExpType = expType;
	}
	public Integer getIsReturnPrintTemplate() {
		return IsReturnPrintTemplate;
	}
	public void setIsReturnPrintTemplate(Integer isReturnPrintTemplate) {
		IsReturnPrintTemplate = isReturnPrintTemplate;
	}
	public String getMonthCode() {
		return MonthCode;
	}
	public void setMonthCode(String monthCode) {
		MonthCode = monthCode;
	}
}
