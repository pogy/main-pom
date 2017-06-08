package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderStatusRecord implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private String statusId;

    /**
     * 订单ID
     */
	private String oid;

    /**
     * 创建时间
     */
	private String createTime;

    /**
     * 1、等待买家付款，2、卖家部分发货，3、等待卖家发货，4、交易完成，5、交易关闭
     */
	private String status;

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getStatusId() {
		return this.statusId;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOid() {
		return this.oid;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

}