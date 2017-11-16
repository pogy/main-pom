package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppSite;
/**
 * 类名:SitesResponse
 * 类路径:com.openJar.responses.appSitesResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:分站集合
 */
public class SitesResponse extends Response {
	//分站信息	必须
	private List<AppSite> sites;
	public List<AppSite> getSites(){
		return sites;
	}

	public void setSites(List<AppSite> sites){
		this.sites=sites;
	}

}