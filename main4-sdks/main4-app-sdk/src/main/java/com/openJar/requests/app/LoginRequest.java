package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.LoginResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:LoginRequest
 * 类路径:com.openJar.requests.appLoginRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:用户登陆 http://www.571xz.com/api/getPhoneMsg.json telephone=手机号，type=login
 */
public class LoginRequest extends Request<LoginResponse> {
	//用户名	必须
	@NotNull(message = "userName is null")
	private String userName;
	//密码	必须
	@NotNull(message = "password is null")
	private String password;
	//1普通账号密码登陆，2手机验证码登陆	必须
	@NotNull(message = "type is null")
	private Integer type;
	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type=type;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"login.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"login.json";
	}

}