package com.shigu.seller.vo;

/**
 * 页面管理对象
 * Created by Administrator on 2017/4/19 0019.
 */
public class PageManageVo {

    private Long pageId;
    private String name;
    private Integer type;
    private String href;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
