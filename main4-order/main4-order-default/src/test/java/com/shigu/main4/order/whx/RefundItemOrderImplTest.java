package com.shigu.main4.order.whx;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.bo.RefundApplyBO;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by whx on 2017/7/21 0021.
 */
public class RefundItemOrderImplTest extends BaseTest{

    private static Long generateRefundId=32L;

    @Test
    public void applyTest() {
        RefundApplyBO refundApplyBO = refundApplyBOGenerator(155L, 78L, 1, 100L, "退款构造测试");
        RefundItemOrder bean = SpringBeanFactory.getBean(RefundItemOrder.class, refundApplyBO, true);
        show(bean);
        generateRefundId = bean.getRefundId();
    }

    @Test
    public void sellerAgreeTest() {
        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, 70L);
        refundItemOrder.sellerAgree();
        //测试重复操作
//        refundItemOrder.sellerAgree();
    }

    @Test
    public void sellerRefuseTest() {
        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, 57L);
        refundItemOrder.sellerRefuse("测试退款，卖家拒绝");
        //测试重复操作
//        refundItemOrder.sellerRefuse("测试退款，卖家拒绝");
    }

    @Test
    public void userSendedTest() {
        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, generateRefundId);
        refundItemOrder.userSended("885782656452802268");
        //测试重复操作
//        refundItemOrder.userSended("885782656452802268");
    }

    @Test
    public void sellerCachedTest() {
        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, 70L);
        refundItemOrder.sellerCached();
        //测试重复操作
//        refundItemOrder.sellerCached();
    }

    @Test
    public void errorTest() throws RefundException, PayerException {
        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, 70L);
//        refundItemOrder.error("退件失败");
        //测试重复操作
        refundItemOrder.changeSuccess();
    }

    @Test
    public void sellerProposalTest() {
        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, generateRefundId);
        refundItemOrder.sellerProposal(200L,"测试参数");
        //测试重复操作
        refundItemOrder.sellerProposal(200L,"测试参数");
    }

    @Test
    public void buyerNoRepriceTest() {
        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, generateRefundId);
        refundItemOrder.buyerNoReprice();
        //测试重复操作
        refundItemOrder.buyerNoReprice();
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

    @Test
    public void sended(){
        SpringBeanFactory.getBean(ItemOrder.class, 195L).sended("437039539484");
    }
}
