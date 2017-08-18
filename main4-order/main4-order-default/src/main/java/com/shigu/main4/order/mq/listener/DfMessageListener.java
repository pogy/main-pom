package com.shigu.main4.order.mq.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.shigu.main4.order.mq.msg.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.shigu.main4.order.mq.listener.DfMessageListener.DfMqTag.refund_agree;

/**
 * 代发消息队列接收处理
 * Created by bugzy on 2017/8/14 0014.
 */
@Component
public class DfMessageListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(DfMessageListener.class);

    public enum DfMqTag {
        refund_agree(RefundMessage.class),

        weight_set(SubOrderInfoMessage.class),

        send_all(SendAllMessage.class),

        stop_trade(StopTradeMessage.class),
        ;
        public final Class<?> clazz;

        DfMqTag(Class<?> clazz) {
            this.clazz = clazz;
        }
    }

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        String body = new String(message.getBody());
        logger.info(body);
        DfMqTag dfMqTag;
        try {
            dfMqTag = DfMqTag.valueOf(message.getTag());
        } catch (IllegalArgumentException e) {
            logger.error(String.format("不支持的消息类型[%s]::body[%s]", message.getTag(), body));
            return Action.ReconsumeLater;
        }
        BaseMessage baseMessage = JSON.parseObject(body, BaseMessage.class);
        baseMessage.setData(JSON.parseObject(baseMessage.getData().toString(), refund_agree.clazz));

        switch (dfMqTag) {
            case refund_agree:
                break;
            case weight_set:
                break;
            case send_all:
                break;
            case stop_trade:
                break;
        }
        return Action.CommitMessage;
    }

    public void refundAgree(BaseMessage<RefundMessage> msg) {

    }

    public void weightSet(BaseMessage<SubOrderInfoMessage> msg) {

    }

    public void sendAll(BaseMessage<SendAllMessage> msg) {

    }

    public void stopTrade(BaseMessage<StopTradeMessage> msg) {

    }
}
