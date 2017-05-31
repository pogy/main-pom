package com.shigu.main4.store.test.wxc;

import com.shigu.main4.store.test.BaseSpringTest;
import com.shigu.main4.storeservices.ShopSearchService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wxc on 2017/4/5.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class ShopSearchServiceImplTest extends BaseSpringTest {

    @Autowired
    private ShopSearchService shopSearchService;

    @Test
    public void searchShop() throws Exception {
        show(shopSearchService.searchShop("电商 379",null, null, 1, 15));
    }

    @Test
    public void selShopByIds() throws Exception {
        List<Long> ids = new ArrayList<>();
        ids.add(41844L);
        ids.add(32888L);
        ids.add(16589L);
        Long[] stores = {35749L, 32861L, 16573L, 41603L, 35782L, 41836L, 29858L, 39959L, 40721L, 15908L, 40097L, 42538L, 39055L};
        show(shopSearchService.selShopByIds(Arrays.asList(stores),"hz"));
    }

    @Test
    public void selShopByShopNum() throws Exception {
        show(shopSearchService.selShopByShopNum("8211","hz"));
    }

}