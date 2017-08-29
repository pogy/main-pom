package com.openJar.beans.app;

import com.openJar.utils.OpenBean;
import java.util.List;
/**
 * 类名:AppShopCat
 * 类路径:com.openJar.beans.appAppShopCat
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:父级店内类目
 */
public class AppShopCat extends OpenBean {
	//父级店内类目ID
	private String scid;
	//店内类目名
	private String catName;
	//如果没有子集，这里为空
	private List<AppShopCatSub> subCats;
	public String getScid(){
		return scid;
	}

	public void setScid(String scid){
		this.scid=scid;
	}

	public String getCatName(){
		return catName;
	}

	public void setCatName(String catName){
		this.catName=catName;
	}

	public List<AppShopCatSub> getSubCats(){
		return subCats;
	}

	public void setSubCats(List<AppShopCatSub> subCats){
		this.subCats=subCats;
	}

}