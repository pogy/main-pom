package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class GoodsFile implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 
     */
	private String fileKey;

    /**
     * 
     */
	private Long goodsId;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	public String getFileKey() {
		return this.fileKey;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

}