package com.openJar.requests.app;
import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ItemSearchResponse;
import java.util.Date;
/**
 * 类名:ItemSearchRequest
 * 类路径:com.openJar.requests.appItemSearchRequest
 * 创建者:自动生成
 * 创建时间:2017-08-29
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
	//todo:排序字段以 com.shigu.main4.item.enums.SearchOrderBy中的值为准
	//排序，综合：comp，新品：xp，人气：popular，价格低到高：price-asc，价格高到低：price-desc
	private String orderBy;
	//1普通搜索，2商品库	必须
	private Integer type;
	//价格区间开始
	private String startPrice;
	//价格区间结束
	private String endPrice;
	//创建时间开始
	private String  startTime;
	//创建时间结束
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String testApiUrl(){
		return HostEnum.TEST+"itemSearch.json";
	}

	public String restApiUrl(){
		return HostEnum.REST+"itemSearch.json";
	}

}