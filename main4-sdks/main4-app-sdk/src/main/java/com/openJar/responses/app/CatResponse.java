package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppCatGroup;
/**
 * 类名:CatResponse
 * 类路径:com.openJar.responses.appCatResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:类目查询
 */
public class CatResponse extends Response {
	//类目分组数据	必须
	private List<AppCatGroup> catGroups;
	public List<AppCatGroup> getCatGroups(){
		return catGroups;
	}

	public void setCatGroups(List<AppCatGroup> catGroups){
		this.catGroups=catGroups;
	}

}