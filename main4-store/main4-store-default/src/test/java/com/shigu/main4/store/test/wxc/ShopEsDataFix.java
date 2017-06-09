package com.shigu.main4.store.test.wxc;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.searchtool.domain.SimpleElaBean;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.Jobs;
import com.shigu.main4.store.test.BaseSpringTest;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.ShopInES;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by bugzy on 2017/5/27 0027.
 */

public class ShopEsDataFix extends BaseSpringTest {

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private ShiguMarketMapper shiguMarketMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Test
    public void jobsToEs(){

        ShiguMarket market = new ShiguMarket();
        market.setCanRegist(1);
        final Map<Long, ShiguMarket> marketMap = BeanMapper.list2Map(shiguMarketMapper.select(market), "marketId", Long.class);

        Jobs<List<ShiguShop>> jobs = new Jobs<List<ShiguShop>>(20) {
            @Override
            public void doWork(List<ShiguShop> shops) throws Exception {
                for (ShiguShop shop : shops) {
                    ShopInES sies= BeanMapper.map(shop,ShopInES.class);
                    ShiguMarket floor = marketMap.get(shop.getFloorId());
                    if (floor != null) {
                        sies.setMarket(floor.getParentMarketName());
                        sies.setFloor(floor.getMarketName());
                    }
                    redisIO.rpush("bulk_shop_to_es",new SimpleElaBean(
                            "shop",
                            shop.getWebSite(),
                            shop.getShopId().toString(),
                            JSON.toJSONStringWithDateFormat(sies, "yyyy-MM-dd HH:mm:ss")
                    ));
                }
            }
        };

        int start;
        int size = 100;
        ShiguShopExample shiguShopExample = new ShiguShopExample();
        shiguShopExample.setStartIndex(start = 0);
        shiguShopExample.setEndIndex(size);
        shiguShopExample.createCriteria().andShopStatusEqualTo(0);

        List<ShiguShop> shiguShops;
        while (!(shiguShops = shiguShopMapper.selectByConditionList(shiguShopExample)).isEmpty()) {
            jobs.addJob(shiguShops);
            shiguShopExample.setStartIndex(start += size);
        }

        jobs.join();
    }
}
