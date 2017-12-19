package com.shigu.main4.jd.vo;

import java.io.Serializable;

/**
 * Created By admin on 2017/12/14/16:23
 */
public class JdFeatureCateAttrValueJosVO implements Serializable {

    private static final long serialVersionUID = 4620925239985421218L;

    private String attrValueFeatureCn;
    private String attrValueFeatureKey;
    private String attrValueFeatureValue;

    public JdFeatureCateAttrValueJosVO() {
    }

    public String getAttrValueFeatureCn() {
        return attrValueFeatureCn;
    }

    public void setAttrValueFeatureCn(String attrValueFeatureCn) {
        this.attrValueFeatureCn = attrValueFeatureCn;
    }

    public String getAttrValueFeatureKey() {
        return attrValueFeatureKey;
    }

    public void setAttrValueFeatureKey(String attrValueFeatureKey) {
        this.attrValueFeatureKey = attrValueFeatureKey;
    }

    public String getAttrValueFeatureValue() {
        return attrValueFeatureValue;
    }

    public void setAttrValueFeatureValue(String attrValueFeatureValue) {
        this.attrValueFeatureValue = attrValueFeatureValue;
    }
}
