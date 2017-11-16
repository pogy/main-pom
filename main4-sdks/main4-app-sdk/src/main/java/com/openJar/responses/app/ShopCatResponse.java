package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppShopCat;
/**
 * 类名:ShopCatResponse
 * 类路径:com.openJar.responses.appShopCatResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:店内类目
 */
public class ShopCatResponse extends Response {
	//店内类目信息	必须
	private List<AppShopCat> cats;
	//商品总数
	private Long totalItemNum;
	public List<AppShopCat> getCats(){
		return cats;
	}

	public void setCats(List<AppShopCat> cats){
		this.cats=cats;
	}

	public Long getTotalItemNum(){
		return totalItemNum;
	}

	public void setTotalItemNum(Long totalItemNum){
		this.totalItemNum=totalItemNum;
	}

}