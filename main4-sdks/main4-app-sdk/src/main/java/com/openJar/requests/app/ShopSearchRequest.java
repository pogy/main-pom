package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ShopSearchResponse;
/**
 * 类名:ShopSearchRequest
 * 类路径:com.openJar.requests.appShopSearchRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:档口搜索
 */
public class ShopSearchRequest extends Request<ShopSearchResponse> {
	//关键词
	private String keyword;
	//分站标识
	private String webSite;
	//页码，默认1开始
	private Integer index;
	//页长
	private Integer size;
	public String getKeyword(){
		return keyword;
	}

	public void setKeyword(String keyword){
		this.keyword=keyword;
	}

	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public Integer getIndex(){
		return index;
	}

	public void setIndex(Integer index){
		this.index=index;
	}

	public Integer getSize(){
		return size;
	}

	public void setSize(Integer size){
		this.size=size;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"shopSearch.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"shopSearch.json";
	}

}