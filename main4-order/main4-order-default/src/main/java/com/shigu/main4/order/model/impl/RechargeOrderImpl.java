package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.interfaces.OrderPayApplyMapper;
import com.shigu.main4.order.bo.SubOrderBO;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.model.RechargeOrder;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.order.vo.PayedVO;
import com.shigu.main4.pay.requests.XzbAlipayRechargeRequest;
import com.shigu.main4.pay.responses.XzbAlipayRechargeResponse;
import com.shigu.main4.pay.services.XzbService;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.tools.XzSdkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class RechargeOrderImpl implements RechargeOrder {

    @Autowired
    private OrderPayApplyMapper orderPayApplyMapper;

    @Autowired
    private XzbService xzbService;

    @Autowired
    private XzSdkClient xzSdkClient;

    private Long oid;

    private Long userId;

    private Long money;

    public RechargeOrderImpl(Long userId,Long oid,Long money) {
        this.userId = userId;
        this.oid = oid;
        this.money = money;
    }

    @Override
    public PayApplyVO payApply(PayType payType) throws PayApplyException {
        return SpringBeanFactory.getBean(payType.getService(), PayerService.class).payApply(userId, money, "充值",oid);
    }

    @Override
    public void addSubOrder(List<SubOrderBO> subOrders, boolean needReprice, Long userId) throws OrderException {

    }

    @Override
    public PayApplyVO repayApply(PayType type) {
        return null;
    }

    @Override
    public List<PayedVO> payedInfo() {
        return null;
    }

    @Override
    public void refunds(Long money) {

    }

    @Override
    public void addMark(String msg) {

    }

    @Override
    public void payed() {
    }

    @Override
    public void payed(Long payMoney) {

    }

    @Override
    public void finished() {

    }

    @Override
    public void closed() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void payed(String alipayNo) throws PayApplyException {
        XzbAlipayRechargeRequest request=new XzbAlipayRechargeRequest();
        request.setPayAmount(money);
        request.setXzUserId(userId);
        request.setAlipayNo(alipayNo);
        XzbAlipayRechargeResponse response = xzbService.rechargeFromOrderByAlipay(request);
        if (!response.isSuccess()) {
            throw new PayApplyException("充值失败");
        }
    }
}
