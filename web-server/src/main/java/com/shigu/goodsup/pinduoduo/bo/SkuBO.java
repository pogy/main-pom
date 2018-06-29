package com.shigu.goodsup.pinduoduo.bo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gtx on 2018/6/27.
 *
 * @author gtx
 * @since
 */
public class SkuBO implements Serializable {
    /**
     * 颜色spcid
     */
    private Long vid;
    /**
     * 颜色名
     */
    private String name;
    /**
     * 色图
     */
    private String imgSrc;
    /**
     * 尺码sku
     */
    List<SizeBO> sizes;

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public List<SizeBO> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizeBO> sizes) {
        this.sizes = sizes;
    }
}
