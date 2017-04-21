package com.shigu.main4.store.test.zjb;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.storeservices.ShopDiscusService;
import com.shigu.main4.vo.Discus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * 评分TEST
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/store_test.xml")
public class ShopDiscusServiceTest {

    @Autowired
    ShopDiscusService shopDiscusService;

    /**
     * 查询店铺平均分
     */
    @Test
    public void selectAvgShop(){
        // 店铺存在情况
        Double doubleAvg = shopDiscusService.selScoreAvg(32888L);
        assertNotEquals(null, doubleAvg);
        System.out.println("店铺平均分：" + doubleAvg);

        // 店铺不存在情况
        doubleAvg = shopDiscusService.selScoreAvg(11111111L);
        assertNotEquals(null, doubleAvg);
        assertEquals("0.0", doubleAvg.toString());
        System.out.println("店铺平均分：" + doubleAvg);
    }

    /**
     * 查询店铺评论信息
     */
    @Test
    public void selectDiscus(){
        Long shopId = 32888L;
        int pageNo = 1;
        int pageSize = 100;
        ShiguPager<Discus> discusPager = shopDiscusService.selDiscusByShopId(shopId, pageNo, pageSize);
        if(discusPager == null){
            return;
        }
        System.out.println("数据信息：" + JSON.toJSONString(discusPager.getContent()));
        System.out.println("当前页查询数据数：" + discusPager.getContent().size());
        System.out.println("分页信息：当前页：" + discusPager.getNumber() + " 总条数：" + discusPager.getTotalCount() +
                            " 总页数：" + discusPager.getTotalPages());
    }

}
