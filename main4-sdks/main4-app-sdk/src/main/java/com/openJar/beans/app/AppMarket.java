package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;
import java.util.List;
/**
 * 类名:AppMarket
 * 类路径:com.openJar.beans.appAppMarket
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:市场
 */
public class AppMarket extends OpenBean implements Serializable {
	//市场名称
	private String marketName;
	//分站标识
	private String webSite;
	//楼层
	private List<AppFloor> floors;
	//其它市场列表
	private List<AppMarketTag> marketTags;
	public String getMarketName(){
		return marketName;
	}

	public void setMarketName(String marketName){
		this.marketName=marketName;
	}

	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public List<AppFloor> getFloors(){
		return floors;
	}

	public void setFloors(List<AppFloor> floors){
		this.floors=floors;
	}

	public List<AppMarketTag> getMarketTags(){
		return marketTags;
	}

	public void setMarketTags(List<AppMarketTag> marketTags){
		this.marketTags=marketTags;
	}

}