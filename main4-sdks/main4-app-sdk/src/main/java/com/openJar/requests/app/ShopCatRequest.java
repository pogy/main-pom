package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ShopCatResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:ShopCatRequest
 * 类路径:com.openJar.requests.appShopCatRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:店内类目
 */
public class ShopCatRequest extends Request<ShopCatResponse> {
	//分站标识	必须
	@NotNull(message = "webSite is null")
	private String webSite;
	//店铺ID	必须
	@NotNull(message = "shopId is null")
	private Long shopId;
	private Integer index;//页码
	private Integer size;//页长
	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public Long getShopId(){
		return shopId;
	}

	public void setShopId(Long shopId){
		this.shopId=shopId;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"shopCat.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"shopCat.json";
	}

}