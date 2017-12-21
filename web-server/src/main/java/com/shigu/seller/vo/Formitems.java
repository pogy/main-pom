package com.shigu.seller.vo;

public class Formitems {
    /**
     *skuId
     */
    private String key_;
    /**
     *sku值
     */
    private String key;
    /**
     *表单名
     */
    private String checkboxName;
    /**
     *颜色
     */
    private String color;
    /**
     *中文颜色名
     */
    private String cnname;
    /**
     *重命名
     */
    private String inputName;
    /**
     *是否选中
     */
    private Boolean checked;

    public String getKey_() {
        return key_;
    }

    public void setKey_(String key_) {
        this.key_ = key_;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCheckboxName() {
        return checkboxName;
    }

    public void setCheckboxName(String checkboxName) {
        this.checkboxName = checkboxName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
