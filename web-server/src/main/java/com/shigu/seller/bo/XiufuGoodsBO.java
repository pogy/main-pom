package com.shigu.seller.bo;

import java.io.Serializable;

/**
 * 修复宝贝BO
 * Created by zhaohongbo on 17/3/12.
 */
public class XiufuGoodsBO extends GhsGet implements Serializable{


    private Integer page;

    private Integer pageSize=10;

    public Integer getPage() {
        if(page==null||page<=0){
            page=1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = 10;
    }
}
