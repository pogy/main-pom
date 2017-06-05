package com.shigu.main4.order.model.impl;

import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.order.vo.LogisticsVO;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.order.vo.SubItemOrderVO;
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
public class ItemOrderImpl implements ItemOrder{
    /**
     * 订单ID
     */
    private Long oid;

    public ItemOrderImpl(Long oid) {
        this.oid=oid;
    }

    @Override
    public List<LogisticsVO> selLogisticses() {
        return null;
    }

    @Override
    public ItemOrderVO orderInfo() {
        return null;
    }

    @Override
    public List<SubItemOrderVO> subOrdersInfo() {
        return null;
    }

    @Override
    public Long addLogistics(List<Long> soids,LogisticsVO logistics) {
        return null;
    }

    @Override
    public void modifyLogistics(Long id, LogisticsVO logistics) {

    }

    @Override
    public void addPackage(Long metarialId,Integer num) {

    }

    @Override
    public void refundPackage(Long id, Long money) {

    }

    @Override
    public void addService(Long serviceId) {

    }

    @Override
    public void refundService(Long id, Long money) {

    }

    @Override
    public void sended(String courierNumber) {

    }

    @Override
    public void sendPart(Long logisticsId, List<Long> soids, String courierNumber) {

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
    public void refunds(Long money) {

    }

    @Override
    public void addMark(String msg) {

    }

    @Override
    public void payed() {

    }

    @Override
    public void finished() {

    }

    @Override
    public void closed() {

    }
}
