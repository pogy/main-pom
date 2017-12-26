package com.shigu.goodsup.jd.vo;

import com.taobao.api.domain.Item;

/**
 * 页面显示要用的商品数据
 * @author zhaohongbo
 *
 */
public class JdPageItem {
    private Item item;
	private Long goodsId;//商品ID
	private Long storeId;//店铺ID
	private String webSite;//分站
	private Integer dataType;//数据来源，1、淘宝来的，2、数据库来的
	private Integer goodsType;//商品类型，1、普通商品，2、数据包商品
	private String piPrice;//批发价
	private String huohao;//货号
	private Long numIid;//原NumIid
	
	private String parentMarketName;//市场名
	private String storeNum;//档口名
	/**
	 * 标题长度
	 */
	private int titleLength;
	/**
	 * 卖点的长度
	 */
	private int sellPointLength;

	/**
	 * 取得利润
	 * @return
	 */
	public String getProfit() {
//		Double p1=Double.valueOf(item.getPrice());//零售价
//		Double p0=Double.valueOf(piPrice);//批价
//		Double cp=p1-p0;//差价
//		DecimalFormat df=new DecimalFormat("0.00");
//		return df.format(cp);
		return "0";
	}

	public int getTitleLength() {
		return titleLength;
	}

	public void setTitleLength(int titleLength) {
		this.titleLength = titleLength;
	}

	public int getSellPointLength() {
		return sellPointLength;
	}

	public void setSellPointLength(int sellPointLength) {
		this.sellPointLength = sellPointLength;
	}

	public Integer getDataType() {
		return dataType;
	}
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
	public Integer getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public String getPiPrice() {
		return piPrice;
	}
	public void setPiPrice(String piPrice) {
		this.piPrice = piPrice;
	}
	public String getHuohao() {
		return huohao;
	}
	public void setHuohao(String huohao) {
		this.huohao = huohao;
	}
	public Long getNumIid() {
		return numIid;
	}
	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}
	public String getParentMarketName() {
		return parentMarketName;
	}
	public void setParentMarketName(String parentMarketName) {
		this.parentMarketName = parentMarketName;
	}
	public String getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
