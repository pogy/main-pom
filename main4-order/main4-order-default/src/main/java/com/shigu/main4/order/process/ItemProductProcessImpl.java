package com.shigu.main4.order.process;

import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.beans.ShiguGoodsTaoRelation;
import com.opentae.data.mall.examples.ItemOrderSubExample;
import com.opentae.data.mall.examples.ItemProductExample;
import com.opentae.data.mall.examples.ShiguGoodsTaoRelationExample;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.opentae.data.mall.interfaces.ItemProductMapper;
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
}
