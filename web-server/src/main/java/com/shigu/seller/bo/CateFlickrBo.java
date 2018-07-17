package com.shigu.seller.bo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.bo
 * @ClassName: CateFlickrBo
 * @Author: sy
 * @CreateDate: 2018/5/11 0011 17:51
 */
public class CateFlickrBo implements Serializable{
    private Long cid;
    private Long cPid;
    private Integer page;
    private Integer rows = 72;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
//        this.rows = rows;
    }

    public Long getcPid() {
        return cPid;
    }

    public void setcPid(Long cPid) {
        this.cPid = cPid;
    }
}
