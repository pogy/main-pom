package com.shigu.helpcenter.vo;

import com.opentae.data.mall.beans.ShiguHelpcenterQuestion;

import java.util.List;

public class ShiguHelpcenterQuestionVo {
    private String queCateNamePath;
    private List<ShiguHelpcenterQuestion> title;
    //分页配置参数，分别是商品总数，每页显示条数，当前页码，使用逗号隔开，比如：'28,10,1'
    private String pageOption;

    public String getPageOption() {
        return pageOption;
    }

    public void setPageOption(String pageOption) {
        this.pageOption = pageOption;
    }

    public String getQueCateNamePath() {
        return queCateNamePath;
    }

    public void setQueCateNamePath(String queCateNamePath) {
        this.queCateNamePath = queCateNamePath;
    }

    public List<ShiguHelpcenterQuestion> getTitle() {
        return title;
    }

    public void setTitle(List<ShiguHelpcenterQuestion> title) {
        this.title = title;
    }
}
