package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.interfaces.ItemProductMapper;
import com.shigu.main4.order.model.ItemProduct;
import com.shigu.main4.order.vo.ItemSkuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品形式的产品实现类
 * Created by zhaohongbo on 17/6/9.
 */
@Repository
@Scope("prototype")
public class ItemProductImpl implements ItemProduct{

    private Long pid;

    @Autowired
    private ItemProductMapper itemProductMapper;

    public ItemProductImpl(Long goodsId,String color,String size) {
    }

    @Override
    public List<ItemSkuVO> selSkus() {
        return null;
    }

    @Override
    public void modifyWeight(Long meter) {

    }

    @Override
    public void modifyPrice(Long price) {
        com.opentae.data.mall.beans.ItemProduct product = new com.opentae.data.mall.beans.ItemProduct();
        product.setPrice(price);
        product.setPid(pid);
        itemProductMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public Long selWeight() {
        return null;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
