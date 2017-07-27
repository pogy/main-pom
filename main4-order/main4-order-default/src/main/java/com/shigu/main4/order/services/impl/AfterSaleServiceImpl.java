package com.shigu.main4.order.services.impl;

import com.shigu.main4.order.zfenums.ShStatusEnum;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.vo.ExpressVo;
import com.shigu.main4.order.vo.ReturnableAddressVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pc on 2017-07-26.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class AfterSaleServiceImpl implements AfterSaleService{
    @Override
    public SubAfterSaleSimpleOrderVO subAfterSaleSimpleOrder(Long subOrderId) {
        SubAfterSaleSimpleOrderVO vo = new SubAfterSaleSimpleOrderVO();
        vo.setColor("红");
        vo.setGoodsNo("zf号");
        vo.setNum(11);
        vo.setPicUrl("http://www.sinaimg.cn/dy/slidenews/1_img/2015_34/2841_605918_687391.jpg");
        vo.setSize("超大号");
        vo.setSubOrderId(105L);
        vo.setRefundNum(2);
        return vo;
    }

    @Override
    public AfterSaleSimpleOrderVO afterSaleSimpleOrder(Long subOrderId) {
        AfterSaleSimpleOrderVO vo = new AfterSaleSimpleOrderVO();
        vo.setEndDate("2017-09-10 11:11:11");
        vo.setExpressPrice(10L);
        vo.setOrderId(105L);
        vo.setOrderPrice(100L);
        vo.setServicePrice(10L);
        vo.setTotalPrice(150L);
        return vo;
    }

    @Override
    public Long returnGoodsApply(Long subOrderId, int refundCount, String refundMoney, String refundReason, String refundDesc) {
        return null;
    }

    @Override
    public Long exchangeApply(Long subOrderId, String refundReason, String refundDesc) {
        return null;
    }

    @Override
    public ShStatusEnum queryAfterSaleType(Long refundId) { return null; } @Override public AfterSaleStatusVO afterSaleStatus(Long refundId) { return null; } @Override public AfterSaleInfoVO afterSaleInfo(Long refundId) { return null; } @Override public List<RefundLogVO> afterSaleApplication(Long refundId) { return null; } @Override public ReturnableAddressVO retrunGoodsAddress(Long refundId) { return null; } @Override public List<ExpressVo> selectExpress() { return null; }
    @Override
    public void chooseExpress(Long refundId, Long expressId, String expressCode) {

    }

    @Override
    public ReturnableExpressInfoVO queryExpress(Long refundId) {
        return null;
    }

    @Override
    public void modifyExpress(Long refundId, Long expressId, String expressCode) {

    }

    @Override
    public ReturnableExpressInfoVO retrunGoodsExpressInfo(Long refundId) {
        return null;
    }

    @Override
    public void agreeOrRejectRefundPrice(Long refundId,boolean isAgree) {

    }

    @Override
    public AfterSaleEntVO afterEnt(Long refundId) {
        return null;
    }
}
