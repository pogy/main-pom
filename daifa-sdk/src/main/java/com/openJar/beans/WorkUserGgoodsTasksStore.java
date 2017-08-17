package com.openJar.beans;

import com.openJar.utils.OpenBean;

public class WorkUserGgoodsTasksStore extends OpenBean{
	private Long storeId;
	private String storeNum;
	private Integer num;
	private Integer hasNum;
	private Integer notNum;
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getNotNum() {
		return notNum;
	}
	public void setNotNum(Integer notNum) {
		this.notNum = notNum;
	}
	public Integer getHasNum() {
		return hasNum;
	}
	public void setHasNum(Integer hasNum) {
		this.hasNum = hasNum;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}
	
}
