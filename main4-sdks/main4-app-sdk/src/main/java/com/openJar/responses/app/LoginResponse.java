package com.openJar.responses.app;
import com.openJar.responses.Response;
/**
 * 类名:LoginResponse
 * 类路径:com.openJar.responses.appLoginResponse
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:用户登陆 http://www.571xz.com/api/getPhoneMsg.json telephone=手机号，type=login
 */
public class LoginResponse extends Response {
	//用户ID	必须
	private Long userId;
	//是否档口卖家	必须
	private Boolean imSeller;
	//头像
	private String imgsrc;
	//用户昵称	必须
	private String userNick;
	//每个用户，每次登陆的唯一码	必须
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

	public String getImgsrc( String headUrl ){
		return imgsrc;
	}

	public void setImgsrc(String imgsrc){
		this.imgsrc=imgsrc;
	}

	public String getUserNick( String userNick ){
		return this.userNick;
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