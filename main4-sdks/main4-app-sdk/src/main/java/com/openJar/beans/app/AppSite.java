package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

/**
 * 类名:AppSite
 * 类路径:com.openJar.beans.appAppSite
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:分站
 */
public class AppSite extends OpenBean implements Serializable {
	//分站标识
	private String webSite;
	//分站中文名
	private String siteName;
	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public String getSiteName(){
		return siteName;
	}

	public void setSiteName(String siteName){
		this.siteName=siteName;
	}

}