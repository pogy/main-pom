package com.shigu.spread.vo;

import java.io.Serializable;

/**
 * 路径:com.shigu.spread.vo.NewHzManIndexItemGoatVO
 * 工程:main-pom
 * 时间:18-1-25下午4:55
 * 创建人:wanghaoxiang
 * 描述：男装首页改版商品广告数据
 */
public class NewHzManIndexItemGoatVO implements Serializable {

    //商品id
    private String id;
    //商品价格
    private String piprice;
    //商品图片地址
    private String imgSrc;
    //店铺id
    private String shopId;
    //档口号
    private String shopNo;
    //店铺所属市场
    private String marketName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
}
