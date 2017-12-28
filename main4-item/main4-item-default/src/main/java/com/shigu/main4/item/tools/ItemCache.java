package com.shigu.main4.item.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

@Service
public class ItemCache {
    @Autowired
    private EhCacheCacheManager ehCacheCacheManager;

    public void cleanItemCache(Long itemId) {
        Cache cdnItemCache = ehCacheCacheManager.getCache("cdnItemCache");
        if (cdnItemCache != null) {
            cdnItemCache.evict(itemId);
        }
    }
}
