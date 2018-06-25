package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class ShiguShopApply implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long ruzhuId;

    /**
     * 星座网用户ID
     */
	private Long userId;

    /**
     * 主营类目
     */
	private String mainBus;

    /**
     * 档口号
     */
	private String shopNum;

    /**
     * 1表示可审核，0表示信息不齐不可审核，2表示审核完毕，不能再审核
     */
	private Integer canExamine;

    /**
     * 联系电话
     */
	private String telephone;

    /**
     * 微信号
     */
	private String imWx;

    /**
     * QQ号
     */
	private String imQq;

    /**
     * 邮箱
     */
	private String email;

    /**
     * 分站标识
     */
	private String webSite;

    /**
     * 市场ID
     */
	private Long marketId;

    /**
     * 楼层ID
     */
	private Long floorId;

    /**
     * 退换服务标签
     */
	private String tags;

    /**
     * 申请者IP
     */
	private String ip;

    /**
     * 申请时间
     */
	private Date applyTime;

    /**
     * 淘宝店铺ID
     */
	private String tbshopId;

    /**
     * 淘宝用户ID
     */
	private String tbuserId;

    /**
     * 淘宝昵称
     */
	private String tbNick;

    /**
     * 淘宝店链接
     */
	private String tbUrl;

    /**
     * 阿里旺旺
     */
	private String imAliww;

    /**
     * 0表示未处理，1表示审核通过，2表示拒绝
     */
	private Integer applyStatus;

    /**
     * 拒绝理由
     */
	private String refuseReason;

	public void setRuzhuId(Long ruzhuId) {
		this.ruzhuId = ruzhuId;
	}

	public Long getRuzhuId() {
		return this.ruzhuId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setMainBus(String mainBus) {
		this.mainBus = mainBus;
	}

	public String getMainBus() {
		return this.mainBus;
	}

	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
	}

	public String getShopNum() {
		return this.shopNum;
	}

	public void setCanExamine(Integer canExamine) {
		this.canExamine = canExamine;
	}

	public Integer getCanExamine() {
		return this.canExamine;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setImWx(String imWx) {
		this.imWx = imWx;
	}

	public String getImWx() {
		return this.imWx;
	}

	public void setImQq(String imQq) {
		this.imQq = imQq;
	}

	public String getImQq() {
		return this.imQq;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Long getMarketId() {
		return this.marketId;
	}

	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}

	public Long getFloorId() {
		return this.floorId;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTags() {
		return this.tags;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setTbshopId(String tbshopId) {
		this.tbshopId = tbshopId;
	}

	public String getTbshopId() {
		return this.tbshopId;
	}

	public void setTbuserId(String tbuserId) {
		this.tbuserId = tbuserId;
	}

	public String getTbuserId() {
		return this.tbuserId;
	}

	public void setTbNick(String tbNick) {
		this.tbNick = tbNick;
	}

	public String getTbNick() {
		return this.tbNick;
	}

	public void setTbUrl(String tbUrl) {
		this.tbUrl = tbUrl;
	}

	public String getTbUrl() {
		return this.tbUrl;
	}

	public void setImAliww(String imAliww) {
		this.imAliww = imAliww;
	}

	public String getImAliww() {
		return this.imAliww;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Integer getApplyStatus() {
		return this.applyStatus;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

	public String getRefuseReason() {
		return this.refuseReason;
	}

}