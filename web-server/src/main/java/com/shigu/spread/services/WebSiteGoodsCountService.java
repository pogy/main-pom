package com.shigu.spread.services;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.tools.RedisIO;
import com.shigu.spread.exceptions.SpreadCacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By Administrator on 2018/5/4 0004/12:52
 * 各站点首页在售商品数量  缓存
 */
@Service
public class WebSiteGoodsCountService {

    @Autowired
    RedisIO redisIO;

    private static String INDEX_PAGE_REDIS_PRE = "index_page_redis_pre_";   //首页redis缓存key的前缀

    /**
     * 取缓存
     * @param key
     * @return
     */
    public Object getGoodsCountFromCache(String key, Class c) throws SpreadCacheException {
        String jsonstr=redisIO.get(INDEX_PAGE_REDIS_PRE + key);
        if (jsonstr != null) {
            if(jsonstr.startsWith("[")){//是数组
                return JSON.parseArray(jsonstr,c);
            }else{
                return JSON.parseObject(jsonstr,c);
            }
        } else {
            SpreadCacheException e = new SpreadCacheException();
            e.setType(SpreadCacheException.CacheType.NONE);
            throw e;
        }
    }

    /**
     * 设置缓存
     * @param key
     * @param obj
     */
    public void addCache(String key, Object obj){
        if (obj==null || key==null) {
            return;
        }
        redisIO.putTemp(INDEX_PAGE_REDIS_PRE + key, obj, 10*60);
    }

    /**
     * 清理缓存
     * @param key
     */
    public void clearCache(String key) {
        redisIO.del(INDEX_PAGE_REDIS_PRE + key);
    }
}
