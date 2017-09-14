package com.shigu.main4.order.model.impl;

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

    @Value("${weixin.pay.notify.url}")
    private String notifyUrl;

    @PostConstruct
    public void initWXPay() {
        Configure.setCertLocalPath((this.getClass().getResource("/").getPath() + "key\\apiclient_cert.p12").replace("\\",  File.separator));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PayApplyVO payApply(Long userId,Long oid, Long money, String title) throws PayApplyException {
        OrderPayApply apply = new OrderPayApply();
        apply.setOid(oid);
        apply.setMoney(money);
        apply.setUserId(userId);
        apply.setType(PayType.WX.getValue());
        orderPayApplyMapper.insertSelective(apply);

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
    @Transactional(rollbackFor = Exception.class)
    public void refund(Long payId, Long money) throws PayerException {
        OrderPay orderPay;
        if (payId == null || (orderPay = orderPayMapper.selectByPrimaryKey(payId)) == null) {
            throw new PayerException(String.format("支付记录不存在。 payId[%d]", payId));
        }
        if (money <= 0 || payedLeft(payId) < money) {
            throw new PayerException(String.format("可退金额不足.payId[%d], money[%d]", payId, money));
        }
        if (System.currentTimeMillis() - orderPay.getCreateTime().getTime() > 365 * 24 * 3600 * 1000L) {
            throw new PayerException("支付完成超过一年的订单无法退款");
        }

        //TODO: call weixin refund
        weixinRefund(orderPay, money.intValue());

        OrderPay pay = new OrderPay();
        pay.setPayId(orderPay.getPayId());
        pay.setRefundMoney(orderPay.getRefundMoney() + money);
        orderPayMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public void payRollback(Long applyId, String outerPid, String outerPuser, Long payMoney, Long money) throws PayerException {
        OrderPay orderPay=new OrderPay();
        orderPay.setOuterPid(outerPid);
        orderPay.setApplyId(applyId);
        orderPay.setOuterPuser(outerPuser);
        orderPay.setMoney(payMoney);
        orderPay.setRefundMoney(0L);
        weixinRefund(orderPay,money.intValue());
    }

    private void weixinRefund(OrderPay orderPay, int refundFee) throws PayerException {
        RefundReqData reqData = new RefundReqData(
                orderPay.getOuterPid(),
                wxOutTradeNo(orderPay.getApplyId()),
                null,
                "RF" + orderPay.getOuterPid() + orderPay.getRefundMoney(),
                orderPay.getMoney().intValue(),
                refundFee,
                orderPay.getOuterPuser(),
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
