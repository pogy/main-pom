package com.shigu.helpcenter.vo;

import com.opentae.data.mall.beans.ShiguHelpcenterQuestion;

import java.util.List;

public class ShowQuestionVo {
    private List<ShiguHelpcenterQuestion> queList;
    //分页配置参数，分别是商品总数，每页显示条数，当前页码，使用逗号隔开，比如：'28,10,1'
    private String pageOption;
    private String keyword;

    public List<ShiguHelpcenterQuestion> getQueList() {
        return queList;
    }

    public void setQueList(List<ShiguHelpcenterQuestion> queList) {
        this.queList = queList;
    }

    public String getPageOption() {
        return pageOption;
    }

    public void setPageOption(String pageOption) {
        this.pageOption = pageOption;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
