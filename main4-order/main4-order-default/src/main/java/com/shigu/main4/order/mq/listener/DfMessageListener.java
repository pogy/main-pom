package com.shigu.main4.order.mq.listener;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.order.model.SoidsCreater;
import com.shigu.main4.order.model.SubItemOrder;
import com.shigu.main4.order.mq.msg.*;
import com.shigu.main4.order.mq.producter.OrderMessageProducter;
import com.shigu.main4.order.vo.RefundVO;
import com.shigu.main4.order.vo.SubItemOrderVO;
import com.shigu.main4.order.zfenums.RefundStateEnum;
import com.shigu.main4.tools.SpringBeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.shigu.main4.order.mq.listener.DfMessageListener.DfMqTag.refund_agree;

/**
 * 代发消息队列接收处理
 * Created by bugzy on 2017/8/14 0014.
 */
@Component
public class DfMessageListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(DfMessageListener.class);

    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;

    @Autowired
    private SoidsCreater soidsCreater;

    @Autowired
    private OrderMessageProducter orderMessageProducter;

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

        if (!baseMessage.getStatus()) {
            logger.error(baseMessage.getMsg());
            return Action.CommitMessage;
        }

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
            RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, msg.getData().getRefundId());
            refundItemOrder.success();
            RefundVO refundinfo = refundItemOrder.refundinfo();
            ItemOrderRefund itemOrderRefund = new ItemOrderRefund();
            itemOrderRefund.setOid(refundinfo.getOid());
            itemOrderRefund.setStatus(RefundStateEnum.ENT_REFUND.refundStatus);
            List<Long> soids = itemOrderRefundMapper.select(itemOrderRefund).stream().map(ItemOrderRefund::getSoid).collect(Collectors.toList());

            ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, refundinfo.getOid());
            if (soids.size() == itemOrder.subOrdersInfo().size()) {
                itemOrder.closed();
            }
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
        soidsCreater.selSoidsBySoidps(msg.getData().getRefundSubOrderIds()).forEach((k, v) -> {
            SubItemOrder subItemOrder = SpringBeanFactory.getBean(SubItemOrder.class, k);
            SubItemOrderVO subItemOrderVO = subItemOrder.subOrderInfo();
            try {
                Long refundId = subItemOrder.refundApply(1, v.size(), subItemOrderVO.getPrice(), msg.getMsg());

                orderMessageProducter.orderRefundNoItem(refundId, k);
            } catch (OrderException e) {
                logger.error(e.getMessage(), e);
            }
        });
    }
}
