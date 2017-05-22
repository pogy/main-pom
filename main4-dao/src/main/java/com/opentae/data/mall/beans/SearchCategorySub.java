package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wxc on 2017/4/4.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class SearchCategorySub implements Serializable {

    private static final long serialVersionUID = -358644895233689160L;
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long subId;

    /**
     * '上级类目值',
     */
    private String parentCateValue;

    /**
     *  DEFAULT '0' COMMENT '种类，1、淘宝类目，2、市场，3、风格，4、元素',
     */
    private Integer type;

    /**
     * 分类名称'
     */
    private String cateName;
    /**
     * '分类值',
     */
    private String cateValue;

    private Integer sort;

    private String webSite;

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public String getParentCateValue() {
        return parentCateValue;
    }

    public void setParentCateValue(String parentCateValue) {
        this.parentCateValue = parentCateValue;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}