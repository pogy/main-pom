package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.UploadedItemResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:UploadedItemRequest
 * 类路径:com.openJar.requests.appUploadedItemRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:已上传宝贝
 */
public class UploadedItemRequest extends Request<UploadedItemResponse> {
	//1所有宝贝，2等待处理的，3淘宝已下架	必须
	@NotNull(message = "type is null")
	private Integer type;
	//页码	必须
	@NotNull(message = "index is null")
	private Integer index;
	//页长
	private Integer size;
	//用户token	必须
	@NotNull(message = "token is null")
	private String token;
	private Long userId;
	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type=type;
	}

	public Integer getIndex(){
		return index;
	}

	public void setIndex(Integer index){
		this.index=index;
	}

	public Integer getSize(){
		return size;
	}

	public void setSize(Integer size){
		this.size=size;
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
		return HostEnum.TEST+"uploadedItem.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"uploadedItem.json";
	}

}