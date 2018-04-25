package com.shigu.photo.bo;

import com.shigu.photo.enums.WorksListSortEnum;

import java.io.Serializable;

/**
 * 作品列表BO
 */
public class PhotoWorksBO implements Serializable{
    /**
     * 排序
     */
    private WorksListSortEnum sort;
    /**
     * 作者ID
     */
    private Long authorId;
    /**
     * 风格ID
     */
    private Long styleId;
    /**
     * 类目
     */
    private Long cid;
    /**
     * 作者类型
     */
    private Integer userType;
    /**
     * 页码
     */
    private Integer page;

    /**
     * 获取 排序
     */
    public WorksListSortEnum getSort() {
        return this.sort;
    }

    /**
     * 设置 排序
     */
    public void setSort(WorksListSortEnum sort) {
        this.sort = sort;
    }

    /**
     * 获取 风格ID
     */
    public Long getStyleId() {
        return this.styleId;
    }

    /**
     * 设置 风格ID
     */
    public void setStyleId(Long styleId) {
        this.styleId = styleId;
    }

    /**
     * 获取 类目
     */
    public Long getCid() {
        return this.cid;
    }

    /**
     * 设置 类目
     */
    public void setCid(Long cid) {
        this.cid = cid;
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

    /**
     * 获取 页码
     */
    public Integer getPage() {
        return this.page;
    }

    /**
     * 设置 页码
     */
    public void setPage(Integer page) {
        this.page = page;
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
}
