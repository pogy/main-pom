package com.shigu.main4.monitor.services;

/**
 * 星星计算规则
 * Created by zhaohongbo on 17/3/8.
 */
public interface StarCaculateService {
    /**
     * 增加一个流量
     * 默认,流量+100,星星+1
     * @param shopId
     */
    void addBrower(Long shopId);

    void addBrower(Long shopId,Long times);

    /**
     * 增加一个商品上传
     * 默认上传+1,星星+1
     * @param shopId
     */
    void addItemUp(Long shopId);

    /**
     * 增加一个流量
     * 默认,流量+100,星星+1
     * 增加一个商品上传
     * 默认上传+1,星星+1
     * @param shopId
     */
    void addStar(Long shopId,int addNumber);

    /**
     * 缓式添加
     * 如,每100次算加1次
     * 此方法实现的逻辑为
     * 按key取出redis中数据
     * 如果数据大于等于max,那么,redis中此key对应值设置为1
     * 如果数据不存在,那么,redis中此key对应值设置为1
     * 否则值++
     * @param key
     * @param max
     * @return
     */
    boolean cacheForAdd(Long key,Long max);
}
