package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemOrderSub implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long soid;

    /**
     * 订单号
     */
	private Long oid;

    /**
     * 产品ID
     */
	private Long pid;

    /**
     * sku信息
     */
	private Long skuId;

    /**
     * 件数
     */
	private Integer num;

    /**
     * 缺货数量
     */
	private Integer outOfStok;

    /**
     * 应付总额
     */
	private Long shouldPayMoney;

    /**
     * 实退
     */
	private Long refundMoney;

    /**
     * 0初始状态，1已退，2已发
     */
	private Integer status;

    /**
     * 备注
     */
	private String mark;

    /**
     * 交易信息ID
     */
	private Long logisticsId;

    /**
     * 星座商品ID
     */
	private Long goodsId;

    /**
     * 图片链接
     */
	private String picUrl;

    /**
     * 分站标识
     */
	private String webSite;

    /**
     * 标题
     */
	private String title;

    /**
     * 产品价格
     */
	private Long price;

    /**
     * 市场ID
     */
	private Long marketId;

    /**
     * 楼层ID
     */
	private Long floorId;

    /**
     * 店铺ID
     */
	private Long shopId;

    /**
     * 档口号
     */
	private String shopNum;

    /**
     * 市场名字
     */
	private String marketName;

    /**
     * 楼层号
     */
	private String floor;

    /**
     * 重量，克为单位
     */
	private Long weight;

    /**
     * 货号
     */
	private String goodsNo;

    /**
     * 尺码
     */
	private String size;

    /**
     * 颜色
     */
	private String color;

    /**
     * 有货时间
     */
	private String outOfStokReason;

    /**
     * 已拿到件数
     */
	private Integer inStok;

	public void setSoid(Long soid) {
		this.soid = soid;
	}

	public Long getSoid() {
		return this.soid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getOid() {
		return this.oid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Long getSkuId() {
		return this.skuId;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setOutOfStok(Integer outOfStok) {
		this.outOfStok = outOfStok;
	}

	public Integer getOutOfStok() {
		return this.outOfStok;
	}

	public void setShouldPayMoney(Long shouldPayMoney) {
		this.shouldPayMoney = shouldPayMoney;
	}

	public Long getShouldPayMoney() {
		return this.shouldPayMoney;
	}

	public void setRefundMoney(Long refundMoney) {
		this.refundMoney = refundMoney;
	}

	public Long getRefundMoney() {
		return this.refundMoney;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return this.mark;
	}

	public void setLogisticsId(Long logisticsId) {
		this.logisticsId = logisticsId;
	}

	public Long getLogisticsId() {
		return this.logisticsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Long getMarketId() {
		return this.marketId;
	}

	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}

	public Long getFloorId() {
		return this.floorId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
	}

	public String getShopNum() {
		return this.shopNum;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getMarketName() {
		return this.marketName;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getFloor() {
		return this.floor;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public Long getWeight() {
		return this.weight;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getGoodsNo() {
		return this.goodsNo;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSize() {
		return this.size;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	public void setOutOfStokReason(String outOfStokReason) {
		this.outOfStokReason = outOfStokReason;
	}

	public String getOutOfStokReason() {
		return this.outOfStokReason;
	}

	public void setInStok(Integer inStok) {
		this.inStok = inStok;
	}

	public Integer getInStok() {
		return this.inStok;
	}

}