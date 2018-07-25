package com.item.test;

import com.shigu.main4.item.services.ShowForCdnService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 注入测试
 * Created by zhaohongbo on 17/2/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/main4/spring/item_test.xml" )
public class AutowireTest {
    @Autowired
    ShowForCdnService showForCdnService;

    @Autowired
    protected EhCacheCacheManager cacheManager;
    @Test
    public void test(){
        showForCdnService.selItemById(20065019L);
        cacheManager.getCache("cdnItemCache").evict(20065019L);
        System.out.println(showForCdnService);
    }
}
