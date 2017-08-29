package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.DelItemCollectResponse;
/**
 * 类名:DelItemCollectRequest
 * 类路径:com.openJar.requests.appDelItemCollectRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:删除商品收藏夹数据？
 */
public class DelItemCollectRequest extends Request<DelItemCollectResponse> {
	//收藏夹ID,多个用,分开	必须
	private String collectIds;
	//用户ID	必须
	private Long userId;
	//每次登陆用户的唯一码	必须
	private String token;
	public String getCollectIds(){
		return collectIds;
	}

	public void setCollectIds(String collectIds){
		this.collectIds=collectIds;
	}

	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId=userId;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token=token;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"delItemCollect.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"delItemCollect.json";
	}

}