package com.shigu.main4.goat.service;

/**
 * 广告功能接口
 * Created by zhaohongbo on 17/5/4.
 */
public interface Goat {
    /**
     * 发布上线
     */
    void publish();

    /**
     * 预发布
     * @param second 多久后发布以秒为单位
     */
    void preparePublish(Long second);
}
