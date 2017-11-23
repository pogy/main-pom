package com.openJar.responses.app;
import com.openJar.responses.Response;
/**
 * 类名:UpToTbResponse
 * 类路径:com.openJar.responses.appUpToTbResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:上传淘宝?
 */
public class UpToTbResponse extends Response {
	//上传成功后的淘宝numIid	必须
	private Long numIid;
	public Long getNumIid(){
		return numIid;
	}

	public void setNumIid(Long numIid){
		this.numIid=numIid;
	}

}