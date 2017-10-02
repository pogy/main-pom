package com.shigu.daifa.services;

import com.opentae.data.daifa.interfaces.DaifaSelFinaceMapper;
import com.shigu.daifa.vo.FinanceVO;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DaifaFinanceService {
    @Autowired
    DaifaSelFinaceMapper daifaSelFinaceMapper;

    public FinanceVO selFinace(String time, Long sellerId){
        String day;
        if(StringUtils.isEmpty(time)){
            day=DateUtil.dateToString(new Date(),DateUtil.patternB);
        }else{
            day= DateUtil.dateToString(DateUtil.stringToDate(time,DateUtil.patternA),DateUtil.patternB);
        }
        //拿货费用
        String takeFee=daifaSelFinaceMapper.selectTodayTakeFee(day,sellerId);

        //未拿费
        String notTakeFee=daifaSelFinaceMapper.selectTodayNotTakeFee(day,sellerId);

        //代发费
        String serverFee=daifaSelFinaceMapper.selectTodayServerFee(day,sellerId);

        //快递费
        String postFee=daifaSelFinaceMapper.selectTodayPostFee(day,sellerId);

        //退款
        String refundFee=daifaSelFinaceMapper.selectTodayRefundFee(day,sellerId);

        //需要费用
        String totalFee= MoneyUtil.dealPrice(MoneyUtil.StringToLong(takeFee)+MoneyUtil.StringToLong(postFee));

        FinanceVO vo=new FinanceVO();
        vo.setDaifaNeedFee(totalFee);
        vo.setGetGoodsFee(takeFee);
        vo.setNotYetGoodsFee(notTakeFee);
        vo.setDaifaServerFee(serverFee);
        vo.setShipmentsFee(postFee);
        vo.setRefundFee(refundFee);
        return vo;

    }
}
