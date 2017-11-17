package com.shigu.main4.item.process;

/**
 * 商品数据的process
 */
public interface ItemDataProcess {
    /**
     * 商品迁移给店，
     * @param oldGoodsId
     * @param oldGoodsId
     */
    void restore(Long oldGoodsId,Long newGoodsId);

}
