package com.openJar.responses.thirdSupport;

import com.openJar.beans.WorkUserGgoodsTasksSku;
import com.openJar.responses.Response;

import java.util.List;

public class SelWorkUserGgoodsTasksGoodsResponse extends Response{
	private List<WorkUserGgoodsTasksSku> skuList;
	private String storeName;
	private Long sumPrice;
	private Integer sumNum;
	public Long getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Long sumPrice) {
		this.sumPrice = sumPrice;
	}

	public Integer getSumNum() {
		return sumNum;
	}

	public void setSumNum(Integer sumNum) {
		this.sumNum = sumNum;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public List<WorkUserGgoodsTasksSku> getSkuList() {
		return skuList;
	}

	public void setSkuList(List<WorkUserGgoodsTasksSku> skuList) {
		this.skuList = skuList;
	}

}
