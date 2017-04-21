package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wxc on 2017/4/14.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class ShopFitmentModule implements Serializable {
    private static final long serialVersionUID = -1765203957054155422L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long moduleId;

    /**
     *1、宝贝推荐，2、宝贝搜索，3、自定义，4、宝贝分类，5、宽屏图片，6、图片轮播，7、全屏轮播
     */
    private Integer type;

    /**
     * 位置类型，1左侧，2右侧，3全屏
     */
    private Integer sideType;

    /**
     * 在哪个模块后
     */
    private Long afterModuleId;

    /**
     * 模块ID
     */
    private Long areaId;

    private String moduleValue = "{}";
    private String moduleData;

    private Boolean canDel;

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSideType() {
        return sideType;
    }

    public void setSideType(Integer sideType) {
        this.sideType = sideType;
    }

    public Long getAfterModuleId() {
        return afterModuleId;
    }

    public void setAfterModuleId(Long afterModuleId) {
        this.afterModuleId = afterModuleId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getModuleValue() {
        return moduleValue;
    }

    public void setModuleValue(String moduleValue) {
        this.moduleValue = moduleValue;
    }

    public String getModuleData() {
        return moduleData;
    }

    public void setModuleData(String moduleData) {
        this.moduleData = moduleData;
    }

    public Boolean getCanDel() {
        return canDel;
    }

    public void setCanDel(Boolean canDel) {
        this.canDel = canDel;
    }

}
