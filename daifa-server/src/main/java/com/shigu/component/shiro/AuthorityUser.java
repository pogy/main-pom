package com.shigu.component.shiro;

import java.io.Serializable;

/**
 * 会话对象
 * @author zjb
 */
public class AuthorityUser implements Serializable{

	private static final long serialVersionUID = -4180134907607936704L;
	/**
	 * 用户数字编号ID
	 */
	private Long userId;
	/** 用户id */
	private String adminId;

	/** 用户名 */
	private String userName;

	/**
	 * 用户昵称
	 */
	private String nick;
	
	/** 角色ids */
	private String roleIds;
	
	/** 角色名称s */
	private String roleNames;

	private Long daifaWorkerId;//具体代发用户ID
	private Long daifaSellerId;//代发ID
	private String daifaUserName;//代发用户
	private Integer workType;//代发类型
	private String payBaoAccount;//代发拿货人的淘宝用户账户
	private String daifaLoginName;//代发登录名
	private String daifaPhone;//代发登录人的手机号
	private String sellerPhone;//代发手机号
	private String webSite;//站点
	private Long dfGroupId;//
	private Long accountId;//支付账户ID
	private Long buycityId;
	

	public Long getBuycityId() {
		return buycityId;
	}

	public void setBuycityId(Long buycityId) {
		this.buycityId = buycityId;
	}

	public String getWebSite () {
		return webSite;
	}

	public void setWebSite (String webSite) {
		this.webSite = webSite;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return  nick;
	}

	public Long getDaifaWorkerId () {
		return daifaWorkerId;
	}

	public void setDaifaWorkerId (Long daifaWorkerId) {
		this.daifaWorkerId = daifaWorkerId;
	}

	public Long getDaifaSellerId () {
		return daifaSellerId;
	}

	public String getDaifaUserName () {
		return daifaUserName;
	}

	public Integer getWorkType () {
		return workType;
	}

	public String getPayBaoAccount () {
		return payBaoAccount;
	}



	public void setDaifaSellerId (Long daifaSellerId) {
		this.daifaSellerId = daifaSellerId;
	}

	public void setDaifaUserName (String daifaUserName) {
		this.daifaUserName = daifaUserName;
	}

	public void setWorkType (Integer workType) {
		this.workType = workType;
	}

	public void setPayBaoAccount (String payBaoAccount) {
		this.payBaoAccount = payBaoAccount;
	}

	public String getDaifaLoginName () {
		return daifaLoginName;
	}

	public void setDaifaLoginName (String daifaLoginName) {
		this.daifaLoginName = daifaLoginName;
	}

	public String getDaifaPhone () {
		return daifaPhone;
	}

	public void setDaifaPhone (String daifaPhone) {
		this.daifaPhone = daifaPhone;
	}

	public String getSellerPhone() {
		return sellerPhone;
	}

	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public Long getDfGroupId () {
		return dfGroupId;
	}

	public Long getAccountId () {
		return accountId;
	}

	public void setDfGroupId (Long dfGroupId) {
		this.dfGroupId = dfGroupId;
	}

	public void setAccountId (Long accountId) {
		this.accountId = accountId;
	}
}
