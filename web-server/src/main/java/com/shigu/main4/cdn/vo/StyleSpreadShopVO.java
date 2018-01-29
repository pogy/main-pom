package com.shigu.main4.cdn.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 路径:com.shigu.main4.cdn.vo.StyleSpreadShopVO
 * 工程:main-pom
 * 时间:18-1-29下午8:27
 * 创建人:wanghaoxiang
 * 描述：风格首页档口广告数据
 */
public class StyleSpreadShopVO implements Serializable {
    //店铺ID
    private Long shopId;
    //档口全称
    private String shopName;
    //档口年限
    private Integer shopAge;
    //商品列表
    private List<StylleSpreadShopGoodsVO> goodsList;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getShopAge() {
        return shopAge;
    }

    public void setShopAge(Integer shopAge) {
        this.shopAge = shopAge;
    }

    public List<StylleSpreadShopGoodsVO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<StylleSpreadShopGoodsVO> goodsList) {
        this.goodsList = goodsList;
    }
}
