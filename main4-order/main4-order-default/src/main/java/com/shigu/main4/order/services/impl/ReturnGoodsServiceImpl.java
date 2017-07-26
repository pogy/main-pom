package com.shigu.main4.order.services.impl;

import com.shigu.main4.order.enums.ReturnGoodsStatusEnum;
import com.shigu.main4.order.services.ReturnGoodsService;
import com.shigu.main4.order.servicevo.ExpressLogVO;
import com.shigu.main4.order.servicevo.RefundLogVO;
import com.shigu.main4.order.servicevo.ReturnGoodsInfoVO;
import com.shigu.main4.order.servicevo.ReturnableExpressInfoVO;
import com.shigu.main4.order.vo.ApplyOperaterVo;
import com.shigu.main4.order.vo.ReturnableAddressVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2017-07-25.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class ReturnGoodsServiceImpl implements ReturnGoodsService{
    @Override
    public Long returnGoodsApply(Long orderChildId, int refundCount, String refundMoney, String refundReason, String refundDesc) {
        return 10086L;
    }

    @Override
    public ReturnableExpressInfoVO chooseExpress(Long refundId, Long expressId, String expressCode) {
        ReturnableExpressInfoVO vo = new ReturnableExpressInfoVO();
        vo.setExpressName("zf快递");
        vo.setExpressCode("1111111111");
        vo.setExpressDetails(new ArrayList<ExpressLogVO>());
        return vo;
    }

    @Override
    public ReturnableExpressInfoVO modifyExpress(Long refundId, Long expressId, String expressCode) {
        return null;
    }

    @Override
    public List<RefundLogVO> retrunGoodsLog(Long refundId) {
        return null;
    }

    @Override
    public ReturnableAddressVO retrunGoodsAddress(Long refundId) {
        return null;
    }

    @Override
    public ReturnableExpressInfoVO retrunGoodsExpressInfo(Long refundId) {
        return null;
    }

    @Override
    public List<ExpressLogVO> retrunGoodsExpressLogs(Long refundId) {
        return null;
    }

    @Override
    public ReturnGoodsInfoVO retrunGoodsInfo(Long refundId) {
        ReturnGoodsInfoVO vo = new ReturnGoodsInfoVO();
        vo.setRefundId("111");
        vo.setRefundPrice("100");
        vo.setRefundSuccessTime(new Date());
        vo.setRetrunGoodsStatus(ReturnGoodsStatusEnum.AGREE_PROCESS);
        return vo;
    }

    @Override
    public List<ApplyOperaterVo> returnGoodsOperater(Long refundId) {
        return null;
    }

    @Override
    public Long selChildOrderId(Long refundId) {
        return null;
    }
}
