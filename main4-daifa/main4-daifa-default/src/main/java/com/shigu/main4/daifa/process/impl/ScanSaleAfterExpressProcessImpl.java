package com.shigu.main4.daifa.process.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaAfterSale;
import com.opentae.data.daifa.beans.DaifaAfterSaleSub;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.examples.DaifaAfterSaleExample;
import com.opentae.data.daifa.examples.DaifaAfterSaleSubExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleMapper;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleSubMapper;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.daifa.bo.ExpressScanBO;
import com.shigu.main4.daifa.bo.ExpressScanInStockBO;
import com.shigu.main4.daifa.bo.RebackPrintExpressBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.ScanSaleAfterExpressModel;
import com.shigu.main4.daifa.process.ScanSaleAfterExpressProcess;
import com.shigu.main4.daifa.vo.ExpressRelevanceSubVO;
import com.shigu.main4.daifa.vo.ExpressRelevanceVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ScanSaleAfterExpressProcessImpl implements ScanSaleAfterExpressProcess{
    @Autowired
    private DaifaAfterSaleMapper daifaAfterSaleMapper;
    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;
    @Autowired
    private DaifaTradeMapper daifaTradeMapper;

    @Override
    public List<ExpressRelevanceVO> expressScan(String expressCode){
        List<ExpressRelevanceVO> list=new ArrayList<>();
        try {
            SpringBeanFactory.getBean(ScanSaleAfterExpressModel.class).expressScanRelevance(expressCode);
        } catch (DaifaException e) {
            return list;
        }
        DaifaAfterSaleSubExample daifaAfterSaleSubExample=new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andApplyExpressCodeEqualTo(expressCode);
        List<DaifaAfterSaleSub> subs=daifaAfterSaleSubMapper.selectFieldsByExample(daifaAfterSaleSubExample, FieldUtil.codeFields("after_sale_id"));
        List<Long> saleIds= BeanMapper.getFieldList(subs,"afterSaleId",Long.class);
        DaifaAfterSaleExample daifaAfterSaleExample=new DaifaAfterSaleExample();
        daifaAfterSaleExample.createCriteria().andAfterSaleIdIn(saleIds);
        List<DaifaAfterSale> sales=daifaAfterSaleMapper.selectByExample(daifaAfterSaleExample);
        List<Long> dfTradeIds=BeanMapper.getFieldList(sales,"dfTradeId",Long.class);
        daifaAfterSaleSubExample.clear();
        daifaAfterSaleSubExample.createCriteria().andAfterSaleIdIn(saleIds);
        subs=daifaAfterSaleSubMapper.selectByExample(daifaAfterSaleSubExample);
        Map<Long,List<DaifaAfterSaleSub>> subMap=BeanMapper.groupBy(subs,"afterSaleId",Long.class);

        DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
        daifaTradeExample.createCriteria().andDfTradeIdIn(dfTradeIds);
        List<DaifaTrade> trades=daifaTradeMapper.selectByExample(daifaTradeExample);
        Map<Long,DaifaTrade> tradeMap=BeanMapper.list2Map(trades,"dfTradeId",Long.class);

        for(DaifaAfterSale sale:sales){
            ExpressRelevanceVO vo=new ExpressRelevanceVO();
            DaifaTrade trade=tradeMap.get(sale.getDfTradeId());
            vo.setCreateTime(DateUtil.dateToString(trade.getCreateTime(),DateUtil.patternD));
            vo.setDiscountFee(trade.getTradeDiscountFee());
            vo.setDfTradeId(trade.getDfTradeId());
            vo.setExpressFee(trade.getExpressFee());
            vo.setImWw(trade.getBuyerWw());
            vo.setReceiverAddress(trade.getReceiverAddress());
            vo.setReceiverName(trade.getReceiverName());
            vo.setReceiverPhone(trade.getReceiverPhone());
            vo.setRemark(sale.getRemark());
            vo.setServersFee(trade.getServicesFee());
            vo.setTotalFee(trade.getTotalFee());
            vo.setSaleId(sale.getAfterSaleId());
            List<ExpressRelevanceSubVO> subVOs=new ArrayList<>();
            for(DaifaAfterSaleSub sub:subMap.get(sale.getAfterSaleId())){
                ExpressRelevanceSubVO subvo=new ExpressRelevanceSubVO();
                subvo.setAfterStatus(sub.getAfterStatus());
                subvo.setDfOrderId(sub.getDfOrderId());
                subvo.setGoodsNum(sub.getGoodsNum());
                subvo.setImgUrl(sub.getPicPath());
                subvo.setTitle(sub.getTitle());
                subvo.setIsScan(expressCode.equals(sub.getApplyExpressCode())?1:0);
                subvo.setPiPrice(sub.getSinglePiPrice());
                subvo.setPostCode(sub.getApplyExpressCode());
                subvo.setPostName(sub.getApplyExpressName());
                subvo.setPrice(sub.getSinglePrice());
                subvo.setPropStr(sub.getPropStr());
                subvo.setSingleServerFee(MoneyUtil.dealPrice(MoneyUtil.StringToLong(trade.getServicesFee())/trade.getGoodsNum()));
                subvo.setStoreGoodsCode(sub.getStoreGoodsCode());
                subVOs.add(subvo);
            }
            vo.setOrders(subVOs);
            list.add(vo);
        }
        return list;
    }

    @Override
    public String expressScanInStock(ExpressScanInStockBO bo){
        SpringBeanFactory.getBean(ScanSaleAfterExpressModel.class)
                .expressScanInStock(bo.getExpressName(),bo.getExpressCode(),bo.getStockLocation(),bo.getSendPhone());
        return null;
    }

    @Override
    public String rebackPrintExpress(RebackPrintExpressBO bo) throws DaifaException {
        return null;
    }
}
