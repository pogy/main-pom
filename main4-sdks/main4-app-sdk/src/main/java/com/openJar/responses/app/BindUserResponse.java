package com.openJar.responses.app;
import com.openJar.responses.Response;
/**
 * 类名:BindUserResponse
 * 类路径:com.openJar.responses.appBindUserResponse
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:用户绑定手机 手机验证码的获取链接为http://www.571xz.com/api/getPhoneMsg.json telephone=手机号，type=bind
 */
public class BindUserResponse extends Response {
	//用户ID	必须
	private Long userId;
	//是否卖家	必须
	private Boolean imSeller;
	//头像	必须
	private String imgsrc;
	//用户昵称	必须
	private String userNick;
	//每次登陆，用户的唯一码	必须
	private String token;
	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId=userId;
	}

	public Boolean getImSeller(){
		return imSeller;
	}

	public void setImSeller(Boolean imSeller){
		this.imSeller=imSeller;
	}

	public String getImgsrc(){
		return imgsrc;
	}

	public void setImgsrc(String imgsrc){
		this.imgsrc=imgsrc;
	}

	public String getUserNick(){
		return userNick;
	}

	public void setUserNick(String userNick){
		this.userNick=userNick;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token=token;
	}

}