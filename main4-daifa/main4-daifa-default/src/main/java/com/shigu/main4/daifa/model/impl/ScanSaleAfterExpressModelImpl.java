package com.shigu.main4.daifa.model.impl;

import com.opentae.data.daifa.beans.DaifaAfterReceiveExpresStock;
import com.opentae.data.daifa.beans.DaifaAfterSaleSub;
import com.opentae.data.daifa.examples.DaifaAfterReceiveExpresStockExample;
import com.opentae.data.daifa.examples.DaifaAfterSaleSubExample;
import com.opentae.data.daifa.interfaces.DaifaAfterReceiveExpresStockMapper;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleSubMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.bo.RebackPrintExpressBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.ScanSaleAfterExpressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
@Scope("prototype")
public class ScanSaleAfterExpressModelImpl implements ScanSaleAfterExpressModel{
    @Autowired
    private DaifaAfterReceiveExpresStockMapper daifaAfterReceiveExpresStockMapper;
    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;
    @Override
    public String expressScanRelevance(String expressCode) throws DaifaException {
        DaifaAfterSaleSubExample daifaAfterSaleSubExample=new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andApplyExpressCodeEqualTo(expressCode);
        List<DaifaAfterSaleSub> subs=daifaAfterSaleSubMapper.selectByExample(daifaAfterSaleSubExample);
        List<Long> updateIds=new ArrayList<>();
        if(subs.size()==0){
            throw new DaifaException("not find after-sale",DaifaException.DEBUG);
        }else{
            DaifaAfterReceiveExpresStockExample daifaAfterReceiveExpresStockExample=new DaifaAfterReceiveExpresStockExample();
            daifaAfterReceiveExpresStockExample.createCriteria().andReceivedExpressCodeEqualTo(expressCode);
            List<DaifaAfterReceiveExpresStock> stocks=daifaAfterReceiveExpresStockMapper.selectByExample(daifaAfterReceiveExpresStockExample);
            if(stocks.size()==0){
                for(DaifaAfterSaleSub sub:subs){
                    DaifaAfterReceiveExpresStock stock=new DaifaAfterReceiveExpresStock();
                    stock.setDfOrderId(sub.getDfOrderId());
                    stock.setDfTradeId(sub.getDfTradeId());
                    stock.setRefundId(sub.getRefundId());
                    stock.setRelevanceStatus(1);
                    stock.setOrderPartitionId(sub.getOrderPartitionId());
                    stock.setTradeCode(sub.getTradeCode());
                    stock.setOrderCode(sub.getOrderCode());
                    stock.setReceivedExpressCode(expressCode);
                    stock.setSendPhone(sub.getBuyerTelephone());
                    stock.setReceivedExpressName(sub.getApplyExpressName());
                    stock.setCreateTime(new Date());
                    daifaAfterReceiveExpresStockMapper.insertSelective(stock);
                    updateIds.add(sub.getAfterSaleSubId());
                }
            }else{
                List<Long> oids= BeanMapper.getFieldList(stocks,"dfOrderId",Long.class);
                for(DaifaAfterSaleSub sub:subs){
                    if(!oids.contains(sub.getDfOrderId())){
                        DaifaAfterReceiveExpresStock stock=new DaifaAfterReceiveExpresStock();
                        stock.setDfOrderId(sub.getDfOrderId());
                        stock.setDfTradeId(sub.getDfTradeId());
                        stock.setRefundId(sub.getRefundId());
                        stock.setRelevanceStatus(1);
                        stock.setOrderPartitionId(sub.getOrderPartitionId());
                        stock.setTradeCode(sub.getTradeCode());
                        stock.setOrderCode(sub.getOrderCode());
                        if(stocks.size()==1&&stocks.get(0).getDfOrderId()==null){
                            stock.setReceivedExpressId(stocks.get(0).getReceivedExpressId());
                            stocks.get(0).setDfOrderId(sub.getDfOrderId());
                            daifaAfterReceiveExpresStockMapper.updateByPrimaryKeySelective(stock);
                        }else{
                            stock.setCreateTime(new Date());
                            stock.setReceivedExpressCode(stocks.get(0).getReceivedExpressCode());
                            stock.setReceivedExpressName(stocks.get(0).getReceivedExpressName());
                            daifaAfterReceiveExpresStockMapper.insertSelective(stock);
                        }
                        updateIds.add(sub.getAfterSaleSubId());
                    }else if(sub.getAfterStatus()==3&&sub.getReceivedTime()!=null){
                        updateIds.add(sub.getAfterSaleSubId());
                    }
                }
            }
        }
        if(updateIds.size()>0){
            DaifaAfterSaleSub sub1=new DaifaAfterSaleSub();
            sub1.setAfterStatus(4);
            sub1.setReceivedTime(new Date());
            daifaAfterSaleSubExample.clear();
            daifaAfterSaleSubExample.createCriteria().andAfterSaleSubIdIn(updateIds);
            daifaAfterSaleSubMapper.updateByExampleSelective(sub1,daifaAfterSaleSubExample);
        }
        return null;
    }

    @Override
    public String expressScanInStock(String expressName, String expressCode, String stockLocation, String sendPhone){
        DaifaAfterReceiveExpresStock stock=new DaifaAfterReceiveExpresStock();
        stock.setReceivedExpressCode(expressCode);
        List<DaifaAfterReceiveExpresStock> stocks=daifaAfterReceiveExpresStockMapper.select(stock);
        if(stocks.size()==0){
            stock=new DaifaAfterReceiveExpresStock();
            stock.setReceivedExpressName(expressName);
            stock.setReceivedExpressCode(expressCode);
            stock.setRelevanceStatus(0);
            stock.setCreateTime(new Date());
            stock.setSendPhone(sendPhone);
            stock.setStockLocation(stockLocation);
            daifaAfterReceiveExpresStockMapper.insertSelective(stock);
        }
        return null;
    }

    @Override
    public String rebackPrintExpress(RebackPrintExpressBO bo) throws DaifaException {
        DaifaAfterSaleSub daifaAfterSaleSub = new DaifaAfterSaleSub();
        daifaAfterSaleSub.setDfOrderId(bo.getOrderId());
        DaifaAfterSaleSub oldSub = daifaAfterSaleSubMapper.selectOne(daifaAfterSaleSub);
        if (oldSub == null){
            throw new DaifaException("not find after-sale",DaifaException.DEBUG);
        }
        Date now = new Date();
        daifaAfterSaleSub.setAfterSaleSubId(oldSub.getAfterSaleSubId());//设置主键
        daifaAfterSaleSub.setSendReturnDate(DateUtil.dateToString(now,DateUtil.patternB));
        daifaAfterSaleSub.setSendReturnTime(now);
        daifaAfterSaleSub.setLastDoTime(now);
        daifaAfterSaleSub.setApplyExpressName(bo.getApplyExpressName());
        daifaAfterSaleSub.setApplyExpressCode(bo.getApplyExpressCode());
        daifaAfterSaleSub.setRemark(oldSub.getRemark()+":"+bo.getRemark());//备注信息

        switch (oldSub.getAfterType()){//售后类型@1退货2换货
            case 1:
                daifaAfterSaleSub.setReturnExpressCode(bo.getReturnExpressCode());
                daifaAfterSaleSub.setReturnExpressName(bo.getReturnExpressName());
                break;
            case 2:
                daifaAfterSaleSub.setChangeExpressCode(bo.getChangeExpressCode());
                daifaAfterSaleSub.setChangeExpressName(bo.getChangeExpressName());
                break;
            default:
                throw new DaifaException("未定义的售后类型",DaifaException.DEBUG);
        }
        daifaAfterSaleSubMapper.updateByPrimaryKeySelective(daifaAfterSaleSub);
        return null;
    }



}
