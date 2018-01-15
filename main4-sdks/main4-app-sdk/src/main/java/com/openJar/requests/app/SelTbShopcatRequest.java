package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.SelTbShopcatResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:SelTbShopcatRequest
 * 类路径:com.openJar.requests.appSelTbShopcatRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:查询分销商淘宝店内类目?
 */
public class SelTbShopcatRequest extends Request<SelTbShopcatResponse> {
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
		return HostEnum.TEST+"selTbShopcat.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"selTbShopcat.json";
	}

}