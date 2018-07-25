package com.shigu.main4.item.vo;

import java.io.Serializable;

public class CatColorSizeVO implements Serializable {
    private Long colorPid;
    private Long sizePid;

    public Long getColorPid() {
        return this.colorPid;
    }

    public void setColorPid(Long colorPid) {
        this.colorPid = colorPid;
    }

    public Long getSizePid() {
        return this.sizePid;
    }

    public void setSizePid(Long sizePid) {
        this.sizePid = sizePid;
    }
}
