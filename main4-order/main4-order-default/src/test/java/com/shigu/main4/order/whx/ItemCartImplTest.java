package com.shigu.main4.order.whx;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ItemCart;
import com.opentae.data.mall.examples.ItemCartExample;
import com.opentae.data.mall.interfaces.ItemCartMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.Cart;
import com.shigu.main4.order.model.impl.ItemCartImpl;
import com.shigu.main4.order.model.impltest.ItemCartTest;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by whx on 2017/6/21 0021.
 */
public class ItemCartImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(ItemCartImplTest.class);

    @Autowired
    private ItemCartMapper itemCartMapper;

    @Test
    public void productNumbersTest() {
        System.out.println(productNumbers(1000077062L));
        System.out.println(productNumbers(0L));
    }

    @Test
    public void modCartOrderNum() {
        modCartOrderNum(3L,2);
    }

    public void modCartOrderNum(Long cid, Integer num) {
        try {
            if (num==null || num.intValue()<=0) {
                throw new Main4Exception("数量异常");
            }
            if(cid==null) {
                throw new Main4Exception("购物车编号缺失");
            }
        } catch (Main4Exception e) {
            logger.error("更改购物车数量失败",e);
            return;
        }
        ItemCartExample itemCartExample = new ItemCartExample();
        itemCartExample.createCriteria().andCartIdEqualTo(cid);
        ItemCart itemCart = new ItemCart();
        itemCart.setNum(num);
        itemCartMapper.updateByExampleSelective(itemCart,itemCartExample);
    }


    public int productNumbers(Long userId) {
        ItemCartExample itemCartExample = new ItemCartExample();
        itemCartExample.createCriteria().andUserIdEqualTo(userId);
        List<Integer> nums = BeanMapper.getFieldList(itemCartMapper.selectFieldsByExample(itemCartExample,"num"),"num",Integer.class);
        int sum = 0;
        for (Integer num: nums) {
            sum += num;
        }
        return sum;
    }
}
