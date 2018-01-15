package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

/**
 * 类名:AppCat
 * 类路径:com.openJar.beans.appAppCat
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:类目
 */
public class AppCat extends OpenBean implements Serializable {
	//类目名
	private String name;
	//关键词，如果这个字段有值，cid失效，以关键词方式查询
	private String keyword;
	//类目ID
	private Long cid;
	//类目图片链接
	private String imgsrc;
	//1cid查询,2keyword查询
	private Integer type;
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getKeyword(){
		return keyword;
	}

	public void setKeyword(String keyword){
		this.keyword=keyword;
	}

	public Long getCid(){
		return cid;
	}

	public void setCid(Long cid){
		this.cid=cid;
	}

	public String getImgsrc(){
		return imgsrc;
	}

	public void setImgsrc(String imgsrc){
		this.imgsrc=imgsrc;
	}

	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type=type;
	}

}