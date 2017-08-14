package com.shigu.main4.order.model.impltest;


import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.vo.PayApplyVO;
import org.junit.Test;
import javax.annotation.Resource;

public class AlipayServiceImplTest  extends BaseTest {

    @Resource(name="aliPayerService")
    private PayerService aliPayerService;

    @Test
    public void payApply() throws Exception {
        PayApplyVO apply = aliPayerService.payApply(5L, 1L, "iphone 6plus 手机");
        System.out.println(apply.getPayLink());
        show(apply);

    }

    @Test
    public void paySure() throws Exception {
        aliPayerService.paySure(22L, "5", "Q_Q1", 1L);
    }

    @Test
    public void refund() throws Exception {
        aliPayerService.refund(18L,1L);
    }

}
