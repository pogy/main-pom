package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppShopBlock;
/**
 * 类名:ShopSearchResponse
 * 类路径:com.openJar.responses.appShopSearchResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:档口搜索
 */
public class ShopSearchResponse extends Response {
	//店铺数据
	private List<AppShopBlock> shops;
	//是否有下一页
	private Boolean hasNext;
	//总数
	private Integer total;
	public List<AppShopBlock> getShops(){
		return shops;
	}

	public void setShops(List<AppShopBlock> shops){
		this.shops=shops;
	}

	public Boolean getHasNext(){
		return hasNext;
	}

	public void setHasNext(Boolean hasNext){
		this.hasNext=hasNext;
	}

	public Integer getTotal(){
		return total;
	}

	public void setTotal(Integer total){
		this.total=total;
	}

}