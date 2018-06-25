package com.shigu.main4.item.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;

/**
 * 所有Item服务的父类
 * Created by zhaohongbo on 17/2/16.
 */
public class ItemServiceImpl {
    @Autowired
    protected EhCacheCacheManager cacheManager;
}
