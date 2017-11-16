package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.CreatePostSignInfoResponse;
/**
 * 类名:CreatePostSignInfoRequest
 * 类路径:com.openJar.requests.appCreatePostSignInfoRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:获取 OSS 临时授权
 */
public class CreatePostSignInfoRequest extends Request<CreatePostSignInfoResponse> {
	public String testApiUrl(){
		return HostEnum.TEST+"createPostSignInfo.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"createPostSignInfo.json";
	}

}