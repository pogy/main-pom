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
    public void testinit(){//OK

        Long oidinit=10000000L;
        Long soidp=50L;
        for(int i=0;i<10;i++) {
            Long oid=oidinit+1;
            soidp+=10;


            ServiceBO serviceBO = new ServiceBO ();
            serviceBO.setMoney ("3.00");

            serviceBO.setSoid (oid+100);

            ServiceBO sO2 = new ServiceBO ();
            sO2.setMoney ("1.00");
            sO2.setSoid (oid+101);

            List<ServiceBO> serviceBOS = new ArrayList<> ();
            serviceBOS.add (serviceBO);
            serviceBOS.add (sO2);


            OrderBO bo = new OrderBO ();
            bo.setOid (oid);
            bo.setSenderId (999999990L);
            bo.setBuyRemark ("买家备注");
            SubOrderBO subOrderBO = new SubOrderBO ();
            subOrderBO.setSoid (oid+100);
            List<Long> soidps = new ArrayList<> ();
            soidps.add (soidp);
            soidps.add (soidp+1);
            soidps.add (soidp+2);
            subOrderBO.setSoidps (soidps);

            subOrderBO.setNum (3);
            subOrderBO.setGoodsId (9311536L);
            subOrderBO.setGoodsNo ("C04");
            subOrderBO.setTitle ("2016秋季新款 青年男士韩版修身纯色长袖衬衫潮C04P30");
            subOrderBO.setPicUrl ("https://img.alicdn.com/bao/uploaded/i2/889300233/TB2jXldaXrB11BjSspjXXciYpXa_!!889300233.jpg");
            subOrderBO.setMarketId (621L);
            subOrderBO.setMarketName ("四季星座网");
            subOrderBO.setFloorId (630L);
            subOrderBO.setFloor ("9F");
            subOrderBO.setShopId (40680L);
            subOrderBO.setShopNum ("900B");
            subOrderBO.setColor ("白色");
            subOrderBO.setSize ("4XL");
            subOrderBO.setSinglePay ("30.00");
            subOrderBO.setWebSite ("hz");


            SubOrderBO s2 = new SubOrderBO ();
            s2.setSoid (oid+101);
            s2.setNum (1);
            s2.setGoodsId (21076838L);
            s2.setGoodsNo ("A268-JK121");
            s2.setTitle ("秋季夹克韩版男士外套潮男装青少年牛仔夹克学生A268-JK121-P78");
            s2.setPicUrl ("https://img.alicdn.com/bao/uploaded/i1/1600266804/TB2oEeuawL8F1JjSsphXXXknVXa_!!1600266804.jpg");
            s2.setSize ("L");
            s2.setColor ("白色");

            s2.setMarketId (1087L);
            s2.setMarketName ("电商基地");
            s2.setFloorId (1089L);
            s2.setFloor ("2F");
            s2.setShopId (41700L);
            s2.setShopNum ("A268");
            //批发价
            s2.setSinglePay ("78.00");


            List<Long> soidps1 = new ArrayList<> ();
            soidps1.add (soidp+3);

            s2.setSoidps (soidps1);
            s2.setWebSite ("hz");


            LogisticsBO logisticsBO = new LogisticsBO ();
            logisticsBO.setMoney ("12.00");
            logisticsBO.setAddress ("芯图大厦11楼");
            logisticsBO.setCity ("杭州市");
            logisticsBO.setProv ("浙江省");
            logisticsBO.setName ("Mark");
            logisticsBO.setTelephone ("13154862568");
            logisticsBO.setTown ("滨江区");
            logisticsBO.setCompany ("申通快递");
            logisticsBO.setCompanyId (68L);
            bo.setType (1);


            List<LogisticsBO> logisticsBOS = new ArrayList<> ();
            logisticsBOS.add (logisticsBO);
            List<SubOrderBO> subOrderBOS = new ArrayList<> ();
            subOrderBOS.add (subOrderBO);
            subOrderBOS.add (s2);


            bo.setLogistics (logisticsBOS);
            bo.setSubOrders (subOrderBOS);
            bo.setServices (serviceBOS);
            BuyerBO buyerBO = new BuyerBO ();
            buyerBO.setNickInMarket ("小红");
            buyerBO.setPhone ("13523656891");
//            bo.setBuyerBO (buyerBO);
            orderModel = SpringBeanFactory.getBean (OrderModel.class, bo);
//        orderModel = SpringBeanFactory.getBean(OrderModel.class,2L);
            show (orderModel);

        }

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
    public void  testauto() throws DaifaException {
        List<Long> sub=new ArrayList<>();
        //sub.add(1L);
        sub.add(379726L);
        orderModel = SpringBeanFactory.getBean(OrderModel.class,62017100804174L);
        orderModel.autoRefund(39967L,sub);
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
