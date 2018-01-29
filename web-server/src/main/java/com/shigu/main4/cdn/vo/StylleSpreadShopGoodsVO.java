package com.shigu.main4.cdn.vo;

import java.io.Serializable;

/**
 * 路径:com.shigu.main4.cdn.vo.StylleSpreadShopGoodsVO
 * 工程:main-pom
 * 时间:18-1-29下午8:31
 * 创建人:wanghaoxiang
 * 描述：风格频道首页档口广告商品数据
 */
public class StylleSpreadShopGoodsVO implements Serializable {
    //商品ID
    private Long goodsId;
    //商品图片
    private String imgsrc;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }
}
