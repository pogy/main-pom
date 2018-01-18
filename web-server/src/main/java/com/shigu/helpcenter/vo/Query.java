package com.shigu.helpcenter.vo;

public class Query {
    /**
     * id  回填问题ID
     * keyword  回填搜索关键字
     */
    private Integer id;
    private String keyword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
