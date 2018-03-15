package com.openJar.responses.app;
import com.openJar.beans.app.AppUser;
import com.openJar.responses.Response;
/**
 * 类名:BindUserResponse
 * 类路径:com.openJar.responses.appBindUserResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:用户绑定手机 手机验证码的获取链接为http://www.571xz.com/api/getPhoneMsg.json telephone=手机号，type=bind
 */
public class BindUserResponse extends Response {
	private AppUser users;
	public AppUser getUsers(){
		return users;
	}

	public void setUsers(AppUser users){
		this.users=users;
	}

}