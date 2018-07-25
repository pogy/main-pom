package com.shigu.seller.services;

import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.seller.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.services
 * @ClassName: DropShippingOrderServices
 * @Author: sy
 * @CreateDate: 2018/5/4 0004 13:57
 */
@Service
public class DropShippingOrderServices {

    @Autowired
    private ItemOrderMapper itemOrderMapper;
    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

    public ShiguPager<OrdersVo> shopDropShippingOrder(Long shopId, Long oId, String goodsNo,Integer page,Integer pageSize){
        ShiguPager<OrdersVo> pager=new ShiguPager<>();
        pager.setNumber(page);
        pager.setContent(new ArrayList<>());
        int count=itemOrderMapper.getDropShippingOrderCount(shopId,oId,goodsNo);
        if(count!=0){
            List<OrdersVo> dfOrderVoList = itemOrderMapper.getDropShippingOrder(shopId,oId,goodsNo,(page-1)*pageSize,pageSize);
            dfOrderVoList.forEach(ordersVo -> {
                ordersVo.setTradeTime(DateUtil.dateToString(ordersVo.getCreateTime(),DateUtil.patternD));
                ordersVo.setTradePay(MoneyUtil.dealPrice(ordersVo.getChildOrders().stream().mapToLong(value -> value.getPriceLong()*value.getSkus().stream().mapToInt(SkusVo::getNum).sum()).sum()));
                ordersVo.getChildOrders().forEach(childOrdersVo -> {
                    childOrdersVo.setPrice(MoneyUtil.dealPrice(childOrdersVo.getPriceLong()));
                });
            });
            pager.setContent(dfOrderVoList);
        }
        pager.calPages(count,pageSize);
        return pager;
    }

    public ShiguPager<OrderGoodsVo> shopDropShippingGoods(Long shopId,String goodsNo,Integer page,Integer pageSize){
        ShiguPager<OrderGoodsVo> pager=new ShiguPager<>();
        pager.setNumber(page);
        pager.setContent(new ArrayList<>());
        int count=itemOrderMapper.getDropShippingGoodsCount(shopId,goodsNo);
        if (count != 0) {
            List<DfGoodsVo> dfGoodsVoList = itemOrderMapper.getDropShippingGoods(shopId,goodsNo,(page-1)*pageSize,pageSize);
            List<Long> goodsIds = new ArrayList<>();
            dfGoodsVoList.forEach(dfGoodsVo -> {
                Long goodsId = dfGoodsVo.getGoodsId();
                goodsIds.add(goodsId);
            });
            List<Long> goodsIdList = new ArrayList<>(new HashSet<>(goodsIds));
            List<OrderGoodsVo> ogVos = new ArrayList<>();
            goodsIdList.forEach(goodsId ->{
                Boolean b = true;
                OrderGoodsVo ogVo = new OrderGoodsVo();
                List<SkusGoodsVo> sgVos = new ArrayList<>();
                Integer totalCount = 0;
                for (int i = 0; i <dfGoodsVoList.size() ; i++) {
                    if(goodsId.equals(dfGoodsVoList.get(i).getGoodsId())){
                        if (b){
                            ogVo.setGoodsId(dfGoodsVoList.get(i).getGoodsId());
                            ogVo.setGoodsNo(dfGoodsVoList.get(i).getGoodsNo());
                            ogVo.setImgsrc(dfGoodsVoList.get(i).getPicUrl());
                            Double price = dfGoodsVoList.get(i).getPrice().doubleValue()/100;
                            ogVo.setPrice(price.toString());
                            ogVo.setTitle(dfGoodsVoList.get(i).getTitle());
                            ogVo.setXzPrice(price.toString());
                            b=false;
                        }
                        SkusGoodsVo skusGoodsVo = new SkusGoodsVo();
                        skusGoodsVo.setColor(dfGoodsVoList.get(i).getColor());
                        Integer n = dfGoodsVoList.get(i).getNum() - dfGoodsVoList.get(i).getInStok();
                        skusGoodsVo.setNum(n);
                        skusGoodsVo.setSize(dfGoodsVoList.get(i).getSize());
                        sgVos.add(skusGoodsVo);
                        totalCount += n;
                    }

                }
                Double tradePay = totalCount * Double.valueOf(ogVo.getPrice());
                ogVo.setTotalCount(totalCount);
                ogVo.setTradePay(tradePay.toString());
                ogVo.setSkus(sgVos);
                ogVos.add(ogVo);
            });
            for (int i = 0; i <ogVos.size() ; i++) {
                for (int j = 0; j <ogVos.get(i).getSkus().size() ; j++) {
                    if (ogVos.get(i).getSkus().get(j).getNum() == 0){
                        ogVos.get(i).getSkus().remove(j);
                    }
                }
                if (ogVos.get(i).getTotalCount() == 0){
                    ogVos.remove(i);
                }
            }
            Iterator<OrderGoodsVo> it = ogVos.iterator();
            while(it.hasNext()){
                OrderGoodsVo x = it.next();
                if(x.getTotalCount()==0){
                    it.remove();
                }
            }
            pager.setContent(ogVos);
        }
        pager.calPages(count,pageSize);
        return pager;
    }

}
