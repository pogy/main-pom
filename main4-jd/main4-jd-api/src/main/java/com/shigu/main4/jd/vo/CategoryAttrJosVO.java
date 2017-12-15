package com.shigu.main4.jd.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created By admin on 2017/12/14/16:15
 */
public class CategoryAttrJosVO implements Serializable {

    private static final long serialVersionUID = -3179694262609983760L;

    private Long categoryAttrId;
    private Long categoryId;
    private String attName;
    private Integer attrIndexId;
    private Integer inputType;
    private Integer attributeType;
    private Set<FeatureCateAttrJosVO> attrFeatures;
    private CategoryAttrGroupJosVO categoryAttrGroup;
    private List<CategoryAttrValueJosVO> attrValueList;

    public CategoryAttrJosVO() {
    }

    public Long getCategoryAttrId() {
        return categoryAttrId;
    }

    public void setCategoryAttrId(Long categoryAttrId) {
        this.categoryAttrId = categoryAttrId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getAttName() {
        return attName;
    }

    public void setAttName(String attName) {
        this.attName = attName;
    }

    public Integer getAttrIndexId() {
        return attrIndexId;
    }

    public void setAttrIndexId(Integer attrIndexId) {
        this.attrIndexId = attrIndexId;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public Integer getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(Integer attributeType) {
        this.attributeType = attributeType;
    }

    public Set<FeatureCateAttrJosVO> getAttrFeatures() {
        return attrFeatures;
    }

    public void setAttrFeatures(Set<FeatureCateAttrJosVO> attrFeatures) {
        this.attrFeatures = attrFeatures;
    }

    public CategoryAttrGroupJosVO getCategoryAttrGroup() {
        return categoryAttrGroup;
    }

    public void setCategoryAttrGroup(CategoryAttrGroupJosVO categoryAttrGroup) {
        this.categoryAttrGroup = categoryAttrGroup;
    }

    public List<CategoryAttrValueJosVO> getAttrValueList() {
        return attrValueList;
    }

    public void setAttrValueList(List<CategoryAttrValueJosVO> attrValueList) {
        this.attrValueList = attrValueList;
    }
}
