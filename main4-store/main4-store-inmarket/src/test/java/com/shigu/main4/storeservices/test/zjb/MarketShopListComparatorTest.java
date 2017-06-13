package com.shigu.main4.storeservices.test.zjb;

import com.shigu.main4.storeservices.vo.MarketShopListComparator;
import org.junit.Test;

/**
 * Created by zhaohongbo on 17/5/25.
 */
public class MarketShopListComparatorTest {

    @Test
    public void shopnumNumberTest(){
        MarketShopListComparator comparator=new MarketShopListComparator();
        System.out.println(comparator.shopnumNumber("1-3-2"));
        System.out.println(comparator.shopnumNumber("1-东街-3"));
    }
}
