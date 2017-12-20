package com.openJar.beans;

import com.openJar.utils.OpenBean;

public class WorkUserGgoodsTasksGoods extends OpenBean{
	private String code;
	private String goodsNo;
	private String skuStr;
	private Integer num;
	private Integer stockNum;
	private String picPath;
	private Integer ggoodsStatus;
	private Long piPrice;
	private String notCode;
	private Integer hasNum;
	private String tempDay;

	public String getTempDay() {
		return tempDay;
	}
	public void setTempDay(String tempDay) {
		this.tempDay = tempDay;
	}
	public Integer getHasNum() {
		return hasNum;
	}
	public void setHasNum(Integer hasNum) {
		this.hasNum = hasNum;
	}
	public String getNotCode() {
		return notCode;
	}
	public void setNotCode(String notCode) {
		this.notCode = notCode;
	}
	public Long getPiPrice() {
		return piPrice;
	}
	public void setPiPrice(Long piPrice) {
		this.piPrice = piPrice;
	}
	public Integer getGgoodsStatus() {
		return ggoodsStatus;
	}
	public void setGgoodsStatus(Integer ggoodsStatus) {
		this.ggoodsStatus = ggoodsStatus;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	public String getSkuStr() {
		return skuStr;
	}
	public void setSkuStr(String skuStr) {
		this.skuStr = skuStr;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public Integer getStockNum() {
		return stockNum;
	}
	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}
}
