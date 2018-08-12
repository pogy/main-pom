package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguSellerAppMsg implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 消息接收方id
     */
	private Long userId;

    /**
     * 标题
     */
	private String msgTitle;

    /**
     * 消息
     */
	private String msg;

    /**
     * 追加信息
     */
	private String extend1;

    /**
     * 
     */
	private String extend2;

    /**
     * 消息状态 0 未读 1 已读
     */
	private Integer msgStatus;

    /**
     * 消息类型 0 新订单
     */
	private Integer msgType;

    /**
     * 
     */
	private Date gmtCreate;

    /**
     * 
     */
	private Date gmtModify;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getMsgTitle() {
		return this.msgTitle;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	public String getExtend1() {
		return this.extend1;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	public String getExtend2() {
		return this.extend2;
	}

	public void setMsgStatus(Integer msgStatus) {
		this.msgStatus = msgStatus;
	}

	public Integer getMsgStatus() {
		return this.msgStatus;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public Integer getMsgType() {
		return this.msgType;
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