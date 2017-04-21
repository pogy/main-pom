package com.shigu.seller.vo;

/**
 * 类目属性格子
 * Created by zhaohongbo on 17/3/15.
 */
public class FormAttrVO {
    private String name;
    private Integer need;
    private FormItemVO formitem;

    public String getName() {
        return name + "：";
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNeed() {
        return need == 1 ? 1 : null;
    }

    public void setNeed(Integer need) {
        this.need = need;
    }

    public FormItemVO getFormitem() {
        return formitem;
    }

    public void setFormitem(FormItemVO formitem) {
        this.formitem = formitem;
    }
}
