package com.shigu.main4.item.tools;

import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

@Service
public class ItemCache {
    @Autowired
    private EhCacheCacheManager ehCacheCacheManager;

    @Autowired
    RedisIO redisIO;

    private static final String ITEM_DUBBO_CACHE_SYNCHRONIZED = "item_dubbo_cache_synchronized";

    public void cleanItemCache(Long itemId) {
        redisIO.hdel(ITEM_DUBBO_CACHE_SYNCHRONIZED,itemId.toString());
        Cache cdnItemCache = ehCacheCacheManager.getCache("cdnItemCache");
        if (cdnItemCache != null) {
            cdnItemCache.evict(itemId);
        }
    }
}
