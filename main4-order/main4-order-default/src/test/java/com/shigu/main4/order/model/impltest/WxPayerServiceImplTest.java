package com.shigu.main4.order.model.impltest;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.PayerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 微信支付测试
 * Created by bugzy on 2017/6/14 0014.
 */
public class WxPayerServiceImplTest extends BaseTest {

    @Autowired
    private PayerService payerService;

    @Test
    public void payApply() throws Exception {
        show(payerService.payApply(1L, 1L, "订单测试"));
    }

    @Test
    public void refund() throws Exception {
    }

    @Test
    public void selApply() throws Exception {
        show(payerService.selApply(2L));
    }

}