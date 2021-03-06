package com.openJar.requests.app;

import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.AboutMeResponse;
import com.openJar.responses.app.DelStoreCollectResponse;

import javax.validation.constraints.NotNull;

/**
 * 类名:AboutMeRequest
 * 类路径:com.openJar.requests.appAboutMeRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:我的信息
 */
public class DelStoreCollectRequest extends Request<DelStoreCollectResponse> {
	//用户token	必须
	@NotNull(message = "token is null")
	private String token;
	private String collectIds;
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

	public String getCollectIds() {
		return collectIds;
	}

	public void setCollectIds( String collectIds ) {
		this.collectIds = collectIds;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"delStoreCollect.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"delStoreCollect.json";
	}

}