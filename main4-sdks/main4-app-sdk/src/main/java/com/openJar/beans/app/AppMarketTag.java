package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

/**
 * 类名:AppMarketTag
 * 类路径:com.openJar.beans.appAppMarketTag
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:市场ID键值对
 */
public class AppMarketTag extends OpenBean implements Serializable {
	//市场ID
	private Long mid;
	//市场名称
	private String name;
	public Long getMid(){
		return mid;
	}

	public void setMid(Long mid){
		this.mid=mid;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

}