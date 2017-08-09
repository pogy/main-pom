package com.shigu.main4.daifa.model;

import com.shigu.main4.daifa.enums.TakeGoodsEnum;

/**
 * 状态管理
 * 单例
 * 管理所有状态的变化
 * Created by zhaohongbo on 17/8/9.
 */
public interface StatusManageModel {
    /**
     * 拿货状态修改
     * @param subOrderId
     * @param status
     */
    void takeGoodsStatusChange(Long subOrderId, TakeGoodsEnum status);
}
