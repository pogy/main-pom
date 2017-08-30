package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.SelTbShopcatResponse;
/**
 * 类名:SelTbShopcatRequest
 * 类路径:com.openJar.requests.appSelTbShopcatRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:查询分销商淘宝店内类目?
 */
public class SelTbShopcatRequest extends Request<SelTbShopcatResponse> {
	//用户Id	必须
	private Long userId;
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