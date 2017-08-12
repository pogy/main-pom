package com.shigu.main4.order.model.impltest;

import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.interfaces.ItemProductMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
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
    public void createProduct() {
        SpringBeanFactory.getBean(ItemProduct.class, 20475519L, "酒红色", "3XL");
    }

    private ItemProduct getProduct() {
        return SpringBeanFactory.getBean(ItemProduct.class, 20477519L, "酒红色", "3XL");
    }

    @Test
    public void selSkus() throws Exception {
        show(SpringBeanFactory.getBean(ItemProduct.class, 20475519L, "酒红色", "3XL").selSkus());
    }

    @Test
    public void modifyWeight() throws Exception {
        getProduct().modifyWeight(5L);
        assertEquals(getProduct().selWeight(), ((Long) 5L));
    }

    @Test
    public void modifyPrice() throws Exception {
        Long modPrice = 500L;
        ItemProduct product = SpringBeanFactory.getBean(ItemProduct.class, 20475519L, "酒红色", "4XL");
        product.modifyPrice(modPrice);

        com.opentae.data.mall.beans.ItemProduct primaryKey = itemProductMapper.selectByPrimaryKey(product.getPid());

        assertEquals(primaryKey.getPrice(), modPrice);
    }
    @Test
    public void selWeight() throws Exception {
        show(getProduct().selWeight());
    }

}