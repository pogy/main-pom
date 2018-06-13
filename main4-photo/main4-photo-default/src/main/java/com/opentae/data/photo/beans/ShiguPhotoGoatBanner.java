package com.opentae.data.photo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguPhotoGoatBanner implements Serializable {
    /**
     * 广告ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long goatId;

    /**
     * 轮播图
     */
	private String banner;

    /**
     * 绑定url
     */
	private String url;

    /**
     * 位置编号
     */
	private Integer place;

	public void setGoatId(Long goatId) {
		this.goatId = goatId;
	}

	public Long getGoatId() {
		return this.goatId;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getBanner() {
		return this.banner;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public void setPlace(Integer place) {
		this.place = place;
	}

	public Integer getPlace() {
		return this.place;
	}

}