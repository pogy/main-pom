package com.shigu.spread.services;


import com.shigu.main4.tools.RedisIO;
import com.shigu.spread.exceptions.SpreadCacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

/**
 * 首页的缓存
 * 如果缓存能取,直接取,如果缓存不能取,使用备用数据
 * 每次新获得缓存,刷新备用数据
 * Created by zhulm on 17/6/22.
 */
@Service
public class RedisForIndexPage {
    @Autowired
    private RedisIO redisIO;

    private static String INDEX_PAGE_REDIS_PRE = "index_page_redis_pre_";   //首页redis缓存key的前缀


    /**
     * 取缓存
     * @param key
     * @return
     */
    public Object getFromCache(String key, Class c) throws SpreadCacheException {
        Object obj = redisIO.get(INDEX_PAGE_REDIS_PRE + key,  c);
        if (obj != null) {
            return obj;
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
    public void putCache(String key, Object obj){
        if (obj==null || key==null) {
            return;
        }

        redisIO.putFixedTemp(INDEX_PAGE_REDIS_PRE + key, obj, 24*60*60);
    }

    /**
     * 清理缓存
     * @param key
     */
    public void clearCache(String key) {
        redisIO.del(INDEX_PAGE_REDIS_PRE + key);
    }
}
