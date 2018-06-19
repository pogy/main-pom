package com.shigu.main4.order.model.impl;

import com.openJar.requests.sgpay.RechargeFromOrderRequest;
import com.openJar.responses.sgpay.RechargeFromOrderResponse;
import com.opentae.data.mall.beans.OrderPayApply;
import com.opentae.data.mall.interfaces.OrderPayApplyMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.SubOrderBO;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.model.RechargeOrder;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.order.vo.PayedVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.tools.XzSdkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Scope("prototype")
public class RechargeOrderImpl implements RechargeOrder {

    @Autowired
    private OrderPayApplyMapper orderPayApplyMapper;

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
        RechargeFromOrderRequest request=new RechargeFromOrderRequest();
        request.setPayAmount(money);
        request.setXzUserId(userId);
        request.setAlipayNo(alipayNo);
        RechargeFromOrderResponse response=xzSdkClient.getPcOpenClient().execute(request);
        if (!response.isSuccess()) {
            throw new PayApplyException("充值失败");
        }
    }
}
