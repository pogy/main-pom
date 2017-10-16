package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppSearchNav;
/**
 * 类名:SearchNavResponse
 * 类路径:com.openJar.responses.appSearchNavResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:搜索筛选条件/今日新品
 */
public class SearchNavResponse extends Response {
	//筛选条件数据	必须
	private List<AppSearchNav> navs;
	public List<AppSearchNav> getNavs(){
		return navs;
	}

	public void setNavs(List<AppSearchNav> navs){
		this.navs=navs;
	}

}