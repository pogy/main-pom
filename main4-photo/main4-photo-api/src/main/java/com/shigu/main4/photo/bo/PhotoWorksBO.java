package com.shigu.main4.photo.bo;

import com.shigu.main4.photo.enums.WorksListSortEnum;

import java.io.Serializable;
import java.util.List;

/**
 * 作品列表BO
 */
public class PhotoWorksBO implements Serializable{
    /**
     * 排序
     */
    private WorksListSortEnum sort;
    /**
     * 用户ID
     */
    private Long userId;
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
    private List<Integer> userTypes;
    /**
     * 性别1:男,2:女
     */
    private Integer sex;
    /**
     * 页码
     */
    private Integer page;
    /**
     * 页长
     */
    private Integer pageSize;
    /**
     * 标题
     */
    private String title;
    /**
     * 是否是作者发起的请求
     */
    private Boolean isAuthor;

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
    public List<Integer> getUserTypes() {
        return this.userTypes;
    }

    /**
     * 设置 作者类型
     */
    public void setUserTypes(List<Integer> userTypes) {
        this.userTypes = userTypes;
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
     * 获取 页长
     */
    public Integer getPageSize() {
        return this.pageSize;
    }

    /**
     * 设置 页长
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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
     * 获取 性别1:男,2:女
     */
    public Integer getSex() {
        return this.sex;
    }

    /**
     * 设置 性别1:男,2:女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取 用户ID
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * 设置 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 是否是作者发起的请求
     */
    public Boolean getIsAuthor() {
        return this.isAuthor;
    }

    /**
     * 设置 是否是作者发起的请求
     */
    public void setIsAuthor(Boolean isAuthor) {
        this.isAuthor = isAuthor;
    }
}
