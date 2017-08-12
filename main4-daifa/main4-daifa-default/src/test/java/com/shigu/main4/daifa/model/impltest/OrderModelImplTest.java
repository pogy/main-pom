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
        SubOrderBO subOrderBO=new SubOrderBO();
        subOrderBO.setSoid(1234654L);
        List<SubOrderPBO> subOrderPBOS=new ArrayList<>();
        SubOrderPBO s=new SubOrderPBO();
        s.setColor("dsg");
        s.setFloor("sdfg");
        s.setFloorId(465461L);
        s.setGoodsId(4564321L);
        s.setGoodsNo("sddfgd");
        s.setMarketId(456461L);
        s.setMarketName("电商基地");
        s.setNumber(2);
        s.setPicUrl("sdfgj");
        s.setSize("dfjgl");
        s.setTitle("sdfgh");
        s.setSinglePay("3");
        s.setShopId(46546L);
        s.setSoidp(468461L);
        s.setWebSite("dfj");
        s.setShopNum("flsdf");
        SubOrderPBO s1=new SubOrderPBO();
        s1.setColor("dsg");
        s1.setFloor("sdfg");
        s1.setFloorId(465461L);
        s1.setGoodsId(4564321L);
        s1.setGoodsNo("sddfgd");
        s1.setMarketId(456461L);
        s1.setMarketName("电商基地");
        s1.setNumber(3);
        s1.setPicUrl("sdfgj");
        s1.setSize("dfjgl");
        s1.setTitle("sdfgh");
        s1.setSinglePay("3");
        s1.setShopId(46546L);
        s1.setSoidp(468461L);
        s1.setWebSite("dfj");
        s1.setShopNum("flsdf");
        subOrderPBOS.add(s1);
        subOrderPBOS.add(s);
        subOrderBO.setSubOrderPBOS(subOrderPBOS);
        LogisticsBO logisticsBO =new LogisticsBO();
        logisticsBO.setMoney("5");
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
        serviceBO.setMoney(10);
       bo.setOid(46846123L);
       List<LogisticsBO> logisticsBOS=new ArrayList<>();
       logisticsBOS.add(logisticsBO);
       List<SubOrderBO> subOrderBOS=new ArrayList<>();
       SubOrderBO subOrderBO1=new SubOrderBO();
       subOrderBO1.setSoid(4567855583L);
       List<SubOrderPBO>subOrderPBOS1=new ArrayList<>();
       SubOrderPBO subOrderPBO23=new SubOrderPBO();
        subOrderPBO23.setColor("dsg");
        subOrderPBO23.setFloor("sdfg");
        subOrderPBO23.setFloorId(465461L);
        subOrderPBO23.setGoodsId(4564321L);
        subOrderPBO23.setGoodsNo("sddfgd");
        subOrderPBO23.setMarketId(456461L);
        subOrderPBO23.setMarketName("之地国际");
        subOrderPBO23.setNumber(3);
        subOrderPBO23.setPicUrl("sdfgj");
        subOrderPBO23.setSize("dfjgl");
        subOrderPBO23.setTitle("sdfgh");
        subOrderPBO23.setSinglePay("3");
        subOrderPBO23.setShopId(46546L);
        subOrderPBO23.setSoidp(468461L);
        subOrderPBO23.setWebSite("dfj");
        subOrderPBO23.setShopNum("flsdf");
        subOrderPBOS1.add(subOrderPBO23);
       subOrderBO1.setSubOrderPBOS(subOrderPBOS1);
        subOrderBOS.add(subOrderBO1);
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
