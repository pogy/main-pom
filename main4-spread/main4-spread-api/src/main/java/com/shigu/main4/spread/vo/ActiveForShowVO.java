package com.shigu.main4.spread.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 类名：ActiveForShowVO
 * 类路径：com.shigu.main4.spread.vo.ActiveForShowVO
 * 创建者：王浩翔
 * 创建时间：2017-11-20 17:54
 * 项目：main-pom
 * 描述：前端活动显示
 */
public class ActiveForShowVO implements Serializable {
    //活动名称
    private String actName;
    //活动期数列表
    private List<ActivePhaseForShowVO> actPhaseList;

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public List<ActivePhaseForShowVO> getActPhaseList() {
        return actPhaseList;
    }

    public void setActPhaseList(List<ActivePhaseForShowVO> actPhaseList) {
        this.actPhaseList = actPhaseList;
    }
}
