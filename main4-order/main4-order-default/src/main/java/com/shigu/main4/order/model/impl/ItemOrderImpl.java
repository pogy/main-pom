package com.shigu.main4.order.model.impl;

import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.order.vo.LogisticsVO;
import com.shigu.main4.order.vo.MetarialVO;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.order.vo.ServiceVO;
import com.shigu.main4.order.vo.SubOrderVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品订单
 * Created by zhaohongbo on 17/6/1.
 */
@Repository
@Scope("prototype")
public class ItemOrderImpl extends ItemOrderVO implements ItemOrder{

    public ItemOrderImpl(ItemOrderVO iov) {
        BeanMapper.map(iov,this);
    }

    @Override
    public List<LogisticsVO> selLogistics() {
        return null;
    }

    @Override
    public void addLogistics(LogisticsVO logistics) {

    }

    @Override
    public void modifyLogistics(Long id, LogisticsVO logistics) {

    }

    @Override
    public void refundLogistics(Long id, Long money) {

    }

    @Override
    public void addPackage(MetarialVO metarial) {

    }

    @Override
    public void refundPackage(Long id, Long money) {

    }

    @Override
    public void addService(ServiceVO service) {

    }

    @Override
    public void refundService(Long id, Long money) {

    }

    @Override
    public PayApplyVO payApply(PayType payType) {
        return null;
    }

    @Override
    public void addSubOrder(List<SubOrderVO> subOrders) {

    }

    @Override
    public PayApplyVO repayApply(PayType type) {
        return null;
    }

    @Override
    public Long pay(Long applyId, Long money) {
        return null;
    }

    @Override
    public void sended() {

    }

    @Override
    public void refunds(Long money) {

    }

    @Override
    public void addMark(String msg) {

    }
}
