package com.shigu.main4.item.vo;

/**
 * 属性类型
 * Created by zhaohongbo on 17/1/10.
 */
public enum PropType {
    INPUT("input"),//输入框
    CHECKBOX("checkbox"),//多选
    SELECT("select"),//选择
    MATERIAL("material");//材质成分类型

    PropType(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
