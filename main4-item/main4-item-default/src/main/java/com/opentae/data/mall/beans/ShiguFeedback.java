package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguFeedback implements Serializable {
    /**
     * feedback_id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long feedbackId;

    /**
     * 标题
     */
	private String title;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 内容
     */
	private String fcontents;

    /**
     * bug处理情况：0 待处理，1已处理
     */
	private Integer status;

    /**
     * 更新时间
     */
	private Date updateTime;

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

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Long getFeedbackId() {
		return this.feedbackId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setFcontents(String fcontents) {
		this.fcontents = fcontents;
	}

	public String getFcontents() {
		return this.fcontents;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
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