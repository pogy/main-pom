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
import com.shigu.test.BaseSpringTest;
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
public class OrderModelImplTest extends BaseSpringTest{

    OrderModel orderModel;

    @Test
    public void testinit(){
        OrderBO bo=new OrderBO();
        bo.setSenderId(16546L);
        SubOrderBO subOrderBO=new SubOrderBO();
        subOrderBO.setSoid(1234654L);
        subOrderBO.setNum(3);
        subOrderBO.setColor("red");
        subOrderBO.setFloor("2F");
        subOrderBO.setFloorId(623L);
        subOrderBO.setGoodsId(165752L);
        subOrderBO.setGoodsNo("140");
        subOrderBO.setMarketId(621L);
        subOrderBO.setMarketName("四季星座");
        subOrderBO.setPicUrl("https://img.alicdn.com/bao/uploaded/i4/18874038534868392/T1_s5bFitcXXXXXXXX_!!0-item_pic.jpg");
        subOrderBO.setSize("XL");
        subOrderBO.setTitle("精品140 秋装新款大牌时尚休闲运动套装 黑底  W06-P275");
        subOrderBO.setSinglePay("275.00");
        subOrderBO.setShopId(16887L);
        List<Long>soidps= new ArrayList<>();
        soidps.add(25L);
        soidps.add(24L);
        soidps.add(23L);
        subOrderBO.setSoidps(soidps);
        subOrderBO.setWebSite("hz");
        subOrderBO.setShopNum("140");
        /*SubOrderBO s2=new SubOrderBO();
        s2.setColor("red");
        s2.setFloor("2F");
        s2.setFloorId(623L);
        s2.setGoodsId(165752L);
        s2.setGoodsNo("140");
        s2.setMarketId(621L);
        s2.setMarketName("四季星座");
        s2.setPicUrl("https://img.alicdn.com/bao/uploaded/i4/18874038534868392/T1_s5bFitcXXXXXXXX_!!0-item_pic.jpg");
        s2.setSize("XL");
        s2.setTitle("精品140 秋装新款大牌时尚休闲运动套装 黑底  W06-P275");
        s2.setSinglePay("275.00");
        s2.setShopId(16887L);
        s2.setSoid(145556L);
        List<Long>soidps1= new ArrayList<>();
        soidps.add(26L);
        soidps.add(27L);
        soidps.add(28L);
        s2.setSoidps(soidps1);
        s2.setWebSite("hz");
        s2.setShopNum("140");*/
//        s2.setNum(3);

        LogisticsBO logisticsBO =new LogisticsBO();
        logisticsBO.setMoney("12");
        logisticsBO.setAddress("浙江省 杭州市 滨江区 芯图大厦11楼");
        logisticsBO.setCity("杭州市");
        logisticsBO.setProv("浙江省");
        logisticsBO.setName("Mark");
        logisticsBO.setTelephone("13154862568");
        logisticsBO.setTown("滨江区");
        logisticsBO.setCompany("韵达");
        logisticsBO.setCompanyId(6L);
        bo.setType(1);
        ServiceBO serviceBO=new ServiceBO();
        serviceBO.setMoney(10);
       bo.setOid(46846123L);
       List<LogisticsBO> logisticsBOS=new ArrayList<>();
       logisticsBOS.add(logisticsBO);
       List<SubOrderBO> subOrderBOS=new ArrayList<>();
//       subOrderBOS.add(s2);
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
        bo.setMarkDestination("桂林670 001 Q15");
        bo.setExpressCode("3335868078327");
        bo.setPackageName("桂林中转包");
        bo.setSellerId(999999990L);
        bo.setDfTradeId(62017081200035L);
        bo.setReceiverState("广西状族自治区");
        bo.setReceiverName("王春");
        bo.setReceiverPhone("18376225167");
        bo.setExpressId(68L);
        bo.setExpressName("申通快递");
        bo.setReceiverAddress("广西状族自治区 桂林市 七星区 东二环路半塘尾口飞扬画室");
        bo.setCreateDate(DateUtil.dateToString(new Date(),DateUtil.patternB));
        bo.setCreateTime(new Date());
        List<Long> ids=new ArrayList<>();
        ids.add(40444L);
        ids.add(40445L);
        bo.setDfOrderIds(ids);
        orderModel = SpringBeanFactory.getBean(OrderModel.class,62017081200035L);
        orderModel.send(bo);
    }
    @Test
    public void  testauto(){
        List<Long> sub=new ArrayList<>();
        sub.add(1L);
        sub.add(40282L);
        orderModel = SpringBeanFactory.getBean(OrderModel.class,62017081100004L);
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
//        daifaTradeMapper.insertSelective(daifaTrade);
    }
}
