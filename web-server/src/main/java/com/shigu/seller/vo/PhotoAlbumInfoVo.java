package com.shigu.seller.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.vo
 * @ClassName: PhotoAlbumInfoVo
 * @Author: sy
 * @CreateDate: 2018/5/7 0007 18:32
 */
public class PhotoAlbumInfoVo implements Serializable{

    private String title;
    private String desc;
    private Long picCount;
    private List<PicVo> pics;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getPicCount() {
        return picCount;
    }

    public void setPicCount(Long picCount) {
        this.picCount = picCount;
    }

    public List<PicVo> getPics() {
        return pics;
    }

    public void setPics(List<PicVo> pics) {
        this.pics = pics;
    }
}
