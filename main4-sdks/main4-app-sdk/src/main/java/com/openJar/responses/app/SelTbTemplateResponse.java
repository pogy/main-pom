package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppTbTemplate;
/**
 * 类名:SelTbTemplateResponse
 * 类路径:com.openJar.responses.appSelTbTemplateResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:查询淘宝分销商运费模板?
 */
public class SelTbTemplateResponse extends Response {
	//淘宝运费模板数据	必须
	private List<AppTbTemplate> templates;
	public List<AppTbTemplate> getTemplates(){
		return templates;
	}

	public void setTemplates(List<AppTbTemplate> templates){
		this.templates=templates;
	}

}