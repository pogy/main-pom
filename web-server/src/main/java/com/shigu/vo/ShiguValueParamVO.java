package com.shigu.vo;

import java.io.Serializable;

/**
 * 页面表单项对象
 * Created by zhaohongbo on 17/3/13.
 */
public class ShiguValueParamVO implements Serializable{
    /** 标签名称 */
    private String label;

    /** 名称 */
    private String name;

    /** 是否只读 */
    private Boolean readonly;

    /** 值 */
    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getReadonly() {
        return readonly;
    }

    public void setReadonly(Boolean readonly) {
        this.readonly = readonly;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
