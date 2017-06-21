package com.shigu.main4.order.model.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ItemCart;
import com.opentae.data.mall.examples.ItemCartExample;
import com.opentae.data.mall.examples.ItemProductExample;
import com.opentae.data.mall.interfaces.ItemCartMapper;
import com.opentae.data.mall.interfaces.ItemProductMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.exceptions.ItemCartNumOutOfBoundsException;
import com.shigu.main4.order.model.Cart;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.ProductVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 商品购物车实现
 * Created by zhaohongbo on 17/6/9.
 */
@Service
@Scope("prototype")
public class ItemCartImpl implements Cart {

    @Autowired
    private ItemCartMapper itemCartMapper;

    @Autowired
    private ItemProductMapper itemProductMapper;

    private Long userId;

    public ItemCartImpl(Long userId) {
        this.userId = userId;
    }

    @Override
    public <T extends ProductVO> void addProduct(T pro, Integer number) {
        ItemProductVO productVO = (ItemProductVO) pro;
        ItemCart cart = BeanMapper.map(productVO, ItemCart.class);
        cart.setSkuId(productVO.getSelectiveSku().getSkuId());
        cart.setNum(number);
        cart.setUserId(userId);
        itemCartMapper.insertSelective(cart);
    }

    @Override
    public void rmProduct(Long cartId) {

    }

    /**
     * 按商品信息移除相应数量的商品
     *
     * @param pid
     * @param skuId
     * @param num
     */
    @Override
    public void rmProductByNum(Long pid, Long skuId, Integer num) throws ItemCartNumOutOfBoundsException {
        if (pid == null || skuId == null || num == null) {
            return;
        }

        ItemCartExample itemCartExample = new ItemCartExample();

        itemCartExample.setWebSite("hz");

        ItemCartExample.Criteria criteria = itemCartExample.createCriteria();

        criteria.andPidEqualTo(pid);

        criteria.andSkuIdEqualTo(skuId);

        List<ItemCart> number = itemCartMapper.selectFieldsByExample(itemCartExample, FieldUtil.codeFields("num"));

        ItemCart selItemCart = number.get(0);

        if (num > selItemCart.getNum()) {

            throw new ItemCartNumOutOfBoundsException("传入的num值大于存储值");

        }

        selItemCart.setNum(selItemCart.getNum() - num);

        itemCartMapper.updateByExampleSelective(selItemCart, itemCartExample);

    }


    @Override
    public Long modifyProductNumber(Long cartId, Integer number) {
        return null;
    }

    @Override
    public Long modifyProductSku(Long cartId, Long skuId) {
        return null;
    }

    /**
     * 某用户购物车订单数量
     *
     * @return
     */
    @Override
    public int productNumbers() {
        return 0;
    }

    public List<ItemProductVO> listProduct() {
        List<ItemProductVO> vos = new ArrayList<>();
        ItemCart cart = new ItemCart();
        cart.setUserId(userId);
        for (ItemCart itemCart : itemCartMapper.select(cart)) {
            ItemProductVO info = SpringBeanFactory.getBean(ItemProductImpl.class, itemCart.getPid(), itemCart.getSkuId()).info();
            info.setNum(itemCart.getNum());
            vos.add(info);
        }
        return vos;
    }
}
