package com.shigu.main4.daifa.process.impltest;/**
 * Created by pc on 2017-09-20.
 *
 * @author pc
 * @description
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */

import com.opentae.data.daifa.beans.DaifaAfterSale;
import com.opentae.data.daifa.beans.DaifaAfterSaleSub;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleMapper;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleSubMapper;
import com.shigu.main4.daifa.bo.RebackPrintExpressBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.ScanSaleAfterExpressProcess;
import com.shigu.test.BaseSpringTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 *Created By pc on 2017-09-20/10:54
 *
 */
public class ScanSaleAfterExpressProcessImplTest extends BaseSpringTest {

    @Autowired
    private ScanSaleAfterExpressProcess scanSaleAfterExpressProcess;
    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;
    @Autowired
    private DaifaAfterSaleMapper daifaAfterSaleMapper;

    static Long refundId=999999L;
    static Long errorRefundId=888888L;
    static Long daifaAfterSaleId = 1l;
    static Long daifaTradeId = 1l;
    static Long orderId = 2l;

    @Test
    @Transactional
    //换货
    public void rebackPrintExpress_test1() throws DaifaException {
        //插入主表数据
        DaifaAfterSale daifaAfterSale = new DaifaAfterSale();
        daifaAfterSale.setAfterSaleId(daifaAfterSaleId);
        daifaAfterSale.setDfTradeId(daifaTradeId);
        daifaAfterSale.setReceiverState("1");
        daifaAfterSale.setBuyerQq("110");
        daifaAfterSaleMapper.insert(daifaAfterSale);
        daifaAfterSaleMapper.selectByPrimaryKey(daifaAfterSaleId);

        //插入附表数据
        DaifaAfterSaleSub daifaAfterSaleSub = new DaifaAfterSaleSub();
        daifaAfterSaleSub.setAfterSaleSubId(1l);
        daifaAfterSaleSub.setRefundId(refundId);
        daifaAfterSaleSub.setAfterSaleId(daifaAfterSaleId);
        daifaAfterSaleSub.setDfOrderId(orderId);
        daifaAfterSaleSub.setRemark("remark1");

        daifaAfterSaleSub.setAfterType(2);//售后类型@1退货2换货
        int effectNum = daifaAfterSaleSubMapper.insert(daifaAfterSaleSub);
        assertEquals(1,effectNum);

        RebackPrintExpressBO  bo = new RebackPrintExpressBO();
        bo.setChangeExpressCode("换货");
        bo.setChangeExpressName("换货快递");

        bo.setOrderId(orderId);
        bo.setRemark("remark2");
        scanSaleAfterExpressProcess.rebackPrintExpress(bo);

        DaifaAfterSaleSub result = daifaAfterSaleSubMapper.selectByPrimaryKey(1l);
        Assert.assertNotNull(result.getLastDoTime());
        assertEquals("remark1:remark2",result.getRemark());
        assertEquals(bo.getChangeExpressCode(),result.getChangeExpressCode());
        assertEquals(bo.getChangeExpressName(),result.getChangeExpressName());
    }

    @Test
    @Transactional
    //退货
    public void rebackPrintExpress_test2() throws DaifaException {
        //插入主表数据
        DaifaAfterSale daifaAfterSale = new DaifaAfterSale();
        daifaAfterSale.setAfterSaleId(daifaAfterSaleId);
        daifaAfterSale.setDfTradeId(daifaTradeId);
        daifaAfterSale.setReceiverState("1");
        daifaAfterSale.setBuyerQq("110");
        daifaAfterSaleMapper.insert(daifaAfterSale);
        daifaAfterSaleMapper.selectByPrimaryKey(daifaAfterSaleId);

        //插入附表数据
        DaifaAfterSaleSub daifaAfterSaleSub = new DaifaAfterSaleSub();
        daifaAfterSaleSub.setAfterSaleSubId(1l);
        daifaAfterSaleSub.setRefundId(refundId);
        daifaAfterSaleSub.setAfterSaleId(daifaAfterSaleId);
        daifaAfterSaleSub.setDfOrderId(orderId);
        daifaAfterSaleSub.setRemark("remark1");

        daifaAfterSaleSub.setAfterType(1);//售后类型@1退货2换货
        int effectNum = daifaAfterSaleSubMapper.insert(daifaAfterSaleSub);
        assertEquals(1,effectNum);

        RebackPrintExpressBO  bo = new RebackPrintExpressBO();
        bo.setReturnExpressCode("退货");
        bo.setChangeExpressName("退货快递");

        bo.setOrderId(orderId);
        bo.setRemark("remark2");
        scanSaleAfterExpressProcess.rebackPrintExpress(bo);

        DaifaAfterSaleSub result = daifaAfterSaleSubMapper.selectByPrimaryKey(1l);
        Assert.assertNotNull(result.getLastDoTime());
        assertEquals("remark1:remark2",result.getRemark());
        assertEquals(bo.getReturnExpressCode(),result.getReturnExpressCode());
        assertEquals(bo.getReturnExpressName(),result.getReturnExpressName());

    }

}
