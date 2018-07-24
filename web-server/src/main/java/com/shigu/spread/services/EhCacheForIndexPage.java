package com.shigu.spread.services;

import com.shigu.spread.exceptions.SpreadCacheException;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

/**
 * 首页的缓存
 * 如果缓存能取,直接取,如果缓存不能取,使用备用数据
 * 每次新获得缓存,刷新备用数据
 * Created by zhaohongbo on 17/4/10.
 */
//@Service
public class EhCacheForIndexPage {
//    @Autowired
    protected EhCacheCacheManager cacheManager;

    private String longCache="indexLongCache";
    private String shortCache="indexShortCache";

    /**
     * 取缓存
     * @param key
     * @return
     */
    public Object getFromCache(String key,Class c) throws SpreadCacheException {
        Cache scache=cacheManager.getCache(shortCache);
        Object obj=scache.get(key,c);
        if(obj!=null){
            return obj;
        }else{//取长缓存
            Cache lcache=cacheManager.getCache(longCache);
            obj=lcache.get(key,c);
            SpreadCacheException e=new SpreadCacheException();
            if(obj!=null){
                e.setObj(obj);
                e.setType(SpreadCacheException.CacheType.LONG);

            }else{
                e.setType(SpreadCacheException.CacheType.NONE);
            }
            throw e;
        }
    }

    /**
     * 设置缓存
     * @param key
     * @param obj
     */
    public void putCache(String key,Object obj){
        if(obj==null||key==null)
            return;
        Cache lcache=cacheManager.getCache(longCache);
        lcache.put(key,obj);
        Cache scache=cacheManager.getCache(shortCache);
        scache.put(key,obj);
    }
}
