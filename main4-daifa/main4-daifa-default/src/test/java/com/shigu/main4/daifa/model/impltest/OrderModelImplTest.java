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
        subOrderBO.setNum(3);
        List<SubOrderPBO> subOrderPBOS=new ArrayList<>();
        SubOrderPBO s=new SubOrderPBO();
        s.setColor("red");
        s.setFloor("2F");
        s.setFloorId(623L);
        s.setGoodsId(165752L);
        s.setGoodsNo("140");
        s.setMarketId(621L);
        s.setMarketName("四季星座");
        s.setPicUrl("https://img.alicdn.com/bao/uploaded/i4/18874038534868392/T1_s5bFitcXXXXXXXX_!!0-item_pic.jpg");
        s.setSize("XL");
        s.setTitle("精品140 秋装新款大牌时尚休闲运动套装 黑底  W06-P275");
        s.setSinglePay("275.00");
        s.setShopId(16887L);
        s.setSoidp(25L);
        s.setWebSite("hz");
        s.setShopNum("140");
        SubOrderPBO s2=new SubOrderPBO();
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
        s2.setSoidp(26L);
        s2.setWebSite("hz");
        s2.setShopNum("140");
        SubOrderPBO s1=new SubOrderPBO();
        s1.setColor("黑");
        s1.setFloor("其他市场");
        s1.setFloorId(675L);
        s1.setGoodsId(166130L);
        s1.setGoodsNo("DS30-121503");
        s1.setMarketId(674L);
        s1.setMarketName("周边市场");
        s1.setPicUrl("http://img04.taobaocdn.com/bao/uploaded/i4/T1ZIR7FpxnXXXXXXXX_!!0-item_pic.jpg");
        s1.setSize("M");
        s1.setTitle("DSOOG夏季男装V领男士短袖T恤潮纯棉修身简约个性男t DS30-121503");
        s1.setSinglePay("49.00");
        s1.setShopId(16800L);
        s1.setSoidp(24L);
        s1.setWebSite("hz");
        s1.setShopNum("搭尚分销");
        subOrderPBOS.add(s2);
        subOrderPBOS.add(s1);
        subOrderPBOS.add(s);
        subOrderBO.setSubOrderPBOS(subOrderPBOS);
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
       SubOrderBO subOrderBO1=new SubOrderBO();
       subOrderBO1.setNum(1);
       subOrderBO1.setSoid(4567855583L);
       List<SubOrderPBO>subOrderPBOS1=new ArrayList<>();
       SubOrderPBO subOrderPBO23=new SubOrderPBO();
        subOrderPBO23.setColor("蓝色");
        subOrderPBO23.setFloor("13F");
        subOrderPBO23.setFloorId(634L);
        subOrderPBO23.setGoodsId(168663L);
        subOrderPBO23.setGoodsNo("5935 P65");
        subOrderPBO23.setMarketId(621L);
        subOrderPBO23.setMarketName("四季星座");
        subOrderPBO23.setPicUrl("https://img.alicdn.com/bao/uploaded/i1/T1uN2tXbVqXXbSPWk0_034233.jpg");
        subOrderPBO23.setSize("L");
        subOrderPBO23.setTitle("2016新品 多拉链大翻领 男士修身休闲卫衣 5935 P30");
        subOrderPBO23.setSinglePay("6.00");
        subOrderPBO23.setShopId(16418L);
        subOrderPBO23.setSoidp(23L);
        subOrderPBO23.setWebSite("hz");
        subOrderPBO23.setShopNum("1399");
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
        daifaTradeMapper.insertSelective(daifaTrade);
    }
}
