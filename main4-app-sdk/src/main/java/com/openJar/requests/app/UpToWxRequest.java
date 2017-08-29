package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.UpToWxResponse;
/**
 * 类名:UpToWxRequest
 * 类路径:com.openJar.requests.appUpToWxRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:上传微信
 */
public class UpToWxRequest extends Request<UpToWxResponse> {
	//用户ID	必须
	private Long userId;
	//分站	必须
	private String webSite;
	//商品ID	必须
	private Long goodsId;
	//每次登陆用户的唯一码	必须
	private String token;
	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId=userId;
	}

	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public Long getGoodsId(){
		return goodsId;
	}

	public void setGoodsId(Long goodsId){
		this.goodsId=goodsId;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token=token;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"upToWx.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"upToWx.json";
	}

}