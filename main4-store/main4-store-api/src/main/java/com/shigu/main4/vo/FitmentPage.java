package com.shigu.main4.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 装修后的页面
 * Created by Licca on 17/4/13.
 */
public class FitmentPage implements Serializable{
    /**
     * 页面名字
     */
    private String pageName;
    /**
     * 页面ID
     */
    private Long pageId;
    /**
     * 顶部模块
     */
    private FitmentArea headArea;
    /**
     * 用户定义区域
     */
    private List<FitmentArea> userDefineAreas;

    /**
     * 页面背景图
     */
    private String backgroundPic;

    /**
     * 背景图平铺方式：1、平铺，2、纵向平铺，3、横向平铺，4、不平铺',
     */
    private Integer backgroundType = 1;

    public FitmentArea getHeadArea() {
        return headArea;
    }

    public void setHeadArea(FitmentArea headArea) {
        this.headArea = headArea;
    }

    public List<FitmentArea> getUserDefineAreas() {
        return userDefineAreas;
    }

    public void setUserDefineAreas(List<FitmentArea> userDefineAreas) {
        this.userDefineAreas = userDefineAreas;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getBackgroundPic() {
        return backgroundPic;
    }

    public void setBackgroundPic(String backgroundPic) {
        this.backgroundPic = backgroundPic;
    }

    public Integer getBackgroundType() {
        return backgroundType;
    }

    public void setBackgroundType(Integer backgroundType) {
        this.backgroundType = backgroundType;
    }
}
