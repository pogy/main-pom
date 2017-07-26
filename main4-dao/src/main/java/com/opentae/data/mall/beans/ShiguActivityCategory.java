package com.opentae.data.mall.beans;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/12.
 */
public class ShiguActivityCategory implements Serializable {
    private Long cateId;
    private String title;
    private Long activeId;
    private String titleImg;

    public Long getCateId() {
        return cateId;
    }

    public void setCateId( Long cateId ) {
        this.cateId = cateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public Long getActiveId() {
        return activeId;
    }

    public void setActiveId( Long activeId ) {
        this.activeId = activeId;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg( String titleImg ) {
        this.titleImg = titleImg;
    }
}
