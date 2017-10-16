package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppItemSpread;
/**
 * 类名:ItemSpreadResponse
 * 类路径:com.openJar.responses.appItemSpreadResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:商品广告数据
 */
public class ItemSpreadResponse extends Response {
	//广告数据	必须
	private List<AppItemSpread> spreads;
	public List<AppItemSpread> getSpreads(){
		return spreads;
	}

	public void setSpreads(List<AppItemSpread> spreads){
		this.spreads=spreads;
	}

}