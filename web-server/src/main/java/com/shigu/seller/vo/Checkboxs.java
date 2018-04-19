package com.shigu.seller.vo;

public class Checkboxs {
    /**
     * checkbox下的文本
     */
    private String text;
    /**
     * checkbox下的value
     */
    private String value;
    /**
     * checkbox下的上传key值
     */
    private String name;
    /**
     * 是否选中 true是 false否
     */
    private Boolean checked;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
