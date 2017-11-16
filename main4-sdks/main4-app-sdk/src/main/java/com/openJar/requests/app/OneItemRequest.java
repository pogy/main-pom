package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.OneItemResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:OneItemRequest
 * 类路径:com.openJar.requests.appOneItemRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:单商品信息
 */
public class OneItemRequest extends Request<OneItemResponse> {
	//分站标识
	private String webSite;
	//商品ID	必须
	@NotNull(message = "itemId is null")
	private Long itemId;
	//不传则收藏状态type返回0
	private String token;
	private Long userId;
	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public Long getItemId(){
		return itemId;
	}

	public void setItemId(Long itemId){
		this.itemId=itemId;
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
		return HostEnum.TEST+"oneItem.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"oneItem.json";
	}

}