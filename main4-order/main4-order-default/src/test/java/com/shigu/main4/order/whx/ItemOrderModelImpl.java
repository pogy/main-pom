package com.shigu.main4.order.whx;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;

/**
 * Created by whx on 2017/7/28 0028.
 */
public class ItemOrderModelImpl extends BaseTest{

    @Test
    public void selServicesTest() {
        ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, 2L);
        show(itemOrder.selServices());
    }
}
