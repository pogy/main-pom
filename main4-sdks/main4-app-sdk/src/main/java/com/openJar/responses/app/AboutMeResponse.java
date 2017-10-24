package com.openJar.responses.app;
import com.openJar.beans.app.AppUser;
import com.openJar.responses.Response;
/**
 * 类名:AboutMeResponse
 * 类路径:com.openJar.responses.appAboutMeResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:我的信息
 */
public class AboutMeResponse extends Response {
	//用户信息
	private AppUser users;
	public AppUser getUsers(){
		return users;
	}

	public void setUsers(AppUser users){
		this.users=users;
	}
	//头像
	private String headUrl;
	//用户昵称
	private String userNick;
	//绑定的手机
	private String phoneBind;
	public String getHeadUrl(){
		return headUrl;
	}

	public void setHeadUrl(String headUrl){
		this.headUrl=headUrl;
	}

	public String getUserNick(){
		return userNick;
	}

	public void setUserNick(String userNick){
		this.userNick=userNick;
	}

	public String getPhoneBind(){
		return phoneBind;
	}

	public void setPhoneBind(String phoneBind){
		this.phoneBind=phoneBind;
	}

}