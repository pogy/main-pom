package com.shigu.seller.bo;

/**
 * 仓库中的宝贝
 * Created by zhaohongbo on 17/3/12.
 */
public class InstockItemBO extends GhsGet{

    private Integer page;

    private Integer pageSize=10;

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
        this.pageSize = 10;
    }

    public Long getGoodsNumIid() {
        return goodsNumIid;
    }

    public void setGoodsNumIid(Long goodsNumIid) {
        this.goodsNumIid = goodsNumIid;
    }
}
