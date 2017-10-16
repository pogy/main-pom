package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.SitesResponse;
/**
 * 类名:SitesRequest
 * 类路径:com.openJar.requests.appSitesRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:分站集合
 */
public class SitesRequest extends Request<SitesResponse> {
	public String testApiUrl(){
		return HostEnum.TEST+"sites.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"sites.json";
	}

}