package com.shigu.photo.bo;

import com.shigu.photo.enums.WorksListSortEnum;
import org.springframework.web.bind.annotation.RequestParam;

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
    private Long styleId;
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
     * 作者子类型
     * 当userType=1时,1:男模,2:女模
     * 当userType=2时,1:摄影公司,2:摄影师
     */
    private Integer subUserType;
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
    /**
     * 作者子类型
     * 当userType=1时,1:男模,2:女模
     * 当userType=2时,1:摄影公司,2:摄影师
     */
    public Integer getSubUserType() {
        return this.subUserType;
    }

    /**
     * 作者子类型
     * 当userType=1时,1:男模,2:女模
     * 当userType=2时,1:摄影公司,2:摄影师
     */
    public void setSubUserType(Integer subUserType) {
        this.subUserType = subUserType;
    }


    public PhotoWorksBO toPhotoWorksBO(){
        if(getPage()==null){
            setPage(1);
        }
        PhotoWorksBO photoWorksBO=new PhotoWorksBO();
        photoWorksBO.setAuthorId(getId());
        photoWorksBO.setCid(getPid());
        photoWorksBO.setPage(getPage());
        photoWorksBO.setPageSize(10);
        photoWorksBO.setStyleId(getStyleId());
        photoWorksBO.setUserType(getRid());
        photoWorksBO.setTitle(getKeyword());
        if(getRid()!=null&&getRid()!=3){
            photoWorksBO.setSubUserType(getSubUserType());
        }
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
}
