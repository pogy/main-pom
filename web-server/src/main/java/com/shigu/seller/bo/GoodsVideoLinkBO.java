package com.shigu.seller.bo;

import javax.validation.constraints.NotNull;

/**
 * 类名：GoodsVideoLinkBO
 * 类路径：com.shigu.seller.bo.GoodsVideoLinkBO
 * 创建者：王浩翔
 * 创建时间：2017-11-14 16:19
 * 项目：main-pom
 * 描述：
 */
public class GoodsVideoLinkBO {
    //商品id
    @NotNull(message = "商品不能为空")
    private Long goodsId;
    //商品视频地址
    @NotNull(message = "视频地址不能为空")
    private String goodsVideoUrl;
    //是否关联设置相同货号的商品，true(关联)，false（不关联）
    private Boolean linkSameGoodsNo;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsVideoUrl() {
        return goodsVideoUrl;
    }

    public void setGoodsVideoUrl(String goodsVideoUrl) {
        this.goodsVideoUrl = goodsVideoUrl;
    }

    public Boolean getLinkSameGoodsNo() {
        return linkSameGoodsNo;
    }

    public void setLinkSameGoodsNo(Boolean linkSameGoodsNo) {
        this.linkSameGoodsNo = linkSameGoodsNo;
    }
}
