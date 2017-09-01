package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.AboutMeResponse;

import javax.validation.constraints.NotNull;

/**
 * 类名:AboutMeRequest
 * 类路径:com.openJar.requests.appAboutMeRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:我的信息
 */
public class AboutMeRequest extends Request<AboutMeResponse> {
	//用户ID	必须
	@NotNull(message = "userId is null")
	private Long userId;
	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId=userId;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"aboutMe.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"aboutMe.json";
	}

}