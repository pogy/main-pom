package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 发货机构
 * Created by zhaohongbo on 17/6/1.
 */
public class SenderVO implements Serializable{
    private Long senderId;

    /**
     * 显示名称
     */
    private String senderName;

    /**
     * 消息队列的flag
     */
    private String topic;

    /**
     * 类别，1代发
     */
    private Integer type;

    /**
     * 退货地址
     */
    private String address;

    /**
     * 退货手机号
     */
    private String telephone;

    /**
     * 退货收件人
     */
    private String name;

    /**
     *
     */
    private String webSite;

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

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
