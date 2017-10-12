package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.CreatePostSignInfoResponse;


/**
 * 类名:CreatePostSignInfoRequest
 * 类路径:com.openJar.requests.CreatePostSignInfoRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:我的信息
 */
public class CreatePostSignInfoRequest extends Request<CreatePostSignInfoResponse> {

	public String testApiUrl(){
		return HostEnum.TEST+"createPostSignInfo.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"createPostSignInfo.json";
	}

}