package com.shigu.main4.order.process;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.beans.ItemTradeForbid;
import com.opentae.data.mall.beans.ShiguGoodsTaoRelation;
import com.opentae.data.mall.examples.ItemOrderSubExample;
import com.opentae.data.mall.examples.ItemProductExample;
import com.opentae.data.mall.examples.ItemTradeForbidExample;
import com.opentae.data.mall.examples.ShiguGoodsTaoRelationExample;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.opentae.data.mall.interfaces.ItemProductMapper;
import com.opentae.data.mall.interfaces.ItemTradeForbidMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTaoRelationMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.GoodsTaoRelationBO;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.model.ItemProduct;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 对外接口实现
 * Created by bugzy on 2017/8/12 0012.
 */
@Component("itemProductProcess")
public class ItemProductProcessImpl implements ItemProductProcess {
    @Autowired
    private ShiguGoodsTaoRelationMapper shiguGoodsTaoRelationMapper;

    @Autowired
    private ItemProductMapper itemProductMapper;

    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

    @Autowired
    private ItemTradeForbidMapper itemTradeForbidMapper;

    @Override
    public ItemProductVO generateProduct(Long goodsId, String color, String size) {
        return SpringBeanFactory.getBean(ItemProduct.class, goodsId, color, size).info();
    }

    @Override
    public void relationTaoGoods(GoodsTaoRelationBO bo) {
        ShiguGoodsTaoRelation shiguGoodsTaoRelation= BeanMapper.map(bo,ShiguGoodsTaoRelation.class);
        try {
            shiguGoodsTaoRelationMapper.insertSelective(shiguGoodsTaoRelation);
        } catch (Exception e) {
            ShiguGoodsTaoRelationExample relationExample=new ShiguGoodsTaoRelationExample();
            relationExample.createCriteria().andNumIidEqualTo(shiguGoodsTaoRelation.getNumIid());
            shiguGoodsTaoRelationMapper.updateByExampleSelective(shiguGoodsTaoRelation,relationExample);
        }
    }

    @Override
    public void updateGoodsNo(Long goodsId, String goodsNo) throws OrderException {
        if (goodsId == null) {
            throw new OrderException("goodsId is null");
        }
        if (StringUtils.isEmpty(goodsNo)) {
            throw new OrderException("goodsNo is empty");
        }
        //修改产品
        ItemProductExample productExample=new ItemProductExample();
        productExample.createCriteria().andGoodsIdEqualTo(goodsId);
        com.opentae.data.mall.beans.ItemProduct product=new com.opentae.data.mall.beans.ItemProduct();
        product.setGoodsNo(goodsNo);
        itemProductMapper.updateByExampleSelective(product,productExample);
        //修改已下子订单
        ItemOrderSubExample subExample=new ItemOrderSubExample();
        subExample.createCriteria().andGoodsIdEqualTo(goodsId);
        ItemOrderSub orderSub=new ItemOrderSub();
        orderSub.setGoodsNo(goodsNo);
        itemOrderSubMapper.updateByExampleSelective(orderSub,subExample);
    }

    @Override
    public Boolean canSale(Long marketId,Long floorId, Long storeId, Long goodsId, String webSite) {
        return listGoodsCanSale(marketId,floorId,storeId, Lists.newArrayList(goodsId),webSite);
    }

    @Override
    public Boolean listGoodsCanSale(Long marketId,Long floorId, Long storeId, List<Long> goodsIds, String webSite) {
        if (!webSite.equals("hz")){
            return false;
        }
        ItemTradeForbidExample example=new ItemTradeForbidExample();
        example.createCriteria().andTypeEqualTo(1).andTargetIdEqualTo(marketId);//市场的
        example.or().andTypeEqualTo(2).andTargetIdEqualTo(storeId);//按店来
        if (floorId != null) {
            example.or().andTypeEqualTo(5).andTargetIdEqualTo(floorId);//按楼层
        }
        if (goodsIds.size()>0) {
            example.or().andTypeEqualTo(3).andTargetIdIn(goodsIds);//按商品
        }
//        example.or().andTypeEqualTo(4).andTargetIdEqualTo(cid);//按类目
        List<ItemTradeForbid> itemTradeForbids = itemTradeForbidMapper.selectByExample(example);
        if (itemTradeForbids.size()>0) {
            Map<Integer, List<ItemTradeForbid>> collect = itemTradeForbids.parallelStream().collect(Collectors.groupingBy(ItemTradeForbid::getType));
            //各维度禁止、允许销售
            List<ItemTradeForbid> typeForbid;
            //商品有不可售
            if ((typeForbid=collect.get(3)) != null) {
                if (!typeCanSale(typeForbid)) {
                    return false;
                }
                //查到商品全部可售
                if (typeForbid.size() == goodsIds.size()) {
                    return true;
                }
            }
            //店铺不可售
            if ((typeForbid=collect.get(2)) != null) {
                if (!typeCanSale(typeForbid)) {
                    return false;
                }
                return true;
            }
            //楼层不可售
            if ((typeForbid=collect.get(5)) != null) {
                if (!typeCanSale(typeForbid)) {
                    return false;
                }
                return true;
            }
            //市场不可售
            if ((typeForbid=collect.get(1)) != null) {
                if (!typeCanSale(typeForbid)) {
                    return false;
                }
                return true;
            }
        }
        //在禁止销售表里没有记录，可售
        return true;
    }

    @Override
    @Deprecated
    public Boolean canSale(Long marketId, Long storeId, Long goodsId, String webSite) {
        return canSale(marketId,null,storeId,goodsId,webSite);
    }

    @Override
    @Deprecated
    public Boolean listGoodsCanSale(Long marketId, Long storeId, List<Long> goodsId, String webSite) {
        return listGoodsCanSale(marketId,null, storeId, goodsId, webSite);
    }

    /**
     * 按类型区分过的可售/不可售记录
     * @param typeForbidList
     * @return
     */
    private boolean typeCanSale(List<ItemTradeForbid> typeForbidList){
        if (typeForbidList != null) {
            for (ItemTradeForbid itemTradeForbid : typeForbidList) {
                //本类型中有不可售项目，返回false
                if (!itemTradeForbid.getCanSale()) {
                    return false;
                }
            }
        }
        return true;
    }
}
