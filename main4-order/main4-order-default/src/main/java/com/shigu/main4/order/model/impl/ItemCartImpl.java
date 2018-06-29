package com.shigu.main4.order.model.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ItemCart;
import com.opentae.data.mall.examples.ItemCartExample;
import com.opentae.data.mall.interfaces.ItemCartMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.exceptions.CartException;
import com.shigu.main4.order.model.Cart;
import com.shigu.main4.order.model.ItemProduct;
import com.shigu.main4.order.vo.CartVO;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.ProductVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品购物车实现
 * Created by zhaohongbo on 17/6/9.
 */
@Service
@Scope("prototype")
public class ItemCartImpl implements Cart {

    @Autowired
    private ItemCartMapper itemCartMapper;

    private Long userId;

    public ItemCartImpl(Long userId) {
        this.userId = userId;
    }

    @Override
    public <T extends ProductVO> void addProduct(T pro, Integer number) {
        ItemProductVO productVO = (ItemProductVO) pro;
        ItemCart cart = BeanMapper.map(productVO, ItemCart.class);
        cart.setSkuId(productVO.getSelectiveSku().getSkuId());
        cart.setUserId(userId);
        List<ItemCart> itemCarts = itemCartMapper.select(cart);
        if (!itemCarts.isEmpty()) {
            number += itemCarts.stream().peek(itemCart -> itemCartMapper.deleteByPrimaryKey(itemCart.getCartId())).mapToInt(ItemCart::getNum).sum();
        }
        cart.setNum(number);
        itemCartMapper.insertSelective(cart);
    }

    @Override
    public void rmProduct(Long cartId) {
        if (null == cartId) {
            return;
        }
        ItemCartExample itemCartExample = new ItemCartExample();
        ItemCartExample.Criteria criteria = itemCartExample.createCriteria();
        criteria.andCartIdEqualTo(cartId);
        itemCartMapper.deleteByExample(itemCartExample);
    }

    /**
     * 按商品信息移除相应数量的商品
     *
     * @param pid
     * @param skuId
     * @param num
     */
    @Override
    public void rmProductByNum(Long pid, Long skuId, Integer num) {
        if (pid == null || skuId == null || num == null) {
            return;
        }
        ItemCartExample itemCartExample = new ItemCartExample();
        ItemCartExample.Criteria criteria = itemCartExample.createCriteria();
        criteria.andPidEqualTo(pid);
        criteria.andSkuIdEqualTo(skuId);
        criteria.andUserIdEqualTo(userId);
        List<ItemCart> number = itemCartMapper.selectFieldsByExample(itemCartExample, FieldUtil.codeFields("cart_id,num"));
        if (number.isEmpty()){
            return;
        }
        ItemCart selItemCart = number.get(0);
        if (num < selItemCart.getNum()) {
            selItemCart.setNum(selItemCart.getNum() - num);
            itemCartMapper.updateByExampleSelective(selItemCart, itemCartExample);
        } else {
            itemCartMapper.deleteByPrimaryKey(selItemCart.getCartId());
        }
    }


    @Override
    public Long modifyProductNumber(Long cartId, Integer number) throws CartException {
        if (cartId == null || number == null)
            throw new CartException("信息不全");
        ItemCart itemCart = new ItemCart();
        itemCart.setNum(number);
        itemCart.setCartId(cartId);
        return (long) itemCartMapper.updateByPrimaryKeySelective(itemCart);
    }

    public ItemProduct getProduct(Long cartId) throws CartException {
        ItemCart cart = itemCartMapper.selectByPrimaryKey(cartId);
        if (cart==null){
            throw new CartException("商品不存在");
        }
        return SpringBeanFactory.getBean(ItemProduct.class, cart.getPid(), cart.getSkuId());
    }

    @Override
    public Long modifyProductSku(Long cartId, String color, String size) throws CartException {
        ItemCart cart = new ItemCart();
        cart.setCartId(cartId);
        cart.setSkuId(getProduct(cartId).modSelectiveSku(color, size));
        return (long) itemCartMapper.updateByPrimaryKeySelective(cart);
    }

    /**
     * 某用户购物车订单数量
     *
     * @return
     */
    @Override
    public int productNumbers() {
        ItemCartExample itemCartExample = new ItemCartExample();
        itemCartExample.createCriteria().andUserIdEqualTo(userId);
        List<Integer> nums = BeanMapper.getFieldList(itemCartMapper.selectFieldsByExample(itemCartExample,"num"),"num",Integer.class);
        int sum = 0;
        for (Integer num: nums) {
            sum += num;
        }
        return sum;
    }


    @Override
    public List<CartVO> listProduct() {
        ItemCart cart = new ItemCart();
        cart.setUserId(userId);
        return itemCartMapper.select(cart).stream().map(itemCart -> {
            ItemProductVO info = SpringBeanFactory.getBean(ItemProduct.class, itemCart.getPid(), itemCart.getSkuId()).info();
            CartVO cartVO = BeanMapper.map(info, CartVO.class);
            cartVO.setCartId(itemCart.getCartId());
            cartVO.setNum(itemCart.getNum());
            cartVO.setUserId(userId);
            cartVO.setLastModify(itemCart.getLastModify());
            cartVO.setSkuId(info.getSelectiveSku().getSkuId());
            return cartVO;
        }).collect(Collectors.toList());
    }

    /**
     * 根据子订单id集合获取购物车内部分产品
     * @return 产品列表
     */
    @Override
    public List<CartVO> listSomeProduct(String childCartIds) {
        String[] childOrderIds = childCartIds.split(",");
        List<Long> cids = new ArrayList<>();
        for (String childOrderId : childOrderIds) {
            if (StringUtils.isBlank(childOrderId)) {
                continue;
            }
            cids.add(Long.valueOf(childOrderId));
        }
        if (cids.isEmpty()) {
            return null;
        }

        ItemCartExample cartExample = new ItemCartExample();
        cartExample.createCriteria().andUserIdEqualTo(userId).andCartIdIn(cids);
        List<ItemCart> itemCarts = itemCartMapper.selectByExample(cartExample);
        if (itemCarts == null || itemCarts.isEmpty()) {
            return null;
        }
        return itemCarts.stream().map(itemCart -> {
            ItemProductVO info = SpringBeanFactory.getBean(ItemProductImpl.class, itemCart.getPid(), itemCart.getSkuId()).info();
            CartVO cartVO = BeanMapper.map(info, CartVO.class);
            cartVO.setCartId(itemCart.getCartId());
            cartVO.setGoodsId(info.getGoodsId());
            cartVO.setPicUrl(info.getPicUrl());
            cartVO.setTitle(info.getTitle());
            cartVO.setGoodsNo(info.getGoodsNo());
            cartVO.setPrice(info.getPrice());
            cartVO.setSelectiveSku(info.getSelectiveSku());

            cartVO.setNum(itemCart.getNum());
            cartVO.setUserId(userId);
            cartVO.setLastModify(itemCart.getLastModify());
            cartVO.setSkuId(info.getSelectiveSku().getSkuId());
            return cartVO;
        }).collect(Collectors.toList());
    }


}
