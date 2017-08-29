package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.InstockMyItemResponse;
/**
 * 类名:InstockMyItemRequest
 * 类路径:com.openJar.requests.appInstockMyItemRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:下架我的宝贝？
 */
public class InstockMyItemRequest extends Request<InstockMyItemResponse> {
	//用户ID	必须
	private Long userId;
	//上传记录ID	必须
	private String uploadId;
	//每次登陆用户的唯一码	必须
	private String token;
	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId=userId;
	}

	public String getUploadId(){
		return uploadId;
	}

	public void setUploadId(String uploadId){
		this.uploadId=uploadId;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token=token;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"instockMyItem.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"instockMyItem.json";
	}

}