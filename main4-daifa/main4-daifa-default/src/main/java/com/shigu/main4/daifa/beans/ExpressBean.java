package com.shigu.main4.daifa.beans;

public class ExpressBean {
	private String kdType;//快递简称
	private String kdSite;//快递网点名
	private String kdName;//电子面单账户名
	private String kdPassword;//电子面单账户密码
	private String kdMonth;//电子面单账户秘钥,和电子面单账户密码至少有一个,具体是哪个,参照文档
	public String getKdMonth() {
		return kdMonth;
	}
	public void setKdMonth(String kdMonth) {
		this.kdMonth = kdMonth;
	}
	public String getKdType() {
		return kdType;
	}
	public void setKdType(String kdType) {
		this.kdType = kdType;
	}
	public String getKdSite() {
		return kdSite;
	}
	public void setKdSite(String kdSite) {
		this.kdSite = kdSite;
	}
	public String getKdName() {
		return kdName;
	}
	public void setKdName(String kdName) {
		this.kdName = kdName;
	}
	public String getKdPassword() {
		return kdPassword;
	}
	public void setKdPassword(String kdPassword) {
		this.kdPassword = kdPassword;
	}
}