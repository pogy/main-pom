package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.vo
 * @ClassName: FlickrDetailsVo
 * @Author: sy
 * @CreateDate: 2018/5/1 0001 16:25
 */
public class FlickrDetailsVo implements Serializable{

    private Long fId;
    private String name;
    private String desc;
    private Long number;
    private Long storeId;
    private List<PicturesVo> pictures;

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public List<PicturesVo> getPictures() {
        return pictures;
    }

    public void setPictures(List<PicturesVo> pictures) {
        this.pictures = pictures;
    }

}
