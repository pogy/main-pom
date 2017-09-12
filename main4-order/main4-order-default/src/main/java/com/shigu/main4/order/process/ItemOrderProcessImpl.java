package com.shigu.main4.order.process;

import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.SoidsModel;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("itemOrderProcess")
public class ItemOrderProcessImpl implements ItemOrderProcess{

    @Autowired
    private SoidsModel soidsModel;

    @Override
    public void finish(Long oid) {
        ItemOrder order= SpringBeanFactory.getBean(ItemOrder.class,oid);
        order.finished();
    }

    @Override
    public void outOfStock(Long soidpid) {
        soidsModel.outOfStock(soidpid);
    }
}
