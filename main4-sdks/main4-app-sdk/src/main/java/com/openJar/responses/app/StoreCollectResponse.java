package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppShopBlock;
/**
 * 类名:StoreCollectResponse
 * 类路径:com.openJar.responses.appStoreCollectResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:店铺收藏夹
 */
public class StoreCollectResponse extends Response {
	//总条数
	private Integer total;
	//是否有下一页
	private Boolean hasNext;
	//商品数据
	private List<AppShopBlock> shops;
	public Integer getTotal(){
		return total;
	}

	public void setTotal(Integer total){
		this.total=total;
	}

	public Boolean getHasNext(){
		return hasNext;
	}

	public void setHasNext(Boolean hasNext){
		this.hasNext=hasNext;
	}

	public List<AppShopBlock> getShops(){
		return shops;
	}

	public void setShops(List<AppShopBlock> shops){
		this.shops=shops;
	}

}