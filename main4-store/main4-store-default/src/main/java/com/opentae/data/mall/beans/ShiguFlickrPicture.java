package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguFlickrPicture implements Serializable {
    /**
     * 照片id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long picId;

    /**
     * 相册id
     */
	private Long fId;

    /**
     * 站片url
     */
	private String picUrl;

    /**
     * 照片排序
     */
	private Integer sortOrder;

    /**
     * 照片状态 1：正常，-1：删除
     */
	private Integer picStatus;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 备用
     */
	private String remark1;

    /**
     * 备用
     */
	private String remark2;

    /**
     * 备用
     */
	private String remark3;

    /**
     * 备用
     */
	private String remark4;

    /**
     * 备用
     */
	private String remark5;

	public void setPicId(Long picId) {
		this.picId = picId;
	}

	public Long getPicId() {
		return this.picId;
	}

	public void setFId(Long fId) {
		this.fId = fId;
	}

	public Long getFId() {
		return this.fId;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getSortOrder() {
		return this.sortOrder;
	}

	public void setPicStatus(Integer picStatus) {
		this.picStatus = picStatus;
	}

	public Integer getPicStatus() {
		return this.picStatus;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public String getRemark4() {
		return this.remark4;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getRemark5() {
		return this.remark5;
	}

}