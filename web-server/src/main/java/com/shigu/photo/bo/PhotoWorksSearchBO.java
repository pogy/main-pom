package com.shigu.photo.bo;

import com.shigu.photo.enums.WorksListSortEnum;

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
     * 作者子类型
     * 当userType=1时,1:男模,2:女模
     * 当userType=2时,1:摄影公司,2:摄影师
     */
    private Integer subUserType;

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


    public PhotoWorksBO toPhotoWorksBO(Long userId){
        if(getPage()==null){
            setPage(1);
        }
        PhotoWorksBO photoWorksBO=new PhotoWorksBO();
        photoWorksBO.setAuthorId(userId);
        photoWorksBO.setCid(getCid());
        photoWorksBO.setPage(getPage());
        photoWorksBO.setPageSize(10);
        photoWorksBO.setStyleId(getStyleId());
        photoWorksBO.setUserType(getUserType());
        if(getUserType()!=null&&getUserType()!=3){
            photoWorksBO.setSubUserType(getSubUserType());
        }
        if(getSort()!=null){
            photoWorksBO.setSort("default".equals(getSort())?WorksListSortEnum.defaults:WorksListSortEnum.create_desc);
        }else{
            photoWorksBO.setSort(WorksListSortEnum.defaults);
        }
        return photoWorksBO;
    }


}
