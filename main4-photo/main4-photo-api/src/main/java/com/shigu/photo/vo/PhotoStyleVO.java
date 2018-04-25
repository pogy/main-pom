package com.shigu.photo.vo;

import java.io.Serializable;

public class PhotoStyleVO implements Serializable {

    private Long styleId;
    private String styleName;

    public Long getStyleId() {
        return this.styleId;
    }

    public void setStyleId(Long styleId) {
        this.styleId = styleId;
    }

    public String getStyleName() {
        return this.styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }
}
