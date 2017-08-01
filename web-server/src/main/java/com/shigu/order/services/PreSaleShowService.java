package com.shigu.order.services;

import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.servicevo.AfterSaleSimpleOrderVO;
import com.shigu.main4.order.servicevo.RefundLogVO;
import com.shigu.main4.order.servicevo.SubAfterSaleSimpleOrderVO;
import com.shigu.main4.order.utils.PriceConvertUtils;
import com.shigu.order.vo.RefundApplyRecordVO;
import com.shigu.order.vo.RefundOrderVO;
import com.shigu.order.vo.SubRefundOrderVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreSaleShowService {
    AfterSaleService afterSaleService;

    public SubRefundOrderVO selSubRefundOrderVO(Long subOrderId){
        SubAfterSaleSimpleOrderVO subSimple=afterSaleService.subAfterSaleSimpleOrder(subOrderId);
        SubRefundOrderVO sub=new SubRefundOrderVO();
        sub.setChildOrderId(subSimple.getSubOrderId());
        sub.setChildOrderCode(subSimple.getGoodsNo());
        sub.setChildOrderColor(subSimple.getColor());
        sub.setChildOrderImgSrc(subSimple.getPicUrl());
        sub.setChildOrderSize(subSimple.getSize());
        sub.setRefundGoodsPrice(PriceConvertUtils.priceToString(subSimple.getPrice()));
        sub.setRefundNumber(subSimple.getNum()-(subSimple.getRefundNum()==null?0:subSimple.getRefundNum()));
        return sub;
    }

    public RefundOrderVO selRefundOrderVO(Long subOrderId){
        AfterSaleSimpleOrderVO order=afterSaleService.afterSaleSimpleOrder(subOrderId);
        RefundOrderVO o=new RefundOrderVO();
        o.setOrderId(order.getOrderId());
        o.setOrderDealTime(order.getEndDate());
        o.setOrderExpressPrice(PriceConvertUtils.priceToString(order.getExpressPrice()));
        o.setOrderGoodsPrice(PriceConvertUtils.priceToString(order.getOrderPrice()));
        o.setOrderServicePrice(PriceConvertUtils.priceToString(order.getServicePrice()));
        o.setOrderTotalPrice(PriceConvertUtils.priceToString(order.getTotalPrice()));
        return o;
    }

    public List<RefundApplyRecordVO> refundApplyRecordList(Long refundId){
        List<RefundLogVO> logs= afterSaleService.afterSaleApplication(refundId);
        List<RefundApplyRecordVO> vos=new ArrayList<>();
        logs.forEach(log->{
            RefundApplyRecordVO vo=new RefundApplyRecordVO();
            vo.setUserType(log.getUserType().type);
            vo.setRecordContent(log.getLogDesc());
            vo.setRecordTime(log.getLogTime());
            vo.setUserHeadimg(log.getHeadImgUrl());
            vo.setUserNickname(log.getUserNick());
            vos.add(vo);
        });
        return vos;
    }



}
