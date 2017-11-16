package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.GetPhoneMsgResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:GetPhoneMsgRequest
 * 类路径:com.openJar.requests.appGetPhoneMsgRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:发短信验证码
 */
public class GetPhoneMsgRequest extends Request<GetPhoneMsgResponse> {
	//手机号	必须
	@NotNull(message = "telephone is null")
	private String telephone;
	//1登录2注册3忘记密码4绑定	必须
	@NotNull(message = "type is null")
	private Integer type;
	public String getTelephone(){
		return telephone;
	}

	public void setTelephone(String telephone){
		this.telephone=telephone;
	}

	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type=type;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"getPhoneMsg.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"getPhoneMsg.json";
	}

}