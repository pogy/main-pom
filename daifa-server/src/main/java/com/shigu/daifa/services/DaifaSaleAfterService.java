package com.shigu.daifa.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.daifa.bo.SaleAfterBO;
import com.shigu.daifa.vo.DaifaSaleAfter;
import com.shigu.daifa.vo.DaifaSaleAfterRefund;
import com.shigu.daifa.vo.DaifaSaleAfterStock;
import com.shigu.daifa.vo.DaifaSaleAfterSub;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DaifaSaleAfterService {

    @Autowired
    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    private DaifaOrderMapper daifaOrderMapper;
    @Autowired
    private DaifaAfterSaleMapper daifaAfterSaleMapper;
    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;
    @Autowired
    private DaifaAfterMoneyConsultMapper daifaAfterMoneyConsultMapper;

    public ShiguPager<DaifaSaleAfter> afterSaleOrder(SaleAfterBO bo){
        List<Long> saleIds=new ArrayList<>();
        if(!StringUtils.isEmpty(bo.getBackPostCode())){
            DaifaAfterSaleSubExample daifaAfterSaleSubExample=new DaifaAfterSaleSubExample();
            daifaAfterSaleSubExample.createCriteria().andApplyExpressCodeEqualTo(bo.getBackPostCode());
            List<DaifaAfterSaleSub> subs=daifaAfterSaleSubMapper.selectFieldsByExample(daifaAfterSaleSubExample, FieldUtil.codeFields("after_sale_id"));
            saleIds= BeanMapper.getFieldList(subs,"afterSaleId",Long.class);
        }
        DaifaAfterSaleExample daifaAfterSaleExample=new DaifaAfterSaleExample();
        DaifaAfterSaleExample.Criteria ce=daifaAfterSaleExample.createCriteria();
        if(saleIds.size()>0){
            ce.andAfterSaleIdIn(saleIds);
        }
        if(!StringUtils.isEmpty(bo.getOrderId())){
            ce.andDfTradeIdLike("%"+bo.getOrderId());
        }
        if(!StringUtils.isEmpty(bo.getTelephone())){
            ce.andReceiverMobileEqualTo(bo.getTelephone());
        }
        if(!StringUtils.isEmpty(bo.getStartTime())){
            ce.andCreateDateGreaterThanOrEqualTo(DateUtil.dateToString(DateUtil.stringToDate(bo.getStartTime(),DateUtil.patternA),DateUtil.patternB));
        }
        if(!StringUtils.isEmpty(bo.getEndTime())){
            ce.andCreateDateLessThanOrEqualTo(DateUtil.dateToString(DateUtil.stringToDate(bo.getEndTime(),DateUtil.patternA),DateUtil.patternB));
        }

        int count=daifaAfterSaleMapper.countByExample(daifaAfterSaleExample);
        List<DaifaSaleAfter> vos=new ArrayList<>();
        if(count>0){
            daifaAfterSaleExample.setStartIndex((bo.getPage()-1)*10);
            daifaAfterSaleExample.setEndIndex(10);
            daifaAfterSaleExample.setOrderByClause("afterSaleId desc");



            List<DaifaAfterSale> sales=daifaAfterSaleMapper.selectByConditionList(daifaAfterSaleExample);
            saleIds=BeanMapper.getFieldList(sales,"afterSaleId",Long.class);
            List<Long> tids=BeanMapper.getFieldList(sales,"dfTradeId",Long.class);

            DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
            daifaTradeExample.createCriteria().andDfTradeIdIn(tids);
            List<DaifaTrade> trades=daifaTradeMapper.selectByExample(daifaTradeExample);
            Map<Long,DaifaTrade> tradeMap=BeanMapper.list2Map(trades,"dfTradeId",Long.class);


            DaifaAfterSaleSubExample daifaAfterSaleSubExample=new DaifaAfterSaleSubExample();
            daifaAfterSaleSubExample.createCriteria().andAfterSaleIdIn(saleIds);
            List<DaifaAfterSaleSub> subs=daifaAfterSaleSubMapper.selectByExample(daifaAfterSaleSubExample);
            Map<Long,List<DaifaAfterSaleSub>> subsGroup=BeanMapper.groupBy(subs,"afterSaleId",Long.class);
            List<Long> refundIds=BeanMapper.getFieldList(subs,"refundId",Long.class);
            List<Long> oids=BeanMapper.getFieldList(subs,"dfOrderId",Long.class);

            DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
            daifaOrderExample.createCriteria().andDfOrderIdIn(oids);
            List<DaifaOrder> orders=daifaOrderMapper.selectByExample(daifaOrderExample);
            Map<Long,DaifaOrder> orderMap=BeanMapper.list2Map(orders,"dfOrderId",Long.class);

            DaifaAfterMoneyConsultExample daifaAfterMoneyConsultExample=new DaifaAfterMoneyConsultExample();
            daifaAfterMoneyConsultExample.createCriteria().andRefundIdIn(refundIds);
            daifaAfterMoneyConsultExample.setOrderByClause("after_consult_id asc");
            List<DaifaAfterMoneyConsult> cs=daifaAfterMoneyConsultMapper.selectByExample(daifaAfterMoneyConsultExample);
            Map<Long,List<DaifaAfterMoneyConsult>> moneyGroup=BeanMapper.groupBy(cs,"refundId",Long.class);
            for(DaifaAfterSale sale:sales){
                DaifaTrade t=tradeMap.get(sale.getDfTradeId());
                DaifaSaleAfter vo=new DaifaSaleAfter();
                vo.setAllChildRemark(sale.getRemark());
                vo.setAfterSaleTime(DateUtil.dateToString(sale.getCreateTime(),DateUtil.patternD));
                vo.setBuyerRemark(sale.getBuyerRemark());
                vo.setDiscountFee(t.getTradeDiscountFee());
                vo.setExpressCode(t.getExpressCode());
                vo.setExpressFee(t.getExpressFee());
                vo.setExpressName(t.getExpressName());
                vo.setImQq(t.getBuyerQq());
                vo.setImTel(t.getBuyerTelephone());
                vo.setImWw(t.getBuyerWw());
                vo.setOrderId(t.getDfTradeId());
                vo.setReceiverAddress(t.getReceiverAddress());
                vo.setReceiverName(t.getReceiverName());
                vo.setReceiverPhone(t.getReceiverPhone());
                vo.setSendTime(DateUtil.dateToString(t.getSendTime(),DateUtil.patternD));
                vo.setServersFee(t.getServicesFee());
                vo.setTotalFee(t.getTotalFee());

                Integer num=0;
                List<DaifaSaleAfterRefund> refunds=new ArrayList<>();
                List<DaifaAfterSaleSub> ss=subsGroup.get(sale.getAfterSaleId());
                for(DaifaAfterSaleSub s:subs){
                    if(s.getRefundId()==null){
                        s.setRefundId(-1L);
                    }
                }
                Map<Long,List<DaifaAfterSaleSub>> refundGroup=BeanMapper.groupBy(ss,"refundId",Long.class);

                Map<Long,Long> tmp=new HashMap<>();
                for(DaifaAfterSaleSub s:subs){
                    if(s.getRefundId()!=null&&s.getRefundId()!=-1L){
                        if(tmp.get(s.getRefundId())!=null){
                            continue;
                        }
                        tmp.put(s.getRefundId(),s.getRefundId());
                        List<DaifaAfterSaleSub> sublist=refundGroup.get(s.getRefundId());
                        DaifaSaleAfterRefund refund=new DaifaSaleAfterRefund();
                        refund.setAfterSalePostCode(sublist.get(0).getApplyExpressCode());
                        refund.setAfterSalePostName(sublist.get(0).getApplyExpressName());
                        refund.setOpeReason(sublist.get(0).getApplyRefuseReason());
                        List<Integer> status= Arrays.asList(5,7);
                        if(status.contains(sublist.get(0).getAfterStatus())){
                            refund.setRefundState(1);
                        }else if(sublist.get(0).getAfterStatus()==6){
                            refund.setRefundState(2);
                        }
                        List<DaifaAfterMoneyConsult> moneys=moneyGroup.get(s.getRefundId());
                        if(moneys!=null&&moneys.size()>0){
                            if(moneys.get(moneys.size()-1).getConsultType()==2){
                                refund.setRefundFeeType(2);
                            }else{
                                refund.setRefundFeeType(1);
                            }
                            List<String> strs=new ArrayList<>();
                            for(DaifaAfterMoneyConsult m:moneys){
                                String str=DateUtil.dateToString(m.getCreateTime(),DateUtil.patternD)+" ";
                                if(m.getConsultType()==1){
                                    str+="修改为:"+m.getConsultMoney();
                                }else{
                                    str+="拒绝:"+m.getConsultMoney();
                                }
                                strs.add(str);
                            }
                            refund.setEditIndo(strs);
                        }else{
                            refund.setRefundFeeType(1);
                        }
                        switch (s.getAfterType()){
                            case 1:{
                                switch (s.getAfterStatus()){
                                    case 1:{
                                        refund.setAfterSaleState(1);
                                        break;
                                    }
                                    case 2:{
                                        refund.setAfterSaleState(s.getApplyDealStatus()==1?2:3);
                                        break;
                                    }
                                    case 3:{
                                        refund.setAfterSaleState(4);
                                        break;
                                    }
                                    case 4:{
                                        refund.setAfterSaleState(5);
                                        break;
                                    }
                                }
                                break;
                            }
                            case 2:{
                                switch (s.getAfterStatus()){
                                    case 1:{
                                        refund.setAfterSaleState(21);
                                        break;
                                    }
                                    case 2:{
                                        refund.setAfterSaleState(s.getApplyDealStatus()==1?22:23);
                                        break;
                                    }
                                    case 3:{
                                        refund.setAfterSaleState(24);
                                        break;
                                    }
                                    case 4:{
                                        refund.setAfterSaleState(25);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        int innum=0;
                        int ennum=0;

                        List<DaifaSaleAfterSub> subvos=new ArrayList<>();
                        for(DaifaAfterSaleSub sub:sublist){
                            DaifaSaleAfterSub subvo=new DaifaSaleAfterSub();
                            DaifaOrder o=orderMap.get(s.getDfOrderId());
                            subvo.setChildOrderId(s.getDfOrderId());
                            subvo.setChildRemark(s.getRemark());
                            subvo.setChildServersFee(o.getSingleServicesFee());
                            subvo.setGoodsProperty(s.getPropStr());
                            subvo.setImgSrc(s.getPicPath());
                            subvo.setNum(s.getGoodsNum());
                            subvo.setPayPrice(o.getSinglePiPrice());
                            subvo.setPiPrice(o.getSinglePiPrice());
                            subvo.setTitle(o.getTitle());
                            subvo.setStoreGoodsCode(o.getStoreGoodsCode());
                            if(s.getInStock()!=null&&s.getInStock()==1){
                                innum++;
                            }
                            if(s.getInStock()!=null&&s.getInStock()==2){
                                ennum++;
                            }
                            subvos.add(subvo);
                            num++;
                        }
                        refund.setChildOrders(subvos);

                        List<DaifaSaleAfterStock> stocks=new ArrayList<>();
                        if(innum>0){
                            DaifaSaleAfterStock stock=new DaifaSaleAfterStock();
                            stock.setType(1);
                            stock.setStorageNum(innum);
                            stocks.add(stock);
                        }
                        if(ennum>0){
                            DaifaSaleAfterStock stock=new DaifaSaleAfterStock();
                            stock.setType(2);
                            stock.setStorageNum(ennum);
                            stocks.add(stock);
                        }
                        refund.setPutInStorageState(stocks);
                        refunds.add(refund);
                    }else{
                        num++;
                        DaifaSaleAfterRefund refund=new DaifaSaleAfterRefund();
                        refund.setAfterSaleState(0);
                        List<DaifaSaleAfterSub> subvos=new ArrayList<>();
                        DaifaSaleAfterSub subvo=new DaifaSaleAfterSub();
                        DaifaOrder o=orderMap.get(s.getDfOrderId());
                        subvo.setChildOrderId(s.getDfOrderId());
                        subvo.setChildRemark(s.getRemark());
                        subvo.setChildServersFee(o.getSingleServicesFee());
                        subvo.setGoodsProperty(s.getPropStr());
                        subvo.setImgSrc(s.getPicPath());
                        subvo.setNum(s.getGoodsNum());
                        subvo.setPayPrice(o.getSinglePiPrice());
                        subvo.setPiPrice(o.getSinglePiPrice());
                        subvo.setTitle(o.getTitle());
                        subvo.setStoreGoodsCode(o.getStoreGoodsCode());
                        subvos.add(subvo);
                        refund.setChildOrders(subvos);
                        refund.setEditIndo(new ArrayList<>());
                        refund.setPutInStorageState(new ArrayList<>());
                        refunds.add(refund);
                    }
                }
                vo.setChildOrderNum(num);
                vo.setAfterSales(refunds);
                vos.add(vo);
            }
        }
        ShiguPager<DaifaSaleAfter> pager=new ShiguPager<>();
        pager.setContent(vos);
        pager.setNumber(bo.getPage());
        pager.calPages(count,10);
        return pager;
    }

}
