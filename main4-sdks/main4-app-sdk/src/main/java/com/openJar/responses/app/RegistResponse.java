package com.openJar.responses.app;
import com.openJar.responses.Response;
import com.openJar.beans.app.AppUser;
/**
 * 类名:RegistResponse
 * 类路径:com.openJar.responses.appRegistResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:APP注册用户，手机验证码的获取链接为http://www.571xz.com/api/getPhoneMsg.json telephone=手机号，type=regist
 */
public class RegistResponse extends Response {
	//返回手机用户AppUser类	必须
	private AppUser users;
	public AppUser getUsers(){
		return users;
	}

	public void setUsers(AppUser users){
		this.users=users;
	}

}