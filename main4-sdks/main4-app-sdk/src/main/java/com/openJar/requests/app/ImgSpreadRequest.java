package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ImgSpreadResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:ImgSpreadRequest
 * 类路径:com.openJar.requests.appImgSpreadRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:图片式广告数据
 */
public class ImgSpreadRequest extends Request<ImgSpreadResponse> {
	//广告位置编号	必须
	@NotNull(message = "spreadCode is null")
	private String spreadCode;
	//分站标识	必须
	@NotNull(message = "webSite is null")
	private String webSite;
	public String getSpreadCode(){
		return spreadCode;
	}

	public void setSpreadCode(String spreadCode){
		this.spreadCode=spreadCode;
	}

	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"imgSpread.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"imgSpread.json";
	}

}