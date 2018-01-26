package com.shigu.helpcenter.vo;

import com.opentae.data.mall.beans.ShiguHelpcenterLevel2;

import java.util.List;

public class IndexVo {
    private Integer pid;
    private String name;
    private List<ShiguHelpcenterLevel2> subSidebarList;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShiguHelpcenterLevel2> getSubSidebarList() {
        return subSidebarList;
    }

    public void setSubSidebarList(List<ShiguHelpcenterLevel2> subSidebarList) {
        this.subSidebarList = subSidebarList;
    }
}
