package com.shigu.main4.jd.vo;

import java.io.Serializable;

/**
 * Created By admin on 2017/12/14/16:17
 */
public class FeatureCateAttrJosVO implements Serializable {

    private static final long serialVersionUID = -4247890569956261091L;
    private String attrFeatureCn;
    private String attrFeatureKey;
    private String attrFeatureValue;

    public FeatureCateAttrJosVO() {
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
