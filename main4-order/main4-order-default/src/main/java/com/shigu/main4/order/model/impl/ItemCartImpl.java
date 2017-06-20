package com.shigu.main4.order.model.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ItemCart;
import com.opentae.data.mall.examples.ItemCartExample;
import com.opentae.data.mall.interfaces.ItemCartMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.exceptions.ItemCartNumOutOfBoundsException;
import com.shigu.main4.order.model.Cart;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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

    @Override
    public Long modifyProductNumber(Long cartId, Integer number) {
        return null;
    }

    @Override
    public Long modifyProductSku(Long cartId, Long skuId) {
        return null;
    }

    /**
     * TODO
     * @param pid pid
     * @param skuId skuId
     * @param number number
     */
    @Override
    public void rmProductByNum(Long pid, Long skuId, Integer number) throws ItemCartNumOutOfBoundsException{
        if (pid==null||skuId==null||number==null){
            return;
        }
        ItemCartExample itemCartExample = new ItemCartExample();
        itemCartExample.setWebSite("hz");
        ItemCartExample.Criteria criteria = itemCartExample.createCriteria();
        criteria.andPidEqualTo(pid);
        criteria.andSkuIdEqualTo(skuId);
        List<ItemCart> num = itemCartMapper.selectFieldsByExample(itemCartExample, FieldUtil.codeFields("num"));
        ItemCart selItemCart = num.get(0);
        if (number > selItemCart.getNum()) {
            throw new ItemCartNumOutOfBoundsException("传入的num值大于存储值");
        }
        selItemCart.setNum(selItemCart.getNum() - number);
        itemCartMapper.updateByExampleSelective(selItemCart, itemCartExample);
    }
}
