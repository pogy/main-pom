package com.shigu.main4.order.model.impltest;

import com.openJar.beans.sgpay.XzbPayTrade;
import com.openJar.requests.sgpay.XzbPayRequest;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.PayerService;
import com.shigu.tools.XzSdkClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class XzPayerServiceImplTest extends BaseTest {
    @Autowired
    private PayerService xzPayerService;
    @Autowired
    private XzSdkClient xzSdkClient;

    @Autowired
    ItemOrderMapper itemOrderMapper;

    @Test
    public void payApply() throws Exception {
        show(xzPayerService.payApply(9968L, 1L, "订单测试XZy1234",1234L));
    }


//    @Test
    public void selApply() throws Exception {
        show(xzPayerService.selApply(9L));
    }

    @Test
    public void payOrder() throws Exception {
        com.opentae.data.mall.beans.ItemOrder iOrder  = new com.opentae.data.mall.beans.ItemOrder();
        iOrder.setSenderId(1L);
        iOrder.setOid(1234L);
        iOrder.setType(1);
        iOrder.setTotalFee(1L);
        iOrder.setPayedFee(1L);
        iOrder.setRefundFee(1L);
        iOrder.setUserId(9968L);
        iOrder.setOrderStatus(3);
        itemOrderMapper.insertSelective(iOrder);

        XzbPayRequest xzbPayRequest = new XzbPayRequest();
        xzbPayRequest.setXzUserId(9968L);
        XzbPayTrade trade = new XzbPayTrade();
        trade.setOuterId("1234");
        trade.setTotalFee(1L);
        xzbPayRequest.setTrade(trade);
        show(xzSdkClient.getPcOpenClient().execute(xzbPayRequest));

    }

    @Test
    public void paySure() throws Exception {
        xzPayerService.paySure(9L, "81231434123127", "Q_Q1", 1L);
    }


    @Test
    public void refund() throws Exception {
        xzPayerService.refund(16L, 1L);
    }



//    @Test
    public void payedLeft() {
        show(xzPayerService.payedLeft(1L));
    }
}
