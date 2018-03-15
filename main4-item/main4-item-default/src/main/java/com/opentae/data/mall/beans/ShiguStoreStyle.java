package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguStoreStyle implements Serializable {
    /**
     * 风格ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long styleId;

    /**
     * 风格名
     */
	private String styleName;

    /**
     * 风格类型@0为男1为女2通用3固定风格4自定义
     */
	private Integer styleType;

    /**
     * 站点@如果不写就是全网能用，写了就是单独站点用
     */
	private String webSite;

    /**
     * 备注
     */
	private String remark;

    /**
     * 店主用户ID@说明这个风格是这个店主加的
     */
	private Long userId;

    /**
     * 备用1
     */
	private String remark1;

    /**
     * 备用2
     */
	private String remark2;

    /**
     * 备用3
     */
	private String remark3;

    /**
     * 备用4
     */
	private String remark4;

    /**
     * 备用4
     */
	private String remark5;

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

	public Long getStyleId() {
		return this.styleId;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public String getStyleName() {
		return this.styleName;
	}

	public void setStyleType(Integer styleType) {
		this.styleType = styleType;
	}

	public Integer getStyleType() {
		return this.styleType;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
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