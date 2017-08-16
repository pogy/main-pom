package com.shigu.main4.daifa.process.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaOrderMapper;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.main4.daifa.bo.OrderBO;
import com.shigu.main4.daifa.enums.DaifaTradeStatus;
import com.shigu.main4.daifa.enums.SubOrderStatus;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.model.SubOrderModel;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("orderManageProcess")
public class OrderManageProcessImpl implements OrderManageProcess {

    private final int MAX_TIME_OUT=3;//3天为最大超时时间

    @Autowired
    DaifaTradeMapper daifaTradeMapper;

    @Autowired
    DaifaOrderMapper daifaOrderMapper;

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
        SubOrderModel subOrderModel=SpringBeanFactory.getBean(SubOrderModel.class,subOrderId);
        subOrderModel.mark(mark);
    }

    /**
     * 设置有货时间
      * @param subOrderId 子订单数据
     * @param time 有货时间
     */
    @Override
    public void haveGoodsTime(Long subOrderId, Date time) throws DaifaException {
        SubOrderModel subOrderModel=SpringBeanFactory.getBean(SubOrderModel.class,subOrderId);
        subOrderModel.noTake();
        subOrderModel.haveGoodsTime(time);
    }

    /**
     * 标记下架
     * @param subOrderId 子订单数据
     */
    @Override
    public void markDown(Long subOrderId) throws DaifaException {
        SubOrderModel subOrderModel=SpringBeanFactory.getBean(SubOrderModel.class,subOrderId);
        subOrderModel.noTake();
        subOrderModel.markDown();
    }

    @Override
    public void orderTimeout() {
        //查出超时的单子
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-3);
        Date minTime=cal.getTime();
        DaifaTradeExample example=new DaifaTradeExample();
        example.createCriteria().andCreateTimeLessThan(minTime).andTradeStatusEqualTo(DaifaTradeStatus.PAYED.getValue());
        example.or().andCreateTimeLessThan(minTime).andTradeStatusEqualTo(DaifaTradeStatus.PACKING.getValue());
        List<DaifaTrade> timeoutTrades=daifaTradeMapper.selectFieldsByExample(example, FieldUtil.codeFields("df_trade_id"));
        timeoutTrades.forEach(t ->{
            OrderModel orderModel=SpringBeanFactory.getBean(OrderModel.class,t.getDfTradeId());
            orderModel.timeout();
        });
    }

    @Override
    public boolean tryRefund(String outerSubOrderId, Integer num) {
        DaifaOrderExample orderExample=new DaifaOrderExample();
        orderExample.createCriteria().andOrderCodeEqualTo(outerSubOrderId).andOrderStatusNotEqualTo((long) SubOrderStatus.PAYED.getValue());
        return daifaOrderMapper.countByExample(orderExample)>num;
    }

}
