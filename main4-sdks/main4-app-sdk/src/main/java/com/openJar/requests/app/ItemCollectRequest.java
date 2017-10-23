package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ItemCollectResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:ItemCollectRequest
 * 类路径:com.openJar.requests.appItemCollectRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:商品收藏夹？
 */
public class ItemCollectRequest extends Request<ItemCollectResponse> {
	//用户token	必须
	@NotNull(message = "token is null")
	private String token;
	private Long userId;
	/**不传或者传空查所有站点下收藏*/
	private String webSite;
	//页码
	private Integer index;
	//页长
	private Integer size;
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

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"itemCollect.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"itemCollect.json";
	}

}