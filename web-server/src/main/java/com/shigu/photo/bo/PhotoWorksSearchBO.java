package com.shigu.photo.bo;

import com.shigu.photo.enums.WorksListSortEnum;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PhotoWorksSearchBO {
    /**
     * 排序
     */
    private String sort;
    /**
     * 风格ID
     */
    private Long styleId;
    /**
     * 类目
     */
    private Long pid;
    /**
     * 作者类型
     */
    private List<Integer> rid;
    /**
     * 页码
     */
    private Integer page;
    /**
     * 关键词
     */
    private String keyword;

    private Long id;

    /**
     * 获取 排序
     */
    public String getSort() {
        return this.sort;
    }

    /**
     * 设置 排序
     */
    public void setSort(String sort) {
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


    public PhotoWorksBO toPhotoWorksBO(){
        if(getPage()==null){
            setPage(1);
        }
        PhotoWorksBO photoWorksBO=new PhotoWorksBO();
        photoWorksBO.setUserId(getId());
        photoWorksBO.setCid(getPid());
        photoWorksBO.setPage(getPage());
        photoWorksBO.setPageSize(10);
        photoWorksBO.setStyleId(getStyleId());
        photoWorksBO.setUserTypes(getRid());
        photoWorksBO.setTitle(getKeyword());
        if(getSort()!=null){
            photoWorksBO.setSort("def".equals(getSort())?WorksListSortEnum.defaults:WorksListSortEnum.create_desc);
        }else{
            photoWorksBO.setSort(WorksListSortEnum.defaults);
        }
        return photoWorksBO;
    }

    /**
     * 获取 类目
     */
    public Long getPid() {
        return this.pid;
    }

    /**
     * 设置 类目
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }


    /**
     * 获取 关键词
     */
    public String getKeyword() {
        return this.keyword;
    }

    /**
     * 设置 关键词
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 作者类型
     */
    public List<Integer> getRid() {
        return this.rid;
    }

    /**
     * 设置 作者类型
     */
    public void setRid(List<Integer> rid) {
        this.rid = rid;
    }
}
