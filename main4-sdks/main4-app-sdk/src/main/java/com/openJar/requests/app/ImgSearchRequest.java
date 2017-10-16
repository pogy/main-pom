package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ImgSearchResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:ImgSearchRequest
 * 类路径:com.openJar.requests.appImgSearchRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:图搜，不分页，最多20个
 */
public class ImgSearchRequest extends Request<ImgSearchResponse> {
	//图片链接	必须
	@NotNull(message = "imgurl is null")
	private String imgurl;
	//分站标识
	private String webSite;
	public String getImgurl(){
		return imgurl;
	}

	public void setImgurl(String imgurl){
		this.imgurl=imgurl;
	}

	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"imgSearch.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"imgSearch.json";
	}

}