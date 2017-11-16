package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ImgUploadResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:ImgUploadRequest
 * 类路径:com.openJar.requests.appImgUploadRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:图片上传
 */
public class ImgUploadRequest extends Request<ImgUploadResponse> {
	//用户头像图片oss地址	必须
	@NotNull(message = "file is null")
	private String file;
	//token	必须
	@NotNull(message = "token is null")
	private String token;
	private Long userId;
	public String getFile(){
		return file;
	}

	public void setFile(String file){
		this.file=file;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token=token;
	}

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