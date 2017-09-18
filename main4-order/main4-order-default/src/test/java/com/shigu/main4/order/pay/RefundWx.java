package com.shigu.main4.order.pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.opentae.data.mall.beans.OrderPay;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.model.able.PayerServiceAble;
import com.shigu.main4.order.model.impl.WxPayerServiceImpl;
import com.tencent.WXPay;
import com.tencent.business.RefundBusiness;
import com.tencent.protocol.refund_protocol.RefundReqData;
import com.tencent.protocol.refund_protocol.RefundResData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by bugzy on 2017/8/18 0018.
 */
public class RefundWx extends BaseTest {

    @Autowired
    private AlipayClient alipayClient;

    @Test
    public void testRefundAlipay() throws PayerException, AlipayApiException {
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "    \"trade_no\":\"4006042001201709050351231403\"," +
                "    \"refund_amount\":303.9," +
                "    \"refund_reason\":\"正常退款\"," +
                "    \"out_request_no\":\"" + UUIDGenerator.getUUID() + "\"" +
                "  }");
        AlipayResponse response = alipayClient.execute(request);
        if(!response.isSuccess()){
            throw new PayerException("支付宝退款失败: "+ response.getCode() + ", " + response.getMsg());
        }
    }

    @Test
    public void testRefundWx() throws PayerException {
        RefundReqData reqData = new RefundReqData(
                "4006042001201709050351231403",
                "OA67306",
                null,
                "fga4006042001201709050351231403",
                102690,
                30390,
                "o6mmVt8p0RHdK8LBi3PzpoaTfXwU",
                null
        );
        ResultListener resultListener = new ResultListener();
        try {
            WXPay.doRefundBusiness(reqData, resultListener);
        } catch (Exception e) {
            throw new PayerException("微信退款请求失败");
        }
        if (!resultListener.isSuccess())
            throw new PayerException("请求失败");
    }

    private class ResultListener implements RefundBusiness.ResultListener {

        private boolean success;

        @Override
        public void onFailByReturnCodeError(RefundResData refundResData) {

        }

        @Override
        public void onFailByReturnCodeFail(RefundResData refundResData) {

        }

        @Override
        public void onFailBySignInvalid(RefundResData refundResData) {

        }

        @Override
        public void onRefundFail(RefundResData refundResData) {

        }

        @Override
        public void onRefundSuccess(RefundResData refundResData) {
            success = true;
        }

        public boolean isSuccess() {
            return success;
        }
    }
}
