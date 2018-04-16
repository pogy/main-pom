package com.shigu.seller.vo;

public class Options {
    /**
     *select下的文本
     */
    private String text;
    /**
     *select下的value
     */
    private String value;
    /**
     * 是否选中 true是 false否
     */
    private Boolean selected;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
