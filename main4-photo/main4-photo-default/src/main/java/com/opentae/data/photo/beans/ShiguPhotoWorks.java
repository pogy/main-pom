package com.opentae.data.photo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguPhotoWorks implements Serializable {
    /**
     * 作品ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long worksId;

    /**
     * 标题
     */
	private String title;

    /**
     * 作者ID
     */
	private Long authorId;

    /**
     * 
     */
	private Date createTime;

    /**
     * 
     */
	private Date lastModifyTme;

    /**
     * 作品类目
     */
	private Long worksCid;

    /**
     * 
     */
	private Boolean havePrice;

    /**
     * 自定义价格
     */
	private Long price;

    /**
     * 
     */
	private Boolean forbidSave;

    /**
     * 封面图
     */
	private String picUrl;

    /**
     * 
     */
	private String images;

    /**
     * 
     */
	private Boolean removeIs;

    /**
     * 点击量
     */
	private Long clicks;

    /**
     * 描述
     */
	private String content;

    /**
     * 
     */
	private Integer searchOpen;

	public void setWorksId(Long worksId) {
		this.worksId = worksId;
	}

	public Long getWorksId() {
		return this.worksId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getAuthorId() {
		return this.authorId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setLastModifyTme(Date lastModifyTme) {
		this.lastModifyTme = lastModifyTme;
	}

	public Date getLastModifyTme() {
		return this.lastModifyTme;
	}

	public void setWorksCid(Long worksCid) {
		this.worksCid = worksCid;
	}

	public Long getWorksCid() {
		return this.worksCid;
	}

	public void setHavePrice(Boolean havePrice) {
		this.havePrice = havePrice;
	}

	public Boolean getHavePrice() {
		return this.havePrice;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setForbidSave(Boolean forbidSave) {
		this.forbidSave = forbidSave;
	}

	public Boolean getForbidSave() {
		return this.forbidSave;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getImages() {
		return this.images;
	}

	public void setRemoveIs(Boolean removeIs) {
		this.removeIs = removeIs;
	}

	public Boolean getRemoveIs() {
		return this.removeIs;
	}

	public void setClicks(Long clicks) {
		this.clicks = clicks;
	}

	public Long getClicks() {
		return this.clicks;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setSearchOpen(Integer searchOpen) {
		this.searchOpen = searchOpen;
	}

	public Integer getSearchOpen() {
		return this.searchOpen;
	}

}