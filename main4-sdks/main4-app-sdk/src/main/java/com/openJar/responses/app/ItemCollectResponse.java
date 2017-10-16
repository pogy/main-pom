package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppGoodsBlock;
/**
 * 类名:ItemCollectResponse
 * 类路径:com.openJar.responses.appItemCollectResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:商品收藏夹？
 */
public class ItemCollectResponse extends Response {
	//是否有下一页
	private Boolean hasNext;
	//商品数据
	private List<AppGoodsBlock> items;
	//总条数
	private Integer total;
	public Boolean getHasNext(){
		return hasNext;
	}

	public void setHasNext(Boolean hasNext){
		this.hasNext=hasNext;
	}

	public List<AppGoodsBlock> getItems(){
		return items;
	}

	public void setItems(List<AppGoodsBlock> items){
		this.items=items;
	}

	public Integer getTotal(){
		return total;
	}

	public void setTotal(Integer total){
		this.total=total;
	}

}