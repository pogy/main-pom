package com.openJar.responses.app;
import com.openJar.responses.Response;
import com.openJar.beans.app.AppMarket;
/**
 * 类名:MarketsResponse
 * 类路径:com.openJar.responses.appMarketsResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:市场数据
 */
public class MarketsResponse extends Response {
	//市场数据	必须
	private AppMarket market;
	public AppMarket getMarket(){
		return market;
	}

	public void setMarket(AppMarket market){
		this.market=market;
	}

}