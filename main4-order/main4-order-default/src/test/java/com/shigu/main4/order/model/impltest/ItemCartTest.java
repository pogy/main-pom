package com.shigu.main4.order.model.impltest;

import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.Cart;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;

/**
 * Created by jmb on 2017/6/20.
 */
public class ItemCartTest extends BaseTest{
    private Cart cart() throws Exception{
        return SpringBeanFactory.getBean(Cart.class,2L);
    }
    @Test
    public void rmProductByNum() throws Exception{
        cart().rmProductByNum(1L,3L,1);
//        cart().rmProductByNum(1L,1L,6);
    }

}
