package com.shigu.kdn.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KuaidiniaoConfig {
    @Value("${kuaidiniao.EBusinessID}")
    private String eBusinessID;
    @Value("${kuaidiniao.AppKey}")
    private  String appKey;
    @Value("${kuaidiniao.queryUrl}")
    private String queryUrl;
    @Value("${kuaidiniao.subscriptionUrl}")
    private String subscriptionUrl;

    public String geteBusinessID() {
        return eBusinessID;
    }

    public void seteBusinessID(String eBusinessID) {
        this.eBusinessID = eBusinessID;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getQueryUrl() {
        return queryUrl;
    }

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }

    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    public void setSubscriptionUrl(String subscriptionUrl) {
        this.subscriptionUrl = subscriptionUrl;
    }
}
