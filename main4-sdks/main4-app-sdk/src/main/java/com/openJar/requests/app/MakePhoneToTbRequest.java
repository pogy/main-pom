package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.MakePhoneToTbResponse;
/**
 * 类名:MakePhoneToTbRequest
 * 类路径:com.openJar.requests.appMakePhoneToTbRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:创建淘宝手机详情?
 */
public class MakePhoneToTbRequest extends Request<MakePhoneToTbResponse> {
	//上传成功后的淘宝numIid	必须
	private Long numIid;
	//用户Id	必须
	private Long userId;
	//每次登陆，用户的唯一码	必须
	private String token;
	public Long getNumIid(){
		return numIid;
	}

	public void setNumIid(Long numIid){
		this.numIid=numIid;
	}

	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId=userId;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token=token;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"makePhoneToTb.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"makePhoneToTb.json";
	}

}