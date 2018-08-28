package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguGoodsTinyCreatedQz implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long goodsId;

    /**
     * 
     */
	private Date oldCreated;

    /**
     * 
     */
	private Date gmtCreate;

	private Date gmtModif;

	public Date getGmtModif() {
		return gmtModif;
	}

	public void setGmtModif(Date gmtModif) {
		this.gmtModif = gmtModif;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setOldCreated(Date oldCreated) {
		this.oldCreated = oldCreated;
	}

	public Date getOldCreated() {
		return this.oldCreated;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

}