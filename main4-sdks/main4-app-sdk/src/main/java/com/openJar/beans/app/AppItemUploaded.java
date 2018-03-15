package com.openJar.beans.app;

import com.openJar.utils.OpenBean;

import java.io.Serializable;

/**
 * 类名:AppItemUploaded
 * 类路径:com.openJar.beans.appAppItemUploaded
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:已上传商品
 */
public class AppItemUploaded extends OpenBean implements Serializable {
	//商品ID
	private Long goodsId;
	//标题
	private String title;
	//图片链接
	private String imgsrc;
	//批发价
	private String piprice;
	//档口是否已下架
	private Integer supperDown;
	//本店是否已下架  淘宝
	private Integer imDown;
	//上传记录ID
	private String uploadId;
	public Long getGoodsId(){
		return goodsId;
	}

	public void setGoodsId(Long goodsId){
		this.goodsId=goodsId;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title=title;
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

	public Integer getSupperDown() {
		return supperDown;
	}

	public void setSupperDown( Integer supperDown ) {
		this.supperDown = supperDown;
	}

	public Integer getImDown() {
		return imDown;
	}

	public void setImDown( Integer imDown ) {
		this.imDown = imDown;
	}

	public String getUploadId(){
		return uploadId;
	}

	public void setUploadId(String uploadId){
		this.uploadId=uploadId;
	}

}