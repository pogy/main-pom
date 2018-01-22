package com.shigu.helpcenter.vo;

import com.opentae.data.mall.beans.ShiguHelpcenterLevel1;
import com.opentae.data.mall.beans.ShiguHelpcenterLevel2;

import java.util.List;

public class QueDetailVo {
    private ShiguHelpcenterLevel1 sidebarList;
    private List<ShiguHelpcenterLevel2> subSidebarList;
    private String answer;
    private String queCateNamePath;

    public ShiguHelpcenterLevel1 getSidebarList() {
        return sidebarList;
    }

    public void setSidebarList(ShiguHelpcenterLevel1 sidebarList) {
        this.sidebarList = sidebarList;
    }

    public List<ShiguHelpcenterLevel2> getSubSidebarList() {
        return subSidebarList;
    }

    public void setSubSidebarList(List<ShiguHelpcenterLevel2> subSidebarList) {
        this.subSidebarList = subSidebarList;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQueCateNamePath() {
        return queCateNamePath;
    }

    public void setQueCateNamePath(String queCateNamePath) {
        this.queCateNamePath = queCateNamePath;
    }
}
