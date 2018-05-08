package com.shigu.seller.services;

import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.seller.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public List<OrdersVo> shopDropShippingOrder(Long shopId,Long oId,String goodsNo){
        List<OrdersVo> dfOrderVoList = itemOrderMapper.getDropShippingOrder(shopId,oId,goodsNo);
        dfOrderVoList.forEach(ordersVo -> {
            ordersVo.setTradeTime(DateUtil.dateToString(ordersVo.getCreateTime(),DateUtil.patternD));
            ordersVo.setTradePay(MoneyUtil.dealPrice(ordersVo.getChildOrders().stream().mapToLong(value -> value.getPriceLong()*value.getSkus().stream().mapToInt(SkusVo::getNum).sum()).sum()));
            ordersVo.getChildOrders().forEach(childOrdersVo -> {
                childOrdersVo.setPrice(MoneyUtil.dealPrice(childOrdersVo.getPriceLong()));
            });
        });
//        List<Long> oids = new ArrayList<>();
//        List<Long> goodsIds = new ArrayList<>();
//        dfOrderVoList.forEach(dfOrderVo -> {
//            Long oid = dfOrderVo.getOid();
//            Long goodsId = dfOrderVo.getGoodsId();
//            oids.add(oid);
//            goodsIds.add(goodsId);
//        });
//        List<Long> oidList = new ArrayList<>(new HashSet<>(oids));
//        List<Long> goodsIdList = new ArrayList<>(new HashSet<>(goodsIds));
//        List<OrdersVo> ordersVos = new ArrayList<>();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        oidList.forEach(oid ->{
//            Boolean b = true;
//            OrdersVo ordersVo = new OrdersVo();
//            Long orderId = null;
//            String ordertime = "";
//            Long tradePay = 0l;
//            Double p = null;
//            List<ChildOrdersVo> covos = new ArrayList<>();
//            for (int i = 0; i <goodsIdList.size() ; i++) {
//                ChildOrdersVo coVo = new ChildOrdersVo();
//                List<SkusVo> skusVoList = new ArrayList<>();
//                boolean a = true;
//                for (int j = 0; j <dfOrderVoList.size() ; j++) {
//                    SkusVo skusVo = new SkusVo();
//                    if (oid ==dfOrderVoList.get(j).getOid()){
//                        if (b){
//                            orderId = oid;
//                            ordertime = format.format(dfOrderVoList.get(j).getCreateTime());
//                            b=false;
//                        }
//                        if (goodsIdList.get(i).equals(dfOrderVoList.get(j).getGoodsId())){
//                            if (a) {
//                                coVo.setGoodsId(dfOrderVoList.get(j).getGoodsId());
//                                coVo.setGoodsNo(dfOrderVoList.get(j).getGoodsNo());
//                                coVo.setImgsrc(dfOrderVoList.get(j).getPicUrl());
//                                p = dfOrderVoList.get(j).getPrice().doubleValue() / 100;
//                                coVo.setPrice(p.toString());
//                                coVo.setTitle(dfOrderVoList.get(j).getTitle());
//                                a=false;
//                            }
//                            skusVo.setColor(dfOrderVoList.get(j).getColor());
//                            skusVo.setNum(dfOrderVoList.get(j).getNum());
//                            skusVo.setHaveTakeGoodsNum(dfOrderVoList.get(j).getInStok());
//                            skusVo.setSize(dfOrderVoList.get(j).getSize());
//                            skusVoList.add(skusVo);
//                            tradePay += dfOrderVoList.get(j).getNum()*dfOrderVoList.get(j).getPrice();
//                        }
//                    }
//                }
//                if (skusVoList.size()>0) {
//                    coVo.setSkus(skusVoList);
//                    covos.add(coVo);
//                }
//            }
//            ordersVo.setOrderId(orderId);
//            ordersVo.setTradeTime(ordertime);
//            ordersVo.setChildOrders(covos);
//            Double sumPrice = tradePay.doubleValue()/100;
//            ordersVo.setTradePay(sumPrice.toString());
//            ordersVos.add(ordersVo);
//        });
        return dfOrderVoList;
    }

    public List<OrderGoodsVo> shopDropShippingGoods(Long shopId,String goodsNo){

        List<DfGoodsVo> dfGoodsVoList = itemOrderMapper.getDropShippingGoods(shopId,goodsNo);
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
            if (ogVos.get(i).getTotalCount() == 0){
                ogVos.remove(i);
            }
            for (int j = 0; j <ogVos.get(i).getSkus().size() ; j++) {
                if (ogVos.get(i).getSkus().get(j).getNum() == 0){
                    ogVos.get(i).getSkus().remove(j);
                }
            }
        }
        return ogVos;
    }

}
