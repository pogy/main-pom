package com.openJar.beans;

import com.openJar.utils.OpenBean;

import java.util.List;

public class WorkUserGgoodsTasksSku extends OpenBean{
	private String goodsNo;
	private List<WorkUserGgoodsTasksGoods> goods;
	private Integer totalNum;
	private Long totalPiPrice;
	private Integer ggoodsStatus;
	public Integer getGgoodsStatus() {
		return ggoodsStatus;
	}
	public void setGgoodsStatus(Integer ggoodsStatus) {
		this.ggoodsStatus = ggoodsStatus;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Long getTotalPiPrice() {
		return totalPiPrice;
	}
	public void setTotalPiPrice(Long totalPiPrice) {
		this.totalPiPrice = totalPiPrice;
	}
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	public List<WorkUserGgoodsTasksGoods> getGoods() {
		return goods;
	}
	public void setGoods(List<WorkUserGgoodsTasksGoods> goods) {
		this.goods = goods;
	}
}
