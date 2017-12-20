package com.shigu.main4.daifa.utils;

import com.aliyun.openservices.ons.api.*;
import com.opentae.common.beans.LogUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class MQUtil {
    @Autowired
    private Producer producer;
    @Value("${MQ_topic}")
    private String topic;
    private final Logger log = LogUtil.getLog(MQUtil.class);

    public void sendMessage(String messageKey, String messageTag, String messages) {
        byte[] bs = null;
        try {
            bs = messages.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Message msg = new Message( //
                // Message所属的Topic
                topic,
                // Message Tag 可理解为Gmail中的标签，对消息进行再归类，方便Consumer指定过滤条件在MQ服务器过滤
                messageTag,
                // Message Body 可以是任何二进制形式的数据， MQ不做任何干预
                // 需要Producer与Consumer协商好一致的序列化和反序列化方式
                bs);
        // 设置代表消息的业务关键属性，请尽可能全局唯一
        // 以方便您在无法正常收到消息情况下，可通过MQ 控制台查询消息并补发
        // 注意：不设置也不会影响消息正常收发
        msg.setKey(messageKey);
        log.info("send body: " + new String(msg.getBody()));
        // 发送消息，只要不抛异常就是成功
        producer.sendAsync(msg, new SendCallback() {
            @Override
            public void onSuccess(final SendResult sendResult) {
                // 消费发送成功
                log.info("send success: " + sendResult.getMessageId());
            }
            @Override
            public void onException(OnExceptionContext context) {
                // 消息发送失败
                log.error("发送失败");
            }
        });
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
