package com.shigu.main4.daifa.process.impl;

import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.bo.OrderBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
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

    /**
     * 备注
     * @param subOrderId 子订单数据
     * @param mark 备注内容
     */
    @Override
    public void markSubOrder(Long subOrderId, String mark) throws DaifaException {
        SubOrderModel subOrderModel = SpringBeanFactory.getBean(SubOrderModel.class,subOrderId);
        subOrderModel.mark(mark);
    }

    /**
     * 设置有货时间
      * @param subOrderId 子订单数据
     * @param time 有货时间
     */
    @Override
    public void haveGoodsTime(Long subOrderId, Date time) {
        SubOrderModel subOrderModel = SpringBeanFactory.getBean(SubOrderModel.class, subOrderId);
        subOrderModel.haveGoodsTime(time);
    }

    /**
     * 标记下架
     * @param subOrderId 子订单数据
     */
    @Override
    public void markDown(Long subOrderId) {
        SubOrderModel subOrderModel = SpringBeanFactory.getBean(SubOrderModel.class, subOrderId);
        subOrderModel.markDown();
    }

    /**
     * 订单超时
     * @param orderId 订单数据
     */
    @Override
    public void orderTimeout(Long orderId) {

    }

    @Override
    public void autoRefund() {

    }
}
