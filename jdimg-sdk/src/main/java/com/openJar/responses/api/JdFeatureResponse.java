package com.openJar.responses.api;

import com.openJar.responses.Response;

/**
 * Created By admin on 2017/12/18/18:20
 */
public class JdFeatureResponse extends Response {

    private String featureCn;
    private String featureKey;
    private String featureValue;

    public JdFeatureResponse() {
    }

    public String getFeatureCn() {
        return featureCn;
    }

    public void setFeatureCn(String featureCn) {
        this.featureCn = featureCn;
    }

    public String getFeatureKey() {
        return featureKey;
    }

    public void setFeatureKey(String featureKey) {
        this.featureKey = featureKey;
    }

    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }
}
