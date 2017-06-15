package com.shigu.activity.vo;

import java.util.List;

/**
 * 文本导航
 * Created by bugzy on 2017/5/18 0018.
 */
public class TextCateNav {
    private List<StyleNavVo> cates;
    private List<StyleNavVo> markets;
    private List<StyleNavVo> styles;

    public List<StyleNavVo> getCates() {
        return cates;
    }

    public void setCates(List<StyleNavVo> cates) {
        this.cates = cates;
    }

    public List<StyleNavVo> getMarkets() {
        return markets;
    }

    public void setMarkets(List<StyleNavVo> markets) {
        this.markets = markets;
    }

    public List<StyleNavVo> getStyles() {
        return styles;
    }

    public void setStyles(List<StyleNavVo> styles) {
        this.styles = styles;
    }
}
