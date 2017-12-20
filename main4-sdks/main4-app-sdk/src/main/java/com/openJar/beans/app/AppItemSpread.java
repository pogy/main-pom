package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

/**
 * 类名:AppItemSpread
 * 类路径:com.openJar.beans.appAppItemSpread
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:商品类广告
 */
public class AppItemSpread extends OpenBean implements Serializable {
	//商品ID
	private String goodsId;
	//图片链接
	private String imgsrc;
	//批发价
	private String piprice;
	//店铺ID
	private String storeId;
	//市场
	private String marketText;
	//档口号
	private String storeNum;
	//描述
	private String title;
	public String getGoodsId(){
		return goodsId;
	}

	public void setGoodsId(String goodsId){
		this.goodsId=goodsId;
	}

	public String getImgsrc(){
		return imgsrc;
	}

	public void setImgsrc(String imgsrc){
		this.imgsrc=imgsrc;
	}

	public String getPiprice(){
		return piprice;
	}

	public void setPiprice(String piprice){
		this.piprice=piprice;
	}

	public String getStoreId(){
		return storeId;
	}

	public void setStoreId(String storeId){
		this.storeId=storeId;
	}

	public String getMarketText(){
		return marketText;
	}

	public void setMarketText(String marketText){
		this.marketText=marketText;
	}

	public String getStoreNum(){
		return storeNum;
	}

	public void setStoreNum(String storeNum){
		this.storeNum=storeNum;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title=title;
	}

}