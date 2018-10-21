package com.shigu.goodsup.shopee.vo;

public class CategoryVO {
    private Long cid;
    private String text;
    private Boolean hasChild;

    public Long getCid() {
        return this.cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getHasChild() {
        return this.hasChild;
    }

    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }
}
