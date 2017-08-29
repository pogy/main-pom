package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.CatResponse;
/**
 * 类名:CatRequest
 * 类路径:com.openJar.requests.appCatRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:类目查询
 */
public class CatRequest extends Request<CatResponse> {
	//分站标识	必须
	private String webSite;
	//1男装，2女装	必须
	private Integer type;
	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type=type;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"cat.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"cat.json";
	}

}