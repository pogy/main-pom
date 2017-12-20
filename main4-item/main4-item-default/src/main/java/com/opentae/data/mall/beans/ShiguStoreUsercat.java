package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguStoreUsercat implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long useCatId;

    /**
     * 显示名称
     */
	private String showName;

    /**
     * 所有的cid按父级到子级排列
     */
	private String allcids;

    /**
     * 最终叶子级CID
     */
	private Long cid;

    /**
     * 最终叶子级名称
     */
	private String cname;

    /**
     * 店铺ID
     */
	private Long storeId;

    /**
     * 创建时间
     */
	private Date created;

	public void setUseCatId(Long useCatId) {
		this.useCatId = useCatId;
	}

	public Long getUseCatId() {
		return this.useCatId;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getShowName() {
		return this.showName;
	}

	public void setAllcids(String allcids) {
		this.allcids = allcids;
	}

	public String getAllcids() {
		return this.allcids;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCname() {
		return this.cname;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getStoreId() {
		return this.storeId;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getCreated() {
		return this.created;
	}

}