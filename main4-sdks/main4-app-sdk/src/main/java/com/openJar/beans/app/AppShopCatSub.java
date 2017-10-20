package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

/**
 * 类名:AppShopCatSub
 * 类路径:com.openJar.beans.appAppShopCatSub
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:叶子级店内类目
 */
public class AppShopCatSub extends OpenBean implements Serializable {
	//店内类目ID
	private String scid;
	//店内类目名
	private String catName;
//	//商品条数
//	private Long itemNum;
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

//	public Long getItemNum(){
//		return itemNum;
//	}
//
//	public void setItemNum(Long itemNum){
//		this.itemNum=itemNum;
//	}

}