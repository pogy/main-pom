package com.shigu.main4.daifa.process.impltest;

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
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.model.impl.SubOrderModelImpl;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.main4.daifa.vo.PrintTagVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.test.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TakeGoodsIssueProcessImplTest extends BaseSpringTest{
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
    @Autowired
    TakeGoodsIssueProcess takeGoodsIssueProcess;


    @Test
    public void printTags_test(){//OK
        takeGoodsIssueProcess = SpringBeanFactory.getBean(TakeGoodsIssueProcess.class);
        List<Long> issueIds=new ArrayList<> ();
        issueIds.add (9063L);
        issueIds.add (9064L);
        List<PrintTagVO> list_printTag= takeGoodsIssueProcess.printTags (issueIds);
        show (list_printTag.get (0));
        show (list_printTag.get (1));
        show (list_printTag);
    }

//    @Test
//    @Transactional
    public void complete_test() throws DaifaException {
        boolean b=false;
        String date= DateUtil.dateToString(new Date(),DateUtil.patternB);
        try {
            takeGoodsIssueProcess.complete(0L);
        } catch (DaifaException e) {
            assertEquals(e.getMessage(),"未找到分配信息");
            b=true;
        }
        assertTrue(b);
        b=false;
        Long tid=99999L;
        DaifaTrade trade=insertTrade(tid);
        DaifaGgoodsTasks daifaGgoodsTasks=new DaifaGgoodsTasks();
        daifaGgoodsTasks.setDfTradeId(99999L);
        List<DaifaGgoodsTasks> ts=daifaGgoodsTasksMapper.select(daifaGgoodsTasks);
        assertNotEquals(ts.size(),0);
        List<Long> tids=new ArrayList<>();

        for(DaifaGgoodsTasks t:ts){
            if(t.getAllocatStatus()==0){
                tids.add(t.getTasksId());
            }
        }
        CargoManModel bean = SpringBeanFactory.getBean(CargoManModel.class, 2L);
        bean.takeToMe(tids);
        DaifaGgoods daifaGgoods=new DaifaGgoods();
        daifaGgoods.setDfTradeId(99999L);
        List<DaifaGgoods> gs=daifaGgoodsMapper.select(daifaGgoods);
        assertEquals(gs.size(),2);

        System.out.println("拿货完成,制造缺货状态");
        bean.finishTakeGoods();
        try {
            takeGoodsIssueProcess.complete(gs.get(0).getTakeGoodsId());
        } catch (DaifaException e) {
            assertEquals(e.getMessage(),"无效的数据,该ID已操作过拿货完成");
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
        goods.setDfOrderId(gs.get(0).getDfOrderId());
        goods.setUseStatus(1);
        goods.setOperateIs(0);
        goods=daifaGgoodsMapper.selectOne(goods);
        System.out.println("临时修改创建时间,制造测试条件");
        DaifaGgoods g=new DaifaGgoods();
        g.setTakeGoodsId(goods.getTakeGoodsId());
        g.setCreateDate("20170809");
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);
        try {
            takeGoodsIssueProcess.complete(goods.getTakeGoodsId());
        } catch (DaifaException e) {
            assertEquals(e.getMessage(),"不是今天的分配数据");
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("创建时间改回,同时修改有效状态,制造测试条件");
        g.setCreateDate(date);
        g.setUseStatus(0);
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);
        try {
            takeGoodsIssueProcess.complete(goods.getTakeGoodsId());
        } catch (DaifaException e) {
            assertEquals(e.getMessage(),"无效的数据,该ID已操作过拿货完成");
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("恢复数据");
        g.setUseStatus(1);
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);

        System.out.println("开始校验数据");
        takeGoodsIssueProcess.complete(goods.getTakeGoodsId());
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
            if(o.getDfOrderId().longValue()==goods.getDfOrderId()){
                assertEquals(o.getHasNum(),o.getGoodsNum());
                assertEquals(o.getTakeGoodsStatus(),new Integer(1));
            }else{
                oid2=o.getDfOrderId();
                assertEquals(o.getHasNum(),new Integer(0));
                assertEquals(o.getTakeGoodsStatus(),new Integer(0));
            }
        }


        goods=new DaifaGgoods();
        goods.setDfOrderId(gs.get(1).getDfOrderId());
        goods.setUseStatus(1);
        goods.setOperateIs(0);
        goods=daifaGgoodsMapper.selectOne(goods);
        takeGoodsIssueProcess.uncomplete(goods.getTakeGoodsId());
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
    public void uncomplete_test() throws DaifaException {
        boolean b=false;
        String date= DateUtil.dateToString(new Date(),DateUtil.patternB);
        try {
            takeGoodsIssueProcess.uncomplete(0L);
        } catch (DaifaException e) {
            assertEquals(e.getMessage(),"未找到分配信息");
            b=true;
        }
        assertTrue(b);
        b=false;
        Long tid=99999L;
        DaifaTrade trade=insertTrade(tid);
        DaifaGgoodsTasks daifaGgoodsTasks=new DaifaGgoodsTasks();
        daifaGgoodsTasks.setDfTradeId(99999L);
        List<DaifaGgoodsTasks> ts=daifaGgoodsTasksMapper.select(daifaGgoodsTasks);
        assertNotEquals(ts.size(),0);
        List<Long> tids=new ArrayList<>();

        for(DaifaGgoodsTasks t:ts){
            if(t.getAllocatStatus()==0){
                tids.add(t.getTasksId());
            }
        }
        CargoManModel bean = SpringBeanFactory.getBean(CargoManModel.class, 2L);
        bean.takeToMe(tids);
        DaifaGgoods daifaGgoods=new DaifaGgoods();
        daifaGgoods.setDfTradeId(99999L);
        List<DaifaGgoods> gs=daifaGgoodsMapper.select(daifaGgoods);
        assertEquals(gs.size(),2);

        System.out.println("拿货完成,制造缺货状态");
        bean.finishTakeGoods();
        try {
            takeGoodsIssueProcess.uncomplete(gs.get(0).getTakeGoodsId());
        } catch (DaifaException e) {
            assertEquals(e.getMessage(),"无效的数据,该ID已操作过拿货完成");
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
        goods.setDfOrderId(gs.get(0).getDfOrderId());
        goods.setUseStatus(1);
        goods.setOperateIs(0);
        goods=daifaGgoodsMapper.selectOne(goods);
        System.out.println("临时修改创建时间,制造测试条件");
        DaifaGgoods g=new DaifaGgoods();
        g.setTakeGoodsId(goods.getTakeGoodsId());
        g.setCreateDate("20170809");
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);
        try {
            takeGoodsIssueProcess.uncomplete(goods.getTakeGoodsId());
        } catch (DaifaException e) {
            assertEquals(e.getMessage(),"不是今天的分配数据");
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("创建时间改回,同时修改有效状态,制造测试条件");
        g.setCreateDate(date);
        g.setUseStatus(0);
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);
        try {
            takeGoodsIssueProcess.uncomplete(goods.getTakeGoodsId());
        } catch (DaifaException e) {
            assertEquals(e.getMessage(),"无效的数据,该ID已操作过拿货完成");
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("恢复数据");
        g.setUseStatus(1);
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);

        System.out.println("开始校验数据");
        takeGoodsIssueProcess.uncomplete(goods.getTakeGoodsId());
        DaifaWaitSendExample daifaWaitSendExample=new DaifaWaitSendExample();
        daifaWaitSendExample.createCriteria().andDfTradeIdEqualTo(99999L);
        List<DaifaWaitSend> ws=daifaWaitSendMapper.selectByExample(daifaWaitSendExample);
        assertEquals(ws.size(),0);
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andDfOrderIdNotEqualTo(goods.getDfOrderId()).andDfTradeIdEqualTo(goods.getDfTradeId());
        List<DaifaOrder> tmporders=daifaOrderMapper.selectByExample(daifaOrderExample);
        assertEquals(tmporders.size(),1);

        Long oid2=tmporders.get(0).getDfOrderId();


        DaifaGgoods goods2=new DaifaGgoods();
        goods2.setDfOrderId(oid2);
        goods2.setUseStatus(1);
        goods2.setOperateIs(0);
        goods2=daifaGgoodsMapper.selectOne(goods2);
        takeGoodsIssueProcess.complete(goods2.getTakeGoodsId());
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
        daifaWaitSendOrderExample1.createCriteria().andDfTradeIdEqualTo(goods.getDfTradeId());
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
        task2.setDfOrderId(goods.getDfOrderId());
        task2.setAllocatStatus(0);
        task2.setOperateIs(0);
        task2.setTakeGoodsStatus(2);
        task2=daifaGgoodsTasksMapper.selectOne(task2);
        for(Long tsid:tids){
            assertNotEquals(task2.getTasksId(),tsid);
        }
        assertEquals(task2.getAllocatStatus(),new Integer(0));
        assertEquals(task2.getPrintBarcodeStatus(),new Integer(1));
        assertEquals(task2.getPrintGoodsStatus(),new Integer(1));
        assertEquals(task2.getPrintBatch(),null);
        assertEquals(task2.getAllocatTime(),null);
        assertEquals(task2.getAllocatDate(),null);
        assertEquals(task2.getTakeGoodsStatus(),new Integer(2));
    }

    @Test
    @Transactional
    public void uncompleteAllNew_test() throws DaifaException {
        boolean b=false;
        String date= DateUtil.dateToString(new Date(),DateUtil.patternB);
        try {
            takeGoodsIssueProcess.uncompleteAllNew(2L,1L, Collections.singletonList(1L),true);
        } catch (DaifaException e) {
            assertEquals(e.getMessage(),"存在非该拿货员的分配数据");
            b=true;
        }
        assertTrue(b);
        b=false;
        Long tid=99999L;
        DaifaTrade trade=insertTrade(tid);
        DaifaGgoodsTasks daifaGgoodsTasks=new DaifaGgoodsTasks();
        daifaGgoodsTasks.setDfTradeId(99999L);
        List<DaifaGgoodsTasks> ts=daifaGgoodsTasksMapper.select(daifaGgoodsTasks);
        assertNotEquals(ts.size(),0);
        List<Long> tids=new ArrayList<>();
        for(DaifaGgoodsTasks t:ts){
            if(t.getAllocatStatus()==0){
                tids.add(t.getTasksId());
            }
        }
        CargoManModel bean = SpringBeanFactory.getBean(CargoManModel.class, 2L);
        bean.takeToMe(tids);
        DaifaGgoods daifaGgoods=new DaifaGgoods();
        daifaGgoods.setDfTradeId(99999L);
        List<DaifaGgoods> gs=daifaGgoodsMapper.select(daifaGgoods);
        assertEquals(gs.size(),2);
        System.out.println("拿货完成,制造缺货状态");
        bean.finishTakeGoods();
        try {
            takeGoodsIssueProcess.uncompleteAllNew(2L,1L,Collections.singletonList(gs.get(0).getTakeGoodsId()),true);
        } catch (DaifaException e) {
            assertEquals(e.getMessage(),"存在已拿货完成的分配数据");
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
        goods.setDfOrderId(gs.get(0).getDfOrderId());
        goods.setUseStatus(1);
        goods.setOperateIs(0);
        goods=daifaGgoodsMapper.selectOne(goods);
        System.out.println("临时修改创建时间,制造测试条件");
        DaifaGgoods g=new DaifaGgoods();
        g.setTakeGoodsId(goods.getTakeGoodsId());
        g.setCreateDate("20170809");
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);
        try {
            takeGoodsIssueProcess.uncompleteAllNew(2L,1L,Collections.singletonList(goods.getTakeGoodsId()),true);
        } catch (DaifaException e) {
            assertEquals(e.getMessage(),"存在不是今天的分配数据");
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("创建时间改回,同时修改有效状态,制造测试条件");
        g.setCreateDate(date);
        g.setUseStatus(0);
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);
        try {
            takeGoodsIssueProcess.uncompleteAllNew(2L,1L,Collections.singletonList(goods.getTakeGoodsId()),true);
        } catch (DaifaException e) {
            assertEquals(e.getMessage(),"存在无效的分配数据");
            b=true;
        }
        assertTrue(b);
        b=false;
        System.out.println("恢复数据");
        g.setUseStatus(1);
        daifaGgoodsMapper.updateByPrimaryKeySelective(g);

        takeGoodsIssueProcess.uncompleteAllNew(2L,1L,Collections.singletonList(goods.getTakeGoodsId()),true);

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

        DaifaWaitSendOrderExample daifaWaitSendOrderExample1=new DaifaWaitSendOrderExample();
        daifaWaitSendOrderExample1.createCriteria().andDfTradeIdEqualTo(goods.getDfTradeId());
        List<DaifaWaitSendOrder> os1=daifaWaitSendOrderMapper.selectByExample(daifaWaitSendOrderExample1);
        assertEquals(os1.size(),2);
        for(DaifaWaitSendOrder o:os1){
            if(o.getDfOrderId().longValue()== os1.get(0).getDfOrderId()){
                assertEquals(o.getHasNum(),o.getGoodsNum());
                assertEquals(o.getTakeGoodsStatus(),new Integer(1));
            }else{
                assertEquals(o.getHasNum(),new Integer(0));
                assertEquals(o.getTakeGoodsStatus(),new Integer(2));
            }
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
        SubOrderModelImpl impl= SpringBeanFactory.getBean(SubOrderModelImpl.class,bo);

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
}
