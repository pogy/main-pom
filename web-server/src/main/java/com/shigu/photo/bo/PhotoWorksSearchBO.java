package com.shigu.photo.bo;

import com.shigu.main4.photo.bo.PhotoWorksBO;
import com.shigu.main4.photo.enums.WorksListSortEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;

public class PhotoWorksSearchBO {
    /**
     * 排序
     */
    private String sort;
    /**
     * 风格ID
     */
    private Long sid;
    /**
     * 类目
     */
    private Long pid;
    /**
     * 作者类型
     */
    private Integer rid;
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
        photoWorksBO.setIsAuthor(false);
        photoWorksBO.setPage(getPage());
        photoWorksBO.setPageSize(20);
        photoWorksBO.setStyleId(getSid());
        photoWorksBO.setUserTypes(getRid()!=null&&getRid()==2? Arrays.asList(2,3): getRid()!=null?Collections.singletonList(getRid()):null);
        photoWorksBO.setTitle(getKeyword());
        if(getSort()!=null){
            photoWorksBO.setSort("def".equals(getSort())?WorksListSortEnum.defaults:WorksListSortEnum.create_desc);
        }else{
            photoWorksBO.setSort(WorksListSortEnum.create_desc);
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
    public Integer getRid() {
        return this.rid;
    }

    /**
     * 设置 作者类型
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * 获取 风格ID
     */
    public Long getSid() {
        return this.sid;
    }

    /**
     * 设置 风格ID
     */
    public void setSid(Long sid) {
        this.sid = sid;
    }
}
