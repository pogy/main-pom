package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

/**
 * 类名:AppItemKv
 * 类路径:com.openJar.beans.appAppItemKv
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:商品参数
 */
public class AppItemKv extends OpenBean implements Serializable {
	//标题
	private String key;
	//值
	private String value;
	public String getKey(){
		return key;
	}

	public void setKey(String key){
		this.key=key;
	}

	public String getValue(){
		return value;
	}

	public void setValue(String value){
		this.value=value;
	}

}