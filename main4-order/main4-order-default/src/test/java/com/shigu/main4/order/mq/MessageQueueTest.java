package com.shigu.main4.order.mq;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.mq.producter.OrderMessageProducter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 消息队列测试
 * Created by bugzy on 2017/8/15 0015.
 */
public class MessageQueueTest extends BaseTest {

    @Autowired
    private OrderMessageProducter orderMessageProducter;

    /**
     * 测试订单推送
     */
    @Test
    public void testSendOrderPush() {
//        orderMessageProducter.orderPush(itemOrder);
    }

    /**
     * 测试仅退款
     */
    @Test
    public void testSendRefundNoItem() {
        orderMessageProducter.orderRefundNoItem(2L, 3L);
    }

    /**
     * 测试退货退款
     */
    @Test
    public void testSendRefundHasItem() {
        orderMessageProducter.orderRefundHasItem(2L, 3L, 666L, "xxxx");
    }

    /**
     * 测试换货
     */
    @Test
    public void testSendRefundNoMoney() {
        orderMessageProducter.orderRefundHasItem(2L, 3L, 0L, "xxx");
    }

    /**
     * 测试用户退货回填快递单号
     */
    @Test
    public void testSendRefundExpress() {
        orderMessageProducter.refundCourierNumberModify(2L, "顺丰", "asee123154235312", false);
    }

    /**
     * 测试用户退货修改快递单号
     */
    @Test
    public void testSendRefundExpressModify() {
        orderMessageProducter.refundCourierNumberModify(2L, "顺丰", "a2123786345312", true);
    }
}
