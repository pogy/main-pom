package com.openJar.responses.app;
import com.openJar.responses.Response;
/**
 * 类名:GetPhoneMsgResponse
 * 类路径:com.openJar.responses.appGetPhoneMsgResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:发短信验证码
 */
public class GetPhoneMsgResponse extends Response {
	//返回验证码	必须
	private String msgCode;
	public String getMsgCode(){
		return msgCode;
	}

	public void setMsgCode(String msgCode){
		this.msgCode=msgCode;
	}

}