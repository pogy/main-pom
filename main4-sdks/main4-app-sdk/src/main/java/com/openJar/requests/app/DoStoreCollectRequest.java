package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.DoStoreCollectResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:DoStoreCollectRequest
 * 类路径:com.openJar.requests.appDoStoreCollectRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:收藏OR取消收藏店铺
 */
public class DoStoreCollectRequest extends Request<DoStoreCollectResponse> {
	//店铺ID	必须
	@NotNull(message = "shopId is null")
	private Long shopId;
	//收藏or取消收藏	必须
	@NotNull(message = "yesOrNo is null")
	private Boolean yesOrNo;
	//临时授权码	必须
	@NotNull(message = "token is null")
	private String token;
	private Long userId;
	public Long getShopId(){
		return shopId;
	}

	public void setShopId(Long shopId){
		this.shopId=shopId;
	}

	public Boolean getYesOrNo(){
		return yesOrNo;
	}

	public void setYesOrNo(Boolean yesOrNo){
		this.yesOrNo=yesOrNo;
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
		return HostEnum.TEST+"doStoreCollect.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"doStoreCollect.json";
	}

}