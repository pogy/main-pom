package com.shigu.main4.other.bo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class ActiveDrawGoods implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 商品ID
     */
	private Long goodsId;

    /**
     * 期次
     */
	private Long pemId;

    /**
     * 坑位ID
     */
	private Long pitId;

    /**
     * 发现好货/每日发现
     */
	private String type;

    /**
     * 排序
     */
	private Integer sort;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 更新时间
     */
	private Date modifyTime;

    /**
     * 数据有效性
     */
	private Boolean enabled;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setPemId(Long pemId) {
		this.pemId = pemId;
	}

	public Long getPemId() {
		return this.pemId;
	}

	public void setPitId(Long pitId) {
		this.pitId = pitId;
	}

	public Long getPitId() {
		return this.pitId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

}