package com.shigu.main4.jd.vo;

import java.io.Serializable;

/**
 * Created By admin on 2017/12/14/16:19
 */
public class JdFeatureCateAttrGroupJosVO implements Serializable {

    private static final long serialVersionUID = -92656786510559696L;

    private String attrGroupFeatureCn;
    private String attrGroupFeatureKey;
    private String attrGroupFeatureValue;

    public JdFeatureCateAttrGroupJosVO() {
    }

    public String getAttrGroupFeatureCn() {
        return attrGroupFeatureCn;
    }

    public void setAttrGroupFeatureCn(String attrGroupFeatureCn) {
        this.attrGroupFeatureCn = attrGroupFeatureCn;
    }

    public String getAttrGroupFeatureKey() {
        return attrGroupFeatureKey;
    }

    public void setAttrGroupFeatureKey(String attrGroupFeatureKey) {
        this.attrGroupFeatureKey = attrGroupFeatureKey;
    }

    public String getAttrGroupFeatureValue() {
        return attrGroupFeatureValue;
    }

    public void setAttrGroupFeatureValue(String attrGroupFeatureValue) {
        this.attrGroupFeatureValue = attrGroupFeatureValue;
    }
}
