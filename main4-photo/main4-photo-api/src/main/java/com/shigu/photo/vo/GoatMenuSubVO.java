package com.shigu.photo.vo;

import java.io.Serializable;

public class GoatMenuSubVO implements Serializable{
    private Long id;
    private String text;

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

    public GoatMenuSubVO(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public GoatMenuSubVO() {
    }
}
