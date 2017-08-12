package com.shigu.main4.monitor.bo;


import java.util.Date;

/**
 * 记录用户的网页浏览记录BO
 * @author shigu_zjb
 * @date 2017/02/16 14:55
 *
 *
 */
public class ShiguPageRecodeBo implements java.io.Serializable {

    private Long id;

    private String webSite;

    private boolean pageable;

    private Integer pageNo;

    private Integer pageSize;

    private Date endInTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public boolean isPageable() {
        return pageable;
    }

    public void setPageable(boolean pageable) {
        this.pageable = pageable;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Date getEndInTime() {
        return endInTime;
    }

    public void setEndInTime(Date endInTime) {
        this.endInTime = endInTime;
    }
}
