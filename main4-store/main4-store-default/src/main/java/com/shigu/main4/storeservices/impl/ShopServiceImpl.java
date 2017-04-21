package com.shigu.main4.storeservices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import javax.annotation.Resource;

/**
 * 店铺统一实现的父类
 * Created by zhaohongbo on 17/2/20.
 */
public class ShopServiceImpl {
    @Autowired
    protected EhCacheCacheManager cacheManager;
}
