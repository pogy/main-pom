package com.shigu.main4.order.services.impl;

import com.shigu.main4.order.enums.ShStatusEnum;
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
        return null;
    }

    @Override
    public AfterSaleSimpleOrderVO afterSaleSimpleOrder(Long subOrderId) {
        return null;
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
    public ShStatusEnum queryAfterSaleType(Long refundId) {
        return null;
    }

    @Override
    public AfterSaleStatusVO afterSaleStatus(Long refundId) {
        return null;
    }

    @Override
    public AfterSaleInfoVO afterSaleInfo(Long refundId) {
        return null;
    }

    @Override
    public List<RefundLogVO> afterSaleApplication(Long refundId) {
        return null;
    }

    @Override
    public ReturnableAddressVO retrunGoodsAddress(Long refundId) {
        return null;
    }

    @Override
    public List<ExpressVo> selectExpress() {
        return null;
    }

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
