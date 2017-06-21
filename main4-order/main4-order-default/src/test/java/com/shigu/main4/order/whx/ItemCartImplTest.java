package com.shigu.main4.order.whx;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ItemCart;
import com.opentae.data.mall.examples.ItemCartExample;
import com.opentae.data.mall.interfaces.ItemCartMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.model.impl.ItemCartImpl;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by whx on 2017/6/21 0021.
 */
public class ItemCartImplTest extends BaseTest {

    @Autowired
    private ItemCartMapper itemCartMapper;

    @Test
    public void productNumbersTest() {
        System.out.println(productNumbers(1000077062L));
        System.out.println(productNumbers(0L));
    }

    public int productNumbers(Long userId) {
        ItemCartExample itemCartExample = new ItemCartExample();
        itemCartExample.createCriteria().andUserIdEqualTo(userId);
        List<Integer> nums = BeanMapper.getFieldList(itemCartMapper.selectFieldsByExample(itemCartExample,"user_id,num"),"num",Integer.class);
        int sum = 0;
        for (Integer num: nums) {
            sum += num;
        }
        return sum;
    }
}
