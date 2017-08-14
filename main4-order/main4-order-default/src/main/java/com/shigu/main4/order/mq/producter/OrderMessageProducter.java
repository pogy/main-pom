package com.shigu.main4.order.mq.producter;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.OnExceptionContext;
import com.aliyun.openservices.ons.api.SendCallback;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.shigu.main4.order.mq.msg.BaseMessage;
import com.shigu.main4.order.mq.msg.CourierMessage;
import com.shigu.main4.order.mq.msg.OrderMessage;
import com.shigu.main4.order.mq.msg.RefundMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单消息生产
 * Created by bugzy on 2017/8/14 0014.
 */
@Service
public class OrderMessageProducter {

    private static final Logger logger = LoggerFactory.getLogger(OrderMessageProducter.class);

    public static final String TOPIC = "PID_SORDER_TEST";

    public enum OrderMQTag {
        order_push("oid_"),
        order_refund_noitem("refund_"),
        order_refund_hasitem("refund_hasitem_"),
        refund_courier_number("courier_"),
        refund_courier_number_modify("courier_modify_");

        public final String preKey;

        OrderMQTag(String preKey) {
            this.preKey = preKey;
        }
    }

    @Autowired
    private ProducerBean producerBean;

    /**
     * 订单推送
     */
    public void orderPush() {
        OrderMessage order = new OrderMessage();
//        order.setOid();
        sendAsync(OrderMQTag.order_push, BaseMessage.success(order.getOid().toString(), "订单创建", order));
    }

    public void orderRefundNoItem() {
        RefundMessage refund = new RefundMessage();
//        refund.setRefundId();
        sendAsync(OrderMQTag.order_refund_noitem, BaseMessage.success(refund.getRefundId().toString(), "仅退款", refund));
    }

    public void orderRefundHasItem() {
        RefundMessage refund = new RefundMessage();
//        refund.setRefundId();
        sendAsync(OrderMQTag.order_refund_hasitem, BaseMessage.success(refund.getRefundId().toString(), "退货退款", refund));
    }

    public void refundCourierNumber() {
        CourierMessage courier = new CourierMessage();
//        courier.setRefundId();
        sendAsync(OrderMQTag.refund_courier_number, BaseMessage.success(courier.getRefundId().toString(), "填写快递单", courier));
    }

    public void refundCourierNumberModify() {
        CourierMessage courier = new CourierMessage();
//        courier.setRefundId();
        sendAsync(OrderMQTag.refund_courier_number_modify, BaseMessage.success(courier.getRefundId().toString(), "填写快递单", courier));
    }

    public void error(OrderMQTag tag, String key, String msg) {
        sendAsync(tag, BaseMessage.error(key, msg));
    }

    private void sendAsync(OrderMQTag tag, BaseMessage msg) {
        producerBean.sendAsync(
                new Message(TOPIC, tag.name(), tag.preKey + msg.getKey(), msg.toString().getBytes()),
                new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                    }

                    @Override
                    public void onException(OnExceptionContext context) {
                        logger.error(String.format(
                                "订单相关消息推送失败！topic:%s, messageid:%s,exception:%s, body:%s",
                                context.getTopic(),
                                context.getMessageId(),
                                context.getException().getMessage(),
                                msg.toString()
                                )
                        );
                    }
                }
        );
    }
}
