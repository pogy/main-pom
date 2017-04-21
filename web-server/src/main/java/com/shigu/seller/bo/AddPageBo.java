package com.shigu.seller.bo;

/**
 * 页面添加业务
 * Created by Administrator on 2017/4/19 0019.
 */
public class AddPageBo {

    private String method;
    private String title;
    private Long alias;
    private Integer type;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAlias() {
        return alias;
    }

    public void setAlias(Long alias) {
        this.alias = alias;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
