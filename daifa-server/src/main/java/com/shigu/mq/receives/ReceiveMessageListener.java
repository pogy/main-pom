package com.shigu.mq.receives;


import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;

/**
 *
 */
public class ReceiveMessageListener implements MessageListener {

    private final static Logger log = LogManager.getLogger(ReceiveMessageListener.class);
    private DefaultProcessMessage defaultProcessMessage;
    @Autowired
    public void setDefaultProcessMessage(DefaultProcessMessage defaultProcessMessage) {
        this.defaultProcessMessage = defaultProcessMessage;
    }

    public Action consume(Message message, ConsumeContext context) {
        try {
            defaultProcessMessage.dispatchMessage(message.getTag(),message.getKey(),message.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return Action.ReconsumeLater;
        }
        return Action.CommitMessage;
    }

}
