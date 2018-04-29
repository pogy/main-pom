package com.shigu.main4.photo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 作品列表
 */
public class PhotoWorksVO implements Serializable{

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
     * 作者ID
     */
    private Long authorId;
    /**
     * 作者
     */
    private String authorName;
    /**
     * 作者常用地址
     */
    private String address;
    /**
     * 上传时间
     */
    private Date createTime;
    /**
     * 点赞数
     */
    private Integer praiseNum;
    /**
     * 作者类型
     */
    private Integer userType;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 描述
     */
    private String content;

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
     * 获取 作者ID
     */
    public Long getAuthorId() {
        return this.authorId;
    }

    /**
     * 设置 作者ID
     */
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    /**
     * 获取 作者
     */
    public String getAuthorName() {
        return this.authorName;
    }

    /**
     * 设置 作者
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * 获取 作者常用地址
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * 设置 作者常用地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取 上传时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 上传时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 点赞数
     */
    public Integer getPraiseNum() {
        return this.praiseNum;
    }

    /**
     * 设置 点赞数
     */
    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Long getWorksId() {
        return this.worksId;
    }

    public void setWorksId(Long worksId) {
        this.worksId = worksId;
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
     * 获取 作者类型
     */
    public Integer getUserType() {
        return this.userType;
    }

    /**
     * 设置 作者类型
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
