package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguPropImgs implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long propimgId;

    /**
     * 商品ID
     */
	private Long itemId;

    /**
     * pid:vid##url;pid:vid##url
     */
	private String propimgs;

	public void setPropimgId(Long propimgId) {
		this.propimgId = propimgId;
	}

	public Long getPropimgId() {
		return this.propimgId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setPropimgs(String propimgs) {
		this.propimgs = propimgs;
	}

	public String getPropimgs() {
		return this.propimgs;
	}

}