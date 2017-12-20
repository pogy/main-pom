package com.openJar.beans;

import com.openJar.utils.OpenBean;

public class WorkUserGgoodsTasksCounts extends OpenBean{
	private Integer totalNum;
	private Integer totalHasNum;
	private String totalFee;
	private String totalHasFee;

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getTotalHasFee() {
		return totalHasFee;
	}

	public void setTotalHasFee(String totalHasFee) {
		this.totalHasFee = totalHasFee;
	}

	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Integer getTotalHasNum() {
		return totalHasNum;
	}
	public void setTotalHasNum(Integer totalHasNum) {
		this.totalHasNum = totalHasNum;
	}
}
