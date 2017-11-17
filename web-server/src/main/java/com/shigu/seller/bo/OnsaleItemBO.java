package com.shigu.seller.bo;

import com.shigu.tools.EncodeParamter;

/**
 * 出售中的商品
 * Created by zhaohongbo on 17/3/9.
 */
public class OnsaleItemBO extends GhsGet{

    private String goodsTitle;

    private Long goodsNumIid;

    private String goodsNo;

    //1无最低零售价 2无大图 3无材料成分 null所有
    private Integer state;

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

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = EncodeParamter.iosToUtf8(goodsTitle);
    }

    public Long getGoodsNumIid() {
        return goodsNumIid;
    }

    public void setGoodsNumIid(Long goodsNumIid) {
        this.goodsNumIid = goodsNumIid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String getGoodsNo() {
        return goodsNo;
    }

    @Override
    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
}
