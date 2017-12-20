package com.shigu.main4.daifa.model.impltest;

import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaWaitSendExample;
import com.opentae.data.daifa.examples.DaifaWaitSendOrderExample;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.bo.SubOrderModelBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.CargoManModel;
import com.shigu.main4.daifa.model.impl.SubOrderModelImpl;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.test.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class SubOrderModelImplHaveDataTest extends BaseSpringTest {
    @Autowired
    DaifaOrderMapper daifaOrderMapper;
    @Autowired
    DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    DaifaGgoodsMapper daifaGgoodsMapper;
    @Autowired
    DaifaTradeMapper daifaTradeMapper;
    @Autowired
    DaifaWaitSendOrderMapper daifaWaitSendOrderMapper;
    @Autowired
    DaifaWaitSendMapper daifaWaitSendMapper;

//    @Test
//    @Transactional
    public void init_test(){
        insert(999999L,"1-1");
    }

   @Test
//    @Transactional
    public void haveGoodsTime_test() throws DaifaException {//OK
        //Long oid=insert(999999L,"1-1");
        Long oid=40627L;

        Date d=new Date(new Date().getTime()/1000*1000);
        SubOrderModelImpl impl=SpringBeanFactory.getBean(SubOrderModelImpl.class,oid);
        impl.haveGoodsTime(d);

        DaifaOrder order=daifaOrderMapper.selectByPrimaryKey(oid);
        assertEquals(sdf.format(order.getHaveGoodsDate()),sdf.format(d));

        DaifaGgoodsTasks daifaGgoodsTasks=new DaifaGgoodsTasks();
        daifaGgoodsTasks.setDfOrderId(oid);
        List<DaifaGgoodsTasks> ts=daifaGgoodsTasksMapper.select(daifaGgoodsTasks);
        assertNotEquals(ts.size(),0);
        List<Long> tids=new ArrayList<>();
        for(DaifaGgoodsTasks t:ts){
            assertEquals(sdf.format(t.getYouhuoDate()),sdf.format(d));
            if(t.getAllocatStatus()==0){
                tids.add(t.getTasksId());
            }
        }
        //完成后要调用一次缺货//把ggoods表里的数据设置成缺货

        /*CargoManModel bean = SpringBeanFactory.getBean(CargoManModel.class, 2L);
        bean.takeToMe(tids);
        DaifaGgoods daifaGgoods=new DaifaGgoods();
        daifaGgoods.setDfOrderId(oid);
        List<DaifaGgoods> gs=daifaGgoodsMapper.select(daifaGgoods);
        assertNotEquals(gs.size(),0);
        for(DaifaGgoods g:gs){
            assertEquals(sdf.format(g.getYouhuoDate()),sdf.format(d));
        }*/
    }
    @Test
//    @Transactional
    public void markDown_test() throws DaifaException {//OK  40626
        //Long oid=insert(999999L,"1-1");
        Long oid=40626L;
        SubOrderModelImpl impl=SpringBeanFactory.getBean(SubOrderModelImpl.class,oid);
        impl.markDown();

        DaifaOrder order=daifaOrderMapper.selectByPrimaryKey(oid);
        assertEquals(order.getDelistIs(),new Integer(1));

        DaifaGgoodsTasks daifaGgoodsTasks=new DaifaGgoodsTasks();
        daifaGgoodsTasks.setDfOrderId(oid);
        List<DaifaGgoodsTasks> ts=daifaGgoodsTasksMapper.select(daifaGgoodsTasks);
        assertNotEquals(ts.size(),0);
        List<Long> tids=new ArrayList<>();
        for(DaifaGgoodsTasks t:ts){
            assertEquals(t.getDelistIs(),new Integer(1));
            if(t.getAllocatStatus()==0){
                tids.add(t.getTasksId());
            }
        }
//下架调完要再调用一次缺货//把ggoods表里的数据设置成缺货

        /*CargoManModel bean = SpringBeanFactory.getBean(CargoManModel.class, 2L);
        bean.takeToMe(tids);

        DaifaGgoods daifaGgoods=new DaifaGgoods();
        daifaGgoods.setDfOrderId(oid);
        List<DaifaGgoods> gs=daifaGgoodsMapper.select(daifaGgoods);
        assertNotEquals(gs.size(),0);
        for(DaifaGgoods g:gs){
            assertEquals(g.getDelistIs(),new Integer(1));
        }*/
    }

    @Test
//    @Transactional
    public void mark_test() throws DaifaException {//备注//OK
        //Long oid=insert(999999L,"1-1");
        Long oid=40630L;


        SubOrderModelImpl impl=SpringBeanFactory.getBean(SubOrderModelImpl.class,oid);
        impl.mark("子订代发单备注");

        DaifaOrder order=daifaOrderMapper.selectByPrimaryKey(oid);
        assertEquals(order.getOrderRemark(),"子订代发单备注");
        impl.mark("子订代发单备注");
        order=daifaOrderMapper.selectByPrimaryKey(oid);
        assertEquals(order.getOrderRemark(),"子订代发单备注@_@子订代发单备注");

    }


    @Test
//    @Transactional
    public void haveTake_test() throws DaifaException {//OK
        boolean b=false;
        Long oid=40630L;
        SubOrderModelImpl impl=SpringBeanFactory.getBean(SubOrderModelImpl.class,oid);
        try {
            impl.haveTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);

    }
       @Test
//    @Transactional
    public void noTake_test() throws DaifaException {//OK
        Long oid=40627L;
        SubOrderModelImpl impl=SpringBeanFactory.getBean(SubOrderModelImpl.class,oid);
        try {
            impl.noTake ();
        } catch (DaifaException e) {

        }


    }



    private DaifaTrade insertTrade(Long tid){
        DaifaTrade t=new DaifaTrade();
        t.setBarCodeKey("A02");
        t.setBuyerId(100012567L);
        t.setBuyerName("zf");
        t.setBuyerQq("460333383");
        t.setBuyerRemark("aaaa");
        t.setBuyerTelephone("18969041771");
        t.setBuyerNick("zf");
        t.setBuyerWw("a1234526");
        t.setBuyerWx("18969041771");
        t.setCreateTime(new Date());
        t.setDaifaType(2);
        t.setExpressFee("6.00");
        t.setExpressName("申通快递");
        t.setExpressId(68L);
        t.setGoodsFee("100.00");
        t.setGoodsNum(2L);
        t.setMoney("108.00");
        t.setPayStatus(1);
        t.setPayTime(new Date());
        t.setPrintExpressStatus(0);
        t.setRealPayMoney("108.00");
        t.setReceiverAddress("浙江省 杭州市 西湖区 中豪晴园2-2-302");
        t.setReceiverMobile("18969041771");
        t.setReceiverName("张峰");
        t.setReceiverPhone("18969041771");
        t.setReceiverQq("460333383");
        t.setReceiverState("浙江省");
        t.setSellerId(999999999L);
        t.setSellerName("星帮");
        t.setSendStatus(0);
        t.setServicesFee("2.00");
        t.setTaobaoTid(12123465443454L);
        t.setTaobaoUserNick("a1234526");
        t.setTotalFee("108.00");
        t.setTradeCode("order_1");
        t.setTradeDiscountFee("0.00");
        t.setTradeStatus(1);
        t.setDfTradeId(tid);
        daifaTradeMapper.insertSelective(t);

        insert(tid,"1-2");
        insert(tid,"2-2");
        return t;
    }

    private Long insert(Long tid,String code){
        SubOrderModelBO bo=new SubOrderModelBO();
        bo.setAggrement(1);
        bo.setBarCodeKeyNum(code);
        bo.setCid(10000L);
        bo.setDfTradeId(tid);
        bo.setFloorId(1090L);
        bo.setFloorName("3F");
        bo.setGoodsCode("DSA322 Y509 P45");
        bo.setGoodsId(21048206L);
        bo.setGoodsNum(1);
        bo.setMarketId(1087L);
        bo.setMarketName("电商基地");
        bo.setOrderCode("subOrder_1");
        bo.setTradeCode("order_1");
        bo.setOrderDiscountFee("0.00");
        bo.setOrderPartitionId("subOrderFen_1");
        bo.setOrderStatus(1L);
        bo.setPicPath("https://img.alicdn.com/bao/uploaded/i1/850617645/TB2KG8ZXF6.F1JjSZPhXXc_LXXa_!!850617645.jpg");
        bo.setPropStr("灰色:4XL");
        bo.setSinglePay("50.00");
        bo.setSinglePiPrice("50.00");
        bo.setSinglePrice("78.00");
        bo.setSingleServicesFee("1.00");
        bo.setStoreGoodsCode("dsjd_A322_Y509_P45");
        bo.setStoreId(40508L);
        bo.setStoreNum("A322");
        bo.setTitle("港风文艺1 秋季男青少年圆领卫衣宽松韩版学生休闲百搭 Y509 P45");
        bo.setTotalFee("51.00");
        bo.setTotalServiceFee("1.00");
        bo.setSellerId(999999999L);
        bo.setWebSite("hz");
        SubOrderModelImpl impl=SpringBeanFactory.getBean(SubOrderModelImpl.class,bo);

        DaifaOrder order=daifaOrderMapper.selectByPrimaryKey(impl.getSubOrderId());
        DaifaGgoodsTasks task=new DaifaGgoodsTasks();
        task.setDfOrderId(impl.getSubOrderId());
        task=daifaGgoodsTasksMapper.selectOne(task);
        SubOrderModelBO bo1= BeanMapper.map(order,SubOrderModelBO.class);
        SubOrderModelBO bo2= BeanMapper.map(task,SubOrderModelBO.class);
        Field[] fs=SubOrderModelBO.class.getDeclaredFields();
        for(Field f:fs){
            f.setAccessible(true);
            try {
                Object b=f.get(bo);
                if(!f.getName().equals("sellerId")&&!f.getName().equals("webSite"))assertEquals(b,f.get(bo1));
                Object b2=f.get(bo2);
                if(b2!=null)assertEquals(b,b2);
            } catch (IllegalAccessException e) {
                System.out.println(f.getName());
                assertFalse(false);
            }
        }
        assertEquals(order.getDelistIs(),new Integer(0));
        assertEquals(order.getAllocatStatus(),new Integer(0));

        assertEquals(task.getDelistIs(),new Integer(0));
        assertEquals(task.getAllocatStatus(),new Integer(0));
        assertEquals(task.getTakeGoodsDate(),null);
        assertEquals(task.getTakeGoodsStatus(),new Integer(0));
        assertEquals(task.getOperateIs(),new Integer(0));
        assertEquals(task.getUseStatus(),new Integer(1));
        assertEquals(task.getDaifaWorker(),null);
        assertEquals(task.getDaifaWorkerId(),null);
        assertEquals(task.getAllocatDate(),null);
        assertEquals(task.getAllocatTime(),null);
        assertEquals(task.getEndStatus(),new Integer(0));
        assertEquals(task.getGgoodsCode(),null);
        assertEquals(task.getPrintBarcodeStatus(),new Integer(1));
        assertEquals(task.getPrintGoodsStatus(),new Integer(1));
        assertEquals(task.getPrintBatch(),null);
        assertEquals(task.getReturnStatus(),new Integer(0));
        return impl.getSubOrderId();
    }











    public static void main(String[] args) throws InterruptedException {
        Date d=new Date();
        System.out.println(d.getTime());

        Thread.sleep(1000l);
        System.out.println(d.getTime());
    }
}
