package com.shigu.main4.photo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 作品列表
 */
public class PhotoWorksUpdateVO implements Serializable{

    private Long worksId;
    /**
     * 封面图
     */
    private String picUrl;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String content;
    /**
     * 类目
     */
    private Long worksCid;
    /**
     * 0:私聊,1:定价
     */
    private Boolean havePrice;
    /**
     * 0:可保存,1:禁止保存
     */
    private Boolean forbidSave;

    private String images;

    public Long getWorksId() {
        return this.worksId;
    }

    public void setWorksId(Long worksId) {
        this.worksId = worksId;
    }

    /**
     * 获取 封面图
     */
    public String getPicUrl() {
        return this.picUrl;
    }

    /**
     * 设置 封面图
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 获取 标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取 描述
     */
    public String getContent() {
        return this.content;
    }

    /**
     * 设置 描述
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取 类目
     */
    public Long getWorksCid() {
        return this.worksCid;
    }

    /**
     * 设置 类目
     */
    public void setWorksCid(Long worksCid) {
        this.worksCid = worksCid;
    }

    /**
     * 获取 0:私聊,1:定价
     */
    public Boolean getHavePrice() {
        return this.havePrice;
    }

    /**
     * 设置 0:私聊,1:定价
     */
    public void setHavePrice(Boolean havePrice) {
        this.havePrice = havePrice;
    }

    /**
     * 获取 0:可保存,1:禁止保存
     */
    public Boolean getForbidSave() {
        return this.forbidSave;
    }

    /**
     * 设置 0:可保存,1:禁止保存
     */
    public void setForbidSave(Boolean forbidSave) {
        this.forbidSave = forbidSave;
    }

    public String getImages() {
        return this.images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
