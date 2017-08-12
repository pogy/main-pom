package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguTaobaocat implements Serializable {
    /**
     * 类目ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
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
     * 父类目
     */
	private String parentCname;

    /**
     * 是否是顶级类目
     */
	private Integer isParent;

    /**
     * 示显排序
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
     * 备用5
     */
	private String remark5;

    /**
     * 备用6
     */
	private String remark6;

    /**
     * 备用7
     */
	private String remark7;

    /**
     * 备用8
     */
	private String remark8;

    /**
     * 备用9
     */
	private String remark9;

    /**
     * 备用10
     */
	private String remark10;

    /**
     * 备用11
     */
	private String remark11;

    /**
     * 备用12
     */
	private String remark12;

    /**
     * 备用13
     */
	private String remark13;

    /**
     * 备用14
     */
	private String remark14;

    /**
     * 备用15
     */
	private String remark15;

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

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

	public Integer getIsParent() {
		return this.isParent;
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

	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}

	public String getRemark6() {
		return this.remark6;
	}

	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}

	public String getRemark7() {
		return this.remark7;
	}

	public void setRemark8(String remark8) {
		this.remark8 = remark8;
	}

	public String getRemark8() {
		return this.remark8;
	}

	public void setRemark9(String remark9) {
		this.remark9 = remark9;
	}

	public String getRemark9() {
		return this.remark9;
	}

	public void setRemark10(String remark10) {
		this.remark10 = remark10;
	}

	public String getRemark10() {
		return this.remark10;
	}

	public void setRemark11(String remark11) {
		this.remark11 = remark11;
	}

	public String getRemark11() {
		return this.remark11;
	}

	public void setRemark12(String remark12) {
		this.remark12 = remark12;
	}

	public String getRemark12() {
		return this.remark12;
	}

	public void setRemark13(String remark13) {
		this.remark13 = remark13;
	}

	public String getRemark13() {
		return this.remark13;
	}

	public void setRemark14(String remark14) {
		this.remark14 = remark14;
	}

	public String getRemark14() {
		return this.remark14;
	}

	public void setRemark15(String remark15) {
		this.remark15 = remark15;
	}

	public String getRemark15() {
		return this.remark15;
	}

}