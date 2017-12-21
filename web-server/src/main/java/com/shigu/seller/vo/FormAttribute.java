package com.shigu.seller.vo;

public class FormAttribute {

    /**
     * 是否为必须填写属性
     */
    private String need;
    /**
     * label名
     */
    private String name;
    /**
     * 类型数据
     */
    private Formitem formitem;

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Formitem getFormitem() {
        return formitem;
    }

    public void setFormitem(Formitem formitem) {
        this.formitem = formitem;
    }
}
