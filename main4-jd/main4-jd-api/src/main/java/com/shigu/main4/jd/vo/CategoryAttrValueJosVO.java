package com.shigu.main4.jd.vo;


import java.io.Serializable;
import java.util.Set;

/**
 * Created By admin on 2017/12/14/16:20
 */
public class CategoryAttrValueJosVO implements Serializable{

    private static final long serialVersionUID = 7592311776160000561L;

    private Long attrValueId;
    private Integer attrValueIndexId;
    private String attrValue;
    private Set<FeatureCateAttrValueJosVO> attrValueFeatures;

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

    public Set<FeatureCateAttrValueJosVO> getAttrValueFeatures() {
        return attrValueFeatures;
    }

    public void setAttrValueFeatures(Set<FeatureCateAttrValueJosVO> attrValueFeatures) {
        this.attrValueFeatures = attrValueFeatures;
    }
}
