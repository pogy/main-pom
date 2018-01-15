package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppItemUploaded;
/**
 * 类名:UploadedItemResponse
 * 类路径:com.openJar.responses.appUploadedItemResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:已上传宝贝
 */
public class UploadedItemResponse extends Response {
	//是否有下一页	必须
	private Boolean hasNext;
	//总条数	必须
	private Integer total;
	//宝贝信息	必须
	private List<AppItemUploaded> items;
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

	public List<AppItemUploaded> getItems(){
		return items;
	}

	public void setItems(List<AppItemUploaded> items){
		this.items=items;
	}

}