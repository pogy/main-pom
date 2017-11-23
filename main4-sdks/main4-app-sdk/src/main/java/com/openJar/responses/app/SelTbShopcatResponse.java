package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppShopCat;
/**
 * 类名:SelTbShopcatResponse
 * 类路径:com.openJar.responses.appSelTbShopcatResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:查询分销商淘宝店内类目?
 */
public class SelTbShopcatResponse extends Response {
	//	必须
	private List<AppShopCat> shopcats;
	public List<AppShopCat> getShopcats(){
		return shopcats;
	}

	public void setShopcats(List<AppShopCat> shopcats){
		this.shopcats=shopcats;
	}

}