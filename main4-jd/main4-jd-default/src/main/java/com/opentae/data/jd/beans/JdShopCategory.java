package com.opentae.data.jd.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class JdShopCategory implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 用户京东Id
     */
	private Long jdUid;

    /**
     *  类目编号
     */
	private Long cid;

    /**
     * 父类目编号
     */
	private Long parentId;

    /**
     * 类目名称
     */
	private String name;

    /**
     * 类目是否为父类目，即：该类目是否还有子类目
     */
	private Boolean isParent;

    /**
     * 是否展开子分类
     */
	private Boolean isOpen;

    /**
     * 是否在首页展示分类
     */
	private Boolean isHomeShow;

    /**
     * 店铺ID
     */
	private Long shopId;

    /**
     * 排序号
     */
	private Integer orderNo;

    /**
     * 创建时间
     */
	private Date gmtCreate;

    /**
     * 修改时间
     */
	private Date gmtModify;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setJdUid(Long jdUid) {
		this.jdUid = jdUid;
	}

	public Long getJdUid() {
		return this.jdUid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Boolean getIsParent() {
		return this.isParent;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public Boolean getIsOpen() {
		return this.isOpen;
	}

	public void setIsHomeShow(Boolean isHomeShow) {
		this.isHomeShow = isHomeShow;
	}

	public Boolean getIsHomeShow() {
		return this.isHomeShow;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getOrderNo() {
		return this.orderNo;
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

}