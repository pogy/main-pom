package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * 分类项的值
 * Created by zhaohongbo on 17/4/4.
 */
public class CategoryValue implements Serializable, Comparable<CategoryValue>{
    private static final long serialVersionUID = -5153641291281375194L;

    private Long subId;
    /**
     * 分类名称
     */
    private String cateName;
    /**
     * 分类值
     */
    private String cateValue;

    private Integer sort;

    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateValue() {
        return cateValue;
    }

    public void setCateValue(String cateValue) {
        this.cateValue = cateValue;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public int compareTo(CategoryValue o) {
        if (this.sort == null)
            return o.getSort() == null ? 0 : -1;
        else if (o.getSort() == null)
            return 1;
        return this.sort - o.sort;
    }
}
