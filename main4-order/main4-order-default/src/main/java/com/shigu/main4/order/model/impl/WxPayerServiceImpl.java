package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.beans.OrderPayApply;
import com.opentae.data.mall.interfaces.OrderPayApplyMapper;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.model.able.PayerServiceAble;
import com.shigu.main4.order.vo.PayApplyVO;
import com.tencent.WXPay;
import com.tencent.protocol.qrpay_protoclo.QrPayReqData;
import com.tencent.protocol.qrpay_protoclo.QrPayResData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * 微信支付
 * Created by zhaohongbo on 17/6/9.
 */
@Service
public class WxPayerServiceImpl extends PayerServiceAble {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PayApplyVO payApply(Long oid, Long money, String title) throws PayApplyException {
        OrderPayApply apply = new OrderPayApply();
        apply.setOid(oid);
        apply.setMoney(money);
        apply.setType(PayType.WX.getValue());
        orderPayApplyMapper.insertSelective(apply);

        QrPayResData resData;
        try {
            resData = payToWx(
                    title,
                    "您正在支付【四季星座网】订单，有效期30分钟",
                    "oa",
                    String.format("OA%d", apply.getApplyId()),
                    money.intValue(),
                    "http://pay2api.571xz.net/testwebapi/wxnotify.json"
            );
        } catch (Exception e) {
            throw PayApplyException.wxApplyException(e);
        }
        if (!"SUCCESS".equals(resData.getReturn_code())
                || !"SUCCESS".equals(resData.getResult_code())) {
            throw PayApplyException.wxApplyException(new Exception(resData.getErr_code() + " : " + resData.getErr_code_des()));
        }

        OrderPayApply payApply = new OrderPayApply();
        payApply.setApplyId(apply.getApplyId());
        payApply.setPayLink(resData.getCode_url());
        orderPayApplyMapper.updateByPrimaryKeySelective(payApply);
        return BeanMapper.map(orderPayApplyMapper.selectByPrimaryKey(apply.getApplyId()), PayApplyVO.class);
    }

    /**
     * 微信申请支付链接
     * @param title 订单标题
     * @param detail 订单详细内容
     *@param attr 携带参数
     * @param outerTradeId 唯一外部订单号 构成：业务标记+ID
     * @param fee 单位为“分”
     * @param notice 回调通知地址
     * @return 响应支付链接
     * @throws Exception
     */
    private QrPayResData payToWx(String title, String detail, String attr, String outerTradeId, int fee, String notice)
            throws Exception {
        Calendar calendar = Calendar.getInstance();
        String timeStart = DateUtil.dateToString(calendar.getTime(), DateUtil.patternF);
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        String timeExpire = DateUtil.dateToString(calendar.getTime(), DateUtil.patternF);
        QrPayReqData data = new QrPayReqData(
                title,
                detail,
                attr,
                outerTradeId,
                fee,
                StringUtil.getRealIp(),
                timeStart,
                timeExpire,
                "order_apply",
                notice
        );
        return WXPay.requestQrPayService(data);
    }

    @Override
    public void refund(Long payId, Long money) {

    }


}
