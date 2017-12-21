package com.shigu.seller.bo;

import java.io.Serializable;

/**
 * 批量修改
 * Created by zhaohongbo on 17/3/19.
 */
public class MoreModifyBO implements Serializable{
    private Integer page;

    private Integer pageSize=5;

    private Long goodsNumIid;


    public Integer getPage() {
        if(page==null||page<=0){
            page=1;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page =page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = 5;
    }
}
