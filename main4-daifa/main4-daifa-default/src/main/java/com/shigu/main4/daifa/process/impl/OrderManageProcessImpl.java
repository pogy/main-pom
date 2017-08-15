package com.shigu.main4.daifa.process.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.main4.common.util.TypeConvert;
import com.shigu.main4.daifa.bo.OrderBO;
import com.shigu.main4.daifa.enums.DaifaTradeStatus;
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

    @Override
    public void newOrder(OrderBO order) {
        SpringBeanFactory.getBean(OrderModel.class,order);
    }

    @Override
    public void markSubOrder(Long subOrderId, String mark) throws DaifaException {
        SubOrderModel subOrderModel=SpringBeanFactory.getBean(SubOrderModel.class,subOrderId);
        subOrderModel.mark(mark);
    }

    @Override
    public void haveGoodsTime(Long subOrderId, Date time) {
        SubOrderModel subOrderModel=SpringBeanFactory.getBean(SubOrderModel.class,subOrderId);
        subOrderModel.haveGoodsTime(time);
    }

    @Override
    public void markDown(Long subOrderId) {
        SubOrderModel subOrderModel=SpringBeanFactory.getBean(SubOrderModel.class,subOrderId);
        subOrderModel.markDown();
    }

    /**
     * 查出3日内超时
     */
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

}
