package com.shigu.main4.storeservices.test.zjb;


import com.alibaba.fastjson.JSON;
import com.shigu.main4.storeservices.MarketShopService;
import com.shigu.main4.vo.FloorShow;
import com.shigu.main4.vo.MarketShow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 市场TEST
 *
 * @author shigu_zjb
 * @date 2017/02/28 14:00
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/store_test.xml")
public class MarketShopTest {

    @Resource(name = "marketShopService")
    private MarketShopService marketShopService;

    /**
     * 测试排序
     *
     * |A230 A231 -1| A230 A229 1| A230 A230 0|
     * |A230 B230 -1| A230 B230-1 -1|A230-1 B230-1 -1|
     * |B230 B230-1 -2|B230-A B230-B -1|B230-1 B230-2 -1|
     * storeId,storeNum,storeName,systemComment,logo;
     *
     */
    @Test
    public void marketLetterSortTest(){
        String letterA = "B230-1";
        String letterB = "B230-2";
        int sortint = letterA.compareTo(letterB);
        System.out.println(sortint);
    }


    /**
     * 市场列表查询排序
     *
     */
    @Test
    public void marketListSort(){
        Long marketId = 35L;
        MarketShow marketShowList = marketShopService.selMarketShow(marketId);
        System.out.println(JSON.toJSONString(marketShowList));
    }

    /**
     * 根据外部楼层查楼层店铺信息
     *
     */
    @Test
    public void selFloorShow(){
        Long outFloorId = 609L;
        FloorShow floorShow = marketShopService.selFloorShow(outFloorId);
        System.out.println("按照规则排序显示店铺列表：" + JSON.toJSONString(floorShow));

        floorShow = marketShopService.selFloorShow(outFloorId);
        System.out.println("按照规则排序显示店铺列表：" + JSON.toJSONString(floorShow));
    }

}
