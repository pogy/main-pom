package com.shigu.main4.daifa.process.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
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

@Service("scanSaleAfterExpressProcess")
public class ScanSaleAfterExpressProcessImpl implements ScanSaleAfterExpressProcess{
    @Autowired
    private DaifaAfterSaleMapper daifaAfterSaleMapper;
    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;
    @Autowired
    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    private DaifaOrderMapper daifaOrderMapper;
    @Autowired
    private DaifaAfterReceiveExpresStockMapper daifaAfterReceiveExpresStockMapper;

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
        Map<Long,List<DaifaAfterSaleSub>> subGroup=BeanMapper.groupBy(subs,"afterSaleId",Long.class);

        DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
        daifaTradeExample.createCriteria().andDfTradeIdIn(dfTradeIds);
        List<DaifaTrade> trades=daifaTradeMapper.selectByExample(daifaTradeExample);
        Map<Long,DaifaTrade> tradeMap=BeanMapper.list2Map(trades,"dfTradeId",Long.class);

        List<Long> oids=BeanMapper.getFieldList(subs,"dfOrderId",Long.class);
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andDfOrderIdIn(oids);
        List<DaifaOrder> orders=daifaOrderMapper.selectByExample(daifaOrderExample);
        Map<Long,DaifaOrder> orderMap=BeanMapper.list2Map(orders,"dfOrderId",Long.class);


        for(DaifaAfterSale sale:sales){
            ExpressRelevanceVO vo=new ExpressRelevanceVO();
            DaifaTrade t=tradeMap.get(sale.getDfTradeId());
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
            List<ExpressRelevanceSubVO> subvos=new ArrayList<>();
            List<DaifaAfterSaleSub> subList=subGroup.get(sale.getAfterSaleId());
            for(DaifaAfterSaleSub s:subList){
                ExpressRelevanceSubVO subvo=new ExpressRelevanceSubVO();
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
                subvo.setAfterSalePostCode(s.getApplyExpressCode());
                subvo.setAfterSalePostName(s.getApplyExpressName());
                switch (s.getAfterStatus()){
                    case 1:{
                        subvo.setAfterSaleState(1);
                        break;
                    }
                    case 2: {
                        if(s.getApplyDealStatus()==1){
                            subvo.setAfterSaleState(2);
                        }else{
                            subvo.setAfterSaleState(3);
                        }
                        break;
                    }
                    case 3:{
                        subvo.setAfterSaleState(4);
                        break;
                    }
                    case 4: case 5: case 6: case 7: case 10:{
                        subvo.setAfterSaleState(5);
                        break;
                    }
                }
                if(subvo.getAfterSaleState()==null){
                    subvo.setAfterSaleState(0);
                }else{
                    subvo.setAfterSaleState(s.getAfterType()==2?subvo.getAfterSaleState()+20:subvo.getAfterSaleState());
                }
                subvo.setChildRemark(o.getOrderRemark());
                subvo.setChildServersFee(o.getSingleServicesFee());
                subvo.setIsInCangKu(s.getAfterStatus()==4&&s.getInStock()==null);
                subvo.setNowScanPostIs(expressCode.equals(s.getApplyExpressCode()));
                subvos.add(subvo);
            }
            vo.setChildOrders(subvos);
            vo.setChildOrderNum(subList.size());
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
        SpringBeanFactory.getBean(ScanSaleAfterExpressModel.class).rebackPrintExpress(bo);
        return null;
    }

    @Override
    public void updatePackageRemark(List<Integer> receivedExpressIds, String packageRemark) {
        DaifaAfterReceiveExpresStockExample example=new DaifaAfterReceiveExpresStockExample();
        example.createCriteria().andReceivedExpressIdIn(receivedExpressIds);
        DaifaAfterReceiveExpresStock stock = new DaifaAfterReceiveExpresStock();
        stock.setPackageRemark(packageRemark);
        daifaAfterReceiveExpresStockMapper.updateByExampleSelective(stock,example);
    }

}
