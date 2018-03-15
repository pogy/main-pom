package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;
import java.util.List;
/**
 * 类名:AppShopCat
 * 类路径:com.openJar.beans.appAppShopCat
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:父级店内类目
 */
public class AppShopCat extends OpenBean implements Serializable {
	//父级店内类目ID
	private String scid;
	//店内类目名
	private String catName;
	//如果没有子集，这里为空
	private List<AppShopCatSub> subCats;
	//商品数量
	private Long itemNum;
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

	public Long getItemNum(){
		return itemNum;
	}

	public void setItemNum(Long itemNum){
		this.itemNum=itemNum;
	}

}