package com.shigu.jd.mapper.beans;

import java.io.Serializable;

/**
 * Created By admin on 2017/12/14/16:17
 */
public class JdFeatureCateAttrJosVO implements Serializable {

    private static final long serialVersionUID = -4247890569956261091L;
    private String attrFeatureCn;
    private String attrFeatureKey;
    private String attrFeatureValue;

    public JdFeatureCateAttrJosVO() {
    }

    public String getAttrFeatureCn() {
        return attrFeatureCn;
    }

    public void setAttrFeatureCn(String attrFeatureCn) {
        this.attrFeatureCn = attrFeatureCn;
    }

    public String getAttrFeatureKey() {
        return attrFeatureKey;
    }

    public void setAttrFeatureKey(String attrFeatureKey) {
        this.attrFeatureKey = attrFeatureKey;
    }

    public String getAttrFeatureValue() {
        return attrFeatureValue;
    }

    public void setAttrFeatureValue(String attrFeatureValue) {
        this.attrFeatureValue = attrFeatureValue;
    }
}
