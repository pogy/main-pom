package com.shigu.main4.daifa.model.impltest;

import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.DaifaGgoodsExample;
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
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SubOrderModelImplTest extends BaseSpringTest {
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

//    @Test
//    @Transactional
    public void haveGoodsTime_test() throws DaifaException {
        Long oid=insert(999999L,"1-1");
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

        CargoManModel bean = SpringBeanFactory.getBean(CargoManModel.class, 2L);
        bean.takeToMe(tids);
        DaifaGgoods daifaGgoods=new DaifaGgoods();
        daifaGgoods.setDfOrderId(oid);
        List<DaifaGgoods> gs=daifaGgoodsMapper.select(daifaGgoods);
        assertNotEquals(gs.size(),0);
        for(DaifaGgoods g:gs){
            assertEquals(sdf.format(g.getYouhuoDate()),sdf.format(d));
        }
    }
    @Test
//    @Transactional
    public void markDown_test() throws DaifaException {//OK  40626//下架调完要再调用一次缺货
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

//    @Test
//    @Transactional
    public void haveTake_test() throws DaifaException {
        String date=DateUtil.dateToString(new Date(),DateUtil.patternB);
        DaifaTrade trade=insertTrade(99999L);
        DaifaGgoodsTasks daifaGgoodsTasks=new DaifaGgoodsTasks();
        daifaGgoodsTasks.setDfTradeId(99999L);
        List<DaifaGgoodsTasks> ts=daifaGgoodsTasksMapper.select(daifaGgoodsTasks);
        assertNotEquals(ts.size(),0);
        List<Long> tids=new ArrayList<>();
        Long oid=null;
        for(DaifaGgoodsTasks t:ts){
            if(t.getAllocatStatus()==0){
                tids.add(t.getTasksId());
                oid=t.getDfOrderId();
            }
        }
        boolean b=false;

        CargoManModel bean = SpringBeanFactory.getBean(CargoManModel.class, 2L);
        bean.takeToMe(tids);

        System.out.println("拿货完成,制造缺货状态");
        bean.finishTakeGoods();
        SubOrderModelImpl impl=SpringBeanFactory.getBean(SubOrderModelImpl.class,oid);
        try {
            impl.haveTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("重新分配");
        ts=daifaGgoodsTasksMapper.select(daifaGgoodsTasks);
        assertNotEquals(ts.size(),0);
        tids=new ArrayList<>();
        for(DaifaGgoodsTasks t:ts){
            if(t.getAllocatStatus()==0){
                tids.add(t.getTasksId());
            }
        }
        bean.takeToMe(tids);
        DaifaGgoods goods=new DaifaGgoods();
        goods.setDfOrderId(oid);
        goods.setUseStatus(1);
        goods.setOperateIs(0);
        goods=daifaGgoodsMapper.selectOne(goods);
        System.out.println("临时修改创建时间,制造测试条件");
        DaifaGgoods g=new DaifaGgoods();
        g.setTakeGoodsId(goods.getTakeGoodsId());
        g.setCreateDate("20170809");
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);
        try {
            impl.haveTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("创建时间改回,同时修改有效状态,制造测试条件");
        g.setCreateDate(date);
        g.setUseStatus(0);
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);
        try {
            impl.haveTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("有效状态改回,同时修改操作状态,制造测试条件");
        g.setUseStatus(1);
        g.setOperateIs(1);
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);
        try {
            impl.haveTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("操作状态改回");
        g.setOperateIs(0);
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);

        System.out.println("测试代发表");
        DaifaGgoodsTasks task=new DaifaGgoodsTasks();
        task.setDfOrderId(oid);
        task.setAllocatStatus(1);
        task.setOperateIs(0);
        task=daifaGgoodsTasksMapper.selectOne(task);
        System.out.println("临时修改分配时间,创造测试条件");
        DaifaGgoodsTasks t=new DaifaGgoodsTasks();
        t.setTasksId(task.getTasksId());
        t.setAllocatDate("20170809");
        daifaGgoodsTasksMapper.updateByPrimaryKeySelective(t);
        try {
            impl.haveTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("分配时间改回,同时修改操作状态");
        t.setAllocatDate(date);
        t.setOperateIs(1);
        daifaGgoodsTasksMapper.updateByPrimaryKeySelective(t);
        try {
            impl.haveTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("操作状态改回,同时修改分配状态");
        t.setOperateIs(0);
        t.setAllocatStatus(0);
        daifaGgoodsTasksMapper.updateByPrimaryKeySelective(t);
        try {
            impl.haveTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("分配状态改回,同时修改退款状态");
        t.setAllocatStatus(1);
        t.setReturnStatus(2);
        daifaGgoodsTasksMapper.updateByPrimaryKeySelective(t);
        try {
            impl.haveTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("退款状态改回,同时修改截单状态");
        t.setReturnStatus(0);
        t.setEndStatus(1);
        daifaGgoodsTasksMapper.updateByPrimaryKeySelective(t);
        try {
            impl.haveTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("截单状态改回");
        t.setEndStatus(0);
        daifaGgoodsTasksMapper.updateByPrimaryKeySelective(t);

        impl.haveTake();
        System.out.println("开始数据校验");
        DaifaWaitSendExample daifaWaitSendExample=new DaifaWaitSendExample();
        daifaWaitSendExample.createCriteria().andDfTradeIdEqualTo(99999L);
        List<DaifaWaitSend> ws=daifaWaitSendMapper.selectByExample(daifaWaitSendExample);
        assertEquals(ws.size(),1);
        DaifaWaitSend w=ws.get(0);
        assertEquals(w.getBuyerId(),trade.getBuyerId());
        assertEquals(w.getBuyerName(),trade.getBuyerName());
        assertEquals(w.getBuyerQq(),trade.getBuyerQq());
        assertEquals(w.getBuyerRemark(),trade.getBuyerRemark());
        assertEquals(w.getBuyerTelephone(),trade.getBuyerTelephone());
        assertEquals(w.getBuyerWw(),trade.getBuyerWw());
        assertEquals(w.getExpressFee(),trade.getExpressFee());
        assertEquals(w.getExpressName(),trade.getExpressName());
        assertEquals(w.getExpressId(),trade.getExpressId());
        assertEquals(w.getMoney(),trade.getMoney());
        assertEquals(w.getReceiverAddress(),trade.getReceiverAddress());
        assertEquals(w.getReceiverName(),trade.getReceiverName());
        assertEquals(w.getReceiverPhone(),trade.getReceiverPhone());
        assertEquals(w.getReceiverQq(),trade.getReceiverQq());
        assertEquals(w.getReceiverState(),trade.getReceiverState());
        assertEquals(w.getSellerId(),trade.getSellerId());
        assertEquals(w.getSendStatus(),new Integer(0));
        assertEquals(w.getStockStatus(),new Integer(0));
        assertEquals(w.getTaobaoTid(),trade.getTaobaoTid());
        assertEquals(w.getTaobaoUserNick(),trade.getTaobaoUserNick());
        assertEquals(w.getTradeCode(),trade.getTradeCode());

        DaifaWaitSendOrderExample daifaWaitSendOrderExample=new DaifaWaitSendOrderExample();
        daifaWaitSendOrderExample.createCriteria().andDwsIdEqualTo(w.getDwsId());
        List<DaifaWaitSendOrder> os=daifaWaitSendOrderMapper.selectByExample(daifaWaitSendOrderExample);
        assertEquals(os.size(),2);
        Long oid2=null;
        for(DaifaWaitSendOrder o:os){
            if(o.getDfOrderId().longValue()==oid){
                assertEquals(o.getHasNum(),o.getGoodsNum());
                assertEquals(o.getTakeGoodsStatus(),new Integer(1));
            }else{
                oid2=o.getDfOrderId();
                assertEquals(o.getHasNum(),new Integer(0));
                assertEquals(o.getTakeGoodsStatus(),new Integer(0));
            }
        }
        SubOrderModelImpl impl2=SpringBeanFactory.getBean(SubOrderModelImpl.class,oid2);
        impl2.noTake();
        ws=daifaWaitSendMapper.selectByExample(daifaWaitSendExample);
        assertEquals(ws.size(),1);
        DaifaWaitSendOrderExample daifaWaitSendOrderExample1=new DaifaWaitSendOrderExample();
        daifaWaitSendOrderExample1.createCriteria().andDwsIdEqualTo(w.getDwsId());
        List<DaifaWaitSendOrder> os1=daifaWaitSendOrderMapper.selectByExample(daifaWaitSendOrderExample1);
        assertEquals(os1.size(),2);
        for(DaifaWaitSendOrder o:os1){
            if(o.getDfOrderId().longValue()==oid2){
                assertEquals(o.getHasNum(),new Integer(0));
                assertEquals(o.getTakeGoodsStatus(),new Integer(2));
            }else{
                assertEquals(o.getHasNum(),o.getGoodsNum());
                assertEquals(o.getTakeGoodsStatus(),new Integer(1));
            }
        }
    }

//    @Test
//    @Transactional
    public void noTake_test() throws DaifaException {
        boolean b=false;
        String date=DateUtil.dateToString(new Date(),DateUtil.patternB);
        DaifaTrade trade=insertTrade(99999L);
        DaifaGgoodsTasks daifaGgoodsTasks=new DaifaGgoodsTasks();
        daifaGgoodsTasks.setDfTradeId(99999L);
        List<DaifaGgoodsTasks> ts=daifaGgoodsTasksMapper.select(daifaGgoodsTasks);
        assertNotEquals(ts.size(),0);
        List<Long> tids=new ArrayList<>();
        Long oid=null;
        for(DaifaGgoodsTasks t:ts){
            if(t.getAllocatStatus()==0){
                tids.add(t.getTasksId());
                oid=t.getDfOrderId();
            }
        }
        CargoManModel bean = SpringBeanFactory.getBean(CargoManModel.class, 2L);
        bean.takeToMe(tids);

        System.out.println("拿货完成,制造缺货状态");
        bean.finishTakeGoods();
        SubOrderModelImpl impl=SpringBeanFactory.getBean(SubOrderModelImpl.class,oid);
        try {
            impl.noTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("重新分配");
        ts=daifaGgoodsTasksMapper.select(daifaGgoodsTasks);
        assertNotEquals(ts.size(),0);
        tids=new ArrayList<>();
        for(DaifaGgoodsTasks t:ts){
            if(t.getAllocatStatus()==0){
                tids.add(t.getTasksId());
            }
        }
        bean.takeToMe(tids);
        DaifaGgoods goods=new DaifaGgoods();
        goods.setDfOrderId(oid);
        goods.setUseStatus(1);
        goods.setOperateIs(0);
        goods=daifaGgoodsMapper.selectOne(goods);
        System.out.println("临时修改有效状态,制造测试条件");
        DaifaGgoods g=new DaifaGgoods();
        g.setTakeGoodsId(goods.getTakeGoodsId());
        g.setCreateDate(date);
        g.setUseStatus(0);
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);
        try {
            impl.noTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("有效状态改回,同时修改操作状态,制造测试条件");
        g.setUseStatus(1);
        g.setOperateIs(1);
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);
        try {
            impl.noTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("操作状态改回");
        g.setOperateIs(0);
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);

        System.out.println("测试代发表");
        DaifaGgoodsTasks task=new DaifaGgoodsTasks();
        task.setDfOrderId(oid);
        task.setAllocatStatus(1);
        task.setOperateIs(0);
        task=daifaGgoodsTasksMapper.selectOne(task);
        System.out.println("临时修改操作状态,创造测试条件");
        DaifaGgoodsTasks t=new DaifaGgoodsTasks();
        t.setTasksId(task.getTasksId());
        t.setOperateIs(1);
        daifaGgoodsTasksMapper.updateByPrimaryKeySelective(t);
        try {
            impl.noTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("操作状态改回,同时修改分配状态");
        t.setOperateIs(0);
        t.setAllocatStatus(0);
        daifaGgoodsTasksMapper.updateByPrimaryKeySelective(t);
        try {
            impl.noTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("分配状态改回,同时修改退款状态");
        t.setAllocatStatus(1);
        t.setReturnStatus(2);
        daifaGgoodsTasksMapper.updateByPrimaryKeySelective(t);
        try {
            impl.noTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("退款状态改回,同时修改截单状态");
        t.setReturnStatus(0);
        t.setEndStatus(1);
        daifaGgoodsTasksMapper.updateByPrimaryKeySelective(t);
        try {
            impl.noTake();
        } catch (DaifaException e) {
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("截单状态改回");
        t.setEndStatus(0);
        daifaGgoodsTasksMapper.updateByPrimaryKeySelective(t);

        impl.noTake();
        System.out.println("开始数据校验");
        DaifaWaitSendExample daifaWaitSendExample=new DaifaWaitSendExample();
        daifaWaitSendExample.createCriteria().andDfTradeIdEqualTo(99999L);
        List<DaifaWaitSend> ws=daifaWaitSendMapper.selectByExample(daifaWaitSendExample);
        assertEquals(ws.size(),0);

        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andDfOrderIdNotEqualTo(oid).andDfTradeIdEqualTo(task.getDfTradeId());
        List<DaifaOrder> tmporders=daifaOrderMapper.selectByExample(daifaOrderExample);
        assertEquals(tmporders.size(),1);

        Long oid2=tmporders.get(0).getDfOrderId();
        SubOrderModelImpl impl2=SpringBeanFactory.getBean(SubOrderModelImpl.class,oid2);
        impl2.haveTake();
        ws=daifaWaitSendMapper.selectByExample(daifaWaitSendExample);
        assertEquals(ws.size(),1);

        DaifaWaitSend w=ws.get(0);
        assertEquals(w.getBuyerId(),trade.getBuyerId());
        assertEquals(w.getBuyerName(),trade.getBuyerName());
        assertEquals(w.getBuyerQq(),trade.getBuyerQq());
        assertEquals(w.getBuyerRemark(),trade.getBuyerRemark());
        assertEquals(w.getBuyerTelephone(),trade.getBuyerTelephone());
        assertEquals(w.getBuyerWw(),trade.getBuyerWw());
        assertEquals(w.getExpressFee(),trade.getExpressFee());
        assertEquals(w.getExpressName(),trade.getExpressName());
        assertEquals(w.getExpressId(),trade.getExpressId());
        assertEquals(w.getMoney(),trade.getMoney());
        assertEquals(w.getReceiverAddress(),trade.getReceiverAddress());
        assertEquals(w.getReceiverName(),trade.getReceiverName());
        assertEquals(w.getReceiverPhone(),trade.getReceiverPhone());
        assertEquals(w.getReceiverQq(),trade.getReceiverQq());
        assertEquals(w.getReceiverState(),trade.getReceiverState());
        assertEquals(w.getSellerId(),trade.getSellerId());
        assertEquals(w.getSendStatus(),new Integer(0));
        assertEquals(w.getStockStatus(),new Integer(0));
        assertEquals(w.getTaobaoTid(),trade.getTaobaoTid());
        assertEquals(w.getTaobaoUserNick(),trade.getTaobaoUserNick());
        assertEquals(w.getTradeCode(),trade.getTradeCode());

        DaifaWaitSendOrderExample daifaWaitSendOrderExample1=new DaifaWaitSendOrderExample();
        daifaWaitSendOrderExample1.createCriteria().andDfTradeIdEqualTo(task.getDfTradeId());
        List<DaifaWaitSendOrder> os1=daifaWaitSendOrderMapper.selectByExample(daifaWaitSendOrderExample1);
        assertEquals(os1.size(),2);
        for(DaifaWaitSendOrder o:os1){
            if(o.getDfOrderId().longValue()==oid2){
                assertEquals(o.getHasNum(),o.getGoodsNum());
                assertEquals(o.getTakeGoodsStatus(),new Integer(1));
            }else{
                assertEquals(o.getHasNum(),new Integer(0));
                assertEquals(o.getTakeGoodsStatus(),new Integer(2));
            }
        }


        DaifaGgoodsTasks task2=new DaifaGgoodsTasks();
        task2.setDfOrderId(oid);
        task2.setAllocatStatus(0);
        task2.setOperateIs(0);
        task2.setTakeGoodsStatus(2);
        task2=daifaGgoodsTasksMapper.selectOne(task2);
        assertNotEquals(task2.getTasksId(),task.getTasksId());
        assertEquals(task2.getAllocatStatus(),new Integer(0));
        assertEquals(task2.getPrintBarcodeStatus(),new Integer(1));
        assertEquals(task2.getPrintGoodsStatus(),new Integer(1));
        assertEquals(task2.getPrintBatch(),null);
        assertEquals(task2.getAllocatTime(),null);
        assertEquals(task2.getAllocatDate(),null);
        assertEquals(task2.getTakeGoodsStatus(),new Integer(2));
        task=daifaGgoodsTasksMapper.selectByPrimaryKey(task.getTasksId());
        assertEquals(task.getTakeGoodsStatus(),new Integer(2));

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
