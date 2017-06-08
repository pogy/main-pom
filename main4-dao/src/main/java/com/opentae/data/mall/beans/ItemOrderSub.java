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
     * 件数
     */
	private Integer num;

    /**
     * 到货数量
     */
	private Integer distributionNum;

    /**
     * 应付总额
     */
	private Long shouldPayMoney;

    /**
     * 实付
     */
	private Long payMoney;

    /**
     * 实退
     */
	private Long refundMoney;

    /**
     * 是否已发
     */
	private Boolean send;

    /**
     * 是否退款
     */
	private Boolean refund;

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
     * 分站
     */
	private String webSite;

    /**
     * 商品图片
     */
	private String picUrl;

    /**
     * 标题
     */
	private String title;

    /**
     * 单价
     */
	private Long singlePrice;

    /**
     * 颜色
     */
	private String color;

    /**
     * 尺码
     */
	private String size;

    /**
     * 单品重量，克
     */
	private Long singleWeight;

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

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setDistributionNum(Integer distributionNum) {
		this.distributionNum = distributionNum;
	}

	public Integer getDistributionNum() {
		return this.distributionNum;
	}

	public void setShouldPayMoney(Long shouldPayMoney) {
		this.shouldPayMoney = shouldPayMoney;
	}

	public Long getShouldPayMoney() {
		return this.shouldPayMoney;
	}

	public void setPayMoney(Long payMoney) {
		this.payMoney = payMoney;
	}

	public Long getPayMoney() {
		return this.payMoney;
	}

	public void setRefundMoney(Long refundMoney) {
		this.refundMoney = refundMoney;
	}

	public Long getRefundMoney() {
		return this.refundMoney;
	}

	public void setSend(Boolean send) {
		this.send = send;
	}

	public Boolean getSend() {
		return this.send;
	}

	public void setRefund(Boolean refund) {
		this.refund = refund;
	}

	public Boolean getRefund() {
		return this.refund;
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

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setSinglePrice(Long singlePrice) {
		this.singlePrice = singlePrice;
	}

	public Long getSinglePrice() {
		return this.singlePrice;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSize() {
		return this.size;
	}

	public void setSingleWeight(Long singleWeight) {
		this.singleWeight = singleWeight;
	}

	public Long getSingleWeight() {
		return this.singleWeight;
	}

}