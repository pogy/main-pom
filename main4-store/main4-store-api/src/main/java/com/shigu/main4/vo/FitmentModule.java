package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 模块
 * Created by Licca on 17/4/13.
 */
public class FitmentModule implements Serializable{

    private Long moduleId;

    private Long areaId;
    /**
     * 1左侧，2右侧，3全屏
     */
    private Integer sideType;

    private Long after;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getSideType() {
        return sideType;
    }

    public void setSideType(Integer sideType) {
        this.sideType = sideType;
    }

    public Long getAfter() {
        return after;
    }

    public void setAfter(Long after) {
        this.after = after;
    }
}
