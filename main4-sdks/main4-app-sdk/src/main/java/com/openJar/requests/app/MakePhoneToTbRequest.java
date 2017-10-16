package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.MakePhoneToTbResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:MakePhoneToTbRequest
 * 类路径:com.openJar.requests.appMakePhoneToTbRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:创建淘宝手机详情?
 */
public class MakePhoneToTbRequest extends Request<MakePhoneToTbResponse> {
	//上传成功后的淘宝numIid	必须
	@NotNull(message = "numIid is null")
	private Long numIid;
	//每次登陆，用户的唯一码	必须
	@NotNull(message = "token is null")
	private String token;
	private Long userId;
	public Long getNumIid(){
		return numIid;
	}

	public void setNumIid(Long numIid){
		this.numIid=numIid;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token=token;
	}

	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId=userId;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"makePhoneToTb.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"makePhoneToTb.json";
	}

}