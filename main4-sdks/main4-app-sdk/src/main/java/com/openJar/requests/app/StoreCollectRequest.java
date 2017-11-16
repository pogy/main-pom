package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.StoreCollectResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:StoreCollectRequest
 * 类路径:com.openJar.requests.appStoreCollectRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:店铺收藏夹
 */
public class StoreCollectRequest extends Request<StoreCollectResponse> {
	//用户token	必须
	@NotNull(message = "token is null")
	private String token;
	private Long userId;
	//页码
	private Integer index;
	//页长
	private Integer size;
	//分站标志	必须
	@NotNull(message = "webSite is null")
	private String webSite;
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

	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"storeCollect.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"storeCollect.json";
	}

}