package com.shigu.main4.daifa.process.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaAfterMoneyConsult;
import com.opentae.data.daifa.beans.DaifaAfterReceiveExpresStock;
import com.opentae.data.daifa.beans.DaifaAfterSaleSub;
import com.opentae.data.daifa.examples.DaifaAfterMoneyConsultExample;
import com.opentae.data.daifa.examples.DaifaAfterReceiveExpresStockExample;
import com.opentae.data.daifa.examples.DaifaAfterSaleSubExample;
import com.opentae.data.daifa.interfaces.DaifaAfterMoneyConsultMapper;
import com.opentae.data.daifa.interfaces.DaifaAfterReceiveExpresStockMapper;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleSubMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.FileUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.DaifaAfterProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By zyl on 2018/9/17 0017/14:43
 */
@Service("daifaAfterProcess")
public class DaifaAfterProcessImpl implements DaifaAfterProcess {

    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;

    @Autowired
    private DaifaAfterReceiveExpresStockMapper daifaAfterReceiveExpresStockMapper;

    @Autowired
    private DaifaAfterMoneyConsultMapper daifaAfterMoneyConsultMapper;

    @Override
    public void runRefundFee() throws DaifaException {
        Date d = DateUtil.addMonthV1_8(-1);
        List<Long> orders = new ArrayList<>();
        DaifaAfterSaleSubExample subExample = new DaifaAfterSaleSubExample();
        subExample.createCriteria().andAfterStatusEqualTo(5).andApplyTimeLessThanOrEqualTo(d);
        List<DaifaAfterSaleSub> subList = daifaAfterSaleSubMapper
                .selectFieldsByExample(subExample, FieldUtil.codeFields("after_sale_sub_id,df_order_id"));
        if (subList.size() > 0) {
            orders = subList.stream().map(DaifaAfterSaleSub::getDfOrderId).collect(Collectors.toList());
        }

//        List<Long> longs = daifaAfterSaleSubMapper.getRefundFeeOrder(date);
        DaifaAfterSaleSubExample saleSubExample = new DaifaAfterSaleSubExample();
        saleSubExample.createCriteria().andAfterStatusEqualTo(7);
        List<DaifaAfterSaleSub> saleSubList = daifaAfterSaleSubMapper
                .selectFieldsByExample(saleSubExample, FieldUtil.codeFields("after_sale_sub_id,refund_id"));
        if (saleSubList.size() > 0) {
            List<Long> longList = saleSubList.stream().map(DaifaAfterSaleSub::getRefundId).collect(Collectors.toList());
            DaifaAfterMoneyConsultExample consultExample = new DaifaAfterMoneyConsultExample();
            consultExample.createCriteria().andRefundIdIn(longList).andCreateTimeLessThanOrEqualTo(d);
            List<DaifaAfterMoneyConsult> consults = daifaAfterMoneyConsultMapper
                    .selectFieldsByExample(consultExample, FieldUtil.codeFields("after_consult_id,refund_id"));
            if (consults.size() > 0) {
                List<Long> collect = consults.stream().map(DaifaAfterMoneyConsult::getRefundId)
                        .collect(Collectors.toList());
                DaifaAfterSaleSubExample saleSubExample1 = new DaifaAfterSaleSubExample();
                saleSubExample1.createCriteria().andRefundIdIn(collect);
                List<Long> collect1 = daifaAfterSaleSubMapper
                        .selectFieldsByExample(saleSubExample1, FieldUtil.codeFields("after_sale_sub_id,df_order_id"))
                        .stream().map(DaifaAfterSaleSub::getDfOrderId).collect(Collectors.toList());
                if (collect1.size() > 0) {
                    orders.addAll(collect1);
                }
            }
        }

        if (orders.size() > 0) {
            DaifaAfterSaleSub saleSub = new DaifaAfterSaleSub();
            saleSub.setAfterStatus(9);
            DaifaAfterSaleSubExample example = new DaifaAfterSaleSubExample();
            example.createCriteria().andDfOrderIdIn(orders);
            daifaAfterSaleSubMapper.updateByExampleSelective(saleSub, example);
        }

    }

    @Override
    public void runReceiveGoods() throws DaifaException {

        //String date = DateUtil.dateToString(DateUtil.addDayV1_8(-30), "yyyy-MM-dd HH:mm:ss");

//            DaifaAfterReceiveExpresStockExample expresStockExample = new DaifaAfterReceiveExpresStockExample();
//            expresStockExample.createCriteria().andRefundIdIn(longs);
//            List<DaifaAfterReceiveExpresStock> stockList=daifaAfterReceiveExpresStockMapper.selectByExample(expresStockExample);
//            if (stockList.size()>0){
//                List<Long> collect = stockList.stream().map(DaifaAfterReceiveExpresStock::getRefundId).collect(Collectors.toList());
//
//                DaifaAfterSaleSubExample subExample = new DaifaAfterSaleSubExample();
//                subExample.createCriteria().andAfterTypeEqualTo(1).andAfterStatusIn(list).andApplyDealStatusEqualTo(1).andRefundIdNotIn(collect);
//                List<DaifaAfterSaleSub> daifaAfterSaleSubList =daifaAfterSaleSubMapper.selectByExample(subExample);
        //if (daifaAfterSaleSubList.size()>0){
        //List<Long> orderList = daifaAfterSaleSubList.stream().map(DaifaAfterSaleSub::getDfOrderId).collect(Collectors.toList());

        //查询客户未发货，将其状态标为8
        DaifaAfterSaleSubExample example = new DaifaAfterSaleSubExample();
        example.createCriteria().andAfterTypeEqualTo(1).andAfterStatusEqualTo(2).andApplyDealStatusEqualTo(1).andApplyTimeLessThanOrEqualTo(DateUtil.addDayV1_8(-30));
        List<DaifaAfterSaleSub> subList = daifaAfterSaleSubMapper.selectFieldsByExample(example, FieldUtil.codeFields("after_sale_sub_id,df_order_id"));
        if (subList.size() > 0) {
            List<Long> orderList = subList.stream().map(DaifaAfterSaleSub::getDfOrderId).collect(Collectors.toList());
            DaifaAfterSaleSub saleSub = new DaifaAfterSaleSub();
            saleSub.setAfterStatus(8);
            DaifaAfterSaleSubExample example2 = new DaifaAfterSaleSubExample();
            example2.createCriteria().andDfOrderIdIn(orderList);
            daifaAfterSaleSubMapper.updateByExampleSelective(saleSub, example);

        }

    }
}
