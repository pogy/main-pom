package com.shigu.main4.order.process;

import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.tools.SpringBeanFactory;

public class ItemOrderProcessImpl implements ItemOrderProcess{
    @Override
    public void finish(Long oid) {
        ItemOrder order= SpringBeanFactory.getBean(ItemOrder.class,oid);
        order.finished();
    }
}
