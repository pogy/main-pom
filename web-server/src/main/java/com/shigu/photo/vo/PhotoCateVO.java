package com.shigu.photo.vo;

public class PhotoCateVO {
    private String id;
    private String text;

    public PhotoCateVO(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
