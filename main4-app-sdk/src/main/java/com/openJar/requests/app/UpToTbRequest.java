package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.UpToTbResponse;
import java.util.Date;
/**
 * 类名:UpToTbRequest
 * 类路径:com.openJar.requests.appUpToTbRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:上传淘宝?
 */
public class UpToTbRequest extends Request<UpToTbResponse> {
	//用户ID	必须
	private Long userId;
	//分站	必须
	private String webSite;
	//原始商品Id	必须
	private Long goodsId;
	//运费模板ID
	private Long templateId;
	//宝贝标题	必须
	private String title;
	//宝贝&nbsp;价格	必须
	private String price;
	//是否承诺退换货	必须
	private Boolean canRefund;
	//不传表示『立即』
	private Date listTime;
	//是否橱窗推荐	必须
	private Boolean needCase;
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

	public Long getTemplateId(){
		return templateId;
	}

	public void setTemplateId(Long templateId){
		this.templateId=templateId;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getPrice(){
		return price;
	}

	public void setPrice(String price){
		this.price=price;
	}

	public Boolean getCanRefund(){
		return canRefund;
	}

	public void setCanRefund(Boolean canRefund){
		this.canRefund=canRefund;
	}

	public Date getListTime(){
		return listTime;
	}

	public void setListTime(Date listTime){
		this.listTime=listTime;
	}

	public Boolean getNeedCase(){
		return needCase;
	}

	public void setNeedCase(Boolean needCase){
		this.needCase=needCase;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token=token;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"upToTb.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"upToTb.json";
	}

}