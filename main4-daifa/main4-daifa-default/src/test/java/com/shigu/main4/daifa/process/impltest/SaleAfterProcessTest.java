package com.shigu.main4.daifa.process.impltest;

import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.DaifaAfterMoneyConsultExample;
import com.opentae.data.daifa.examples.DaifaAfterSaleSubExample;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.daifa.bo.ExpressScanInStockBO;
import com.shigu.main4.daifa.bo.MoneyConsultBO;
import com.shigu.main4.daifa.bo.SaleAfterBO;
import com.shigu.main4.daifa.bo.SaleAfterExpressBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.SaleAfterProcess;
import com.shigu.main4.daifa.process.ScanSaleAfterExpressProcess;
import com.shigu.main4.daifa.vo.ExpressRelevanceSubVO;
import com.shigu.main4.daifa.vo.ExpressRelevanceVO;
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

public class SaleAfterProcessTest extends BaseSpringTest {
    @Autowired
    private SaleAfterProcess saleAfterProcess;
    @Autowired
    private ScanSaleAfterExpressProcess scanSaleAfterExpressProcess;

    @Autowired
    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    private DaifaOrderMapper daifaOrderMapper;
    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;
    @Autowired
    private DaifaAfterSaleMapper daifaAfterSaleMapper;
    @Autowired
    private DaifaAfterReceiveExpresStockMapper daifaAfterReceiveExpresStockMapper;
    @Autowired
    private DaifaAfterMoneyConsultMapper daifaAfterMoneyConsultMapper;

    static Long refundId = 999999L;
    static Long errorRefundId = 888888L;

    static String postCode = "111111111";
    static String errPostCode = "111111112";
    static String postName = "STO";
    static String sendPhone = "18969041771";
    static String huojia = "1";
    static String errorHuojia = "2";

    @Test
@Transactional
//    售后写入
    public void newSaleAfter_test() {
        DaifaTradeExample daifaTradeExample = new DaifaTradeExample();
        daifaTradeExample.createCriteria().andSendStatusEqualTo(2).andGoodsNumGreaterThan(1L).andDfTradeIdEqualTo(62017090295790L);
        daifaTradeExample.setOrderByClause("df_trade_id desc");
        daifaTradeExample.setEndIndex(1);
        Map<String, List<DaifaOrder>> orderGroup;
        DaifaTrade trade;
        List<DaifaOrder> orders;
        int i = 0;
        while (true) {
            daifaTradeExample.setStartIndex(i);
            List<DaifaTrade> trades = daifaTradeMapper.selectByConditionList(daifaTradeExample);
            trade = trades.get(0);
            DaifaOrder tmpOrder = new DaifaOrder();
            tmpOrder.setDfTradeId(trade.getDfTradeId());
            orders = daifaOrderMapper.select(tmpOrder);
            orderGroup = new HashMap<>();
            for (DaifaOrder order : orders) {
                List<DaifaOrder> os = orderGroup.get(order.getGoodsId() + order.getPropStr());
                if (os == null) {
                    os = new ArrayList<>();
                }
                os.add(order);
                orderGroup.put(order.getGoodsId() + order.getPropStr(), os);
            }
            List<String> keys = new ArrayList<>(orderGroup.keySet());
            if (orderGroup.get(keys.get(0)).size() > 1) {
                break;
            }
            i++;
        }
        List<String> keys = new ArrayList<>(orderGroup.keySet());
        //测试一,订单不存在
        SaleAfterBO bo = new SaleAfterBO();
        bo.setAfterType(1);
        bo.setNum(1);
        bo.setReason("测试");
        bo.setRefundId(refundId);
        bo.setSubOid(-10L);
        boolean isError = false;
        try {
            saleAfterProcess.newSaleAfter(bo);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "订单不存在");
        }
        assertTrue(isError);
        //测试二,申请的售后的件数大于可申请售后的数量
        List<DaifaOrder> tmpOrders = orderGroup.get(keys.get(0));
        bo = new SaleAfterBO();
        bo.setAfterType(1);
        bo.setNum(tmpOrders.size() + 1);
        bo.setReason("测试");
        bo.setRefundId(refundId);
        bo.setSubOid(new Long(tmpOrders.get(0).getOrderCode()));
        isError = false;
        try {
            saleAfterProcess.newSaleAfter(bo);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "申请的售后的件数大于可申请售后的数量");
        }
        assertTrue(isError);
        //测试三,未发货订单
        DaifaOrderExample testOrderExample = new DaifaOrderExample();
        testOrderExample.createCriteria().andOrderStatusLessThan(3).andRefundIdIsNull();
        testOrderExample.setOrderByClause("df_order_id desc");
        testOrderExample.setStartIndex(0);
        testOrderExample.setEndIndex(1);
        DaifaOrder testOrder = daifaOrderMapper.selectByConditionList(testOrderExample).get(0);
        bo = new SaleAfterBO();
        bo.setAfterType(1);
        bo.setNum(1);
        bo.setReason("测试");
        bo.setRefundId(refundId);
        bo.setSubOid(new Long(testOrder.getOrderCode()));
        isError = false;
        try {
            saleAfterProcess.newSaleAfter(bo);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "未发货,不能申请售后");
        }
        assertTrue(isError);

        //测试四,正常
        bo = new SaleAfterBO();
        bo.setAfterType(1);
        bo.setNum(tmpOrders.size());
        bo.setReason("测试");
        bo.setRefundId(refundId);
        bo.setSubOid(new Long(tmpOrders.get(0).getOrderCode()));
        isError = false;
        try {
            saleAfterProcess.newSaleAfter(bo);
        } catch (DaifaException e) {
            isError = true;
        }
        assertFalse(isError);
        DaifaAfterSale sale = new DaifaAfterSale();
        sale.setDfTradeId(trade.getDfTradeId());
        sale = daifaAfterSaleMapper.selectOne(sale);
        assertNotEquals(sale, null);
        DaifaAfterSaleSub sub = new DaifaAfterSaleSub();
        sub.setAfterSaleId(sale.getAfterSaleId());
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(sub);
        assertEquals(subs.size(), orders.size());
        List<Long> oids = BeanMapper.getFieldList(tmpOrders, "dfOrderId", Long.class);
        for (DaifaAfterSaleSub s : subs) {
            if (oids.contains(s.getDfOrderId())) {
                assertEquals(s.getAfterStatus(), new Integer(1));
                assertEquals(s.getAfterType(), new Integer(1));
                assertEquals(s.getRefundId(), refundId);
                DaifaOrder o = daifaOrderMapper.selectByPrimaryKey(s.getDfOrderId());
                assertEquals(o.getRefundId(), refundId);
                assertEquals(o.getReCause(), "测试");
            } else {
                assertEquals(s.getAfterStatus(), new Integer(0));
                assertEquals(s.getAfterType(), null);
                assertEquals(s.getRefundId(), null);
                DaifaOrder o = daifaOrderMapper.selectByPrimaryKey(s.getDfOrderId());
                assertEquals(o.getReCause(), null);
            }
        }
    }


    //    @Test
//    @Transactional
//    客服处理
    public void afterApplyDeal_test() {
        newSaleAfter_test();
        //测试一,售后不存在
        boolean isError = false;
        try {
            saleAfterProcess.afterApplyDeal(errorRefundId, 1, null);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后申请不存在");
        }
        assertTrue(isError);

        //测试二,状态错误,临时修改状态
        DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(1);
        DaifaAfterSaleSub update = new DaifaAfterSaleSub();
        update.setAfterStatus(2);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);
        isError = false;
        try {
            saleAfterProcess.afterApplyDeal(refundId, 1, null);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后状态错误,不是申请中的订单");
        }
        assertTrue(isError);
        //还原
        update.setAfterStatus(1);
        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(2);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);

        //测试三 拒绝,无理由
        isError = false;
        try {
            saleAfterProcess.afterApplyDeal(refundId, 2, null);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "请填写拒绝理由");
        }
        assertTrue(isError);

        //测试四,正常
        isError = false;
        try {
            saleAfterProcess.afterApplyDeal(refundId, 1, null);
        } catch (DaifaException e) {
            isError = true;
        }
        assertFalse(isError);

        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.selectByExample(daifaAfterSaleSubExample);
        for (DaifaAfterSaleSub sub : subs) {
            assertEquals(sub.getAfterStatus(), new Integer(2));
            assertEquals(sub.getApplyDealStatus(), new Integer(1));
            assertNotEquals(sub.getApplyDealTime(), null);
        }
    }

    //    @Test
//    @Transactional
//    客户填写快递,包裹不存在
    public void saleAfterExpress_test1() {
        afterApplyDeal_test();
        //测试一,售后不存在
        boolean isError = false;
        SaleAfterExpressBO bo = new SaleAfterExpressBO();
        bo.setRefundId(errorRefundId);
        bo.setExpressCode(postCode);
        bo.setExpressName(postName);
        try {
            saleAfterProcess.saleAfterExpress(bo);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后申请不存在");
        }
        assertTrue(isError);

        //测试二,状态错误,临时修改状态
        DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(2);
        DaifaAfterSaleSub update = new DaifaAfterSaleSub();
        update.setAfterStatus(5);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);
        isError = false;
        bo.setRefundId(refundId);
        try {
            saleAfterProcess.saleAfterExpress(bo);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后状态错误,当前状态不能设置退回快递信息");
        }
        assertTrue(isError);
        //还原
        update.setAfterStatus(2);
        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(5);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);

        //测试三,正常
        isError = false;
        try {
            saleAfterProcess.saleAfterExpress(bo);
        } catch (DaifaException e) {
            isError = true;
        }
        assertFalse(isError);
    }

    //    @Test
//    @Transactional
//    客户填写快递,包裹已存在,自动匹配
    public void saleAfterExpress_test2() {
        afterApplyDeal_test();
        expressScanInStock_test();
        //测试一,售后不存在
        boolean isError = false;
        SaleAfterExpressBO bo = new SaleAfterExpressBO();
        bo.setRefundId(errorRefundId);
        bo.setExpressCode(postCode);
        bo.setExpressName(postName);
        try {
            saleAfterProcess.saleAfterExpress(bo);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后申请不存在");
        }
        assertTrue(isError);

        //测试二,状态错误,临时修改状态
        DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(2);
        DaifaAfterSaleSub update = new DaifaAfterSaleSub();
        update.setAfterStatus(5);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);
        isError = false;
        bo.setRefundId(refundId);
        try {
            saleAfterProcess.saleAfterExpress(bo);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后状态错误,当前状态不能设置退回快递信息");
        }
        assertTrue(isError);
        //还原
        update.setAfterStatus(2);
        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(5);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);

        //测试三,正常
        isError = false;
        try {
            saleAfterProcess.saleAfterExpress(bo);
        } catch (DaifaException e) {
            isError = true;
        }
        assertFalse(isError);

        DaifaAfterReceiveExpresStock stock = new DaifaAfterReceiveExpresStock();
        stock.setReceivedExpressCode(postCode);
        List<DaifaAfterReceiveExpresStock> stocks = daifaAfterReceiveExpresStockMapper.select(stock);
        DaifaAfterSaleSub sub = new DaifaAfterSaleSub();
        sub.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(sub);
        assertEquals(stocks.size(), subs.size());
        for (DaifaAfterReceiveExpresStock s : stocks) {
            assertEquals(s.getStockLocation(), huojia);
            assertEquals(s.getSendPhone(), sendPhone);
            assertEquals(s.getRelevanceStatus(), new Integer(1));
            assertNotEquals(s.getDfOrderId(), null);
            assertNotEquals(s.getDfTradeId(), null);
            assertNotEquals(s.getRefundId(), null);
            assertNotEquals(s.getTradeCode(), null);
            assertNotEquals(s.getOrderCode(), null);
            assertEquals(s.getStockLocation(), huojia);
            assertEquals(s.getSendPhone(), sendPhone);
        }
        for (DaifaAfterSaleSub s : subs) {
            assertEquals(s.getInStock(), null);
            assertEquals(s.getAfterStatus(), new Integer(4));
            assertEquals(s.getApplyExpressCode(), postCode);
            assertEquals(s.getApplyExpressName(), postName);
        }
    }

    //    @Test
//    @Transactional
//    扫描快递自动匹配
    public void expressScan_test() {
        saleAfterExpress_test1();
        //测试一,快递单号匹配不到
        List<ExpressRelevanceVO> list = scanSaleAfterExpressProcess.expressScan(errPostCode);
        assertEquals(list.size(), 0);
        //测试二,快递单号匹配
        list = scanSaleAfterExpressProcess.expressScan(postCode);
        assertNotEquals(list.size(), 0);
        int num = 0;
        for (ExpressRelevanceVO vo : list) {
            for (ExpressRelevanceSubVO svo : vo.getChildOrders()) {
                if (svo.getNowScanPostIs()) {
                    num++;
                    assertEquals(svo.getAfterSalePostCode(), postCode);
                }
            }
        }
        assertNotEquals(num, 0);
    }

    //    @Test
//    @Transactional
//    扫描入库
    public void expressScanInStock_test() {
        ExpressScanInStockBO bo = new ExpressScanInStockBO();
        bo.setExpressCode(postCode);
        bo.setExpressName(postName);
        bo.setSendPhone(sendPhone);
        bo.setStockLocation(huojia);
        scanSaleAfterExpressProcess.expressScanInStock(bo);
        DaifaAfterReceiveExpresStock stock = new DaifaAfterReceiveExpresStock();
        stock.setReceivedExpressCode(postCode);
        List<DaifaAfterReceiveExpresStock> stocks = daifaAfterReceiveExpresStockMapper.select(stock);
        assertEquals(stocks.size(), 1);
        assertEquals(stocks.get(0).getStockLocation(), huojia);
        assertEquals(stocks.get(0).getSendPhone(), sendPhone);
        assertEquals(stocks.get(0).getRelevanceStatus(), new Integer(0));
        assertEquals(stocks.get(0).getDfOrderId(), null);
    }


    //    @Test
//    @Transactional
//    售后入库,完全入库
    public void saleInStock_test1() {
        expressScan_test();
        //测试一,售后不存在
        boolean isError = false;
        try {
            saleAfterProcess.saleInStock(-1L, huojia, sendPhone);
        } catch (DaifaException e) {
            assertEquals(e.getMessage(), "售后申请不存在");
            isError = true;
        }
        assertTrue(isError);
        //测试二,状态错误,临时修改状态
        DaifaAfterSaleSub sub = new DaifaAfterSaleSub();
        sub.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(sub);
        DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(4);
        DaifaAfterSaleSub update = new DaifaAfterSaleSub();
        update.setAfterStatus(6);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);
        isError = false;
        try {
            saleAfterProcess.saleInStock(subs.get(0).getDfOrderId(), huojia, sendPhone);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后状态错误,之后收到货的状态或退货失败状态时才能入库");
        }
        assertTrue(isError);
        //还原
        update.setAfterStatus(4);
        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(6);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);

        //测试三,正常
        isError = false;
        for (DaifaAfterSaleSub s : subs) {
            DaifaAfterSaleSub s1 = daifaAfterSaleSubMapper.selectByPrimaryKey(s.getAfterSaleSubId());
            assertEquals(s1.getInStock(), null);
            assertEquals(s1.getStockLocation(), null);
            try {
                saleAfterProcess.saleInStock(s.getDfOrderId(), huojia, sendPhone);
            } catch (DaifaException e) {
                isError = true;
            }
            assertFalse(isError);
            s1 = daifaAfterSaleSubMapper.selectByPrimaryKey(s.getAfterSaleSubId());
            assertEquals(s1.getInStock(), new Integer(1));
            assertEquals(s1.getStockLocation(), huojia);

            DaifaAfterReceiveExpresStock stock = new DaifaAfterReceiveExpresStock();
            stock.setDfOrderId(s1.getDfOrderId());
            stock = daifaAfterReceiveExpresStockMapper.selectOne(stock);
            assertNotEquals(stock, null);
            assertEquals(stock.getSendPhone(), sendPhone);
            assertEquals(stock.getRelevanceStatus(), new Integer(1));
            assertEquals(stock.getStockLocation(), huojia);
        }
    }

    //    @Test
//    @Transactional
//    售后入库,部分入库
    public void saleInStock_test2() {
        expressScan_test();
        //测试一,售后不存在
        boolean isError = false;
        try {
            saleAfterProcess.saleInStock(-1L, huojia, sendPhone);
        } catch (DaifaException e) {
            assertEquals(e.getMessage(), "售后申请不存在");
            isError = true;
        }
        assertTrue(isError);
        //测试二,状态错误,临时修改状态
        DaifaAfterSaleSub sub = new DaifaAfterSaleSub();
        sub.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(sub);
        DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(4);
        DaifaAfterSaleSub update = new DaifaAfterSaleSub();
        update.setAfterStatus(6);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);
        isError = false;
        try {
            saleAfterProcess.saleInStock(subs.get(0).getDfOrderId(), huojia, sendPhone);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后状态错误,之后收到货的状态或退货失败状态时才能入库");
        }
        assertTrue(isError);
        //还原
        update.setAfterStatus(4);
        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(6);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);

        //测试三,正常
        isError = false;
        DaifaAfterSaleSub s1 = daifaAfterSaleSubMapper.selectByPrimaryKey(subs.get(0).getAfterSaleSubId());
        assertEquals(s1.getInStock(), null);
        assertEquals(s1.getStockLocation(), null);
        try {
            saleAfterProcess.saleInStock(subs.get(0).getDfOrderId(), huojia, sendPhone);
        } catch (DaifaException e) {
            isError = true;
        }
        assertFalse(isError);
        s1 = daifaAfterSaleSubMapper.selectByPrimaryKey(subs.get(0).getAfterSaleSubId());
        assertEquals(s1.getInStock(), new Integer(1));
        assertEquals(s1.getStockLocation(), huojia);

        DaifaAfterReceiveExpresStock stock = new DaifaAfterReceiveExpresStock();
        stock.setDfOrderId(s1.getDfOrderId());
        stock = daifaAfterReceiveExpresStockMapper.selectOne(stock);
        assertNotEquals(stock, null);
        assertEquals(stock.getSendPhone(), sendPhone);
        assertEquals(stock.getRelevanceStatus(), new Integer(1));
        assertEquals(stock.getStockLocation(), huojia);

        s1 = daifaAfterSaleSubMapper.selectByPrimaryKey(subs.get(1).getAfterSaleSubId());
        assertEquals(s1.getInStock(), null);
        assertEquals(s1.getStockLocation(), null);
    }

    //    @Test
//    @Transactional
//    全部到货,退失败一件
    public void storeRefundRefuse_test1() {
        saleInStock_test1();
        DaifaAfterSaleSub sub = new DaifaAfterSaleSub();
        sub.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(sub);
        //测试一,售后不存在
        boolean isError = false;
        try {
            saleAfterProcess.storeRefundRefuse(-1L, "测试", errorHuojia);
        } catch (DaifaException e) {
            assertEquals(e.getMessage(), "售后申请不存在");
            isError = true;
        }
        assertTrue(isError);

        //测试二,状态错误,临时修改状态
        DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(4);
        DaifaAfterSaleSub update = new DaifaAfterSaleSub();
        update.setAfterStatus(6);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);
        isError = false;
        try {
            saleAfterProcess.storeRefundRefuse(subs.get(0).getDfOrderId(), "测试", errorHuojia);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后状态错误,未收到货");
        }
        assertTrue(isError);
        //还原
        update.setAfterStatus(4);
        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(6);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);

        //测试三,
        isError = false;
        try {
            saleAfterProcess.storeRefundRefuse(subs.get(0).getDfOrderId(), "测试", errorHuojia);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后状态错误,未收到货");
        }
        assertFalse(isError);
        subs = daifaAfterSaleSubMapper.select(sub);
        assertEquals(subs.get(0).getStockLocation(), errorHuojia);
        assertEquals(subs.get(0).getInStock(), new Integer(2));
        assertEquals(subs.get(0).getAfterStatus(), new Integer(5));
        assertEquals(subs.get(0).getStoreDealStatus(), new Integer(2));
        assertNotEquals(subs.get(0).getStoreDealTime(), null);

        assertEquals(subs.get(1).getStockLocation(), huojia);
        assertEquals(subs.get(1).getInStock(), new Integer(1));
        assertEquals(subs.get(1).getAfterStatus(), new Integer(4));
        assertEquals(subs.get(1).getStoreDealStatus(), null);
        assertEquals(subs.get(1).getStoreDealTime(), null);
    }

    //    @Test
//    @Transactional
//    第一件到货,第一件退失败(即两件都默认失败)
    public void storeRefundRefuse_test2() {
        saleInStock_test2();
        DaifaAfterSaleSub sub = new DaifaAfterSaleSub();
        sub.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(sub);
        //测试一,售后不存在
        boolean isError = false;
        try {
            saleAfterProcess.storeRefundRefuse(-1L, "测试", errorHuojia);
        } catch (DaifaException e) {
            assertEquals(e.getMessage(), "售后申请不存在");
            isError = true;
        }
        assertTrue(isError);

        //测试二,状态错误,临时修改状态
        DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(4);
        DaifaAfterSaleSub update = new DaifaAfterSaleSub();
        update.setAfterStatus(6);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);
        isError = false;
        try {
            saleAfterProcess.storeRefundRefuse(subs.get(0).getDfOrderId(), "测试", errorHuojia);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后状态错误,未收到货");
        }
        assertTrue(isError);
        //还原
        update.setAfterStatus(4);
        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(6);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);

        //测试三,
        isError = false;
        try {
            saleAfterProcess.storeRefundRefuse(subs.get(0).getDfOrderId(), "测试", errorHuojia);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后状态错误,未收到货");
        }
        assertFalse(isError);
        subs = daifaAfterSaleSubMapper.select(sub);
        assertEquals(subs.get(0).getStockLocation(), errorHuojia);
        assertEquals(subs.get(0).getInStock(), new Integer(2));
        assertEquals(subs.get(0).getAfterStatus(), new Integer(5));
        assertEquals(subs.get(0).getStoreDealStatus(), new Integer(2));
        assertNotEquals(subs.get(0).getStoreDealTime(), null);
        assertEquals(subs.get(0).getStoreReturnMoney(), "0.00");

        assertEquals(subs.get(1).getStockLocation(), null);
        assertEquals(subs.get(1).getInStock(), null);
        assertEquals(subs.get(1).getAfterStatus(), new Integer(5));
        assertEquals(subs.get(1).getStoreDealStatus(), new Integer(2));
        assertNotEquals(subs.get(1).getStoreDealTime(), null);
        assertEquals(subs.get(1).getStoreReturnMoney(), "0.00");
    }

    //    @Test
//    @Transactional
//    全部到货,全部退款
    public void storeRefundAgree_test1() {
        saleInStock_test1();
        //测试一,无售后信息
        boolean isError = false;
        try {
            saleAfterProcess.storeRefundAgree(errorRefundId, "10.00");
        } catch (DaifaException e) {
            assertEquals(e.getMessage(), "售后申请不存在");
            isError = true;
        }
        assertTrue(isError);

        //测试二,状态错误,临时修改状态
        DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(4);
        DaifaAfterSaleSub update = new DaifaAfterSaleSub();
        update.setAfterStatus(3);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);
        isError = false;
        try {
            saleAfterProcess.storeRefundAgree(refundId, "10.00");
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后状态错误,未收到货");
        }
        assertTrue(isError);
        //还原
        update.setAfterStatus(4);
        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(3);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);

        //测试三,正常
        isError = false;
        try {
            saleAfterProcess.storeRefundAgree(refundId, "10.00");
        } catch (DaifaException e) {
            isError = true;
        }
        assertFalse(isError);
        DaifaAfterSaleSub sub = new DaifaAfterSaleSub();
        sub.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(sub);
        for (DaifaAfterSaleSub s : subs) {
            assertEquals(s.getAfterStatus(), new Integer(5));
            assertEquals(s.getStoreDealStatus(), new Integer(1));
            assertNotEquals(s.getStoreDealTime(), null);
            assertEquals(s.getStoreReturnMoney(), MoneyUtil.dealPrice(MoneyUtil.StringToLong("10.00") / subs.size()));
        }
    }

    //    @Test
//    @Transactional
//    全部到货,部分退款
    public void storeRefundAgree_test2() {
        storeRefundRefuse_test1();
        //测试一,无售后信息
        boolean isError = false;
        try {
            saleAfterProcess.storeRefundAgree(errorRefundId, "10.00");
        } catch (DaifaException e) {
            assertEquals(e.getMessage(), "售后申请不存在");
            isError = true;
        }
        assertTrue(isError);

        //因为在storeRefundRefuse_test1中已测试状态错误,所以在这边跳过
        //测试二,正常
        isError = false;
        try {
            saleAfterProcess.storeRefundAgree(refundId, "10.00");
        } catch (DaifaException e) {
            isError = true;
        }
        assertFalse(isError);
        DaifaAfterSaleSub sub = new DaifaAfterSaleSub();
        sub.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(sub);

        assertEquals(subs.get(0).getStockLocation(), errorHuojia);
        assertEquals(subs.get(0).getInStock(), new Integer(2));
        assertEquals(subs.get(0).getAfterStatus(), new Integer(5));
        assertEquals(subs.get(0).getStoreDealStatus(), new Integer(2));
        assertNotEquals(subs.get(0).getStoreDealTime(), null);
        assertEquals(subs.get(0).getStoreReturnMoney(), "0.00");

        assertEquals(subs.get(1).getStockLocation(), huojia);
        assertEquals(subs.get(1).getInStock(), new Integer(1));
        assertEquals(subs.get(1).getAfterStatus(), new Integer(5));
        assertEquals(subs.get(1).getStoreDealStatus(), new Integer(1));
        assertNotEquals(subs.get(1).getStoreDealTime(), null);
        assertEquals(subs.get(1).getStoreReturnMoney(), "10.00");
    }

    //    @Test
//    @Transactional
//    第一件到货,第一件退款(第二件会因为没到货而被自动设置为档口拒绝)
    public void storeRefundAgree_test3() {
        saleInStock_test2();
        //测试一,无售后信息
        boolean isError = false;
        try {
            saleAfterProcess.storeRefundAgree(errorRefundId, "10.00");
        } catch (DaifaException e) {
            assertEquals(e.getMessage(), "售后申请不存在");
            isError = true;
        }
        assertTrue(isError);

        //测试二,状态错误,临时修改状态
        DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(4);
        DaifaAfterSaleSub update = new DaifaAfterSaleSub();
        update.setAfterStatus(3);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);
        isError = false;
        try {
            saleAfterProcess.storeRefundAgree(refundId, "10.00");
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "售后状态错误,未收到货");
        }
        assertTrue(isError);
        //还原
        update.setAfterStatus(4);
        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(3);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);
        //测试三,正常
        isError = false;
        try {
            saleAfterProcess.storeRefundAgree(refundId, "10.00");
        } catch (DaifaException e) {
            isError = true;
        }
        assertFalse(isError);
        DaifaAfterSaleSub sub = new DaifaAfterSaleSub();
        sub.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(sub);

        assertEquals(subs.get(0).getStockLocation(), huojia);
        assertEquals(subs.get(0).getInStock(), new Integer(1));
        assertEquals(subs.get(0).getAfterStatus(), new Integer(5));
        assertEquals(subs.get(0).getStoreDealStatus(), new Integer(1));
        assertNotEquals(subs.get(0).getStoreDealTime(), null);
        assertEquals(subs.get(0).getStoreReturnMoney(), "10.00");

        assertEquals(subs.get(1).getStockLocation(), null);
        assertEquals(subs.get(1).getInStock(), null);
        assertEquals(subs.get(1).getAfterStatus(), new Integer(5));
        assertEquals(subs.get(1).getStoreDealStatus(), new Integer(2));
        assertNotEquals(subs.get(1).getStoreDealTime(), null);
        assertEquals(subs.get(1).getStoreReturnMoney(), "0.00");
    }

    //    @Test
//    @Transactional
//    议价
    public void moneyConsultRefuse_test() {
        storeRefundAgree_test1();
        //测试一,售后不存在
        boolean isError = false;
        MoneyConsultBO bo = new MoneyConsultBO();
        bo.setRefundId(errorRefundId);
        try {
            saleAfterProcess.moneyConsultRefuse(bo);
        } catch (DaifaException e) {
            assertEquals(e.getMessage(), "售后申请不存在");
            isError = true;
        }
        assertTrue(isError);
        bo.setRefundId(refundId);
        //测试二,状态错误,临时修改状态
        DaifaAfterSaleSubExample daifaAfterSaleSubExample = new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(5);
        DaifaAfterSaleSub update = new DaifaAfterSaleSub();
        update.setAfterStatus(6);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);
        isError = false;
        try {
            saleAfterProcess.moneyConsultRefuse(bo);
        } catch (DaifaException e) {
            isError = true;
            assertEquals(e.getMessage(), "当前订单状态不可议价");
        }
        assertTrue(isError);
        //还原
        update.setAfterStatus(5);
        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andRefundIdEqualTo(refundId).andAfterStatusEqualTo(6);
        daifaAfterSaleSubMapper.updateByExampleSelective(update, daifaAfterSaleSubExample);

        //测试三,正常
        DaifaAfterMoneyConsult daifaAfterMoneyConsult = new DaifaAfterMoneyConsult();
        daifaAfterMoneyConsult.setRefundId(refundId);
        assertEquals(daifaAfterMoneyConsultMapper.selectCount(daifaAfterMoneyConsult), 0);


        isError = false;
        try {
            saleAfterProcess.moneyConsultRefuse(bo);
        } catch (DaifaException e) {
            isError = true;
        }
        assertFalse(isError);

        List<DaifaAfterMoneyConsult> cs = daifaAfterMoneyConsultMapper.select(daifaAfterMoneyConsult);
        assertEquals(cs.size(), 1);
        assertEquals(cs.get(0).getRefundId(), refundId);
        assertEquals(cs.get(0).getConsultType(), new Integer(2));
        assertEquals(cs.get(0).getConsultBatch(), new Integer(1));

        DaifaAfterSaleSub sub = new DaifaAfterSaleSub();
        sub.setRefundId(refundId);
        List<DaifaAfterSaleSub> subs = daifaAfterSaleSubMapper.select(sub);
        for (DaifaAfterSaleSub s : subs) {
            assertEquals(s.getAfterStatus(), new Integer(7));
        }

        //测试四,重复发起
        isError = false;
        try {
            saleAfterProcess.moneyConsultRefuse(bo);
        } catch (DaifaException e) {
            assertEquals(e.getMessage(), "当前已处于\"拒绝协商金额\"状态");
            isError = true;
        }
        assertTrue(isError);
    }

    @Test
    @Transactional
//    改价
    public void moneyConsult_test() {
        moneyConsultRefuse_test();
        //测试一,议价信息错误
        boolean isError = false;
        try {
            saleAfterProcess.moneyConsult(errorRefundId, "10.00");
        } catch (DaifaException e) {
            assertEquals(e.getMessage(), "议价信息错误");
            isError = true;
        }
        assertTrue(isError);

        //测试二,正常
        isError = false;
        try {
            saleAfterProcess.moneyConsult(refundId, "10.00");
        } catch (DaifaException e) {
            isError = true;
        }
        assertFalse(isError);
        DaifaAfterMoneyConsultExample daifaAfterMoneyConsultExample = new DaifaAfterMoneyConsultExample();
        daifaAfterMoneyConsultExample.createCriteria().andRefundIdEqualTo(refundId);
        daifaAfterMoneyConsultExample.setOrderByClause("after_consult_id asc");
        List<DaifaAfterMoneyConsult> cs = daifaAfterMoneyConsultMapper.selectByExample(daifaAfterMoneyConsultExample);
        assertEquals(cs.size(), 2);
        assertEquals(cs.get(0).getRefundId(), refundId);
        assertEquals(cs.get(0).getConsultType(), new Integer(2));
        assertEquals(cs.get(0).getConsultBatch(), new Integer(1));

        assertEquals(cs.get(1).getRefundId(), refundId);
        assertEquals(cs.get(1).getConsultType(), new Integer(1));
        assertEquals(cs.get(1).getConsultBatch(), new Integer(2));
        assertEquals(cs.get(1).getConsultMoney(), "10.00");

        //测试三,重复
        isError = false;
        try {
            saleAfterProcess.moneyConsult(refundId, "20.00");
        } catch (DaifaException e) {
            isError = true;
        }
        assertFalse(isError);
        daifaAfterMoneyConsultExample.clear();
        daifaAfterMoneyConsultExample.createCriteria().andRefundIdEqualTo(refundId);
        daifaAfterMoneyConsultExample.setOrderByClause("after_consult_id asc");
        cs = daifaAfterMoneyConsultMapper.selectByExample(daifaAfterMoneyConsultExample);
        assertEquals(cs.size(), 2);
        assertEquals(cs.get(0).getRefundId(), refundId);
        assertEquals(cs.get(0).getConsultType(), new Integer(2));
        assertEquals(cs.get(0).getConsultBatch(), new Integer(1));

        assertEquals(cs.get(1).getRefundId(), refundId);
        assertEquals(cs.get(1).getConsultType(), new Integer(1));
        assertEquals(cs.get(1).getConsultBatch(), new Integer(2));
        assertEquals(cs.get(1).getConsultMoney(), "20.00");
    }
}
