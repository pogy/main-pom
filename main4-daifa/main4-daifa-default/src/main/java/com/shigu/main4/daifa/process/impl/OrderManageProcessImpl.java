package com.shigu.main4.daifa.process.impl;

import com.shigu.main4.daifa.bo.OrderBO;
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.model.SubOrderModel;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("orderManageProcess")
public class OrderManageProcessImpl implements OrderManageProcess {


    @Override
    public void newOrder(OrderBO order) {
        SpringBeanFactory.getBean(OrderModel.class,order);
    }

    @Override
    public void markSubOrder(Long subOrderId, String mark) {
        SubOrderModel subOrderModel;
    }

    @Override
    public void haveGoodsTime(Long subOrderId, Date time) {

    }

    @Override
    public void markDown(Long subOrderId) {

    }

    @Override
    public void orderTimeout(Long orderId) {

    }

    @Override
    public void autoRefund() {

    }
}
