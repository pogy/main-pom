package com.openJar.responses.api;

import com.openJar.responses.Response;
import java.io.Serializable;
import java.util.Date;

/**
 * Created By admin on 2017/12/27/17:33
 */
public class JdImgzoneCategoryResponse extends Response {

    /**
     * 分类ID
     */
    private Long cateId;
    /**
     * 分类名称
     */
    private String cateName;
    /**
     * 分类层级，默认分类为0，父分类为1，子分类为2
     */
    private Integer cateLevel;
    /**
     * 父分类ID
     */
    private Long parentCateId;
    /**
     * 同级分类排序值，正整数，唯一但不一定连续
     */
    private Integer cateOrder;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 修改时间
     */
    private Date modified;

    public JdImgzoneCategoryResponse() {
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Integer getCateLevel() {
        return cateLevel;
    }

    public void setCateLevel(Integer cateLevel) {
        this.cateLevel = cateLevel;
    }

    public Long getParentCateId() {
        return parentCateId;
    }

    public void setParentCateId(Long parentCateId) {
        this.parentCateId = parentCateId;
    }

    public Integer getCateOrder() {
        return cateOrder;
    }

    public void setCateOrder(Integer cateOrder) {
        this.cateOrder = cateOrder;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
