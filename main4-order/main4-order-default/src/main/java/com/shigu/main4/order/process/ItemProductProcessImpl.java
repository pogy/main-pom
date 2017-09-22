package com.shigu.main4.order.process;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.opentae.data.mall.beans.ItemOrderSub;
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
    public Boolean canSale(Long marketId, Long storeId, Long goodsId, String webSite) {
        return listGoodsCanSale(marketId,storeId, Lists.newArrayList(goodsId),webSite);
    }

    @Override
    public Boolean listGoodsCanSale(Long marketId, Long storeId, List<Long> goodsIds, String webSite) {
        if (!webSite.equals("hz")){
            return false;
        }
        ItemTradeForbidExample example=new ItemTradeForbidExample();
        example.createCriteria().andTypeEqualTo(1).andTargetIdEqualTo(marketId);//市场的
        example.or().andTypeEqualTo(2).andTargetIdEqualTo(storeId);//按店来
        example.or().andTypeEqualTo(3).andTargetIdIn(goodsIds);//按商品
//        example.or().andTypeEqualTo(4).andTargetIdEqualTo(cid);//按类目
        return itemTradeForbidMapper.countByExample(example)==0;

    }
}
