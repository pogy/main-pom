package com.shigu.main4.cdn.vo;

import java.util.List;

/**
 * 楼层
 * Created by Licca on 17/3/25.
 */
public class FloorVO {
    /**
     * 楼层标题
     */
    private String title;
    /**
     * 楼层中的店铺
     */
    private List<ShopInFloorVO> stores;

    public List<ShopInFloorVO> getStores() {
        return stores;
    }

    public void setStores(List<ShopInFloorVO> stores) {
        this.stores = stores;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
