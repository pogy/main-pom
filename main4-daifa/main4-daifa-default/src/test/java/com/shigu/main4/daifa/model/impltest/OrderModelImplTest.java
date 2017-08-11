package com.shigu.main4.daifa.model.impltest;

import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.interfaces.DaifaOrderMapper;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.TypeConvert;
import com.shigu.main4.daifa.bo.DeliveryBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.model.impl.OrderModelImpl;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jmb on 2017/8/10.
 * Path com.shigu.main4.spring-database.model.impltest.OrderModelImplTest
 */
public class OrderModelImplTest extends BaseDaifaTest{

    OrderModel orderModel;

    @Autowired
    DaifaTradeMapper daifaTradeMapper;
    @Test
    public void testinit(){
        System.out.println("asdf");
        orderModel = SpringBeanFactory.getBean(OrderModel.class,2L);
        show(orderModel);
    }
    @Test
    public void testtimeOut(){

        testinit();
        orderModel.timeout();
    }
    @Test
    public void testsend() throws DaifaException {
        DeliveryBO bo=new DeliveryBO();
        bo.setMarkDestination("标记已死");
        bo.setExpressCode("12345646");
        bo.setPackageName("天堂");
        bo.setSellerId(13245L);
        bo.setDfTradeId(2L);
        bo.setReceiverState("asdf");
        bo.setReceiverName("adsffdsg");
        bo.setReceiverPhone("dfgdsfg");
        bo.setExpressId(325423L);
        bo.setExpressName("adsfjkh");
        bo.setReceiverAddress("sdgf");
        bo.setCreateDate(DateUtil.dateToString(new Date(),DateUtil.patternB));
        bo.setCreateTime(new Date());
        List<Long> ids=new ArrayList<>();
        ids.add(1L);
        ids.add(40282L);
        bo.setDfOrderIds(ids);
        testinit();
        orderModel.send(bo);
    }
    @Test
    public void  testauto(){
        testinit();
        List<Long> sub=new ArrayList<>();
        sub.add(1L);
        sub.add(40282L);
        orderModel.autoRefund(1234412L,sub);
    }
    public void createData(){
         DaifaTrade daifaTrade=new DaifaTrade();
        Date d=new Date();
        TypeConvert.dateAddDay(d,-4);
        daifaTrade.setCreateTime(d);
        daifaTrade.setDfTradeId(2L);
        daifaTrade.setSellerId(1L);
        daifaTrade.setGoodsNum(1L);
        daifaTrade.setReceiverName("member");
        daifaTrade.setReceiverPhone("123456123");
        daifaTrade.setReceiverState("浙江");
        daifaTrade.setReceiverAddress("天唐");
        daifaTrade.setDaifaType(1);
        daifaTrade.setExpressId(1L);
        daifaTrade.setExpressName("火星速递");
        daifaTrade.setTradeStatus(1);
        daifaTrade.setGoodsFee("2毛");
        daifaTrade.setExpressFee("3毛");
        daifaTrade.setServicesFee("4毛");
        daifaTrade.setTradeDiscountFee("adf");
        daifaTrade.setTotalFee("asdf");
        daifaTrade.setMoney("fasdf");
        daifaTrade.setRealPayMoney("asdjkfh");
        daifaTrade.setTradeCode("46543");
        daifaTradeMapper.insertSelective(daifaTrade);
    }
}
