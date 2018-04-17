package com.openJar.beans;

import com.openJar.responses.api.JdFeatureCateAttrValueResponse;
import com.openJar.utils.OpenBean;

import java.io.Serializable;
import java.util.Set;

/**
 * Created By admin on 2018/1/16/15:38
 */
public class JdCategoryAttrValue  extends OpenBean implements Serializable {
    private Long attrValueId;
    private Integer attrValueIndexId;
    private String attrValue;
    private Set<JdFeatureCateAttrValueResponse> attrValueFeatures;

    public JdCategoryAttrValue() {
    }

    public Long getAttrValueId() {
        return attrValueId;
    }

    public void setAttrValueId(Long attrValueId) {
        this.attrValueId = attrValueId;
    }

    public Integer getAttrValueIndexId() {
        return attrValueIndexId;
    }

    public void setAttrValueIndexId(Integer attrValueIndexId) {
        this.attrValueIndexId = attrValueIndexId;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public Set<JdFeatureCateAttrValueResponse> getAttrValueFeatures() {
        return attrValueFeatures;
    }

    public void setAttrValueFeatures(Set<JdFeatureCateAttrValueResponse> attrValueFeatures) {
        this.attrValueFeatures = attrValueFeatures;
    }
}
