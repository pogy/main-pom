package com.shigu.daifa.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.daifa.bo.ParcelSearchBO;
import com.shigu.daifa.bo.PutInStorageBO;
import com.shigu.daifa.bo.SaleAfterBO;
import com.shigu.daifa.vo.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.daifa.bo.ExpressScanInStockBO;
import com.shigu.main4.daifa.bo.SaleAfterRemarkerBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.SaleAfterProcess;
import com.shigu.main4.daifa.process.ScanSaleAfterExpressProcess;
import com.shigu.main4.daifa.vo.ExpressRelevanceSubVO;
import com.shigu.main4.daifa.vo.ExpressRelevanceVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
    private DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    private SaleAfterProcess saleAfterProcess;
    @Autowired
    private ScanSaleAfterExpressProcess scanSaleAfterExpressProcess;
    @Autowired
    private DaifaAfterReceiveExpresStockMapper daifaAfterReceiveExpresStockMapper;
    @Autowired
    private DaifaSendService daifaSendService;



    public AfterSumVO sum(Long sellerId){
        Integer totalNum=daifaAfterSaleSubMapper.selectAfterCount(sellerId,null);
        Integer returnNum=daifaAfterSaleSubMapper.selectAfterCount(sellerId,1);
        Integer changeNum=daifaAfterSaleSubMapper.selectAfterCount(sellerId,2);
        SendSumVO sendSum=daifaSendService.sum(sellerId);
        int queCount = 0;
        DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andCreateDateEqualTo(DateUtil.dateToString(new Date(),DateUtil.patternB));
        daifaGgoodsTasksExample.setOrderByClause("tasks_id desc");
        List<DaifaGgoodsTasks> ts=daifaGgoodsTasksMapper.selectFieldsByExample(daifaGgoodsTasksExample,
                FieldUtil.codeFields("df_order_id,take_goods_status,goods_num"));
        if(ts.size()>0){
            Map<Long, List<DaifaGgoodsTasks>> goodsMap = BeanMapper.groupBy(ts, "dfOrderId", Long.class);
            queCount=goodsMap.values().stream().map(daifaGgoodsTasksList ->
                    daifaGgoodsTasksList.stream().findFirst().get())
                    .collect(Collectors.toList())
                    .stream().filter(daifaGgoodsTasks -> daifaGgoodsTasks.getTakeGoodsStatus()==2)
                    .mapToInt(DaifaGgoodsTasks::getGoodsNum).sum();
        }
        AfterSumVO vo=new AfterSumVO();
        vo.setAfterOrderNum(totalNum);
        vo.setRefundsNum(returnNum);
        vo.setExchangeNum(changeNum);
        vo.setBeenShippedGoodsFee(sendSum.getBeenShippedGoodsFee());
        vo.setStockoutNum(queCount);
        return vo;
    }

    /**
     * 列表
     * @param bo
     * @return
     */
    public ShiguPager<DaifaSaleAfterVO> afterSaleOrder(SaleAfterBO bo, Long sellerId,Integer pageSize){
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
            daifaAfterSaleExample.setStartIndex((bo.getPage()-1)*pageSize);
            daifaAfterSaleExample.setEndIndex(pageSize);
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
                List<DaifaAfterSaleSub> saleOfSubs=subsGroup.get(sale.getAfterSaleId());
                for(DaifaAfterSaleSub s:saleOfSubs){
                    if(s.getRefundId()==null){
                        s.setRefundId(-1L);
                    }
                }
                Map<Long,List<DaifaAfterSaleSub>> refundGroup=BeanMapper.groupBy(saleOfSubs,"refundId",Long.class);

                Map<Long,Long> tmp=new HashMap<>();
                for(DaifaAfterSaleSub s:saleOfSubs){
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
                        String shop=null;
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
                                    shop=m.getConsultMoney();
                                }else{
                                    str+="拒绝:"+m.getConsultMoney();
                                }
                                strs.add(str);
                            }
                            refund.setEditInfo(strs);
                        }else{
                            refund.setRefundFeeType(0);
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
                        Long shopMoney=0L;
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
                            shopMoney+= MoneyUtil.StringToLong(sub.getStoreReturnMoney()==null?"0.00":sub.getStoreReturnMoney());
                            if(sub.getInStock()!=null&&sub.getInStock()==1){
                                innum++;
                            }
                            if(sub.getInStock()!=null&&sub.getInStock()==2){
                                ennum++;
                            }
                            subvos.add(subvo);
                            num++;
                        }
                        if(shop==null){
                            shop=MoneyUtil.dealPrice(shopMoney);
                        }
                        refund.setRefundForShop(shop);
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
                        refund.setEditInfo(new ArrayList<>());
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

    /**
     * 退回单
     * @param
     * @param postCode
     */
    public List<DaifaSalePackageOrderVO> returnOrder(String postCode){
//        DaifaAfterSaleSubExample daifaAfterSaleSubExample=new DaifaAfterSaleSubExample();
//        daifaAfterSaleSubExample.createCriteria().andApplyExpressCodeEqualTo(postCode);
//        List<DaifaAfterSaleSub> subs=daifaAfterSaleSubMapper.selectFieldsByExample(daifaAfterSaleSubExample,FieldUtil.codeFields("after_sale_id"));
//        if(subs.size()==0){
//            return new ArrayList<>();
//        }
//        List<Long> saleIds=BeanMapper.getFieldList(subs,"afterSaleId",Long.class);
//        DaifaAfterSaleExample daifaAfterSaleExample=new DaifaAfterSaleExample();
//        daifaAfterSaleExample.createCriteria().andAfterSaleIdIn(saleIds);
//        List<DaifaAfterSale> sales=daifaAfterSaleMapper.selectByExample(daifaAfterSaleExample);
//
//        daifaAfterSaleSubExample.clear();
//        daifaAfterSaleSubExample.createCriteria().andAfterSaleIdIn(saleIds);
//        subs=daifaAfterSaleSubMapper.selectByExample(daifaAfterSaleSubExample);
//
//        List<Long> tids=BeanMapper.getFieldList(sales,"dfTradeId",Long.class);
//        DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
//        daifaTradeExample.createCriteria().andDfTradeIdIn(tids);
//        List<DaifaTrade> trades=daifaTradeMapper.selectByExample(daifaTradeExample);
//        Map<Long,DaifaTrade> tradeMap=BeanMapper.list2Map(trades,"dfTradeId",Long.class);
//
//        List<Long> oids=BeanMapper.getFieldList(subs,"dfOrderId",Long.class);
//        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
//        daifaOrderExample.createCriteria().andDfOrderIdIn(oids);
//        List<DaifaOrder> orders=daifaOrderMapper.selectByExample(daifaOrderExample);
//        Map<Long,DaifaOrder> orderMap=BeanMapper.list2Map(orders,"dfOrderId",Long.class);
//
//        Map<Long,List<DaifaAfterSaleSub>> subGroup=BeanMapper.groupBy(subs,"afterSaleId",Long.class);
//        List<DaifaSalePackageOrderVO> vos=new ArrayList<>();
//        for(DaifaAfterSale sale:sales){
//            DaifaSalePackageOrderVO vo=new DaifaSalePackageOrderVO();
//            DaifaTrade t=tradeMap.get(sale.getDfTradeId());
//            vo.setAllChildRemark(sale.getRemark());
//            vo.setAfterSaleTime(DateUtil.dateToString(sale.getCreateTime(),DateUtil.patternD));
//            vo.setBuyerRemark(sale.getBuyerRemark());
//            vo.setDiscountFee(t.getTradeDiscountFee());
//            vo.setExpressCode(t.getExpressCode());
//            vo.setExpressFee(t.getExpressFee());
//            vo.setExpressName(t.getExpressName());
//            vo.setImQq(t.getBuyerQq());
//            vo.setImTel(t.getBuyerTelephone());
//            vo.setImWw(t.getBuyerWw());
//            vo.setOrderId(t.getDfTradeId());
//            vo.setReceiverAddress(t.getReceiverAddress());
//            vo.setReceiverName(t.getReceiverName());
//            vo.setReceiverPhone(t.getReceiverPhone());
//            vo.setSendTime(DateUtil.dateToString(t.getSendTime(),DateUtil.patternD));
//            vo.setServersFee(t.getServicesFee());
//            vo.setTotalFee(t.getTotalFee());
//            vo.setIsTbOrder(t.getDaifaType()==2);
//            List<DaifaSalePackageOrderSubVO> subvos=new ArrayList<>();
//            List<DaifaAfterSaleSub> subList=subGroup.get(sale.getAfterSaleId());
//            for(DaifaAfterSaleSub s:subList){
//                DaifaSalePackageOrderSubVO subvo=new DaifaSalePackageOrderSubVO();
//                DaifaOrder o=orderMap.get(s.getDfOrderId());
//                subvo.setChildOrderId(s.getDfOrderId());
//                subvo.setChildRemark(s.getRemark());
//                subvo.setChildServersFee(o.getSingleServicesFee());
//                subvo.setGoodsProperty(s.getPropStr());
//                subvo.setImgSrc(s.getPicPath());
//                subvo.setNum(s.getGoodsNum());
//                subvo.setPayPrice(o.getSinglePiPrice());
//                subvo.setPiPrice(o.getSinglePiPrice());
//                subvo.setTitle(o.getTitle());
//                subvo.setStoreGoodsCode(o.getStoreGoodsCode());
//                subvo.setAfterSalePostCode(s.getApplyExpressCode());
//                subvo.setAfterSalePostName(s.getApplyExpressName());
//                switch (s.getAfterStatus()){
//                    case 1: case 2: {
//                        subvo.setAfterSaleState(1);
//                        break;
//                    }
//                    case 3:{
//                        subvo.setAfterSaleState(4);
//                        break;
//                    }
//                    case 4: case 5: case 6: case 7: case 10:{
//                        subvo.setAfterSaleState(5);
//                        break;
//                    }
//                }
//
//                if(subvo.getAfterSaleState()==null){
//                    subvo.setAfterSaleState(0);
//                }else{
//                    subvo.setAfterSaleState(s.getAfterType()==2?subvo.getAfterSaleState()+20:subvo.getAfterSaleState());
//                }
//                subvo.setChildRemark(o.getOrderRemark());
//                subvo.setChildServersFee(o.getSingleServicesFee());
//                subvo.setIsInCangKu(s.getInStock()==null);
//                subvo.setNowScanPostIs(postCode.equals(s.getApplyExpressCode()));
//                subvos.add(subvo);
//            }
//            vo.setChildOrders(subvos);
//            vo.setChildOrderNum(subList.size());
//            vos.add(vo);
//        }

        List<ExpressRelevanceVO> pvos=scanSaleAfterExpressProcess.expressScan(postCode);
        List<DaifaSalePackageOrderVO> vos=new ArrayList<>();
        for(ExpressRelevanceVO v:pvos){
            DaifaSalePackageOrderVO vo= new DaifaSalePackageOrderVO();
            BeanUtils.copyProperties(v,vo);
            List<DaifaSalePackageOrderSubVO> subvos=new ArrayList<>();
            for(ExpressRelevanceSubVO sv:v.getChildOrders()){
                DaifaSalePackageOrderSubVO subvo=new DaifaSalePackageOrderSubVO();
                BeanUtils.copyProperties(sv,subvo);
                subvos.add(subvo);
            }
            vo.setChildOrders(subvos);
            vos.add(vo);
        }
        return vos;
    }

    /**
     * 包裹入库
     * @param
     */
    public void putInStorage(PutInStorageBO bo) {
        ExpressScanInStockBO expressScanInStockBO = new ExpressScanInStockBO();
        expressScanInStockBO.setExpressCode(bo.getPostCode());
        expressScanInStockBO.setExpressName(bo.getPostName());
        expressScanInStockBO.setSendPhone(bo.getTelephone());
        expressScanInStockBO.setStockLocation(bo.getStockCode());
        scanSaleAfterExpressProcess.expressScanInStock(expressScanInStockBO);
    }

    /**
     * 子单入库
     * @param
     */
    public void childOrderInStorage(String stockCode,Long childOrderId) throws DaifaException{
        DaifaAfterSaleSub daifaAfterSaleSub  = new DaifaAfterSaleSub();
        daifaAfterSaleSub.setDfOrderId(childOrderId);
        daifaAfterSaleSub = daifaAfterSaleSubMapper.selectOne(daifaAfterSaleSub);
        saleAfterProcess.saleInStock(childOrderId,stockCode,daifaAfterSaleSub.getBuyerTelephone());
    }

    /**
     * 全部包裹数量
     * @param
     */
    public ParcelSearchOrderStatisticsVO getOrderStatistics(ParcelSearchBO bo) {
        ParcelSearchOrderStatisticsVO vo = new ParcelSearchOrderStatisticsVO();
        DaifaAfterReceiveExpresStock daifaAfterReceiveExpresStock = new DaifaAfterReceiveExpresStock();
        int allPackbagNum = daifaAfterReceiveExpresStockMapper.selectCount(daifaAfterReceiveExpresStock);
        daifaAfterReceiveExpresStock.setRelevanceStatus(0);//查有关联数量
        int unmatchPackbagNum = daifaAfterReceiveExpresStockMapper.selectCount(daifaAfterReceiveExpresStock);

        vo.setAllPackbagNum(allPackbagNum+"");
        vo.setMatchedPackbagNum((allPackbagNum - unmatchPackbagNum)+"");
        vo.setMatchedPackbagNum(unmatchPackbagNum+"");
        return vo;
    }

    /**
     * 添加包裹备注接口
     * @param packbagId   包裹id
     * @param remarkCon
     * @throws DaifaException
     */
    public void addPackageRemark(Long packbagId,String remarkCon) throws DaifaException {

        DaifaAfterSale sale = daifaAfterSaleMapper.selectByPrimaryKey(packbagId);
        if(sale== null){
            throw new DaifaException("packbagId错误");
        }
        SaleAfterRemarkerBO bo=new SaleAfterRemarkerBO();
        bo.setAfterSaleId(packbagId);
        bo.setRemark(remarkCon);
        saleAfterProcess.saleAfterRemark(bo);
    }

    /**
     * 查询包裹
     * @throws DaifaException
     */
    public ShiguPager<DaifaAfterReceiveExpresStockVO> getDaifaAfterReceiveExpresStock(ParcelSearchBO bo, Long sellerId) throws DaifaException {
        List<DaifaAfterReceiveExpresStockVO> vos = new ArrayList<>();
        int count=daifaAfterReceiveExpresStockMapper.selectExpressPackageCount(bo.getTelphone(),bo.getPostCode(),bo.getMatchState());
        if(count>0) {
            List<DaifaAfterReceiveExpresStock>  stocks = daifaAfterReceiveExpresStockMapper.selectExpressPackage(
                    bo.getTelphone(),bo.getPostCode(),bo.getMatchState(),(bo.getPage()-1)*10,10
            );


            for (DaifaAfterReceiveExpresStock stock : stocks){
                DaifaAfterReceiveExpresStockVO daifaAfterReceiveExpresStockVO = new DaifaAfterReceiveExpresStockVO();
                List<DaifaSaleAfterVO>  dvo=new ArrayList<>();
                if(stock.getRelevanceStatus()==1){
                    SaleAfterBO saleAfterBO = new SaleAfterBO();
                    saleAfterBO.setPage(1);
                    saleAfterBO.setTelephone(bo.getTelphone());
                    saleAfterBO.setBackPostCode(stock.getReceivedExpressCode());
                    dvo = afterSaleOrder(saleAfterBO,sellerId,100).getContent();
                    daifaAfterReceiveExpresStockVO.setPackageRemark(dvo.size()>0 ? dvo.get(0).getBuyerRemark() : "");
                }
                daifaAfterReceiveExpresStockVO.setOrders(dvo);
                daifaAfterReceiveExpresStockVO.setPackageId(stock.getReceivedExpressId()+"");
                daifaAfterReceiveExpresStockVO.setPostName(stock.getReceivedExpressName());
                daifaAfterReceiveExpresStockVO.setPostCode(stock.getReceivedExpressCode());
                daifaAfterReceiveExpresStockVO.setTelephone(stock.getSendPhone());
                daifaAfterReceiveExpresStockVO.setIsMatchingOrder(stock.getRelevanceStatus()==1);
                daifaAfterReceiveExpresStockVO.setMatchingTime(DateUtil.dateToString(stock.getCreateTime(),DateUtil.patternD));
                vos.add(daifaAfterReceiveExpresStockVO);
            }
        }

        ShiguPager<DaifaAfterReceiveExpresStockVO> pager=new ShiguPager<>();
        pager.setContent(vos);
        pager.setNumber(bo.getPage());
        pager.calPages(count,10);
        return pager;
    }

}
