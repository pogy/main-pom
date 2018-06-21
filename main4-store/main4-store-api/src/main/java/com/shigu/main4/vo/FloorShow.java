package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 市场显示中楼层对象
 * Created by zhaohongbo on 17/2/27.
 */
public class FloorShow implements Serializable{
    /**
     * 外部楼层ID
     */
    private Long outerFloorId;
    /**
     * 内部楼层ID
     */
    private String floorIds;
    /**
     * 楼层名
     */
    private String showName;
    /**
     * 额外楼层名
     */
    private String otherName;
    /**
     * 排序好的店铺信息
     */
    private List<ShopShow> shops;

    public Long getOuterFloorId() {
        return outerFloorId;
    }

    public void setOuterFloorId(Long outerFloorId) {
        this.outerFloorId = outerFloorId;
    }

    public String getFloorIds() {
        return floorIds;
    }

    public void setFloorIds(String floorIds) {
        this.floorIds = floorIds;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public List<ShopShow> getShops() {
        return shops;
    }

    public void setShops(List<ShopShow> shops) {
        this.shops = shops;
    }

    /**
     * 获取 额外楼层名
     */
    public String getOtherName() {
        return this.otherName;
    }

    /**
     * 设置 额外楼层名
     */
    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }
}
