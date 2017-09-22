package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ChangePasswordResponse;

import javax.validation.constraints.NotNull;

/**
 * 类名:ChangePasswordRequest
 * 类路径:com.openJar.requests.appChangePasswordRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:修改我的密码
 */
public class ChangePasswordRequest extends Request<ChangePasswordResponse> {
	//用户ID	必须
	@NotNull(message = "userId is null")
	private Long userId;
	//老密码	必须
	@NotNull(message = "原密码不能为空")
	private String oldPwd;
	//新密码	必须
	@NotNull(message = "新密码不能为空")
	private String newPwd;
	//每次登陆，用户的唯一码	必须
	@NotNull(message = "token is null")
	private String token;
	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId=userId;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd( String oldPwd ) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd(){
		return newPwd;
	}

	public void setNewPwd(String newPwd){
		this.newPwd=newPwd;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token=token;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"changePassword.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"changePassword.json";
	}

}