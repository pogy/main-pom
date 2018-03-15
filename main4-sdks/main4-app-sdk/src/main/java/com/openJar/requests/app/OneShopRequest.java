package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.OneShopResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:OneShopRequest
 * 类路径:com.openJar.requests.appOneShopRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:查询单个店铺信息
 */
public class OneShopRequest extends Request<OneShopResponse> {
	//	必须
	@NotNull(message = "shopId is null")
	private Long shopId;
	//分站标识	必须
	@NotNull(message = "webSite is null")
	private String webSite;
	//用户token
	private String token;
	private Long userId;
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
		return HostEnum.TEST+"oneShop.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"oneShop.json";
	}

}