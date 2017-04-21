package com.shigu.buyer.bo;

import java.io.Serializable;

/**
 * 店铺入驻申请
 * Created by zhaohongbo on 17/3/18.
 */
public class StoreInBO implements Serializable{
    private Integer page;

    private Integer rows=100;

    public Integer getPage() {
        if(page==null||page<1){
            return 1;
        }
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
