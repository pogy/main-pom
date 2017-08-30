package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class OrderStatusRecord implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long statusId;

    /**
     * 订单ID
     */
	private Long oid;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 1、等待买家付款，2、卖家部分发货，3、等待卖家发货，4、交易完成，5、交易关闭
     */
	private Integer status;

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getStatusId() {
		return this.statusId;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getOid() {
		return this.oid;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

}