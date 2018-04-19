package com.openJar.beans;

import com.openJar.responses.api.JdCategoryAttrGroupJosResponse;
import com.openJar.responses.api.JdFeatureCateAttrJosResponse;
import com.openJar.utils.OpenBean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created By admin on 2018/1/16/16:09
 */
public class JdCategoryAttrJos extends OpenBean implements Serializable {
    private Long categoryAttrId;
    private Long categoryId;
    private String attName;
    private Integer attrIndexId;
    private Integer inputType;
    private Integer attributeType;
    private Set<JdFeatureCateAttrJosResponse> attrFeatures;
    private JdCategoryAttrGroupJosResponse categoryAttrGroup;
    private List<JdCategoryAttrValue> attrValueList;

    public JdCategoryAttrJos() {
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

    public Set<JdFeatureCateAttrJosResponse> getAttrFeatures() {
        return attrFeatures;
    }

    public void setAttrFeatures(Set<JdFeatureCateAttrJosResponse> attrFeatures) {
        this.attrFeatures = attrFeatures;
    }

    public JdCategoryAttrGroupJosResponse getCategoryAttrGroup() {
        return categoryAttrGroup;
    }

    public void setCategoryAttrGroup(JdCategoryAttrGroupJosResponse categoryAttrGroup) {
        this.categoryAttrGroup = categoryAttrGroup;
    }

    public List<JdCategoryAttrValue> getAttrValueList() {
        return attrValueList;
    }

    public void setAttrValueList(List<JdCategoryAttrValue> attrValueList) {
        this.attrValueList = attrValueList;
    }
}
