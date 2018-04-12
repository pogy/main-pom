package com.opentae.data.mall.multibeans;

import java.io.Serializable;

/**
 * 路径:com.opentae.data.mall.multibeans.ShopStyleGoodsAggrBean
 * 工程:main-pom
 * 时间:18-1-25下午6:31
 * 创建人:wanghaoxiang
 * 描述：
 */
public class ShopStyleGoodsAggrBean implements Serializable {

    //父类商品风格
    private Long parentStyleId;
    //店铺中对应商品风格的数量统计
    private Integer styleGoodsCount;

    public Long getParentStyleId() {
        return parentStyleId;
    }

    public void setParentStyleId(Long parentStyleId) {
        this.parentStyleId = parentStyleId;
    }

    public Integer getStyleGoodsCount() {
        return styleGoodsCount;
    }

    public void setStyleGoodsCount(Integer styleGoodsCount) {
        this.styleGoodsCount = styleGoodsCount;
    }
}
