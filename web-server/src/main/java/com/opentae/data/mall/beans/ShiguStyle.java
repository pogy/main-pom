package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguStyle implements Serializable {
    /**
     * 风格id，主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 创建时间
     */
	private Date gmtCreate;

    /**
     * 最后修改时间
     */
	private Date gmtModify;

    /**
     * 风格名称
     */
	private String styleName;

    /**
     * 显示排序
     */
	private Integer sort;

    /**
     * id，是否顶级风格标签，0不是，1是
     */
	private Integer isParent;

    /**
     * 
     */
	private Long parentStyleId;

    /**
     * 风格描述信息
     */
	private String description;

    /**
     * 
     */
	private String channelImgUrl;

    /**
     * 广告位缓存风格类型识别标签
     */
	private String tag;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public Date getGmtModify() {
		return this.gmtModify;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public String getStyleName() {
		return this.styleName;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

	public Integer getIsParent() {
		return this.isParent;
	}

	public void setParentStyleId(Long parentStyleId) {
		this.parentStyleId = parentStyleId;
	}

	public Long getParentStyleId() {
		return this.parentStyleId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setChannelImgUrl(String channelImgUrl) {
		this.channelImgUrl = channelImgUrl;
	}

	public String getChannelImgUrl() {
		return this.channelImgUrl;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return this.tag;
	}

}