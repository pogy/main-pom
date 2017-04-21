package com.shigu.seller.bo;

/**
 * 移动模块
 * Created by zhaohongbo on 17/4/20.
 */
public class MoveModuleBO {

    private Long area;
    /**
     * 1左侧,2右侧
     */
    private Integer type;

    private Long moduleId;

    private Long sideId;
    /**
     * 1上移,2下移
     */
    private Integer after;

    public Integer getAfter() {
        return after;
    }

    public void setAfter(Integer after) {
        this.after = after;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long getSideId() {
        return sideId;
    }

    public void setSideId(Long sideId) {
        this.sideId = sideId;
    }
}
