package com.openJar.responses.app;
import com.openJar.responses.Response;
import com.openJar.beans.app.AppUser;
/**
 * 类名:LoginResponse
 * 类路径:com.openJar.responses.appLoginResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:用户登陆 http://www.571xz.com/api/getPhoneMsg.json telephone=手机号，type=login
 */
public class LoginResponse extends Response {
	//手机用户AppUser类	必须
	private AppUser users;
	public AppUser getUsers(){
		return users;
	}

	public void setUsers(AppUser users){
		this.users=users;
	}

}