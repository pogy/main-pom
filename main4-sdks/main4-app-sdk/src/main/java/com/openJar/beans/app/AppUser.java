package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

/**
 * 类名:AppUser
 * 类路径:com.openJar.beans.appAppUser
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:手机用户
 */
public class AppUser extends OpenBean implements Serializable {
	//是否是商家
	private Boolean imSeller;
	//头像
	private String imgsrc;
	//用户昵称
	private String userNick;
	//用户唯一登录信息
	private String token;
	public Boolean getImSeller(){
		return imSeller;
	}

	public void setImSeller(Boolean imSeller){
		this.imSeller=imSeller;
	}

	public String getImgsrc(){
		return imgsrc;
	}

	public void setImgsrc(String imgsrc){
		this.imgsrc=imgsrc;
	}

	public String getUserNick(){
		return userNick;
	}

	public void setUserNick(String userNick){
		this.userNick=userNick;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token=token;
	}

}