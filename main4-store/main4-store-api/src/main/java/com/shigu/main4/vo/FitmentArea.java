package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 区域
 * Created by Licca on 17/4/13.
 */
public class FitmentArea implements Serializable{
    /**
     * 区域ID
     */
    private Long areaId;
    private Integer areaType;
    /**
     * 全屏模块
     */
    private List<FitmentModule> allarea;
    /**
     * 左侧模块
     */
    private List<FitmentModule> leftarea;
    /**
     * 右侧模块
     */
    private List<FitmentModule> rightarea;

    public List<FitmentModule> getAllarea() {
        return allarea;
    }

    public void setAllarea(List<FitmentModule> allarea) {
        this.allarea = allarea;
    }

    public List<FitmentModule> getLeftarea() {
        return leftarea;
    }

    public void setLeftarea(List<FitmentModule> leftarea) {
        this.leftarea = leftarea;
    }

    public List<FitmentModule> getRightarea() {
        return rightarea;
    }

    public void setRightarea(List<FitmentModule> rightarea) {
        this.rightarea = rightarea;
    }

    public static FitmentArea emptyArea() {
        FitmentArea area = new FitmentArea();
        area.setRightarea(new ArrayList<FitmentModule>());
        area.setLeftarea(new ArrayList<FitmentModule>());
        area.setAllarea(new ArrayList<FitmentModule>());
        return area;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }
}
