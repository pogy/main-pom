package com.openJar.responses.app;
import com.openJar.beans.app.AppUser;
import com.openJar.responses.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名:LoginResponse
 * 类路径:com.openJar.responses.appLoginResponse
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:用户登陆 http://www.571xz.com/api/getPhoneMsg.json telephone=手机号，type=login
 */
public class LoginResponse extends Response {
	private List<AppUser> users;

	public void setUsers( List<AppUser> users ) {
		this.users = users;
	}

	public List<AppUser> getUsers() {
		return users;
	}
}