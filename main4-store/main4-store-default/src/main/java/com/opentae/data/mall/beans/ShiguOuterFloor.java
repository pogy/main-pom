package com.opentae.data.mall.beans;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 外部楼层编号，只作用于市场页
 *
 * @author shigu_zjb
 * @date 2017/02/27 18:51
 *
 */
public class ShiguOuterFloor implements Serializable{


    /** 主键 */
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long outerFloorId;

    /** 对应的内部楼层ID，如果没有，果断填-1 */
    private String floorIds;

    /** 对外显示楼层号 */
    private String showName;

    /** 楼层额外加的档口 */
    private String addedShop;
    /**
     * 排序，越小排越前
     */
    private Integer sortOrder;

    @Transient
    private String floorNames;


    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

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

    public String getAddedShop() {
        return addedShop;
    }

    public void setAddedShop(String addedShop) {
        this.addedShop = addedShop;
    }

    public String getFloorNames() {
        return floorNames;
    }

    public void setFloorNames(String floorNames) {
        this.floorNames = floorNames;
    }
}
