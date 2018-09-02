package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class VirtualFlow implements Serializable {
    /**
     * 商品ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long goodsId;

    /**
     * 虚拟点击量
     */
	private Long virtualClicks;

    /**
     * 虚拟上传量
     */
	private Long virtualUploadNum;

    /**
     * 0
     */
	private Long virtualDownNum;

    /**
     * 浏览量的增加比例   默认为1  上传量是浏览量的 1/3 此比例在程序里进行控制
     */
	private Long clicksScale;

    /**
     * 0000-00-00 00:00:00
     */
	private Date gmtCreate;

    /**
     * 0000-00-00 00:00:00
     */
	private Date gmtModif;

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setVirtualClicks(Long virtualClicks) {
		this.virtualClicks = virtualClicks;
	}

	public Long getVirtualClicks() {
		return this.virtualClicks;
	}

	public void setVirtualUploadNum(Long virtualUploadNum) {
		this.virtualUploadNum = virtualUploadNum;
	}

	public Long getVirtualUploadNum() {
		return this.virtualUploadNum;
	}

	public void setVirtualDownNum(Long virtualDownNum) {
		this.virtualDownNum = virtualDownNum;
	}

	public Long getVirtualDownNum() {
		return this.virtualDownNum;
	}

	public void setClicksScale(Long clicksScale) {
		this.clicksScale = clicksScale;
	}

	public Long getClicksScale() {
		return this.clicksScale;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtModif(Date gmtModif) {
		this.gmtModif = gmtModif;
	}

	public Date getGmtModif() {
		return this.gmtModif;
	}

}