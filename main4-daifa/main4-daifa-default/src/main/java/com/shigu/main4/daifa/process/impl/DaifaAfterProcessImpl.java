package com.shigu.main4.daifa.process.impl;

import com.opentae.data.daifa.beans.DaifaAfterSaleSub;
import com.opentae.data.daifa.examples.DaifaAfterSaleSubExample;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleSubMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.DaifaAfterProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By zyl on 2018/9/17 0017/14:43
 */
@Service
public class DaifaAfterProcessImpl implements DaifaAfterProcess {

    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;

    @Override
    public void runRefundFee() throws DaifaException {

        String date = DateUtil.dateToString(DateUtil.addMonthV1_8(-1), "yyyy-MM-dd HH:mm:ss");
        List<Long> orders = new ArrayList<>();
        DaifaAfterSaleSubExample subExample = new DaifaAfterSaleSubExample();
        subExample.createCriteria().andAfterStatusEqualTo(5).andApplyTimeLessThanOrEqualTo(DateUtil.addMonthV1_8(-1));
        List<DaifaAfterSaleSub> subList = daifaAfterSaleSubMapper.selectByExample(subExample);
        if (subList.size()>0){
            orders = subList.stream().map(daifaAfterSaleSub -> daifaAfterSaleSub.getDfOrderId()).collect(Collectors.toList());
        }

        List<Long> longs = daifaAfterSaleSubMapper.getRefundFeeOrder(date);
        orders.addAll(longs);
        if (orders.size() > 0) {
            System.out.println("==============" + orders.size());
            DaifaAfterSaleSub saleSub = new DaifaAfterSaleSub();
            saleSub.setAfterStatus(9);
            DaifaAfterSaleSubExample example = new DaifaAfterSaleSubExample();
            example.createCriteria().andDfOrderIdIn(orders);
            daifaAfterSaleSubMapper.updateByExampleSelective(saleSub, example);
        }

    }

    @Override
    public void runReceiveGoods() throws DaifaException {

        String date = DateUtil.dateToString(DateUtil.addDayV1_8(-30), "yyyy-MM-dd HH:mm:ss");
        List<DaifaAfterSaleSub> subList = daifaAfterSaleSubMapper.getAfterOrder(date);
        if (subList.size() > 0) {
            List<Long> longs = subList.stream().map(daifaAfterSaleSub -> daifaAfterSaleSub.getDfOrderId()).collect(Collectors.toList());
            DaifaAfterSaleSub saleSub = new DaifaAfterSaleSub();
            saleSub.setAfterStatus(8);
            DaifaAfterSaleSubExample example = new DaifaAfterSaleSubExample();
            example.createCriteria().andDfOrderIdIn(longs);
            daifaAfterSaleSubMapper.updateByExampleSelective(saleSub, example);
        }

    }
}
