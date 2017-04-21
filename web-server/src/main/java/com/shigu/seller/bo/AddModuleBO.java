package com.shigu.seller.bo;

/**
 * 添加模块
 * Created by zhaohongbo on 17/4/17.
 */
public class AddModuleBO {
    /**
     * 添加的模块种类
     */
    private String id;
    /**
     * 区域标识
     */
    private Long area;
    /**
     * 排版
     */
    private Integer type;
    /**
     * 相邻模块ID
     */
    private String side;
    /**
     * 在前还是在后,2在前,1在后
     */
    private Integer after;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public Integer getAfter() {
        return after;
    }

    public void setAfter(Integer after) {
        this.after = after;
    }
}
