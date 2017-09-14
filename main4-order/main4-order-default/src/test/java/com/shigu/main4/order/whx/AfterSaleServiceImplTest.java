package com.shigu.main4.order.whx;

import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.vo.RefundVO;
import com.shigu.main4.order.vo.SubItemOrderVO;
import com.shigu.main4.order.zfenums.RefundStateEnum;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Licca on 17/9/2.
 */
public class AfterSaleServiceImplTest extends BaseTest{

    @Autowired
    AfterSaleService afterSaleService;

    @Autowired
    ItemOrderRefundMapper itemOrderRefundMapper;

    @Test
    public void subAfterSaleSimpleOrderTest(){
        show(afterSaleService.subAfterSaleSimpleOrder(97105L));
    }

    @Test
    public void refundApplyTest() throws OrderException {
        Long soid=96022l;
        Long money=774880l;
        Integer count=3;
        System.out.println(afterSaleService.preRefundApply(soid, count, money));
    }

    @Test
    public void refundAgree() throws Main4Exception {

        try {
            RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, 36260l);
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
}
