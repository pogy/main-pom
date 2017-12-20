package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.SelTbTemplateResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:SelTbTemplateRequest
 * 类路径:com.openJar.requests.appSelTbTemplateRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:查询淘宝分销商运费模板?
 */
public class SelTbTemplateRequest extends Request<SelTbTemplateResponse> {
	//用户token	必须
	@NotNull(message = "token is null")
	private String token;
	private Long userId;
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
		return HostEnum.TEST+"selTbTemplate.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"selTbTemplate.json";
	}

}