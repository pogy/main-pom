package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.GoodsCollectResponse;

/**
 * 类名:AboutMeRequest
 * 类路径:com.openJar.requests.appAboutMeRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:我的信息
 */
public class GoodsCollectRequest  extends Request<GoodsCollectResponse> {
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 商品id
	 */
	private Long goodsId;
	/**
	 * 店铺ID
	 */
	private Long storeId;

	/**
	 * 站点
	 * @return
	 */
	private String webSite;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"goodsCollect.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"goodsCollect.json";
	}

}