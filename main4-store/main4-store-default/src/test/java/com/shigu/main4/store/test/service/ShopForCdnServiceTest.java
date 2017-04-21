package com.shigu.main4.store.test.service;

import com.fasterxml.jackson.core.FormatFeature;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.vo.ShopCat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wxc on 2017/2/20.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/store_test.xml" )
public class ShopForCdnServiceTest {

    @Resource
    private ShopForCdnService shopForCdnService;

    /**
     * 按店ID查店内类目 测试
     *
     */
    @Test
    public void testSelShopCatsById() {
        List<ShopCat> shopCats = shopForCdnService.selShopCatsById(39347L);
        List<ShopCat> shopCatsHit = shopForCdnService.selShopCatsById(39347L);
        FormatFeature f;
        assertTrue("未cache住哇哇哇哇!", shopCats == shopCatsHit);
    }

    /**
     *  查店铺的星星数
     */
    @Test
    public void testSelShopStarById() {
        Long starById = shopForCdnService.selShopStarById(15418L);
        Long starByCache = shopForCdnService.selShopStarById(15418L);

        assertTrue(starById == starByCache);
    }
}
