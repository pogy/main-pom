package com.shigu.main4.order.pay;

import com.opentae.data.mall.beans.OrderPay;
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

/**
 * Created by bugzy on 2017/8/18 0018.
 */
public class RefundWx extends BaseTest {

    @Test
    public void testRefundWx() throws PayerException {
        RefundReqData reqData = new RefundReqData(
                "4004942001201708186913867728",
                "OA195",
                null,
                "RF4004942001201708186913867728",
                2510,
                2510,
                "o6mmVt3kI-BLwWMTItTi2sbuS1hA",
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
