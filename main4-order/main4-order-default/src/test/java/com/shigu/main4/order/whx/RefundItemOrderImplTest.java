package com.shigu.main4.order.whx;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.bo.RefundApplyBO;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;

/**
 * Created by whx on 2017/7/21 0021.
 */
public class RefundItemOrderImplTest extends BaseTest{

    @Test
    public void applyTest() {
        RefundApplyBO refundApplyBO = refundApplyBOGenerator(2L, 4L, 1, 100L, "退款构造测试");
        RefundItemOrder bean = SpringBeanFactory.getBean(RefundItemOrder.class, refundApplyBO, true);
        show(bean);
    }

    @Test
    public void sellerAgreeTest() {
        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, 4L);
        refundItemOrder.sellerAgree();
        //测试重复操作
        refundItemOrder.sellerAgree();
    }

    @Test
    public void sellerRefuseTest() {
        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, 4L);
        refundItemOrder.sellerRefuse("测试退款，卖家拒绝");
        //测试重复操作
        refundItemOrder.sellerRefuse("测试退款，卖家拒绝");
    }

    @Test
    public void sellerCachedTest() {
        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, 4L);
        refundItemOrder.sellerCached();
        //测试重复操作
        refundItemOrder.sellerCached();
    }

    private RefundApplyBO refundApplyBOGenerator(Long oid,Long soid,Integer type,Long hopeMoney,String reason) {
        RefundApplyBO refundApplyBO = new RefundApplyBO();
        refundApplyBO.setOid(oid);
        refundApplyBO.setSoid(soid);
        refundApplyBO.setType(type);
        refundApplyBO.setHopeMoney(hopeMoney);
        refundApplyBO.setReason(reason);
        return refundApplyBO;
    }
}
