package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.OneShopResponse;
/**
 * 类名:OneShopRequest
 * 类路径:com.openJar.requests.appOneShopRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:查询单个店铺信息
 */
public class OneShopRequest extends Request<OneShopResponse> {
	//	必须
	private Long shopId;
	//分站标识	必须
	private String webSite;
	public Long getShopId(){
		return shopId;
	}

	public void setShopId(Long shopId){
		this.shopId=shopId;
	}

	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"oneShop.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"oneShop.json";
	}

}