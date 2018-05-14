package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.vo
 * @ClassName: FlickrPictureVo
 * @Author: sy
 * @CreateDate: 2018/5/1 0001 13:39
 */
public class FlickrPictureVo implements Serializable {

    private Long goodsPicId;
    private String imgSrc;
    private String created;

    public Long getGoodsPicId() {
        return goodsPicId;
    }

    public void setGoodsPicId(Long goodsPicId) {
        this.goodsPicId = goodsPicId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
