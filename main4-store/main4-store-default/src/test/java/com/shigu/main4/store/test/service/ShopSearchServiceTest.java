package com.shigu.main4.store.test.service;


import com.fasterxml.jackson.core.FormatFeature;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.storeservices.ShopSearchService;
import com.shigu.main4.vo.SearchShop;
import com.shigu.main4.vo.ShopCat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by wxc on 2017/2/20.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/store_test.xml" )
public class ShopSearchServiceTest {

    @Resource(name="shopSearchOpenService")
    private ShopSearchService shopSearchOpenService;

    @Test
    public void testSearchOpenService() {
/*        List<ShopCat> shopCats = shopForCdnService.selShopCatsById(39347L);
        List<ShopCat> shopCatsHit = shopForCdnService.selShopCatsById(39347L);
        FormatFeature f;
        assertTrue("未cache住哇哇哇哇!", shopCats == shopCatsHit);*/
        ShiguPager<SearchShop> pager = shopSearchOpenService.searchShop("女装", "hz",null, 0, 30);
        List<SearchShop> list = pager.getContent();
        for (SearchShop item : list) {
            System.out.println(item.getMarket() + " : " + item.getShopNum());
        }
    }
}
