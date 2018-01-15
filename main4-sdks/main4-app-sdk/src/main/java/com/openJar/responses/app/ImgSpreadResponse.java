package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppImgBanner;
/**
 * 类名:ImgSpreadResponse
 * 类路径:com.openJar.responses.appImgSpreadResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:图片式广告数据
 */
public class ImgSpreadResponse extends Response {
	//广告数据
	private List<AppImgBanner> spreads;
	public List<AppImgBanner> getSpreads(){
		return spreads;
	}

	public void setSpreads(List<AppImgBanner> spreads){
		this.spreads=spreads;
	}

}