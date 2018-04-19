package com.openJar.responses.api;

import com.openJar.responses.Response;

/**
 * Created By admin on 2017/12/14/16:23
 */
public class JdFeatureCateAttrValueResponse extends Response {

    private String attrValueFeatureCn;
    private String attrValueFeatureKey;
    private String attrValueFeatureValue;

    public JdFeatureCateAttrValueResponse() {
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
