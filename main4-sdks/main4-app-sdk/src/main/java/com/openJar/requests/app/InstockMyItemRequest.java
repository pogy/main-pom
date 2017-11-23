package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.InstockMyItemResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:InstockMyItemRequest
 * 类路径:com.openJar.requests.appInstockMyItemRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:下架我的宝贝？
 */
public class InstockMyItemRequest extends Request<InstockMyItemResponse> {
	//上传记录ID	必须
	@NotNull(message = "goodsId is null")
	private Long goodsId;
	//每次登陆用户的唯一码	必须
	@NotNull(message = "token is null")
	private String token;
	private Long userId;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId( Long goodsId ) {
		this.goodsId = goodsId;
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
		return HostEnum.TEST+"instockMyItem.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"instockMyItem.json";
	}

}