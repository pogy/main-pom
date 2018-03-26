package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguSiteSearchCategory implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 类目ID
     */
	private Long cid;

    /**
     * 类目名
     */
	private String cname;

    /**
     * 父类目ID
     */
	private Long parentCid;

    /**
     * 父类目名
     */
	private String parentCname;

    /**
     * 顶级类目ID
     */
	private Long topCid;

    /**
     * 样式名称
     */
	private String icon;

    /**
     * 导航栏页面 1：逛市场，2：首页
     */
	private Integer pageType;

    /**
     * 自定义类目名
     */
	private String keyword;

    /**
     * 是否热卖 1：热卖，2：非热卖
     */
	private Integer hot;

    /**
     * 是否显示  1：显示，2：不显示
     */
	private Integer display;

    /**
     * 栏目类别   1：二级类目自定义栏目，2：二级栏目非自定义栏目，3：一级类目
     */
	private Integer type;

    /**
     * 是否删除 1：正常，-1：删除
     */
	private Integer cStatus;

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

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCname() {
		return this.cname;
	}

	public void setParentCid(Long parentCid) {
		this.parentCid = parentCid;
	}

	public Long getParentCid() {
		return this.parentCid;
	}

	public void setParentCname(String parentCname) {
		this.parentCname = parentCname;
	}

	public String getParentCname() {
		return this.parentCname;
	}

	public void setTopCid(Long topCid) {
		this.topCid = topCid;
	}

	public Long getTopCid() {
		return this.topCid;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setPageType(Integer pageType) {
		this.pageType = pageType;
	}

	public Integer getPageType() {
		return this.pageType;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Integer getHot() {
		return this.hot;
	}

	public void setDisplay(Integer display) {
		this.display = display;
	}

	public Integer getDisplay() {
		return this.display;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setCStatus(Integer cStatus) {
		this.cStatus = cStatus;
	}

	public Integer getCStatus() {
		return this.cStatus;
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

}