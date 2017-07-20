package com.shigu.main4.order.whx;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.SubItemOrder;
import com.shigu.main4.order.model.impl.SubItemOrderImpl;
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
        subItemOrder = SpringBeanFactory.getBean(SubItemOrderImpl.class,10L);
    }

    @Test
    public void subOrderInfoTest() {
        show(subItemOrder.subOrderInfo());
    }
}
