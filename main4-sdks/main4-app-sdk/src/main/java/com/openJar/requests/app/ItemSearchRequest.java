package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ItemSearchResponse;
import javax.validation.constraints.NotNull;
/**
 * 类名:ItemSearchRequest
 * 类路径:com.openJar.requests.appItemSearchRequest
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:商品搜索
 */
public class ItemSearchRequest extends Request<ItemSearchResponse> {
	//关键词
	private String keyword;
	//分站标识
	private String webSite;
	//市场
	private Long marketId;
	//店铺ID
	private Long storeId;
	//类目ID
	private Long cid;
	//页码
	private Integer index;
	//页长
	private Integer size;
	//排序，综合：common，新品：xp，人气：popular，价格低到高：price-asc，&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格高到低：price-desc
	private String orderBy;
	//1商品库cid不能为空,2普通搜索keyword不能为空，&nbsp;&nbsp;&nbsp;&nbsp;3店铺搜索storeId不能为空	必须
	@NotNull(message = "type is null")
	private Integer type;
	//价格区间开始
	private String startPrice;
	//价格区间结束
	private String endPrice;
	//创建时间开始yyyy-MM-dd
	private String startTime;
	//创建时间结束yyyy-MM-dd
	private String endTime;
	public String getKeyword(){
		return keyword;
	}

	public void setKeyword(String keyword){
		this.keyword=keyword;
	}

	public String getWebSite(){
		return webSite;
	}

	public void setWebSite(String webSite){
		this.webSite=webSite;
	}

	public Long getMarketId(){
		return marketId;
	}

	public void setMarketId(Long marketId){
		this.marketId=marketId;
	}

	public Long getStoreId(){
		return storeId;
	}

	public void setStoreId(Long storeId){
		this.storeId=storeId;
	}

	public Long getCid(){
		return cid;
	}

	public void setCid(Long cid){
		this.cid=cid;
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

	public String getOrderBy(){
		return orderBy;
	}

	public void setOrderBy(String orderBy){
		this.orderBy=orderBy;
	}

	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type=type;
	}

	public String getStartPrice(){
		return startPrice;
	}

	public void setStartPrice(String startPrice){
		this.startPrice=startPrice;
	}

	public String getEndPrice(){
		return endPrice;
	}

	public void setEndPrice(String endPrice){
		this.endPrice=endPrice;
	}

	public String getStartTime(){
		return startTime;
	}

	public void setStartTime(String startTime){
		this.startTime=startTime;
	}

	public String getEndTime(){
		return endTime;
	}

	public void setEndTime(String endTime){
		this.endTime=endTime;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"itemSearch.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"itemSearch.json";
	}

}