package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ItemCollectResponse;
/**
 * 类名:ItemCollectRequest
 * 类路径:com.openJar.requests.appItemCollectRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:商品收藏夹？
 */
public class ItemCollectRequest extends Request<ItemCollectResponse> {
	//用户ID	必须
	private Long userId;
	//页码
	private Integer index;
	//页长
	private Integer size;
	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId=userId;
	}

	public Integer getIndex(){
		return index;
	}

	public void setIndex(Integer index){
		this.index=index;
	}

	public Integer getSize(){
		return size;
	}

	public void setSize(Integer size){
		this.size=size;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"itemCollect.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"itemCollect.json";
	}

}