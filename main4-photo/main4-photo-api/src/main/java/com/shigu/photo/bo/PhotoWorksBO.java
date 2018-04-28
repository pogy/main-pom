package com.shigu.photo.bo;

import com.shigu.photo.enums.WorksListSortEnum;

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
}
