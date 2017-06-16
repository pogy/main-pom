package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 发货机构
 * Created by zhaohongbo on 17/6/1.
 */
public class SenderVO implements Serializable{

    private Long senderId;

    private String webSite;

    private String topic;

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
