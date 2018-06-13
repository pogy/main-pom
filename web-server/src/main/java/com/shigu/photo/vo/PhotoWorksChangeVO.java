package com.shigu.photo.vo;

import java.util.List;

public class PhotoWorksChangeVO {
    private String title;
    private String desc;
    private Long cate;
    private Integer price;
    private Integer saveType;
    private String cover;
    private List<String> imgs;
    private Long worksId;
    private List<Long> styleIds;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getCate() {
        return this.cate;
    }

    public void setCate(Long cate) {
        this.cate = cate;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSaveType() {
        return this.saveType;
    }

    public void setSaveType(Integer saveType) {
        this.saveType = saveType;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public List<String> getImgs() {
        return this.imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public Long getWorksId() {
        return this.worksId;
    }

    public void setWorksId(Long worksId) {
        this.worksId = worksId;
    }

    public List<Long> getStyleIds() {
        return this.styleIds;
    }

    public void setStyleIds(List<Long> styleIds) {
        this.styleIds = styleIds;
    }
}
