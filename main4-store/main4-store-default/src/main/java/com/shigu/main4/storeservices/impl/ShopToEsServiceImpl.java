package com.shigu.main4.storeservices.impl;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.searchtool.domain.SimpleElaBean;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.storeservices.ShopToEsService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.ShopInES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhaohongbo on 17/5/27.
 */
@Service
public class ShopToEsServiceImpl implements ShopToEsService {

    @Autowired
    RedisIO redisIO;
    @Resource(name = "tae_mall_shiguMarketMapper")
    private ShiguMarketMapper shiguMarketMapper;

    @Resource(name = "tae_mall_shiguShopMapper")
    private ShiguShopMapper shiguShopMapper;
    /**
     * 添加到ES
     * @param shopId
     */
    @Override
    public void addToEs(Long shopId) {
        ShiguShop shop=shiguShopMapper.selectByPrimaryKey(shopId);
        if(shop!=null){
            ShopInES sies= BeanMapper.map(shop,ShopInES.class);
            ShiguMarket floor=shiguMarketMapper.selectByPrimaryKey(shop.getFloorId());
            if(floor!=null){
                sies.setMarket(floor.getParentMarketName());
                sies.setFloor(floor.getMarketName());
            }
            redisIO.rpush("bulk_shop_to_es",new SimpleElaBean(
                    "shop",
                    shop.getWebSite(),
                    shopId.toString(),
                    JSON.toJSONStringWithDateFormat(sies, "yyyy-MM-dd HH:mm:ss")
            ));

        }
    }
}
