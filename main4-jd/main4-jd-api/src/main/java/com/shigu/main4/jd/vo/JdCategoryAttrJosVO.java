package com.shigu.main4.jd.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created By admin on 2017/12/14/16:15
 */
public class JdCategoryAttrJosVO implements Serializable {

    private static final long serialVersionUID = -3179694262609983760L;

    private Long categoryAttrId;
    private Long categoryId;
    private String attName;
    private Integer attrIndexId;
    private Integer inputType;
    private Integer attributeType;
    private Set<JdFeatureCateAttrJosVO> attrFeatures;
    private JdCategoryAttrGroupJosVO categoryAttrGroup;
    private List<JdCategoryAttrValueJosVO> attrValueList;

    public JdCategoryAttrJosVO() {
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

    public Set<JdFeatureCateAttrJosVO> getAttrFeatures() {
        return attrFeatures;
    }

    public void setAttrFeatures(Set<JdFeatureCateAttrJosVO> attrFeatures) {
        this.attrFeatures = attrFeatures;
    }

    public JdCategoryAttrGroupJosVO getCategoryAttrGroup() {
        return categoryAttrGroup;
    }

    public void setCategoryAttrGroup(JdCategoryAttrGroupJosVO categoryAttrGroup) {
        this.categoryAttrGroup = categoryAttrGroup;
    }

    public List<JdCategoryAttrValueJosVO> getAttrValueList() {
        return attrValueList;
    }

    public void setAttrValueList(List<JdCategoryAttrValueJosVO> attrValueList) {
        this.attrValueList = attrValueList;
    }
}
