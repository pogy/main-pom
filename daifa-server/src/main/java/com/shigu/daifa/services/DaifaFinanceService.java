package com.shigu.daifa.services;

import com.opentae.data.daifa.beans.DaifaGgoodsReturnFee;
import com.opentae.data.daifa.examples.DaifaGgoodsReturnFeeExample;
import com.opentae.data.daifa.interfaces.DaifaGgoodsReturnFeeMapper;
import com.opentae.data.daifa.interfaces.DaifaSelFinaceMapper;
import com.shigu.daifa.vo.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DaifaFinanceService {
    @Autowired
    DaifaSelFinaceMapper daifaSelFinaceMapper;
    @Autowired
    DaifaGgoodsReturnFeeMapper daifaGgoodsReturnFeeMapper;

    public FinanceVO selFinace(String time, Long sellerId){
        String day = DateUtil.dateToString(DateUtil.stringToDate(time,DateUtil.patternA),DateUtil.patternB);

        //拿货费用
        String takeFee=toDouble(daifaSelFinaceMapper.selectTodayTakeFee(day,sellerId));

        //商品费用
        String goodsFee=toDouble(daifaSelFinaceMapper.selectTodayGoodsFee(day,sellerId));

        //代发费
        String serverFee=toDouble(daifaSelFinaceMapper.selectTodayServerFee(day,sellerId));

        //快递费
        String postFee=toDouble(daifaSelFinaceMapper.selectTodayPostFee(day,sellerId));

        //仓库中商品费用(以关联)
        String stockGoodsFee=stockFee(day,sellerId);

        //要退款的费用
        String needRefundFee="0.00";

        //退款
        String refundFee=refundFee(day,sellerId);

        FinanceVO vo=new FinanceVO();
        vo.setHaveToTakeFee(takeFee);
        vo.setDaifaServerFee(serverFee);
        vo.setShipmentsFee(postFee);
        vo.setRefundedGoodsFee(refundFee);
        vo.setAllotmentFee(goodsFee);
        vo.setInventoryGoodsFee(stockGoodsFee);
        vo.setInTheBackGoodsFee(needRefundFee);
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
    public List<FinancialGoodsFeeDetailVO> workerTakeFeeDetail(String day, Long sellerId){
        DaifaGgoodsReturnFeeExample daifaGgoodsReturnFeeExample=new DaifaGgoodsReturnFeeExample();
        daifaGgoodsReturnFeeExample.createCriteria().andCreateDateEqualTo(day)
                .andDaifaSellerIdEqualTo(sellerId);
        List<DaifaGgoodsReturnFee> fees= daifaGgoodsReturnFeeMapper.selectByExample(daifaGgoodsReturnFeeExample);
        Map<Long,List<DaifaGgoodsReturnFee>> map=fees.stream().collect(Collectors.groupingBy(DaifaGgoodsReturnFee::getDaifaWorkerId));
        return daifaSelFinaceMapper.selectWorkerTakeNums(day,day,sellerId).stream().map(workerTakeNumVO -> {
            FinancialGoodsFeeDetailVO vo=new FinancialGoodsFeeDetailVO();
            vo.setAllotmentFee(toDouble(workerTakeNumVO.getTotalPrice()));
            vo.setUserId(workerTakeNumVO.getWorkerId());
            vo.setUserName(workerTakeNumVO.getName());
            vo.setHaveToTakeFee(toDouble(workerTakeNumVO.getTakePrice()));
            if(map.get(workerTakeNumVO.getWorkerId())!=null){
                DaifaGgoodsReturnFee fee=map.get(workerTakeNumVO.getWorkerId()).get(0);
                vo.setUserRefundedFee(fee.getReturnFee());
                vo.setUserRefundedIsWrong(
                        MoneyUtil.StringToLong(workerTakeNumVO.getTotalPrice())-MoneyUtil.StringToLong(workerTakeNumVO.getTakePrice())>MoneyUtil.StringToLong(fee.getReturnFee())
                );
            }
            return vo;
        }).collect(Collectors.toList());
    }

    public List<WorkerTakeNumVO> takeGoodsStatistic(String day, Long sellerId){
        return daifaSelFinaceMapper.selectWorkerTakeNums(day,null,sellerId).stream().map(workerTakeNum -> BeanMapper.map(workerTakeNum,WorkerTakeNumVO.class)).collect(Collectors.toList());
    }
    public String stockFee(String day, Long sellerId){
        return toDouble(daifaSelFinaceMapper.selectTodayStockGoodsFee(day,sellerId));
    }
    public String refundFee(String day, Long sellerId){
        return toDouble(daifaSelFinaceMapper.selectTodayRefundFee(day,sellerId));
    }

    public ShiguPager<TodayPostDetailVO> todaySendPostDetail(String day, Long daifaSellerId,Integer page) {
        Integer count=daifaSelFinaceMapper.selectTodayPostDetailCount(day,daifaSellerId);
        List<TodayPostDetailVO> list=new ArrayList<>();
        if(count>0){
            list=daifaSelFinaceMapper.selectTodayPostDetail(day,daifaSellerId,(page-1)*10,10)
                    .stream().map(todayPostDetail -> {
                        TodayPostDetailVO vo=new TodayPostDetailVO();
                        vo.setOrderId(todayPostDetail.getDfTradeId());
                        vo.setPostCode(todayPostDetail.getExpressCode());
                        vo.setPostFee(todayPostDetail.getExpressFee());
                        vo.setPostName(todayPostDetail.getExpressName());
                        return vo;
                    }).collect(Collectors.toList());
        }
        ShiguPager<TodayPostDetailVO> pager=new ShiguPager<>();
        pager.setContent(list);
        pager.setNumber(page);
        pager.calPages(count,10);
        return pager;
    }

    public ShiguPager<StockGoodsVO> afterSaleStockFee(String day, Long daifaSellerId,Integer page) {
        Integer count=daifaSelFinaceMapper.selectStockGoodsCount(day,daifaSellerId);
        List<StockGoodsVO> list=new ArrayList<>();
        if(count>0){
            list=daifaSelFinaceMapper.selectStockGoods(day,daifaSellerId,(page-1)*10,10)
                    .stream().map(stockGoods -> {
                        StockGoodsVO vo=new StockGoodsVO();
                        vo.setGoodsNo(stockGoods.getGoodsNo());
                        vo.setInStockDate(stockGoods.getInStockDay());
                        vo.setMarketName(stockGoods.getMarketName());
                        vo.setOrderId(stockGoods.getDfTradeId());
                        vo.setPrice(stockGoods.getPiPriceString());
                        vo.setShopNum(stockGoods.getStoreNum());
                        return vo;
                    }).collect(Collectors.toList());
        }
        ShiguPager<StockGoodsVO> pager=new ShiguPager<>();
        pager.setContent(list);
        pager.setNumber(page);
        pager.calPages(count,10);
        return pager;
    }

    public ShiguPager<RefundedFeeVO> afterSaleRefundedFee(String day, Long daifaSellerId,Integer page) {
        Integer count=daifaSelFinaceMapper.selectTodayRefundCount(day,daifaSellerId);
        List<RefundedFeeVO> list=new ArrayList<>();
        if(count>0){
            list=daifaSelFinaceMapper.selectTodayRefund(day,daifaSellerId,(page-1)*10,10)
                    .stream().map(stockGoods -> {
                        RefundedFeeVO vo=new RefundedFeeVO();
                        vo.setGoodsNo(stockGoods.getGoodsNo());
                        vo.setRefundedDate(stockGoods.getRefundedDay());
                        vo.setMarketName(stockGoods.getMarketName());
                        vo.setOrderId(stockGoods.getDfTradeId());
                        vo.setPrice(stockGoods.getPiPriceString());
                        vo.setShopNum(stockGoods.getStoreNum());
                        return vo;
                    }).collect(Collectors.toList());
        }
        ShiguPager<RefundedFeeVO> pager=new ShiguPager<>();
        pager.setContent(list);
        pager.setNumber(page);
        pager.calPages(count,10);
        return pager;
    }

}
