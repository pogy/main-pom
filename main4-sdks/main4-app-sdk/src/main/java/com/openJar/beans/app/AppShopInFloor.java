package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;
import java.util.List;
/**
 * 类名:AppShopInFloor
 * 类路径:com.openJar.beans.appAppShopInFloor
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:楼层里的店铺
 */
public class AppShopInFloor extends OpenBean implements Serializable {
	//店铺ID
	private Long storeId;
	//档口号
	private String num;
	//新品标识，1为新品
	private Integer isNew;
	//标识，如旗舰店、发现好货
	private String cate;
	//退换服务，1退，2换
	private List<Integer> tags;
	public Long getStoreId(){
		return storeId;
	}

	public void setStoreId(Long storeId){
		this.storeId=storeId;
	}

	public String getNum(){
		return num;
	}

	public void setNum(String num){
		this.num=num;
	}

	public Integer getIsNew(){
		return isNew;
	}

	public void setIsNew(Integer isNew){
		this.isNew=isNew;
	}

	public String getCate(){
		return cate;
	}

	public void setCate(String cate){
		this.cate=cate;
	}

	public List<Integer> getTags(){
		return tags;
	}

	public void setTags(List<Integer> tags){
		this.tags=tags;
	}

}