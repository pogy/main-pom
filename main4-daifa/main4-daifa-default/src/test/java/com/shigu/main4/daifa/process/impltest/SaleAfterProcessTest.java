package com.shigu.main4.daifa.process.impltest;

import com.opentae.data.daifa.beans.DaifaAfterSale;
import com.opentae.data.daifa.beans.DaifaAfterSaleSub;
import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.examples.DaifaAfterSaleSubExample;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleMapper;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleSubMapper;
import com.opentae.data.daifa.interfaces.DaifaOrderMapper;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.daifa.bo.SaleAfterBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.SaleAfterProcess;
import com.shigu.test.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class SaleAfterProcessTest extends BaseSpringTest{
    @Autowired
    private SaleAfterProcess saleAfterProcess;
    @Autowired
    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    private DaifaOrderMapper daifaOrderMapper;
    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;
    @Autowired
    private DaifaAfterSaleMapper daifaAfterSaleMapper;

    static Long refundId=999999L;
    static Long errorRefundId=888888L;

//    @Test
//    @Transactional
    public void newSaleAfter_test(){
        DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
        daifaTradeExample.createCriteria().andSendStatusEqualTo(2).andGoodsNumGreaterThan(1L);
        daifaTradeExample.setOrderByClause("df_trade_id desc");
        daifaTradeExample.setStartIndex(0);
        daifaTradeExample.setEndIndex(1);
        List<DaifaTrade> trades=daifaTradeMapper.selectByConditionList(daifaTradeExample);
        DaifaTrade trade=trades.get(0);

        DaifaOrder tmpOrder=new DaifaOrder();
        tmpOrder.setDfTradeId(trade.getDfTradeId());
        List<DaifaOrder> orders=daifaOrderMapper.select(tmpOrder);

        Map<String,List<DaifaOrder>> orderGroup=new HashMap<>();
        for(DaifaOrder order:orders){
            List<DaifaOrder> os=orderGroup.get(order.getGoodsId()+order.getPropStr());
            if(os==null){
                os=new ArrayList<>();
            }
            os.add(order);
            orderGroup.put(order.getGoodsId()+order.getPropStr(),os);
        }
        List<String> keys=new ArrayList<>(orderGroup.keySet());
        //测试一,订单不存在
        SaleAfterBO bo=new SaleAfterBO();
        bo.setAfterType(1);
        bo.setNum(1);
        bo.setReason("测试");
        bo.setRefundId(refundId);
        bo.setSubOid(-10L);
        boolean isError=false;
        try {
            saleAfterProcess.newSaleAfter(bo);
        } catch (DaifaException e) {
            isError=true;
            assertEquals(e.getMessage(),"订单不存在");
        }
        assertTrue(isError);
        //测试二,申请的售后的件数大于可申请售后的数量
        List<DaifaOrder> tmpOrders=orderGroup.get(keys.get(0));
        bo=new SaleAfterBO();
        bo.setAfterType(1);
        bo.setNum(tmpOrders.size()+1);
        bo.setReason("测试");
        bo.setRefundId(refundId);
        bo.setSubOid(new Long(tmpOrders.get(0).getOrderCode()));
        isError=false;
        try {
            saleAfterProcess.newSaleAfter(bo);
        } catch (DaifaException e) {
            isError=true;
            assertEquals(e.getMessage(),"申请的售后的件数大于可申请售后的数量");
        }
        assertTrue(isError);
        //测试三,未发货订单
        DaifaOrderExample testOrderExample=new DaifaOrderExample();
        testOrderExample.createCriteria().andOrderStatusLessThan(3L);
        testOrderExample.setOrderByClause("df_order_id desc");
        testOrderExample.setStartIndex(0);
        testOrderExample.setEndIndex(1);
        DaifaOrder testOrder=daifaOrderMapper.selectByConditionList(testOrderExample).get(0);
        bo=new SaleAfterBO();
        bo.setAfterType(1);
        bo.setNum(1);
        bo.setReason("测试");
        bo.setRefundId(refundId);
        bo.setSubOid(new Long(testOrder.getOrderCode()));
        isError=false;
        try {
            saleAfterProcess.newSaleAfter(bo);
        } catch (DaifaException e) {
            isError=true;
            assertEquals(e.getMessage(),"未发货,不能申请售后");
        }
        assertTrue(isError);

        //测试四,正常
        bo=new SaleAfterBO();
        bo.setAfterType(1);
        bo.setNum(tmpOrders.size());
        bo.setReason("测试");
        bo.setRefundId(refundId);
        bo.setSubOid(new Long(tmpOrders.get(0).getOrderCode()));
        isError=false;
        try {
            saleAfterProcess.newSaleAfter(bo);
        } catch (DaifaException e) {
            isError=true;
        }
        assertFalse(isError);
        DaifaAfterSale sale=new DaifaAfterSale();
        sale.setDfTradeId(trade.getDfTradeId());
        sale=daifaAfterSaleMapper.selectOne(sale);
        assertNotEquals(sale,null);
        DaifaAfterSaleSub sub=new DaifaAfterSaleSub();
        sub.setAfterSaleId(sale.getAfterSaleId());
        List<DaifaAfterSaleSub> subs=daifaAfterSaleSubMapper.select(sub);
        assertEquals(subs.size(),orders.size());
        List<Long> oids= BeanMapper.getFieldList(tmpOrders,"dfOrderId",Long.class);
        for(DaifaAfterSaleSub s:subs){
            if(oids.contains(s.getDfOrderId())){
                assertEquals(s.getAfterStatus(),new Integer(1));
                assertEquals(s.getAfterType(),new Integer(1));
                assertEquals(s.getRefundId(),refundId);
                DaifaOrder o=daifaOrderMapper.selectByPrimaryKey(s.getDfOrderId());
                assertEquals(o.getRefundId(),refundId);
                assertEquals(o.getReCause(),"测试");
            }else{
                assertEquals(s.getAfterStatus(),new Integer(0));
                assertEquals(s.getAfterType(),null);
                assertEquals(s.getRefundId(),null);
                DaifaOrder o=daifaOrderMapper.selectByPrimaryKey(s.getDfOrderId());
                assertEquals(o.getReCause(),null);
            }
        }
    }


    @Test
    @Transactional
    public void afterApplyDeal_test(){
        newSaleAfter_test();
        boolean isError=false;
        try {
            saleAfterProcess.afterApplyDeal(errorRefundId,1,null);
        } catch (DaifaException e) {
            isError=true;
            assertEquals(e.getMessage(),"售后申请不存在");
        }
        assertTrue(isError);

        //测试二,状态错误,临时修改状态
        DaifaAfterSaleSubExample daifaAfterSaleSubExample=new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(1);
        DaifaAfterSaleSub update=new DaifaAfterSaleSub();
        update.setAfterStatus(2);
        daifaAfterSaleSubMapper.updateByExampleSelective(update,daifaAfterSaleSubExample);
        isError=false;
        try {
            saleAfterProcess.afterApplyDeal(refundId,1,null);
        } catch (DaifaException e) {
            isError=true;
            assertEquals(e.getMessage(),"售后状态错误,不是申请中的订单");
        }
        assertTrue(isError);
        //还原
        update.setAfterStatus(1);
        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(2);
        daifaAfterSaleSubMapper.updateByExampleSelective(update,daifaAfterSaleSubExample);

        //测试三 拒绝,无理由
        isError=false;
        try {
            saleAfterProcess.afterApplyDeal(refundId,2,null);
        } catch (DaifaException e) {
            isError=true;
            assertEquals(e.getMessage(),"请填写拒绝理由");
        }
        assertTrue(isError);

        //测试四,正常
        isError=false;
        try {
            saleAfterProcess.afterApplyDeal(refundId,1,null);
        } catch (DaifaException e) {
            isError=true;
        }
        assertFalse(isError);

        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId);
        List<DaifaAfterSaleSub> subs=daifaAfterSaleSubMapper.selectByExample(daifaAfterSaleSubExample);
        for(DaifaAfterSaleSub sub:subs){
            assertEquals(sub.getAfterStatus(),new Integer(2));
            assertEquals(sub.getApplyDealStatus(),new Integer(1));
            assertNotEquals(sub.getApplyDealTime(),null);
        }
    }


}
