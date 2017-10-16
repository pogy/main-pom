package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.RegistResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:RegistRequest
 * 类路径:com.openJar.requests.appRegistRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:APP注册用户，手机验证码的获取链接为http://www.571xz.com/api/getPhoneMsg.json telephone=手机号，type=regist
 */
public class RegistRequest extends Request<RegistResponse> {
	//手机号	必须
	@NotNull(message = "telephone is null")
	private String telephone;
	//手机验证码	必须
	@NotNull(message = "code is null")
	private String code;
	//密码	必须
	@NotNull(message = "password is null")
	private String password;
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

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"regist.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"regist.json";
	}

}