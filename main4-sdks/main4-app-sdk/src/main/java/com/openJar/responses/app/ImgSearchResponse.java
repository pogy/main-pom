package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppGoodsBlock;
/**
 * 类名:ImgSearchResponse
 * 类路径:com.openJar.responses.appImgSearchResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:图搜，不分页，最多20个
 */
public class ImgSearchResponse extends Response {
	//匹配的商品数据
	private List<AppGoodsBlock> items;
	public List<AppGoodsBlock> getItems(){
		return items;
	}

	public void setItems(List<AppGoodsBlock> items){
		this.items=items;
	}

}