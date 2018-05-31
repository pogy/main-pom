package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguFlickr implements Serializable {
    /**
     * 相册id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long fId;

    /**
     * 类目id
     */
	private Long cId;

    /**
     * 相册名
     */
	private String fName;

    /**
     * 相册描述
     */
	private String fDesc;

    /**
     * 相册封面
     */
	private String fCover;

    /**
     * 浏览量
     */
	private Long clicks;

    /**
     * 档口id
     */
	private Long storeId;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 修改时间
     */
	private Date modifyTime;

    /**
     * 相册状态 1：正常，-1：删除
     */
	private Integer fStatus;

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

    /**
     * 站点
     */
	private String webSite;

	public void setFId(Long fId) {
		this.fId = fId;
	}

	public Long getFId() {
		return this.fId;
	}

	public void setCId(Long cId) {
		this.cId = cId;
	}

	public Long getCId() {
		return this.cId;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getFName() {
		return this.fName;
	}

	public void setFDesc(String fDesc) {
		this.fDesc = fDesc;
	}

	public String getFDesc() {
		return this.fDesc;
	}

	public void setFCover(String fCover) {
		this.fCover = fCover;
	}

	public String getFCover() {
		return this.fCover;
	}

	public void setClicks(Long clicks) {
		this.clicks = clicks;
	}

	public Long getClicks() {
		return this.clicks;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getStoreId() {
		return this.storeId;
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

	public void setFStatus(Integer fStatus) {
		this.fStatus = fStatus;
	}

	public Integer getFStatus() {
		return this.fStatus;
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

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

}