package com.shigu.seller.services;

import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.seller.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<DfOrderVo> dfOrderVoList = itemOrderMapper.getDropShippingOrder(shopId,oId,goodsNo);
        List<Long> oids = new ArrayList<>();
        List<Long> goodsIds = new ArrayList<>();
        dfOrderVoList.forEach(dfOrderVo -> {
            Long oid = dfOrderVo.getOid();
            Long goodsId = dfOrderVo.getGoodsId();
            oids.add(oid);
            goodsIds.add(goodsId);
        });
        List<Long> oidList = new ArrayList<>(new HashSet<>(oids));
        List<Long> goodsIdList = new ArrayList<>(new HashSet<>(goodsIds));
        List<OrdersVo> ordersVos = new ArrayList<>();
        oidList.forEach(oid ->{
            Boolean b = true;
            OrdersVo ordersVo = new OrdersVo();
            Long orderId = null;
            String ordertime = "";
            Long tradePay = 0l;
            List<ChildOrdersVo> covos = new ArrayList<>();
            for (int i = 0; i <goodsIdList.size() ; i++) {
                ChildOrdersVo coVo = new ChildOrdersVo();
                Boolean a = true;
                List<SkusVo> skusVoList = new ArrayList<>();
                for (int j = 0; j <dfOrderVoList.size() ; j++) {
                    SkusVo skusVo = new SkusVo();
                    if (oid ==dfOrderVoList.get(j).getOid() && goodsIdList.get(i)==dfOrderVoList.get(j).getGoodsId()){
                        if (b){
                            orderId = oid;
                            ordertime = dfOrderVoList.get(j).getCreateTime().toString();
                            b=false;
                        }
                        if (a){
                            coVo.setGoodsId(dfOrderVoList.get(j).getGoodsId());
                            coVo.setGoodsNo(dfOrderVoList.get(j).getGoodsNo());
                            coVo.setImgsrc(dfOrderVoList.get(j).getPicUrl());
                            coVo.setPrice(dfOrderVoList.get(j).getPrice());
                            coVo.setTitle(dfOrderVoList.get(j).getTitle());
                        }
                        skusVo.setColor(dfOrderVoList.get(j).getColor());
                        skusVo.setNum(dfOrderVoList.get(j).getNum());
                        skusVo.setHaveTakeGoodsNum(dfOrderVoList.get(j).getInStok());
                        skusVo.setSize(dfOrderVoList.get(j).getSize());
                        skusVoList.add(skusVo);
                        tradePay += dfOrderVoList.get(j).getNum()*dfOrderVoList.get(j).getPrice();
                    }
                }
                coVo.setSkus(skusVoList);
            }
            ordersVo.setOrderId(orderId);
            ordersVo.setTradeTime(ordertime);
            ordersVo.setChildOrders(covos);
            Double sumPrice = tradePay.doubleValue()/100;
            ordersVo.setTradePay(sumPrice.toString());
            ordersVos.add(ordersVo);
        });
        return ordersVos;
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
                if(goodsId == dfGoodsVoList.get(i).getGoodsId() && b){
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
                if (goodsId == dfGoodsVoList.get(i).getGoodsId()){
                    skusGoodsVo.setColor(dfGoodsVoList.get(i).getColor());
                    skusGoodsVo.setNum(dfGoodsVoList.get(i).getNum());
                    skusGoodsVo.setSize(dfGoodsVoList.get(i).getSize());
                    sgVos.add(skusGoodsVo);
                    totalCount += dfGoodsVoList.get(i).getNum();
                }
            }
            Double tradePay = totalCount * Double.valueOf(ogVo.getPrice())/100;
            ogVo.setTotalCount(totalCount);
            ogVo.setTradePay(tradePay.toString());
            ogVos.add(ogVo);
        });
        return ogVos;
    }

}
