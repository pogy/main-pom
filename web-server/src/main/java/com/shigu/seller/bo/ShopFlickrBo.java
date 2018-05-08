package com.shigu.seller.bo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.bo
 * @ClassName: ShopFlickrBo
 * @Author: sy
 * @CreateDate: 2018/5/8 0008 9:36
 */
public class ShopFlickrBo implements Serializable{

    private Long id;
    private Long cid;
    private Integer page;
    private Integer rows = 5;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
