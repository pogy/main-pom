package com.shigu.main4.order.model.impltest;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.model.RechargeOrder;
import com.shigu.main4.order.model.impl.RechargeOrderImpl;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;

/**
 * Created by Licca on 17/10/6.
 */
public class RechargeOrderImplTest extends BaseTest {

    @Test
    public void change() throws PayApplyException {
        RechargeOrder order=SpringBeanFactory.getBean(RechargeOrder.class, 1000073949L, 147912L, 500000L);
        order.payed("2017100121001004410526524836");
    }
}
