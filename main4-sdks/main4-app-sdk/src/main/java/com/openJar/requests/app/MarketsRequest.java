package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.MarketsResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:MarketsRequest
 * 类路径:com.openJar.requests.appMarketsRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:市场数据
 */
public class MarketsRequest extends Request<MarketsResponse> {
	//市场ID,如果传入空，默认返回这个分站的默认市场
	private Long mid;
	//分站标识	必须
	@NotNull(message = "webSite is null")
	private String webSite;
	public Long getMid(){
		return mid;
	}

	public void setMid(Long mid){
		this.mid=mid;
	}

	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"markets.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"markets.json";
	}

}