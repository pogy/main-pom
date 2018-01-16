package com.openJar.responses.api;

import com.openJar.responses.Response;

/**
 * Created By admin on 2017/12/14/16:19
 */
public class JdFeatureCateAttrGroupJosResponse extends Response {

    private String attrGroupFeatureCn;
    private String attrGroupFeatureKey;
    private String attrGroupFeatureValue;

    public JdFeatureCateAttrGroupJosResponse() {
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
