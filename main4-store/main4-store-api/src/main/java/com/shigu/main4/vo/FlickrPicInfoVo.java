package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.vo
 * @ClassName: FlickrPicInfoVo
 * @Author: sy
 * @CreateDate: 2018/5/9 0009 14:33
 */
public class FlickrPicInfoVo implements Serializable{

    private String title;
    private String cover;
    private Integer picCount;
    private List<FlickrPictureVo> goodsPics;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getPicCount() {
        return picCount;
    }

    public void setPicCount(Integer picCount) {
        this.picCount = picCount;
    }

    public List<FlickrPictureVo> getGoodsPics() {
        return goodsPics;
    }

    public void setGoodsPics(List<FlickrPictureVo> goodsPics) {
        this.goodsPics = goodsPics;
    }
}
