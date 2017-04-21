package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 提供给注册的楼层
 * Created by zhaohongbo on 17/2/23.
 */
public class FloorForRegist implements Serializable{
    /**
     * 楼层ID
     */
    private Long floorId;
    /**
     * 楼层名称
     */
    private String floorName;

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }
}
