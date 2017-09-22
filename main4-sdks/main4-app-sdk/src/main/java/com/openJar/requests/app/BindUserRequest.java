package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.BindUserResponse;

import javax.validation.constraints.NotNull;

/**
 * 类名:BindUserRequest
 * 类路径:com.openJar.requests.appBindUserRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:用户绑定手机 手机验证码的获取链接为http://www.571xz.com/api/getPhoneMsg.json telephone=手机号，type=bind
 */
public class BindUserRequest extends Request<BindUserResponse> {
	//临时ID，第三方登陆以后能过链接返回	必须
	@NotNull
	private String tempId;
	//手机号	必须
	@NotNull
	private String telephone;
	//验证码	必须
	@NotNull
	private String code;
	//绑定类型,淘宝3,qq4,微信5,阿里6,星座7,手机7
	@NotNull
	private Integer type;
	//第三方用户名
	private String userNick;

	public String getTempId(){
		return tempId;
	}

	public void setTempId(String tempId){
		this.tempId=tempId;
	}

	public String getTelephone(){
		return telephone;
	}

	public void setTelephone(String telephone){
		this.telephone=telephone;
	}

	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code=code;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"bindUser.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"bindUser.json";
	}

}