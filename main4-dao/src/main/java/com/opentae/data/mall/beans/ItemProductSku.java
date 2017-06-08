package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemProductSku implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private String skuId;

    /**
     * 颜色
     */
	private String color;

    /**
     * 尺码
     */
	private String size;

    /**
     * 产品ID
     */
	private String pid;

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getSkuId() {
		return this.skuId;
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

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPid() {
		return this.pid;
	}

}