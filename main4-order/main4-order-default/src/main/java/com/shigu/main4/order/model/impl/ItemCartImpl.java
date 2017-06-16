package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.beans.ItemCart;
import com.opentae.data.mall.interfaces.ItemCartMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.model.Cart;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品购物车实现
 * Created by zhaohongbo on 17/6/9.
 */
@Service("itemCart")
public class ItemCartImpl implements Cart{

    @Autowired
    private ItemCartMapper itemCartMapper;

    @Override
    public <T extends ProductVO> void addProduct(T pro,Integer number) {
        ItemProductVO productVO = (ItemProductVO) pro;
        ItemCart cart = BeanMapper.map(productVO, ItemCart.class);
        cart.setSkuId(productVO.getSelectiveSku().getSkuId());
        cart.setNum(number);
//        cart.setUserId(); TODO: 缺失1个信息
        itemCartMapper.insertSelective(cart);
    }

    @Override
    public void rmProduct(Long cartId) {

    }

    @Override
    public Long modifyProductNumber(Long cartId, Integer number) {
        return null;
    }

    @Override
    public Long modifyProductSku(Long cartId, Long skuId) {
        return null;
    }
}
