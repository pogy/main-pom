package com.openJar.responses.app;
import com.openJar.responses.Response;
/**
 * 类名:InstockMyItemResponse
 * 类路径:com.openJar.responses.appInstockMyItemResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:下架我的宝贝？
 */
public class InstockMyItemResponse extends Response {
	//失败原因，no_auth未授权或授权失败
	private String msg;
	private Integer type;

	public Integer getType() {
		return type;
	}

	public void setType( Integer type ) {
		this.type = type;
	}

	public String getMsg(){
		return msg;
	}

	public void setMsg(String msg){
		this.msg=msg;
	}

}