package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguMarketActivitys implements Serializable {
    /**
     * 市场活动id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long maId;

    /**
     * 活动名
     */
	private String maName;

    /**
     * 活动banner图
     */
	private String maPic;

    /**
     * 活动状态1：正常 -1：删除
     */
	private Integer maStatus;

    /**
     * 背景颜色
     */
	private String maBackground;

	public void setMaId(Long maId) {
		this.maId = maId;
	}

	public Long getMaId() {
		return this.maId;
	}

	public void setMaName(String maName) {
		this.maName = maName;
	}

	public String getMaName() {
		return this.maName;
	}

	public void setMaPic(String maPic) {
		this.maPic = maPic;
	}

	public String getMaPic() {
		return this.maPic;
	}

	public void setMaStatus(Integer maStatus) {
		this.maStatus = maStatus;
	}

	public Integer getMaStatus() {
		return this.maStatus;
	}

	public void setMaBackground(String maBackground) {
		this.maBackground = maBackground;
	}

	public String getMaBackground() {
		return this.maBackground;
	}

}