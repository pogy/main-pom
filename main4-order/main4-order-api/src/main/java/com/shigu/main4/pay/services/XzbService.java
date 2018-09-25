package com.shigu.main4.pay.services;

import com.shigu.main4.pay.requests.*;
import com.shigu.main4.pay.responses.*;

/**
 * 类名：XzbService
 * 类路径： com.shigu.main4.pay.services.XzbService
 * 创建者： whx
 * 创建时间： 8/6/18 3:47 PM
 * 项目： main-pom
 * 描述： 星座宝
 */
public interface XzbService {

    /**
     * 星座宝用户余额
     * @param request
     * @return
     */
    XzbUserBalanceResponse xzbUserBalance(XzbUserBalanceRequest request);

    /**
     * 星座宝支付
     */
    XzbPayResponse xzbPay(XzbPayRequest request);

    /**
     * 使用支付宝进行星座宝充值
     */
    XzbAlipayRechargeResponse rechargeFromOrderByAlipay(XzbAlipayRechargeRequest request);

    /**
     * 星座宝退款
     */
    XzbRefundResponse xzbRefund(XzbRefundRequest request);

    /**
     * 提现申请
     */
    XzbAlipayToCashEdResponse alipayToCashEd(XzbAlipayToCashedRequest request);

    /**
     * 用户资金明细
     */
    XzbUserPayTradeRecordResponse userPayTradeRecord(XzbUserPayTradeRecordRequest request);

    /**
     * 用户每月提现限制
     * @return
     */
    XzbDisposeLimitResponse userDisposeLimit(XzbUserDisposeLimitRequest request);

    /**
     * 邀请返现
     */
    XzbInviteRechargeResponse inviteRebateRecharge(XzbInviteRechargeRequest request);

    /**
     * 订单返现
     */
    XzbOrderCashBackResponse orderCashBack(XzbOrderCashBackRequest request);



    /**
     * 红包充值
     */
    XzbRedPackPayResponse redPackPay(XzbReqPackPayRequest request);

}
