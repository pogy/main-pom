package com.shigu.seller.vo;

import com.shigu.main4.vo.FitmentArea;

import java.util.ArrayList;
import java.util.List;

/**
 * 区域
 * Created by zhaohongbo on 17/4/19.
 */
public class AreaVO extends FitmentArea{
    /**
     * 通栏模块
     */
    private List<ModuleVO> allModules;
    /**
     * 左侧栏模块
     */
    private List<ModuleVO> leftModules;
    /**
     * 右侧栏模块
     */
    private List<ModuleVO> rightModules;

    public AreaVO(FitmentArea area) {
        this.setAreaId(area.getAreaId());
        this.setAllarea(area.getAllarea());
        this.setRightarea(area.getRightarea());
        this.setLeftarea(area.getLeftarea());
        this.setAreaType(area.getAreaType());
    }

    /**
     * 添加通栏模块
     * @param moduleVO
     */
    public void addAllModule(ModuleVO moduleVO){
        if (allModules == null) {
            allModules=new ArrayList<>();
        }
        allModules.add(moduleVO);
    }

    /**
     * 添加左侧栏模块
     * @param moduleVO
     */
    public void addLeftModule(ModuleVO moduleVO){
        if (leftModules == null) {
            leftModules=new ArrayList<>();
        }
        leftModules.add(moduleVO);
    }

    /**
     * 添加右侧栏模块
     * @param moduleVO
     */
    public void addRightModule(ModuleVO moduleVO){
        if (rightModules == null) {
            rightModules=new ArrayList<>();
        }
        rightModules.add(moduleVO);
    }


    public List<ModuleVO> getAllModules() {
        return allModules;
    }

    public void setAllModules(List<ModuleVO> allModules) {
        this.allModules = allModules;
    }

    public List<ModuleVO> getLeftModules() {
        return leftModules;
    }

    public void setLeftModules(List<ModuleVO> leftModules) {
        this.leftModules = leftModules;
    }

    public List<ModuleVO> getRightModules() {
        return rightModules;
    }

    public void setRightModules(List<ModuleVO> rightModules) {
        this.rightModules = rightModules;
    }
}
