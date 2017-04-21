package com.shigu.buyer.bo;

import java.io.Serializable;

/**
 * 数据包列表页面
 * Created by zhaohongbo on 17/3/13.
 */
public class DataPackageBO implements Serializable{
    /**
     * 分站标识
     */
    private String website;

    private Integer page;

    private Integer rows=12;

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

    public String getWebsite() {
        if(website==null){
            return "hz";
        }
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
