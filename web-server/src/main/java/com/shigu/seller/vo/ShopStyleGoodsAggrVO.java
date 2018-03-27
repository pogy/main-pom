package com.shigu.seller.vo;

import java.io.Serializable;

/**
 * 路径:com.shigu.seller.vo.ShopStyleGoodsAggrVO
 * 工程:main-pom
 * 时间:18-1-25下午7:07
 * 创建人:wanghaoxiang
 * 描述：店铺内风格商品统计数据
 */
public class ShopStyleGoodsAggrVO implements Serializable {

    //大类风格id
    private Long spid;
    //风格名称
    private String sname;
    //该风格下的商品数量
    private Integer goodsCount;

    public Long getSpid() {
        return spid;
    }

    public void setSpid(Long spid) {
        this.spid = spid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getGoodsCount() {
        if (goodsCount == null) {
            return 0;
        }
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }
}
