package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.BindUserResponse;
/**
 * 类名:BindUserRequest
 * 类路径:com.openJar.requests.appBindUserRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:用户绑定手机 手机验证码的获取链接为http://www.571xz.com/api/getPhoneMsg.json telephone=手机号，type=bind
 */
public class BindUserRequest extends Request<BindUserResponse> {
	//临时ID，第三方登陆以后能过链接返回	必须
	private String tempId;
	//手机号	必须
	private String telephone;
	//验证码	必须
	private String code;
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

	public String testApiUrl(){
		return HostEnum.TEST+"bindUser.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"bindUser.json";
	}

}