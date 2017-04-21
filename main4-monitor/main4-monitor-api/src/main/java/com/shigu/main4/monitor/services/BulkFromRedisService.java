package com.shigu.main4.monitor.services;

/**
 * 从redis中bulk给es
 * Created by zhaohongbo on 17/4/15.
 */
public interface BulkFromRedisService {
    /**
     * 执行bulk操作,流量
     */
    void bulkFlowTmc();

    /**
     * 执行bulk操作,商品
     */
    void bulkGoodsTmc();
}
