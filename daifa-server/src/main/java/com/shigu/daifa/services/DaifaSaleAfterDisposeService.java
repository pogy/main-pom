package com.shigu.daifa.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.DaifaAfterSaleExample;
import com.opentae.data.daifa.examples.DaifaAfterSaleSubExample;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleMapper;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleSubMapper;
import com.opentae.data.daifa.interfaces.DaifaOrderMapper;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.daifa.bo.SaleAfterBO;
import com.shigu.daifa.vo.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.SaleAfterProcess;
import com.shigu.tools.JsonResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DaifaSaleAfterDisposeService {
    @Autowired
    private DaifaAfterSaleMapper daifaAfterSaleMapper;
    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;
    @Autowired
    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    private DaifaOrderMapper daifaOrderMapper;
    @Autowired
    private SaleAfterProcess saleAfterProcess;

    public ShiguPager<DaifaSaleAfterDisposeVO> afterSaleProcess(SaleAfterBO bo,Long sellerId){
        DaifaAfterSaleSubExample daifaAfterSaleSubExamplex=new DaifaAfterSaleSubExample();
        DaifaAfterSaleSubExample.Criteria ca=daifaAfterSaleSubExamplex.createCriteria().andSellerIdEqualTo(sellerId).andAfterStatusEqualTo(4);
        if(!StringUtils.isEmpty(bo.getBackPostCode())){
            ca.andApplyExpressCodeEqualTo(bo.getBackPostCode());
        }
        List<DaifaAfterSaleSub> subsx=daifaAfterSaleSubMapper.selectFieldsByExample(daifaAfterSaleSubExamplex, FieldUtil.codeFields("after_sale_id"));
        List<Long>saleIds= BeanMapper.getFieldList(subsx,"afterSaleId",Long.class);

        DaifaAfterSaleExample daifaAfterSaleExample=new DaifaAfterSaleExample();
        DaifaAfterSaleExample.Criteria ce=daifaAfterSaleExample.createCriteria().andSellerIdEqualTo(sellerId).andAfterSaleIdIn(saleIds);
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

        List<DaifaSaleAfterDisposeVO> vos=new ArrayList<>();
        if(count>0){
            daifaAfterSaleExample.setStartIndex((bo.getPage()-1)*10);
            daifaAfterSaleExample.setEndIndex(10);
            daifaAfterSaleExample.setOrderByClause("afterSaleId desc");
            List<DaifaAfterSale> sales=daifaAfterSaleMapper.selectByConditionList(daifaAfterSaleExample);

            List<Long> tids=BeanMapper.getFieldList(sales,"dfTradeId",Long.class);
            DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
            daifaTradeExample.createCriteria().andDfTradeIdIn(tids);
            List<DaifaTrade> trades=daifaTradeMapper.selectByExample(daifaTradeExample);
            Map<Long,DaifaTrade> tradeMap=BeanMapper.list2Map(trades,"dfTradeId",Long.class);

            saleIds=BeanMapper.getFieldList(sales,"afterSaleId",Long.class);
            DaifaAfterSaleSubExample daifaAfterSaleSubExample=new DaifaAfterSaleSubExample();
            daifaAfterSaleSubExample.createCriteria().andAfterSaleIdIn(saleIds);
            List<DaifaAfterSaleSub> subs=daifaAfterSaleSubMapper.selectByExample(daifaAfterSaleSubExample);
            Map<Long,List<DaifaAfterSaleSub>> subsGroup=BeanMapper.groupBy(subs,"afterSaleId",Long.class);

            List<Long> oids=BeanMapper.getFieldList(subs,"dfOrderId",Long.class);
            DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
            daifaOrderExample.createCriteria().andDfOrderIdIn(oids);
            List<DaifaOrder> orders=daifaOrderMapper.selectByExample(daifaOrderExample);
            Map<Long,DaifaOrder> orderMap=BeanMapper.list2Map(orders,"dfOrderId",Long.class);

            List<Long> refundIds=BeanMapper.getFieldList(subs,"refundId",Long.class);
            for(DaifaAfterSale sale:sales){
                DaifaTrade t=tradeMap.get(sale.getDfTradeId());
                DaifaSaleAfterDisposeVO vo=new DaifaSaleAfterDisposeVO();
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
                vo.setIsTbOrder(t.getDaifaType()==2);
                Integer num=0;
                List<DaifaSaleAfterDisposeRefundVO> refunds=new ArrayList<>();
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
                        DaifaSaleAfterDisposeRefundVO refund=new DaifaSaleAfterDisposeRefundVO();
                        refund.setRefundId(s.getRefundId());

                        List<DaifaSaleAfterDisposeSubVO> subvos=new ArrayList<>();
                        boolean isInStock=true;
                        for(DaifaAfterSaleSub sub:sublist){
                            DaifaSaleAfterDisposeSubVO subvo=new DaifaSaleAfterDisposeSubVO();
                            DaifaOrder o=orderMap.get(sub.getDfOrderId());
                            subvo.setChildOrderId(sub.getDfOrderId());
                            subvo.setChildRemark(sub.getRemark());
                            subvo.setChildServersFee(o.getSingleServicesFee());
                            subvo.setGoodsProperty(sub.getPropStr());
                            subvo.setImgSrc(sub.getPicPath());
                            subvo.setNum(sub.getGoodsNum());
                            subvo.setPayPrice(o.getSinglePiPrice());
                            subvo.setPiPrice(o.getSinglePiPrice());
                            subvo.setTitle(o.getTitle());
                            subvo.setStoreGoodsCode(o.getStoreGoodsCode());
                            if(sub.getAfterStatus()>3){
                                subvo.setAfterSaleState(sub.getAfterType()==1?5:25);
                                subvo.setPutInStorageType(sub.getInStock()!=null&&sub.getInStock()==1?1:2);
                            }else{
                                subvo.setAfterSaleState(0);
                                subvo.setPutInStorageType(3);
                            }
                            if(sub.getInStock()==null){
                                isInStock=false;
                            }
                            subvo.setAfterSalePostCode(sub.getApplyExpressCode());
                            subvo.setAfterSalePostName(sub.getApplyExpressName());
                            subvos.add(subvo);
                            num++;
                        }
                        refund.setAllNotPutInIs(isInStock);
                        refund.setChildOrders(subvos);
                        refunds.add(refund);
                    }else{
                        num++;
                        DaifaSaleAfterDisposeRefundVO refund=new DaifaSaleAfterDisposeRefundVO();
                        refund.setAllNotPutInIs(true);
                        List<DaifaSaleAfterDisposeSubVO> subvos=new ArrayList<>();
                        DaifaSaleAfterDisposeSubVO subvo=new DaifaSaleAfterDisposeSubVO();
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
                        subvo.setAfterSaleState(0);
                        subvo.setPutInStorageType(3);
                        subvos.add(subvo);
                        refund.setChildOrders(subvos);
                        refunds.add(refund);
                    }
                }
                vo.setChildOrderNum(num);
                vo.setAfterSales(refunds);
                vos.add(vo);
            }
        }
        ShiguPager<DaifaSaleAfterDisposeVO> pager=new ShiguPager<>();
        pager.setContent(vos);
        pager.setNumber(bo.getPage());
        pager.calPages(count,10);
        return pager;
    }

    public void writeRefund(Long refundId, String refundMoney) throws DaifaException {
        saleAfterProcess.storeRefundAgree(refundId,refundMoney);
    }

    public void writeStockCode(Long childOrderId, String stockCode, String reason) throws DaifaException {
        saleAfterProcess.storeRefundRefuse(childOrderId,reason,stockCode);
    }
}
