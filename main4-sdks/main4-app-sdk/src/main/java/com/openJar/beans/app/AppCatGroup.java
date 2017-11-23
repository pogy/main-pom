package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;
import java.util.List;
/**
 * 类名:AppCatGroup
 * 类路径:com.openJar.beans.appAppCatGroup
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:类目分组
 */
public class AppCatGroup extends OpenBean implements Serializable {
	/**类目Id*/
	private String id;
	//标题
	private String title;
	//分组中的类目
	private List<AppCat> cats;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public List<AppCat> getCats(){
		return cats;
	}

	public void setCats(List<AppCat> cats){
		this.cats=cats;
	}

}