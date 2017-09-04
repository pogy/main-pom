package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.SearchNavResponse;
/**
 * 类名:SearchNavRequest
 * 类路径:com.openJar.requests.appSearchNavRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:搜索筛选条件
 */
public class SearchNavRequest extends Request<SearchNavResponse> {
	//1类目，2市场	必须
	private Integer type;
	//站点 必须
	private String webSite;
	//上级类目ID，不传意思为查顶级
	private Long sid;
	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type=type;
	}

	public Long getSid(){
		return sid;
	}

	public void setSid(Long sid){
		this.sid=sid;
	}

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String testApiUrl(){
		return HostEnum.TEST+"searchNav.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"searchNav.json";
	}

}