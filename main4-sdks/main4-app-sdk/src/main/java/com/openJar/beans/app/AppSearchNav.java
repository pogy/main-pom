package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

/**
 * 类名:AppSearchNav
 * 类路径:com.openJar.beans.appAppSearchNav
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:搜索筛选条件
 */
public class AppSearchNav extends OpenBean implements Serializable {
	//ID
	private Long navId;
	//标签名
	private String name;
	public Long getNavId(){
		return navId;
	}

	public void setNavId(Long navId){
		this.navId=navId;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

}