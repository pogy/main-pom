package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ForgetPasswordResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:ForgetPasswordRequest
 * 类路径:com.openJar.requests.appForgetPasswordRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:忘记密码
 */
public class ForgetPasswordRequest extends Request<ForgetPasswordResponse> {
	//手机手机号	必须
	@NotNull(message = "telephone is null")
	private String telephone;
	//验证码	必须
	@NotNull(message = "msgCode is null")
	private String msgCode;
	//新密码
	private String newPassword;
	public String getTelephone(){
		return telephone;
	}

	public void setTelephone(String telephone){
		this.telephone=telephone;
	}

	public String getMsgCode(){
		return msgCode;
	}

	public void setMsgCode(String msgCode){
		this.msgCode=msgCode;
	}

	public String getNewPassword(){
		return newPassword;
	}

	public void setNewPassword(String newPassword){
		this.newPassword=newPassword;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"forgetPassword.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"forgetPassword.json";
	}

}