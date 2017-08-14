package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 中奖纪录
 *
 * @author shigu_zjb
 * @date 2017/05/12 18:34
 *
 *
 */
public class ActiveDrawRecord {

	public final static int DRAW_STATUS_WAIT = 1;// 等待中奖
	public final static int DRAW_STATUS_NO = 2;// 未中奖
	public final static int DRAW_STATUS_YES = 3;// 中奖

	/** 中奖ID */
	@Id
	@GeneratedValue(
			generator = "JDBC"
	)
	private Long id;

	/** 用户ID */
	private Long userId;

	/** 奖项 */
	private String ward;

	/** 期次 */
	private Long pemId;

	/** 是否领取 */
	private Boolean receivesYes;

	/** 中奖码 */
	private String drawCode;

	/** 中奖状态 */
	private Integer drawStatus;

	/** 创建时间 */
	private Date createTime;

	/** 更新时间 */
	private Date modifyTime;

	/** 查阅时间 */
	private Date refeTime;

	/** 数据有效性 */
	private Boolean enabled;

	@Transient
	private String userNick;

	@Transient
	private String loginPhone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public Long getPemId() {
		return pemId;
	}

	public void setPemId(Long pemId) {
		this.pemId = pemId;
	}

	public Boolean getReceivesYes() {
		return receivesYes;
	}

	public void setReceivesYes(Boolean receivesYes) {
		this.receivesYes = receivesYes;
	}

	public String getDrawCode() {
		return drawCode;
	}

	public void setDrawCode(String drawCode) {
		this.drawCode = drawCode;
	}

	public Integer getDrawStatus() {
		return drawStatus;
	}

	public void setDrawStatus(Integer drawStatus) {
		this.drawStatus = drawStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getLoginPhone() {
		return loginPhone;
	}

	public void setLoginPhone(String loginPhone) {
		this.loginPhone = loginPhone;
	}

	public Date getRefeTime() {
		return refeTime;
	}

	public void setRefeTime(Date refeTime) {
		this.refeTime = refeTime;
	}
}