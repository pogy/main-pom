package com.openJar.beans.app;

import com.openJar.utils.OpenBean;
/**
 * 类名:AppMarketTag
 * 类路径:com.openJar.beans.appAppMarketTag
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:市场ID键值对
 */
public class AppMarketTag extends OpenBean {
	//市场ID
	private Long marketId;
	//市场名称
	private String name;
	public Long getMarketId(){
		return marketId;
	}

	public void setMarketId(Long marketId){
		this.marketId=marketId;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

}