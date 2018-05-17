package com.shigu.spread.services;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.tools.RedisIO;
import com.shigu.spread.exceptions.SpreadCacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.spread.services
 * @ClassName: RedisForFlickrPage
 * @Author: sy
 * @CreateDate: 2018/5/3 0003 14:24
 */
@Service
public class RedisForFlickrPage {

    @Autowired
    private RedisIO redisIO;

    private static String FLICKR_PAGE_REDIS_PRE = "flickr_page_redis_pre_";   //相册redis缓存key的前缀



    /**
     * 取缓存
     * @param key
     * @return
     */
    public Object getFromCache(String key, Class c) throws SpreadCacheException {
        String jsonstr=redisIO.get(FLICKR_PAGE_REDIS_PRE + key);
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
    public void putCache(String key, Object obj){
        if (obj==null || key==null) {
            return;
        }

        redisIO.putTemp(FLICKR_PAGE_REDIS_PRE + key, obj, 48*60*60);
    }

    /**
     * 清理缓存
     * @param key
     */
    public void clearCache(String key) {
        redisIO.del(FLICKR_PAGE_REDIS_PRE + key);
    }

}
