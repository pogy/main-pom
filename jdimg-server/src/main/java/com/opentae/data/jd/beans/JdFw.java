package com.opentae.data.jd.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class JdFw implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 用户京东Id
     */
	private Long jdUid;

    /**
     * 发布的服务京东项目编码
     */
	private String itemCode;

    /**
     * 购买人
     */
	private String userName;

    /**
     * 调用来源
     */
	private String itemSource;

    /**
     * 服务版本号
     */
	private Integer versionNo;

    /**
     * 到期时间
     */
	private Date endDate;

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

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setItemSource(String itemSource) {
		this.itemSource = itemSource;
	}

	public String getItemSource() {
		return this.itemSource;
	}

	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	public Integer getVersionNo() {
		return this.versionNo;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return this.endDate;
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