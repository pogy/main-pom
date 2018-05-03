package com.shigu.photo.vo;

public class PhotoCateVO {
    private String id;
    private String text;
    private Boolean checkedIs;

    public PhotoCateVO(String id, String text) {
        this.id = id;
        this.text = text;
    }
    public PhotoCateVO(String id, String text,Boolean checkedIs) {
        this.id = id;
        this.text = text;
        this.checkedIs=checkedIs;
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

    public Boolean getCheckedIs() {
        return this.checkedIs;
    }

    public void setCheckedIs(Boolean checkedIs) {
        this.checkedIs = checkedIs;
    }
}
