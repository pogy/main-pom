package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class SpreadActivity implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long activityId;

    /**
     * 
     */
	private Long termId;

    /**
     * 描述
     */
	private String description;

    /**
     * 排序
     */
	private Integer sort;

    /**
     * 0卖广告服务，1LED服务
     */
	private Integer type;

    /**
     * 内容
     */
	private String context;

    /**
     * 唯一对应
     */
	private String activityKey;

    /**
     * 活动费用
     */
	private Long price;

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getActivityId() {
		return this.activityId;
	}

	public void setTermId(Long termId) {
		this.termId = termId;
	}

	public Long getTermId() {
		return this.termId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getContext() {
		return this.context;
	}

	public void setActivityKey(String activityKey) {
		this.activityKey = activityKey;
	}

	public String getActivityKey() {
		return this.activityKey;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getPrice() {
		return this.price;
	}

}