package com.shigu.main4.cdn.vo;

import java.util.List;

public class SkuMetaVO {
    private String text;
    private String imgSrc;
    private List<SkuSizeMetaVO> sizes;

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgSrc() {
        return this.imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public List<SkuSizeMetaVO> getSizes() {
        return this.sizes;
    }

    public void setSizes(List<SkuSizeMetaVO> sizes) {
        this.sizes = sizes;
    }
}
