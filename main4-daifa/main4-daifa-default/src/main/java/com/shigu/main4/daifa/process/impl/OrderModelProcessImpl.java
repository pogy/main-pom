package com.shigu.main4.daifa.process.impl;

import com.shigu.main4.daifa.bo.DeliveryBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.process.OrderModelProcess;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.stereotype.Service;

/**
 * Created By zyl on 2018/8/28 0028/18:34
 */
@Service("orderModelProcess")
public class OrderModelProcessImpl implements OrderModelProcess {

    @Override
    public void getSend(DeliveryBO bo) {
        try {
            OrderModel orderModel = SpringBeanFactory.getBean(OrderModel.class, bo.getDfTradeId());
            bo.setTag(2);
            orderModel.send(bo);
        } catch (DaifaException e) {
            e.printStackTrace();
        }
    }
}
