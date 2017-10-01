package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ImgUploadResponse;

import javax.validation.constraints.NotNull;

/**
 * 类名:ImgUploadRequest
 * 类路径:com.openJar.requests.appImgUploadRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:图片上传？
 */
public class ImgUploadRequest extends Request<ImgUploadResponse> {
	//图片文件数据	必须      2.0//用户头像图片oss地址
	@NotNull(message = "file is null")
	private String file;
//	//1、普通文件数据，2、图搜文件数据	必须
//	private Integer type;
	//如果type!=1，需要传入userId
	@NotNull(message = "userId is null")
	private Long userId;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

//	public Integer getType(){
//		return type;
//	}
//
//	public void setType(Integer type){
//		this.type=type;
//	}

	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId=userId;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"imgUpload.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"imgUpload.json";
	}

}