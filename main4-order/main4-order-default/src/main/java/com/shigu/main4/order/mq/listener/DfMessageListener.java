package com.shigu.main4.order.mq.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.order.mq.msg.*;
import com.shigu.main4.tools.SpringBeanFactory;
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
                refundAgree(baseMessage);
                break;
            case weight_set:
                weightSet(baseMessage);
                break;
            case send_all:
                sendAll(baseMessage);
                break;
            case stop_trade:
                stopTrade(baseMessage);
                break;
        }
        return Action.CommitMessage;
    }

    public void refundAgree(BaseMessage<RefundMessage> msg) {
        try {
            SpringBeanFactory.getBean(RefundItemOrder.class, msg.getData().getRefundId()).success();
        } catch (PayerException | RefundException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void weightSet(BaseMessage<SubOrderInfoMessage> msg) {

    }

    public void sendAll(BaseMessage<SendAllMessage> msg) {
        SendAllMessage sendAllMessage = msg.getData();
        SpringBeanFactory.getBean(ItemOrder.class, sendAllMessage.getOrderId()).sended(sendAllMessage.getExpressCode());
    }

    public void stopTrade(BaseMessage<StopTradeMessage> msg) {

    }
}
