package com.shigu.main4.daifa.process;


/**
 * 打包发货
 * Created by zhaohongbo on 17/8/8.
 */
public interface PackDeliveryProcess {
    /**
     * 单件发货扫货
     * @param issueId
     */
    void packSubOrder(Long issueId);
}
