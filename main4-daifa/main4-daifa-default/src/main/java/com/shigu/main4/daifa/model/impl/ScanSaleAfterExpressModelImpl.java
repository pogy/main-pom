package com.shigu.main4.daifa.model.impl;

import com.opentae.data.daifa.beans.DaifaAfterReceiveExpresStock;
import com.opentae.data.daifa.beans.DaifaAfterSaleSub;
import com.opentae.data.daifa.examples.DaifaAfterReceiveExpresStockExample;
import com.opentae.data.daifa.examples.DaifaAfterSaleSubExample;
import com.opentae.data.daifa.interfaces.DaifaAfterReceiveExpresStockMapper;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleSubMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.ScanSaleAfterExpressModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

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
        if(subs.size()==0){
            throw new DaifaException("not find after-sale");
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
                    stock.setReceivedExpressName(sub.getApplyExpressName());
                    daifaAfterReceiveExpresStockMapper.insertSelective(stock);
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
                            stock.setReceivedExpressCode(stocks.get(0).getReceivedExpressCode());
                            stock.setReceivedExpressName(stocks.get(0).getReceivedExpressName());
                            daifaAfterReceiveExpresStockMapper.insertSelective(stock);
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String expressScanInStock(String expressName, String expressCode, String stockLocation, String sendPhone) throws DaifaException {
        DaifaAfterReceiveExpresStock stock=new DaifaAfterReceiveExpresStock();
        stock.setReceivedExpressCode(expressCode);
        stock=daifaAfterReceiveExpresStockMapper.selectOne(stock);
        if(stock==null){
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
    public String rebackPrintExpress(Long orderId) throws DaifaException {
        return null;
    }



}
