package com.shigu.daifa.services;

import com.opentae.data.daifa.interfaces.DaifaSelFinaceMapper;
import com.shigu.daifa.vo.FinanceVO;
import com.shigu.daifa.vo.WorkerTakeNumVO;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

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
        String takeFee=toDouble(daifaSelFinaceMapper.selectTodayTakeFee(day,sellerId));

        //未拿费
        String notTakeFee=toDouble(daifaSelFinaceMapper.selectTodayNotTakeFee(day,sellerId));

        //代发费
        String serverFee=toDouble(daifaSelFinaceMapper.selectTodayServerFee(day,sellerId));

        //快递费
        String postFee=toDouble(daifaSelFinaceMapper.selectTodayPostFee(day,sellerId));

        //退款
        String refundFee=toDouble(daifaSelFinaceMapper.selectTodayRefundFee(day,sellerId));

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

    private String toDouble(String fee){
        try {
            Double d=new Double(fee);
            DecimalFormat df = new DecimalFormat("0.00");
            return df.format(d);
        } catch (Exception e) {
            return "0.00";
        }
    }


    public List<WorkerTakeNumVO> takeGoodsStatistic(String day,Long sellerId){
        return daifaSelFinaceMapper.selectWorkerTakeNums(day,sellerId);
    }
}
