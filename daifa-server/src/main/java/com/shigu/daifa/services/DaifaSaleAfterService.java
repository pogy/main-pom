package com.shigu.daifa.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.daifa.bo.SaleAfterBO;
import com.shigu.daifa.vo.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.bo.SaleAfterRemarkerBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.SaleAfterProcess;
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
    @Autowired
    private DaifaRefuseReasonMapper daifaRefuseReasonMapper;
    @Autowired
    private SaleAfterProcess saleAfterProcess;

    /**
     * 列表
     * @param bo
     * @return
     */
    public ShiguPager<DaifaSaleAfterVO> afterSaleOrder(SaleAfterBO bo, Long sellerId){
        List<Long> saleIds=new ArrayList<>();
        if(!StringUtils.isEmpty(bo.getBackPostCode())){
            DaifaAfterSaleSubExample daifaAfterSaleSubExample=new DaifaAfterSaleSubExample();
            daifaAfterSaleSubExample.createCriteria().andApplyExpressCodeEqualTo(bo.getBackPostCode());
            List<DaifaAfterSaleSub> subs=daifaAfterSaleSubMapper.selectFieldsByExample(daifaAfterSaleSubExample, FieldUtil.codeFields("after_sale_id"));
            saleIds= BeanMapper.getFieldList(subs,"afterSaleId",Long.class);
        }
        DaifaAfterSaleExample daifaAfterSaleExample=new DaifaAfterSaleExample();
        DaifaAfterSaleExample.Criteria ce=daifaAfterSaleExample.createCriteria().andSellerIdEqualTo(sellerId);
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
        List<DaifaSaleAfterVO> vos=new ArrayList<>();
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
                DaifaSaleAfterVO vo=new DaifaSaleAfterVO();
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
                List<DaifaSaleAfterRefundVO> refunds=new ArrayList<>();
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
                        DaifaSaleAfterRefundVO refund=new DaifaSaleAfterRefundVO();
                        refund.setRefundId(s.getRefundId());
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

                        List<DaifaSaleAfterSubVO> subvos=new ArrayList<>();
                        for(DaifaAfterSaleSub sub:sublist){
                            DaifaSaleAfterSubVO subvo=new DaifaSaleAfterSubVO();
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
                            if(sub.getInStock()!=null&&sub.getInStock()==1){
                                innum++;
                            }
                            if(sub.getInStock()!=null&&sub.getInStock()==2){
                                ennum++;
                            }
                            subvos.add(subvo);
                            num++;
                        }
                        refund.setChildOrders(subvos);

                        List<DaifaSaleAfterStockVO> stocks=new ArrayList<>();
                        if(innum>0){
                            DaifaSaleAfterStockVO stock=new DaifaSaleAfterStockVO();
                            stock.setType(1);
                            stock.setStorageNum(innum);
                            stocks.add(stock);
                        }
                        if(ennum>0){
                            DaifaSaleAfterStockVO stock=new DaifaSaleAfterStockVO();
                            stock.setType(2);
                            stock.setStorageNum(ennum);
                            stocks.add(stock);
                        }
                        refund.setPutInStorageState(stocks);
                        refunds.add(refund);
                    }else{
                        num++;
                        DaifaSaleAfterRefundVO refund=new DaifaSaleAfterRefundVO();
                        refund.setAfterSaleState(0);
                        List<DaifaSaleAfterSubVO> subvos=new ArrayList<>();
                        DaifaSaleAfterSubVO subvo=new DaifaSaleAfterSubVO();
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
        ShiguPager<DaifaSaleAfterVO> pager=new ShiguPager<>();
        pager.setContent(vos);
        pager.setNumber(bo.getPage());
        pager.calPages(count,10);
        return pager;
    }

    /**
     * 改价格
     * @param refundId
     * @param refundMoney
     * @throws DaifaException
     */
    public void editRefund(Long refundId, String refundMoney) throws DaifaException {
        saleAfterProcess.moneyConsult(refundId,refundMoney);
    }

    /**
     * 售后备注
     * @param orderId
     * @param remarkCon
     * @throws DaifaException
     */
    public void addAfterServerRemarkJson(Long orderId, String remarkCon) throws DaifaException {
        DaifaAfterSaleExample daifaAfterSaleExample=new DaifaAfterSaleExample();
        daifaAfterSaleExample.createCriteria().andDfTradeIdEqualTo(orderId);
        List<DaifaAfterSale> sales=daifaAfterSaleMapper.selectFieldsByExample(daifaAfterSaleExample,FieldUtil.codeFields("after_sale_id"));
        if(sales.size()!=1){
            throw new DaifaException("orderId错误");
        }
        SaleAfterRemarkerBO bo=new SaleAfterRemarkerBO();
        bo.setAfterSaleId(sales.get(0).getAfterSaleId());
        bo.setRemark(remarkCon);
        saleAfterProcess.saleAfterRemark(bo);
    }

    /**
     * 获取拒绝原因列表
     * @return
     */
    public List<RefuseReasonVO> getRefuseReason() {
        DaifaRefuseReasonExample daifaRefuseReasonExample=new DaifaRefuseReasonExample();
        daifaRefuseReasonExample.createCriteria().andDealReasonTypeEqualTo(1).andUseStatusEqualTo(1);
        daifaRefuseReasonExample.setOrderByClause("deal_reason_id asc");
        List<DaifaRefuseReason> list=daifaRefuseReasonMapper.selectByExample(daifaRefuseReasonExample);
        List<RefuseReasonVO> vos=new ArrayList<>();
        for(DaifaRefuseReason re:list){
            RefuseReasonVO vo=new RefuseReasonVO();
            vo.setText(re.getDealReason());
            vo.setType(re.getDealReasonId());
            vos.add(vo);
        }
        return vos;
    }

    /**
     * 拒绝受理
     * @param refundId
     * @param dealReasonId
     * @throws DaifaException
     */
    public void refuseAfterSale(Long refundId, Long dealReasonId) throws DaifaException {
        DaifaRefuseReason reason=daifaRefuseReasonMapper.selectByPrimaryKey(dealReasonId);
        if(reason==null){
            throw new DaifaException("原因类型错误");
        }
        saleAfterProcess.afterApplyDeal(refundId,2,reason.getDealReason());
    }

    /**
     * 受理
     * @param refundId
     * @throws DaifaException
     */
    public void agreeAfterSale(Long refundId) throws DaifaException {
        saleAfterProcess.afterApplyDeal(refundId,1,null);
    }
}
