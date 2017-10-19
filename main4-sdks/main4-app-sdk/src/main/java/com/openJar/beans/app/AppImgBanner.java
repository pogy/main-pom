package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

/**
 * 类名:AppImgBanner
 * 类路径:com.openJar.beans.appAppImgBanner
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:图片广告
 */
public class AppImgBanner extends OpenBean implements Serializable {
	//超链接
	private String href;
	//图片链接
	private String imgsrc;
	//描述
	private String text;
	public String getHref(){
		return href;
	}

	public void setHref(String href){
		this.href=href;
	}

	public String getImgsrc(){
		return imgsrc;
	}

	public void setImgsrc(String imgsrc){
		this.imgsrc=imgsrc;
	}

	public String getText(){
		return text;
	}

	public void setText(String text){
		this.text=text;
	}

}