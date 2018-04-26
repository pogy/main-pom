package com.shigu.photo.vo;

public class PhotoCateVO {
    private Long id;
    private String text;

    public PhotoCateVO(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
