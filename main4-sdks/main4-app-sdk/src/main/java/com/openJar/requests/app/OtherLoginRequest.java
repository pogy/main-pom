package com.openJar.requests.app;

import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.OtherLoginResponse;

import javax.validation.constraints.NotNull;

public class OtherLoginRequest extends Request<OtherLoginResponse> {
    //第三方登录类型1:淘宝,2:微信	必须
	@NotNull(message = "type is null")
	private Integer type;
	//淘宝必须传入,授权返回的nick
	private String nick;
	//微信必须传入,授权返回的参数唯一标识
	private String key;


	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type=type;
	}

	public String getNick(){
		return nick;
	}

	public void setNick(String nick){
		this.nick=nick;
	}

	public String getKey(){
		return key;
	}

	public void setKey(String key){
		this.key=key;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"otherLogin.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"otherLogin.json";
	}

}