package com.shigu.helpcenter.vo;

import com.opentae.data.mall.beans.ShiguHelpcenterLevel2;
import com.opentae.data.mall.beans.ShiguHelpcenterQuestion;

public class ShiguHelpcenterLevelTowVo {
    private String queCateNamePath;
    private ShiguHelpcenterLevel2 subSidebarList;
    private String query;//回调关键字

    public String getQueCateNamePath() {
        return queCateNamePath;
    }

    public void setQueCateNamePath(String queCateNamePath) {
        this.queCateNamePath = queCateNamePath;
    }

    public ShiguHelpcenterLevel2 getSubSidebarList() {
        return subSidebarList;
    }

    public void setSubSidebarList(ShiguHelpcenterLevel2 subSidebarList) {
        this.subSidebarList = subSidebarList;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
