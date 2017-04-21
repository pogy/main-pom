package com.shigu.main4.monitor.enums;

/**
 * 流量统计类型
 * Created by zhaohongbo on 17/3/13.
 */
public enum FlowType {
    PV("pv统计","water_pv"),IP("ip统计","water_ip");

    FlowType(String title, String value) {
        this.title = title;
        this.value = value;
    }

    private String title;
    private String value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
