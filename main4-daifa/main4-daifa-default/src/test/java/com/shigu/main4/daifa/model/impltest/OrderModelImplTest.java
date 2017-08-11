package com.shigu.main4.daifa.model.impltest;

import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.interfaces.DaifaOrderMapper;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.TypeConvert;
import com.shigu.main4.daifa.bo.*;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.model.impl.OrderModelImpl;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
        OrderBO bo=new OrderBO();
        bo.setSenderId(16546L);
        List<SubOrderBO> subOrders =new ArrayList<>();
        SubOrderBO subOrderBO=new SubOrderBO();
        subOrderBO.setNum(1222);
        subOrderBO.setSinglePay("14654");
        LogisticsBO logisticsBO =new LogisticsBO();
        logisticsBO.setMoney("4131223");
        logisticsBO.setAddress("kadjfhlk");
        logisticsBO.setCity("dsfgds");
        logisticsBO.setProv("asdf");
        logisticsBO.setName("sdgas");
        logisticsBO.setTelephone("gsdg65554");
        logisticsBO.setTown("lasdk");
        logisticsBO.setCompany("sdfgdf");
        logisticsBO.setCompanyId(1235L);
        bo.setType(1);
        ServiceBO serviceBO=new ServiceBO();
        serviceBO.setMoney(134651);
       bo.setOid(46846123L);
       List<LogisticsBO> logisticsBOS=new ArrayList<>();
       logisticsBOS.add(logisticsBO);
       List<SubOrderBO> subOrderBOS=new ArrayList<>();
       subOrderBOS.add(subOrderBO);
       List<ServiceBO>serviceBOS=new ArrayList<>();
       serviceBOS.add(serviceBO);
       bo.setLogistics(logisticsBOS);
       bo.setSubOrders(subOrderBOS);
       bo.setServices(serviceBOS);
        orderModel = SpringBeanFactory.getBean(OrderModel.class,bo);
//        orderModel = SpringBeanFactory.getBean(OrderModel.class,2L);
        show(orderModel);
    }
    @Test
    public void testtimeOut(){
        orderModel = SpringBeanFactory.getBean(OrderModel.class,62017081100004L);
        orderModel.timeout();
    }
    @Test
    @Transactional
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
        orderModel = SpringBeanFactory.getBean(OrderModel.class,62017081100004L);
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
