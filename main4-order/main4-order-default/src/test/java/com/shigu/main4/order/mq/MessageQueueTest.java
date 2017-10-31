package com.shigu.main4.order.mq;

import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.order.mq.producter.OrderMessageProducter;
import com.shigu.main4.order.vo.RefundVO;
import com.shigu.main4.order.vo.SubItemOrderVO;
import com.shigu.main4.order.zfenums.RefundStateEnum;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 消息队列测试
 * Created by bugzy on 2017/8/15 0015.
 */
public class MessageQueueTest extends BaseTest {

    @Autowired
    private OrderMessageProducter orderMessageProducter;

    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;


    @Test
    public void testAgreeRefund(){
        Long refundId=39101L;
        try {
            RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, refundId);
            refundItemOrder.success();
            RefundVO refundinfo = refundItemOrder.refundinfo();
            ItemOrderRefund itemOrderRefund = new ItemOrderRefund();
            itemOrderRefund.setOid(refundinfo.getOid());
            itemOrderRefund.setStatus(RefundStateEnum.ENT_REFUND.refundStatus);
            int soidps = itemOrderRefundMapper.select(itemOrderRefund).stream().mapToInt(ItemOrderRefund::getNumber).sum();

            ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, refundinfo.getOid());
            if (soidps == itemOrder.subOrdersInfo().stream().mapToInt(SubItemOrderVO::getNum).sum()) {
                itemOrder.finished();
            }
        } catch (PayerException | RefundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 测试订单推送
     */
    @Test
    public void testSendOrderPush() {
        ItemOrder bean = SpringBeanFactory.getBean(ItemOrder.class, 347L);
        orderMessageProducter.orderPush(bean);
    }

    /**
     * 测试仅退款
     */
    @Test
    public void testSendRefundNoItem() {
//        orderMessageProducter.orderRefundNoItem(2L, 3L, refundCount);
    }

    /**
     * 测试退货退款
     */
    @Test
    public void testSendRefundHasItem() {
//        orderMessageProducter.orderRefundHasItem(2L, 3L, 666L, "xxxx");
    }

    /**
     * 测试换货
     */
    @Test
    public void testSendRefundNoMoney() {
//        orderMessageProducter.orderRefundHasItem(2L, 3L, 0L, "xxx");
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
