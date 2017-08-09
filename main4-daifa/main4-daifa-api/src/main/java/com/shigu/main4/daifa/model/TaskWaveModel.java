package com.shigu.main4.daifa.model;

/**
 * 任务波次
 * 多例,描述了一个波次的变化
 * 按波次ID构造
 * Created by zhaohongbo on 17/8/9.
 */
public interface TaskWaveModel {
    /**
     * 结束本波次
     * 没拿到直接缺货
     */
    void finishAll();
}
