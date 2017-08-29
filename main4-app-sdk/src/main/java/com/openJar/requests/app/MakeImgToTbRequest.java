package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.MakeImgToTbResponse;
/**
 * 类名:MakeImgToTbRequest
 * 类路径:com.openJar.requests.appMakeImgToTbRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:创建淘宝图片?
 */
public class MakeImgToTbRequest extends Request<MakeImgToTbResponse> {
	//用户ID	必须
	private Long userId;
	//分站标识	必须
	private String webSite;
	//商品Id	必须
	private Long goodsId;
	//1、主图，2、属性图，3、详情图	必须
	private Integer type;
	//每次登陆，用户的唯一码	必须
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

	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type=type;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token=token;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"makeImgToTb.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"makeImgToTb.json";
	}

}