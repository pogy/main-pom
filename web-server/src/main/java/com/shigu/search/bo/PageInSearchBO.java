package com.shigu.search.bo;

import java.io.Serializable;

/**
 * 搜索的分页查询
 * Created by zhaohongbo on 17/4/5.
 */
public class PageInSearchBO implements Serializable{

    private static final long serialVersionUID = -3674152430277810820L;
    private Integer page;

    private Integer rows;

    private Integer totalPage;

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPage() {
        if(page==null){
            page=1;
        }else if(page>200){
            page=200;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        if(rows==null){
            rows = 40;
        }
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
