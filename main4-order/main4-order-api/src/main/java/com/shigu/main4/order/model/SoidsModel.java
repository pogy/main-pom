package com.shigu.main4.order.model;

/**
 * 类名：SoidsModel
 * 类路径：com.shigu.main4.order.model.SoidsModel
 * 创建者：王浩翔
 * 创建时间：2017-09-11 16:35
 * 项目：main-pom
 * 描述：
 */
public interface SoidsModel {
    /**
     * 缺货标记
     * @param soidpid
     */
    void outOfStock(Long soidpid);

    void cancleOutOfStock(Long soidpid);
}
