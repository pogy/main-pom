package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguGoodsTaoRelation implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long relationId;

    /**
     * 商品ID
     */
	private Long goodsId;

    /**
     * 淘宝ID
     */
	private Long numIid;

    /**
     * 分站
     */
	private String webSite;

    /**
     * 
     */
	private Long userId;

	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}

	public Long getRelationId() {
		return this.relationId;
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

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

}