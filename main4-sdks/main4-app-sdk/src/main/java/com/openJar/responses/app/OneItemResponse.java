package com.openJar.responses.app;
import com.openJar.responses.Response;
import java.util.List;
import com.openJar.beans.app.AppItemKv;
/**
 * 类名:OneItemResponse
 * 类路径:com.openJar.responses.appOneItemResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:单商品信息
 */
public class OneItemResponse extends Response {
	//标题	必须
	private String title;
	//商品ID	必须
	private String goodsId;
	//商品5张图
	private List<String> imgSrcs;
	//货号
	private String goodsNo;
	//发布时间&nbsp;yyyy-MM-dd
	private String createTime;
	//商品权益
	private List<String> goodsLicenses;
	//商品价格
	private String price;
	//店铺ID
	private Long storeId;
	//市场
	private String market;
	//档口号
	private String storeNum;
	//星星数
	private Integer starNum;
	//商品颜色
	private List<String> colors;
	//商品尺码
	private List<String> size;
	//商品参数
	private List<AppItemKv> itemKvs;
	//店铺头像
	private String shopHeadUrl;
	//
	private Long collectId;
	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getGoodsId(){
		return goodsId;
	}

	public void setGoodsId(String goodsId){
		this.goodsId=goodsId;
	}

	public List<String> getImgSrcs(){
		return imgSrcs;
	}

	public void setImgSrcs(List<String> imgSrcs){
		this.imgSrcs=imgSrcs;
	}

	public String getGoodsNo(){
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo){
		this.goodsNo=goodsNo;
	}

	public String getCreateTime(){
		return createTime;
	}

	public void setCreateTime(String createTime){
		this.createTime=createTime;
	}

	public List<String> getGoodsLicenses(){
		return goodsLicenses;
	}

	public void setGoodsLicenses(List<String> goodsLicenses){
		this.goodsLicenses=goodsLicenses;
	}

	public String getPrice(){
		return price;
	}

	public void setPrice(String price){
		this.price=price;
	}

	public Long getStoreId(){
		return storeId;
	}

	public void setStoreId(Long storeId){
		this.storeId=storeId;
	}

	public String getMarket(){
		return market;
	}

	public void setMarket(String market){
		this.market=market;
	}

	public String getStoreNum(){
		return storeNum;
	}

	public void setStoreNum(String storeNum){
		this.storeNum=storeNum;
	}

	public Integer getStarNum(){
		return starNum;
	}

	public void setStarNum(Integer starNum){
		this.starNum=starNum;
	}

	public List<String> getColors(){
		return colors;
	}

	public void setColors(List<String> colors){
		this.colors=colors;
	}

	public List<String> getSize(){
		return size;
	}

	public void setSize(List<String> size){
		this.size=size;
	}

	public List<AppItemKv> getItemKvs(){
		return itemKvs;
	}

	public void setItemKvs(List<AppItemKv> itemKvs){
		this.itemKvs=itemKvs;
	}

	public String getShopHeadUrl(){
		return shopHeadUrl;
	}

	public void setShopHeadUrl(String shopHeadUrl){
		this.shopHeadUrl=shopHeadUrl;
	}

	public Long getCollectId() {
		return collectId;
	}

	public void setCollectId( Long collectId ) {
		this.collectId = collectId;
	}
}