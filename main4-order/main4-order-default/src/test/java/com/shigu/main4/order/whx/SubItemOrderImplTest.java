package com.shigu.main4.order.whx;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.model.SubItemOrder;
import com.shigu.main4.order.model.impl.SubItemOrderImpl;
import com.shigu.main4.order.zfenums.RefundTypeEnum;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by whx on 2017/7/20 0020.
 */
public class SubItemOrderImplTest extends BaseTest {

    private SubItemOrder subItemOrder;

    @Before
    public void init() {
        subItemOrder = SpringBeanFactory.getBean(SubItemOrderImpl.class,78L);
    }

    @Test
    public void subOrderInfoTest() {
        show(subItemOrder.subOrderInfo());
    }

    @Test
    public void refundApplyTest() throws OrderException {
        subItemOrder.refundApply(1, 1, 1L, "test");
    }

    @Test
    public void refundInfosTest() {
        show(subItemOrder.refundInfos(RefundTypeEnum.GOODS_CHANGE));
    }
}
