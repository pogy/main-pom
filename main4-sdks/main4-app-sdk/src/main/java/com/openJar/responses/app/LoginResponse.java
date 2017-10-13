package com.openJar.responses.app;


import com.openJar.beans.app.AppUser;
import com.openJar.responses.Response;

/**
 * 类名:LoginResponse
 * 类路径:com.openJar.responses.appLoginResponse
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:用户登陆 http://www.571xz.com/api/getPhoneMsg.json telephone=手机号，type=login
 */
public class LoginResponse extends Response {
	private AppUser users;

	private  Boolean ReturnState;

	public Boolean getReturnState() {
		return ReturnState;
	}

	public void setReturnState(Boolean returnState) {
		ReturnState = returnState;
	}

	public void setUsers(AppUser users ) {
		this.users = users;
	}

	public AppUser getUsers() {
		return users;
	}
}