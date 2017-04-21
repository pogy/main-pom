package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * 页面导航
 * Created by zhaohongbo on 17/4/19.
 */
public class PageNavVO implements Serializable{
    /**
     * 页面ID
     */
    private Long pageId;
    /**
     * 页面名
     */
    private String pageName;
    /**
     * 是否被选中
     */
    private Boolean checked;
    /**
     * 页面关键ID
     */
    private String href;

    public PageNavVO() {
    }

    public PageNavVO(Long pageId, String pageName, Boolean checked, String href) {
        this.pageId = pageId;
        this.pageName = pageName;
        this.checked = checked;
        this.href = href;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
