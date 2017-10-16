package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppGoodsBlock;
/**
 * 类名:ItemSearchResponse
 * 类路径:com.openJar.responses.appItemSearchResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:商品搜索
 */
public class ItemSearchResponse extends Response {
	//商品数据
	private List<AppGoodsBlock> items;
	//是否还有下一页	必须
	private Boolean hasNext;
	//总条数
	private Integer total;
	public List<AppGoodsBlock> getItems(){
		return items;
	}

	public void setItems(List<AppGoodsBlock> items){
		this.items=items;
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