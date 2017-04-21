package com.shigu.seller.vo;

import java.util.List;

/**
 * Created by wxc on 2016/12/27.
 *
 * @author wxc
 * @version main-site3.2 3.0.0
 * @since main-site3.2 3.0.0
 */
public class SKUVO {
    private String name;
    private String type;
    private List<SKUAttrVO> formitems;

    public String getName() {
        return name + "：";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<SKUAttrVO> getFormitems() {
        return formitems;
    }

    public void setFormitems(List<SKUAttrVO> formitems) {
        this.formitems = formitems;
    }
}
