package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

/**
 * 类名:AppGoodsBlock
 * 类路径:com.openJar.beans.appAppGoodsBlock
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:商品块信息
 */
public class AppGoodsBlock extends OpenBean implements Serializable {
	//商品ID
	private String goodsId;
	//标题
	private String title;
	//高亮型标题
	private String highLightTitle;
	//图片链接
	private String imgsrc;
	//批发价
	private String piprice;
	//市场档口，空格隔开
	private String fullStoreName;
	//旺旺昵称
	private String aliww;
	//店铺ID
	private Long storeid;
	//货号
	private String goodsNo;
	//高亮型货号，一般情况下此字段为null，如果有值说明货号匹配上了
	private String highLightGoodsNo;
	//收藏夹ID
	private String collectId;
	public String getGoodsId(){
		return goodsId;
	}

	public void setGoodsId(String goodsId){
		this.goodsId=goodsId;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getHighLightTitle(){
		return highLightTitle;
	}

	public void setHighLightTitle(String highLightTitle){
		this.highLightTitle=highLightTitle;
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

	public String getFullStoreName(){
		return fullStoreName;
	}

	public void setFullStoreName(String fullStoreName){
		this.fullStoreName=fullStoreName;
	}

	public String getAliww(){
		return aliww;
	}

	public void setAliww(String aliww){
		this.aliww=aliww;
	}

	public Long getStoreid(){
		return storeid;
	}

	public void setStoreid(Long storeid){
		this.storeid=storeid;
	}

	public String getGoodsNo(){
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo){
		this.goodsNo=goodsNo;
	}

	public String getHighLightGoodsNo(){
		return highLightGoodsNo;
	}

	public void setHighLightGoodsNo(String highLightGoodsNo){
		this.highLightGoodsNo=highLightGoodsNo;
	}

	public String getCollectId(){
		return collectId;
	}

	public void setCollectId(String collectId){
		this.collectId=collectId;
	}

}