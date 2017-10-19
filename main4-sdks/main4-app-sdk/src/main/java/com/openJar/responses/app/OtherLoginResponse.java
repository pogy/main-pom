package com.openJar.responses.app;
import com.openJar.responses.Response;
import com.openJar.beans.app.AppUser;
/**
 * 类名:OrtherLoginResponse
 * 类路径:com.openJar.responses.appOrtherLoginResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:第三方登录-微信,淘宝登录
 */
public class OtherLoginResponse extends Response {
	//已经绑定星座网返回的数据
	private AppUser users;
	//未绑定星座网账号,返回数据唯一键
	private String tempId;
	//0未绑定星座网1绑定星座网
	private Integer type;
	//跳转地址	必须
	//第三方昵称
	private String userNick;

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick( String userNick ) {
		this.userNick = userNick;
	}

	public AppUser getUsers() {
		return users;
	}

	public void setUsers( AppUser users ) {
		this.users = users;
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId( String tempId ) {
		this.tempId = tempId;
	}

	public Integer getType() {
		return type;
	}

	public void setType( Integer type ) {
		this.type = type;
	}
}