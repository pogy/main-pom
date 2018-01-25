package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguNewActiveParticipants implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 参与用户ID
     */
	private Long memberId;

    /**
     * 对应的活动Id
     */
	private Long newActiveId;

    /**
     * 商品上传量
     */
	private Long goodsUploadNum;

    /**
     * 中奖状态 1 等待中奖 2未中奖 3中奖4已领奖
     */
	private Integer winningStatus;

    /**
     * 中奖码
     */
	private String winningCode;

    /**
     * 记录创建时间
     */
	private Date gmtCreate;

    /**
     * 记录最后修改时间
     */
	private Date gmtModify;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getMemberId() {
		return this.memberId;
	}

	public void setNewActiveId(Long newActiveId) {
		this.newActiveId = newActiveId;
	}

	public Long getNewActiveId() {
		return this.newActiveId;
	}

	public void setGoodsUploadNum(Long goodsUploadNum) {
		this.goodsUploadNum = goodsUploadNum;
	}

	public Long getGoodsUploadNum() {
		return this.goodsUploadNum;
	}

	public void setWinningStatus(Integer winningStatus) {
		this.winningStatus = winningStatus;
	}

	public Integer getWinningStatus() {
		return this.winningStatus;
	}

	public void setWinningCode(String winningCode) {
		this.winningCode = winningCode;
	}

	public String getWinningCode() {
		return this.winningCode;
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