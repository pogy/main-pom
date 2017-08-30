package com.openJar.beans.app;

import com.openJar.utils.OpenBean;
/**
 * 类名:AppShopCatSub
 * 类路径:com.openJar.beans.appAppShopCatSub
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:叶子级店内类目
 */
public class AppShopCatSub extends OpenBean {
	//商品数量
	private Integer itemNum;
	//店内类目ID
	private String scid;
	//店内类目名
	private String catName;
	public Integer getItemNum(){
		return itemNum;
	}

	public void setItemNum(Integer itemNum){
		this.itemNum=itemNum;
	}

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

}