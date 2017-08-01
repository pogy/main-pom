package com.shigu.main4.item.tools;

import com.searchtool.domain.SimpleElaBean;
import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 把商品添加到redis
 * Created by zhaohongbo on 17/4/16.
 */
@Service
public class GoodsAddToRedis {
    @Autowired
    RedisIO redisIO;
    private String goodslistName="bulk_goods_to_es";

    public void addToRedis(SimpleElaBean seb){
        redisIO.rpush(goodslistName,seb);
    }
}
