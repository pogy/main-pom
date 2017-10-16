package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.DelItemCollectResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:DelItemCollectRequest
 * 类路径:com.openJar.requests.appDelItemCollectRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:删除商品收藏夹数据？
 */
public class DelItemCollectRequest extends Request<DelItemCollectResponse> {
	//收藏夹ID,多个用,分开	必须
	@NotNull(message = "collectIds is null")
	private String collectIds;
	//每次登陆用户的唯一码	必须
	@NotNull(message = "token is null")
	private String token;
	private Long userId;
	public String getCollectIds(){
		return collectIds;
	}

	public void setCollectIds(String collectIds){
		this.collectIds=collectIds;
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
		return HostEnum.TEST+"delItemCollect.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"delItemCollect.json";
	}

}