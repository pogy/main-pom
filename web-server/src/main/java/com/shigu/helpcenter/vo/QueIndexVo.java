package com.shigu.helpcenter.vo;

import com.opentae.data.mall.beans.ShiguHelpcenterLevel1;
import com.opentae.data.mall.beans.ShiguHelpcenterLevel2;

import java.util.List;

public class QueIndexVo {
    private ShiguHelpcenterLevel1 sidebarList;
    private List<ShiguHelpcenterLevel2> subSidebarList;
    private ShiguHelpcenterQuestionVo questionList;

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

    public ShiguHelpcenterQuestionVo getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ShiguHelpcenterQuestionVo questionList) {
        this.questionList = questionList;
    }
}
