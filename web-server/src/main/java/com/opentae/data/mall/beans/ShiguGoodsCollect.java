package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguGoodsCollect implements Serializable {
    /**
     * 商品收藏ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long goodsCollectId;

    /**
     * 类别，1加数据包，2普通收藏
     */
	private Integer type;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 商品ID
     */
	private Long goodsId;

    /**
     * 状态@0删除1有效
     */
	private Integer useStatus;

    /**
     * 店铺ID
     */
	private Long storeId;

    /**
     * 站点
     */
	private String website;

    /**
     * 排序
     */
	private Integer sortOrder;

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

    /**
     * 备用16
     */
	private String remark16;

    /**
     * 备用17
     */
	private String remark17;

    /**
     * 备用18
     */
	private String remark18;

    /**
     * 备用19
     */
	private String remark19;

    /**
     * 备用20
     */
	private String remark20;

    /**
     * 
     */
	private Date lastTime;

	public void setGoodsCollectId(Long goodsCollectId) {
		this.goodsCollectId = goodsCollectId;
	}

	public Long getGoodsCollectId() {
		return this.goodsCollectId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}

	public Integer getUseStatus() {
		return this.useStatus;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getStoreId() {
		return this.storeId;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getSortOrder() {
		return this.sortOrder;
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

	public void setRemark16(String remark16) {
		this.remark16 = remark16;
	}

	public String getRemark16() {
		return this.remark16;
	}

	public void setRemark17(String remark17) {
		this.remark17 = remark17;
	}

	public String getRemark17() {
		return this.remark17;
	}

	public void setRemark18(String remark18) {
		this.remark18 = remark18;
	}

	public String getRemark18() {
		return this.remark18;
	}

	public void setRemark19(String remark19) {
		this.remark19 = remark19;
	}

	public String getRemark19() {
		return this.remark19;
	}

	public void setRemark20(String remark20) {
		this.remark20 = remark20;
	}

	public String getRemark20() {
		return this.remark20;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Date getLastTime() {
		return this.lastTime;
	}

}