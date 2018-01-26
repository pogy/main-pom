package com.shigu.helpcenter.vo;

import com.opentae.data.mall.beans.ShiguHelpcenterQuestion;

import java.util.List;

public class ShiguHelpcenterQuestionSearchVo {
    private List<ShiguHelpcenterQuestion> shiguHelpcenterQuestions;
    private String keyword;//回调关键字


    public List<ShiguHelpcenterQuestion> getShiguHelpcenterQuestions() {
        return shiguHelpcenterQuestions;
    }

    public void setShiguHelpcenterQuestions(List<ShiguHelpcenterQuestion> shiguHelpcenterQuestions) {
        this.shiguHelpcenterQuestions = shiguHelpcenterQuestions;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
