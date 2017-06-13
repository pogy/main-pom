package com.shigu.main4.order.model.impltest;

import com.opentae.data.mall.interfaces.ItemProductMapper;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.ItemProduct;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 *  产品服务测试
 * Created by bugzy on 2017/6/13 0013.
 */
public class ItemProductImplTest extends BaseTest {

    @Autowired
    private ItemProductMapper itemProductMapper;

    @Test
    public void selSkus() throws Exception {
    }

    @Test
    public void modifyWeight() throws Exception {
    }

    @Test
    public void modifyPrice() throws Exception {
        Long pid = 1L;
        Long modPrice = 500L;
        ItemProduct product = SpringBeanFactory.getBean(ItemProduct.class, pid);
        product.modifyPrice(modPrice);

        com.opentae.data.mall.beans.ItemProduct primaryKey = itemProductMapper.selectByPrimaryKey(pid);

        assertEquals(primaryKey.getPrice(), modPrice);
    }

    @Test
    public void selWeight() throws Exception {
    }

}