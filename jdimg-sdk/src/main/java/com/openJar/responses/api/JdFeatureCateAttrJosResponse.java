package com.openJar.responses.api;

import com.openJar.responses.Response;

/**
 * Created By admin on 2017/12/14/16:17
 */
public class JdFeatureCateAttrJosResponse extends Response {

    private String attrFeatureCn;
    private String attrFeatureKey;
    private String attrFeatureValue;

    public JdFeatureCateAttrJosResponse() {
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
