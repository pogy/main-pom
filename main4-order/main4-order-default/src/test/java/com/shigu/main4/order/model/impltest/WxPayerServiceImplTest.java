package com.shigu.main4.order.model.impltest;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.PayerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * 微信支付测试
 * Created by bugzy on 2017/6/14 0014.
 */
public class WxPayerServiceImplTest extends BaseTest {

    @Resource(name = "wxPayerService")
    private PayerService payerService;

    @Test
    public void payApply() throws Exception {
        show(payerService.payApply(9968L, 1L, "订单测试",1L));
    }

    @Test
    public void refund() throws Exception {
        payerService.refund(2L, 1L);
    }

    @Test
    public void selApply() throws Exception {
        show(payerService.selApply(2L));
    }

    @Test
    public void paySure() throws Exception {
        payerService.paySure(2L, "81231434123123", "Q_Q", 1L);
    }

    @Test
    public void payedLeft(){
        show(payerService.payedLeft(1L));
    }

}