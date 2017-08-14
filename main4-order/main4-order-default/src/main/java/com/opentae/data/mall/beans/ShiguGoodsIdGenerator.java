package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguGoodsIdGenerator implements Serializable {
    /**
     * 商品ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long goodId;

    /**
     * 具体站点@比如杭州用hz
     */
	private String webSite;

    /**
     * 备注
     */
	private String remark;

	public void setGoodId(Long goodId) {
		this.goodId = goodId;
	}

	public Long getGoodId() {
		return this.goodId;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

}