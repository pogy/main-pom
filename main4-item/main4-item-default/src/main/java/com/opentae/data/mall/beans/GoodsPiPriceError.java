package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class GoodsPiPriceError implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long pipriceId;

    /**
     * 
     */
	private Long goodsId;

    /**
     * 
     */
	private Long numIid;

    /**
     * 
     */
	private String webSite;

    /**
     * 
     */
	private String title;

    /**
     * 
     */
	private String goodsNo;

    /**
     * 
     */
	private String otherId;

    /**
     * 
     */
	private Long sysPiPrice;

    /**
     * 
     */
	private Long customPiPrice;

    /**
     * 
     */
	private String errorPiPrice;

    /**
     * 
     */
	private Long price;

    /**
     * 
     */
	private Integer hasEnt;

    /**
     * 
     */
	private Date createTime;

    /**
     * 
     */
	private Date lastModifyTime;

	public void setPipriceId(Long pipriceId) {
		this.pipriceId = pipriceId;
	}

	public Long getPipriceId() {
		return this.pipriceId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}

	public Long getNumIid() {
		return this.numIid;
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

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getGoodsNo() {
		return this.goodsNo;
	}

	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}

	public String getOtherId() {
		return this.otherId;
	}

	public void setSysPiPrice(Long sysPiPrice) {
		this.sysPiPrice = sysPiPrice;
	}

	public Long getSysPiPrice() {
		return this.sysPiPrice;
	}

	public void setCustomPiPrice(Long customPiPrice) {
		this.customPiPrice = customPiPrice;
	}

	public Long getCustomPiPrice() {
		return this.customPiPrice;
	}

	public void setErrorPiPrice(String errorPiPrice) {
		this.errorPiPrice = errorPiPrice;
	}

	public String getErrorPiPrice() {
		return this.errorPiPrice;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setHasEnt(Integer hasEnt) {
		this.hasEnt = hasEnt;
	}

	public Integer getHasEnt() {
		return this.hasEnt;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Date getLastModifyTime() {
		return this.lastModifyTime;
	}

}