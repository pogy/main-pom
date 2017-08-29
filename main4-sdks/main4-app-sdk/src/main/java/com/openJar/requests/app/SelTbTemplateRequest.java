package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.SelTbTemplateResponse;
/**
 * 类名:SelTbTemplateRequest
 * 类路径:com.openJar.requests.appSelTbTemplateRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:查询淘宝分销商运费模板?
 */
public class SelTbTemplateRequest extends Request<SelTbTemplateResponse> {
	//用户Id	必须
	private Long userId;
	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId=userId;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"selTbTemplate.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"selTbTemplate.json";
	}

}