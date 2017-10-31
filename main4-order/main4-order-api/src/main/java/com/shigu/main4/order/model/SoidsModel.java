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

    /**
     * 标记有货时间
     * @param soidpid
     * @param day
     */
    void havaTime(Long soidpid,String day);

    void cancleOutOfStock(Long soidpid);

    /**
     * 更新已拿货数量
     * @param soidpid
     */
     void  updateInStok(Long soidpid);
}
