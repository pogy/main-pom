package com.shigu.main4.goat.model;

import com.shigu.main4.goat.exceptions.GoatException;

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

    /**
     * 备注
     * @param recommon
     */
    void recommon(String recommon);

    /**
     * 上移
     */
    void moveUp() throws GoatException;

    /**
     * 下移
     */
    void moveDown() throws GoatException;
}
