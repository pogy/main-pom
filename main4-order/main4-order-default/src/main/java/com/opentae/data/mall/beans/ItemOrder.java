package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ItemOrder implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long oid;

    /**
     * 1星座商品类别
     */
	private Integer type;

    /**
     * 总费用
     */
	private Long totalFee;

    /**
     * 已付金额
     */
	private Long payedFee;

    /**
     * 已退总额
     */
	private Long refundFee;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 发件单位ID
     */
	private Long senderId;

    /**
     * 标题
     */
	private String title;

    /**
     * 分站
     */
	private String webSite;

    /**
     * 1、等待买家付款，2、已支付，3、已发货，4、交易完成，5、交易关闭
     */
	private Integer orderStatus;

    /**
     * 备注
     */
	private String mark;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 结单时间
     */
	private Date finishTime;

    /**
     * 淘宝订单id
     */
	private String outerId;

    /**
     * 被删除1/0正常
     */
	private Boolean disenable;

    /**
     * 发货时间
     */
	private Date sendTime;

    /**
     * 
     */
	private Boolean tbSend;

    /**
     * 支付时间
     */
	private Date payTime;

    /**
     * 订单终端来源 1:PC 2:APP 3:WAP 4:WX
     */
	private Integer orderFrom;

    /**
     * 不计算减免的总金额，单位为分
     */
	private Long totalFeeWithoutVoucher;

    /**
     * 实际代金券减免金额
     */
	private Long realVoucherAmount;

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getOid() {
		return this.oid;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	public Long getTotalFee() {
		return this.totalFee;
	}

	public void setPayedFee(Long payedFee) {
		this.payedFee = payedFee;
	}

	public Long getPayedFee() {
		return this.payedFee;
	}

	public void setRefundFee(Long refundFee) {
		this.refundFee = refundFee;
	}

	public Long getRefundFee() {
		return this.refundFee;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getSenderId() {
		return this.senderId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return this.mark;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Date getFinishTime() {
		return this.finishTime;
	}

	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

	public String getOuterId() {
		return this.outerId;
	}

	public void setDisenable(Boolean disenable) {
		this.disenable = disenable;
	}

	public Boolean getDisenable() {
		return this.disenable;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setTbSend(Boolean tbSend) {
		this.tbSend = tbSend;
	}

	public Boolean getTbSend() {
		return this.tbSend;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getPayTime() {
		return this.payTime;
	}

	public void setOrderFrom(Integer orderFrom) {
		this.orderFrom = orderFrom;
	}

	public Integer getOrderFrom() {
		return this.orderFrom;
	}

	public void setTotalFeeWithoutVoucher(Long totalFeeWithoutVoucher) {
		this.totalFeeWithoutVoucher = totalFeeWithoutVoucher;
	}

	public Long getTotalFeeWithoutVoucher() {
		return this.totalFeeWithoutVoucher;
	}

	public void setRealVoucherAmount(Long realVoucherAmount) {
		this.realVoucherAmount = realVoucherAmount;
	}

	public Long getRealVoucherAmount() {
		return this.realVoucherAmount;
	}

}