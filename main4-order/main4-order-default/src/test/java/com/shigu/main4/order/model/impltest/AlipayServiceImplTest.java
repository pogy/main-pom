package com.shigu.main4.order.model.impltest;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.vo.PayApplyVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class AlipayServiceImplTest  extends BaseTest {

    @Autowired
    private AlipayClient alipayClient;

    @Resource(name="aliPayerService")
    private PayerService aliPayerService;

    @Test
    public void payApply() throws Exception {
        PayApplyVO apply = aliPayerService.payApply(9968L, 1L, "iphone 6plus 手机",5L);
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

    @Test
    public void refundTrue() throws PayerException {

        //查出第几次退
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "    \"out_trade_no\":\"" + 66510 +"\"," +
                "    \"refund_amount\":" + String.format("%,.2f", 796 * .01)  + "," +
                "    \"refund_reason\":\"正常退款\"," +
                "    \"out_request_no\":\"" + UUIDGenerator.getUUID() + "\"" +
                "  }");
        System.out.println(request.getBizContent());
        try {
            AlipayResponse response = alipayClient.execute(request);
            if(!response.isSuccess()){
                throw new PayerException("支付宝退款失败: "+ response.getCode() + ", " + response.getMsg());
            }
        } catch (AlipayApiException e) {
            throw new PayerException(e.getMessage());
        } catch (PayerException e) {
            e.printStackTrace();
        }
    }

}
