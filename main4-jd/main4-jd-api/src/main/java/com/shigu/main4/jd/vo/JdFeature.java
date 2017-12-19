package com.shigu.main4.jd.vo;

import java.io.Serializable;

/**
 * Created By admin on 2017/12/18/18:20
 */
public class JdFeature implements Serializable{

    private static final long serialVersionUID = 4119412039913096782L;

    private String featureCn;
    private String featureKey;
    private String featureValue;

    public JdFeature() {
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
