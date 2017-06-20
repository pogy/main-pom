package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 镇
 * Created by zhaohongbo on 17/6/20.
 */
public class TownVO implements Serializable{
    /**
     * 镇ID
     */
    private Long townId;
    /**
     * 镇
     */
    private String town;

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
