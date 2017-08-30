package com.openJar.beans;

import com.openJar.utils.OpenBean;

import java.util.List;

public class WorkUserGgoodsTasksMarket extends OpenBean{
	private String parentMarketName;
	private List<WorkUserGgoodsTasksStore> stores;
	public String getParentMarketName() {
		return parentMarketName;
	}
	public void setParentMarketName(String parentMarketName) {
		this.parentMarketName = parentMarketName;
	}
	public List<WorkUserGgoodsTasksStore> getStores() {
		return stores;
	}
	public void setStores(List<WorkUserGgoodsTasksStore> stores) {
		this.stores = stores;
	}
	
}
