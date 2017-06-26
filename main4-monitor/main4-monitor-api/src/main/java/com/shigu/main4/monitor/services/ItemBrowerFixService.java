package com.shigu.main4.monitor.services;

/**
 * 商品浏览量数据固化
 * Created by zhaohongbo on 17/6/22.
 */
public interface ItemBrowerFixService {
    /**
     * 固化当前的浏览量数据
     * @param key
     */
    void fixNow(String key);
}
