package com.shigu.main4.order.mq.listener;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 代发消息队列接收处理
 * Created by bugzy on 2017/8/14 0014.
 */
@Component
public class DfMessageListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(DfMessageListener.class);
    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        String body = new String(message.getBody());
        logger.info(body);
        return Action.ReconsumeLater;
    }
}
