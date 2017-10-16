package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.GoodsCollectResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:GoodsCollectRequest
 * 类路径:com.openJar.requests.appGoodsCollectRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:单个商品收藏
 */
public class GoodsCollectRequest extends Request<GoodsCollectResponse> {
	//用户token	必须
	@NotNull(message = "token is null")
	private String token;
	private Long userId;
	//商品id	必须
	@NotNull(message = "goodsId is null")
	private Long goodsId;
	//店铺ID	必须
	@NotNull(message = "storeId is null")
	private Long storeId;
	//站点
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

	public Long getGoodsId(){
		return goodsId;
	}

	public void setGoodsId(Long goodsId){
		this.goodsId=goodsId;
	}

	public Long getStoreId(){
		return storeId;
	}

	public void setStoreId(Long storeId){
		this.storeId=storeId;
	}

	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"goodsCollect.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"goodsCollect.json";
	}

}