package com.shigu.main4.order.model.impltest;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.model.able.PayerServiceAble;
import com.shigu.main4.order.model.impl.AliPayerServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AlipayServiceImplTest  extends BaseTest {

    @Autowired
    @Qualifier(value = "aliPayerService")
    private PayerServiceAble aliPayerService;

    @Test
    public void payApply() throws Exception {
        aliPayerService.refund(1L,2L);
    }

}
