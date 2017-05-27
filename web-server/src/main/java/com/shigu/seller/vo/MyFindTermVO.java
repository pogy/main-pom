package com.shigu.seller.vo;

import java.util.List;

/**
 * 一期里面的广告
 * Created by zhaohongbo on 17/5/27.
 */
public class MyFindTermVO {
    /**
     * 期号
     */
    private Integer termId;
    /**
     * 开始上线时间
     */
    private String startOnline;
    /**
     * 上线结束时间
     */
    private String endOnline;
    /**
     * 广告商品
     */
    private List<FindGoodsVO> goods;

    public Integer getTermId() {
        return termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
    }

    public String getStartOnline() {
        return startOnline;
    }

    public void setStartOnline(String startOnline) {
        this.startOnline = startOnline;
    }

    public String getEndOnline() {
        return endOnline;
    }

    public void setEndOnline(String endOnline) {
        this.endOnline = endOnline;
    }

    public List<FindGoodsVO> getGoods() {
        return goods;
    }

    public void setGoods(List<FindGoodsVO> goods) {
        this.goods = goods;
    }
}
