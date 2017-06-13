package com.shigu.activity.vo;

import java.util.List;

/**
 * 风格
 * Created by bugzy on 2017/5/18 0018.
 */
public class PicCateNav {
    private List<PicCatVo> picCates;
    private List<StyleNavVo> textCates;

    public List<PicCatVo> getPicCates() {
        return picCates;
    }

    public void setPicCates(List<PicCatVo> picCates) {
        this.picCates = picCates;
    }

    public List<StyleNavVo> getTextCates() {
        return textCates;
    }

    public void setTextCates(List<StyleNavVo> textCates) {
        this.textCates = textCates;
    }
}
