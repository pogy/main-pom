package com.shigu.main4.daifa.model;

import java.util.List;

/**
 * 拿货员
 * 多例,描述了一个拿货员的所有操作
 * 按拿货员ID构造
 * Created by zhaohongbo on 17/8/9.
 */
public interface CargoManModel {
    /**
     * 创建波次
     * @param subOrderIds 子单集合
     * @return 波次号
     */
    String makeTakeWave(List<Long> subOrderIds);
}
