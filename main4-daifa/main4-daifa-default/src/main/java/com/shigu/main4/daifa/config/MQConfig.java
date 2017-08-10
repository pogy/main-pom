package com.shigu.main4.daifa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @类编号
 * @类名称：MQConfig
 * @文件路径：com.shigu.daifa.messagemq.beans.MQConfig
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/6/16 17:48
 * @version: daifa_site8.0
 * @since: daifa_site8.0
 * @commonents:
 */
@Component
public class MQConfig {

    @Value("${MQ_topic}")
    public String topic;
    @Value("${MQ_ProducerId}")
    public String mqProducerId;
    @Value("${MQ_ConsumerId}")
    public String mqConsumerId;
    @Value("${MQ_AccessKey}")
    public String mqAccessKey;
    @Value("${MQ_SecretKey}")
    public String mqSecretKey;

    public String getTopic () {
        return topic;
    }

    public void setTopic (String topic) {
        this.topic = topic;
    }

    public String getMqProducerId () {
        return mqProducerId;
    }

    public void setMqProducerId (String mqProducerId) {
        this.mqProducerId = mqProducerId;
    }

    public String getMqConsumerId () {
        return mqConsumerId;
    }

    public void setMqConsumerId (String mqConsumerId) {
        this.mqConsumerId = mqConsumerId;
    }

    public String getMqAccessKey () {
        return mqAccessKey;
    }

    public void setMqAccessKey (String mqAccessKey) {
        this.mqAccessKey = mqAccessKey;
    }

    public String getMqSecretKey () {
        return mqSecretKey;
    }

    public void setMqSecretKey (String mqSecretKey) {
        this.mqSecretKey = mqSecretKey;
    }
}
