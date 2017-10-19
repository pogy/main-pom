package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;
import java.util.List;
/**
 * 类名:AppFloor
 * 类路径:com.openJar.beans.appAppFloor
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:楼层
 */
public class AppFloor extends OpenBean implements Serializable {
	//楼层标题
	private String title;
	//楼层中的店铺
	private List<AppShopInFloor> stores;
	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public List<AppShopInFloor> getStores(){
		return stores;
	}

	public void setStores(List<AppShopInFloor> stores){
		this.stores=stores;
	}

}