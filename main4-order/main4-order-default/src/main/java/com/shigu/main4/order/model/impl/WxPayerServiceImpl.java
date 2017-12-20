package com.shigu.main4.order.model.impl;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.OrderPay;
import com.opentae.data.mall.beans.OrderPayApply;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.model.able.PayerServiceAble;
import com.shigu.main4.order.vo.PayApplyVO;
import com.tencent.WXPay;
import com.tencent.business.RefundBusiness;
import com.tencent.common.Configure;
import com.tencent.common.Signature;
import com.tencent.protocol.refund_protocol.RefundReqData;
import com.tencent.protocol.refund_protocol.RefundResData;
import com.tencent.protocol.unify_protocol.UnifyPayReqData;
import com.tencent.protocol.unify_protocol.UnifyPayResData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.Calendar;

/**
 * 微信支付
 * Created by zhaohongbo on 17/6/9.
 */
@Service("wxPayerService")
public class WxPayerServiceImpl extends  PayerServiceAble {

    private static final Logger logger = LoggerFactory.getLogger(WxPayerServiceImpl.class);

    @Value("${weixin.pay.notify.url}")
    private String notifyUrl;

    @PostConstruct
    public void initWXPay() {
        Configure.setCertLocalPath((this.getClass().getResource("/").getPath() + "key\\apiclient_cert.p12").replace("\\",  File.separator));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PayApplyVO payApply(Long userId, Long money, String title,Long[] oids) throws PayApplyException {
        OrderPayApply apply = payApplyPrepare(userId,money,PayType.WX,oids);

        UnifyPayResData resData;
        try {
            resData = payToWx(
                    title,
                    "您正在支付【四季星座网】订单，有效期30分钟",
                    "oa",
                    wxOutTradeNo(apply.getApplyId()),
                    money.intValue(),
                    notifyUrl
            );
        } catch (Exception e) {
            throw PayApplyException.wxApplyException(e);
        }
        if (!"SUCCESS".equals(resData.getReturn_code())
                || !"SUCCESS".equals(resData.getResult_code())) {
            throw PayApplyException.wxApplyException(new Exception(resData.getResult_code() + " : " + resData.getReturn_msg()));
        }

        OrderPayApply payApply = new OrderPayApply();
        payApply.setApplyId(apply.getApplyId());
        payApply.setPayLink(resData.getCode_url());
        orderPayApplyMapper.updateByPrimaryKeySelective(payApply);
        return BeanMapper.map(orderPayApplyMapper.selectByPrimaryKey(apply.getApplyId()), PayApplyVO.class);
    }

    private String wxOutTradeNo(Long applyId) {
        return String.format("OA%d", applyId);
    }

    /**
     * 微信申请支付链接
     * @param title 订单标题
     * @param detail 订单详细内容
     * @param attr 携带参数
     * @param outerTradeId 唯一外部订单号 构成：业务标记+ID
     * @param fee 单位为“分”
     * @param notice 回调通知地址
     * @return 响应支付链接
     * @throws Exception
     */
    private UnifyPayResData payToWx(String title, String detail, String attr, String outerTradeId, int fee, String notice)
            throws Exception {
        Calendar calendar = Calendar.getInstance();
        String timeStart = DateUtil.dateToString(calendar.getTime(), DateUtil.patternF);
        calendar.add(Calendar.HOUR_OF_DAY, 72);
        String timeExpire = DateUtil.dateToString(calendar.getTime(), DateUtil.patternF);
        UnifyPayReqData data = new UnifyPayReqData(
                title,
                detail,
                attr,
                outerTradeId,
                fee,
                StringUtil.getRealIp(),
                "",
                "",
                "NATIVE",
                timeStart,
                timeExpire,
                "order_apply",
                notice
        );
        return WXPay.exec(data);
    }

    @Override
    protected void realRefund(String refundNo,OrderPay orderPay, Long money) throws PayerException {
        weixinRefund(refundNo,orderPay, money.intValue());
    }

    @Override
    public void payRollback(Long applyId, String outerPid, String outerPuser, Long payMoney, Long money) throws PayerException {
        OrderPay orderPay=new OrderPay();
        orderPay.setOuterPid(outerPid);
        orderPay.setApplyId(applyId);
        orderPay.setOuterPuser(outerPuser);
        orderPay.setMoney(payMoney);
        orderPay.setRefundMoney(0L);
        weixinRefund("ROLL_"+applyId,orderPay,money.intValue());
    }

    private void weixinRefund(String refundNo,OrderPay orderPay, int refundFee) throws PayerException {
        RefundReqData reqData = new RefundReqData(
                orderPay.getOuterPid(),
                wxOutTradeNo(orderPay.getApplyId()),
                null,
                refundNo,
                orderPay.getMoney().intValue(),
                refundFee,
                orderPay.getOuterPuser(),
                null
        );
        ResultListener resultListener = new ResultListener();
        try {
            WXPay.doRefundBusiness(reqData, resultListener);
        } catch (Exception e) {
            logger.error("微信退款异常",e);
            throw new PayerException("微信退款请求失败");
        }
        if (!resultListener.isSuccess()){
            if("NOTENOUGH".equals(resultListener.getErrCode())){//未结算里面余额不足
                reqData = new RefundReqData(
                        orderPay.getOuterPid(),
                        wxOutTradeNo(orderPay.getApplyId()),
                        null,
                        "RF" + orderPay.getOuterPid() + orderPay.getRefundMoney(),
                        orderPay.getMoney().intValue(),
                        refundFee,
                        orderPay.getOuterPuser(),
                        null
                );
                reqData.setRefund_account("REFUND_SOURCE_RECHARGE_FUNDS");
                reqData.setSign(Signature.getSign(reqData.toMap()));
                ResultListener resultListenerCache = new ResultListener();
                try {
                    WXPay.doRefundBusiness(reqData, resultListenerCache);
                } catch (Exception e) {
                    throw new PayerException("微信现金退款请求失败");
                }
                if(!resultListenerCache.isSuccess()){//现金余额也退不了
                    throw new PayerException(resultListenerCache.getErrCode()+"请求失败");
                }
            }else{
                throw new PayerException(resultListener.getErrCode()+"请求失败");
            }
        }
    }

    private class ResultListener implements RefundBusiness.ResultListener {

        private boolean success;
        private String errCode;

        @Override
        public void onFailByReturnCodeError(RefundResData refundResData) {
            errCode=refundResData.getErr_code();
            logger.error("[onFailByReturnCodeError]"+JSON.toJSONString(refundResData));
        }

        @Override
        public void onFailByReturnCodeFail(RefundResData refundResData) {
            errCode=refundResData.getErr_code();
            logger.error("[onFailByReturnCodeFail]"+JSON.toJSONString(refundResData));
        }

        @Override
        public void onFailBySignInvalid(RefundResData refundResData) {
            errCode=refundResData.getErr_code();
            logger.error("[onFailBySignInvalid]"+JSON.toJSONString(refundResData));
        }

        @Override
        public void onRefundFail(RefundResData refundResData) {
            errCode=refundResData.getErr_code();
            logger.error("[onRefundFail]"+JSON.toJSONString(refundResData));
        }

        @Override
        public void onRefundSuccess(RefundResData refundResData) {
            success = true;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getErrCode() {
            return errCode;
        }
    }

}
