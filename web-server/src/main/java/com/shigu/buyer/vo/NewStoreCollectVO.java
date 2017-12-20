package com.shigu.buyer.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 类名：NewStoreCollectVO
 * 类路径：com.shigu.buyer.vo.NewStoreCollectVO
 * 创建者：王浩翔
 * 创建时间：2017-10-16 15:24
 * 项目：main-pom
 * 描述：新档口收藏
 */
public class NewStoreCollectVO implements Serializable {
    //收藏id
    private Long collId;
    //店铺id
    private Long shopId;
    //市场
    private String marketName;
    //档口号
    private String shopNum;
    //分站
    private String webSite;
    //店铺图片
    private String  shopImgSrc;
    //店铺信誉值
    private Long starNum;
    //店铺旺旺
    private String imWw;
    //店铺QQ
    private String imQq;
    //店铺上新数据
    private List<SimpleGoodsInfoVO> goodsList;

    public Long getCollId() {
        return collId;
    }

    public void setCollId(Long collId) {
        this.collId = collId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getShopImgSrc() {
        if (shopImgSrc == null || "".equals(shopImgSrc)) {
            return "http://gw.alicdn.com/tps/i3/TB1yeWeIFXXXXX5XFXXuAZJYXXX-210-210.png";
        }
        return shopImgSrc;
    }

    public void setShopImgSrc(String shopImgSrc) {
        this.shopImgSrc = shopImgSrc;
    }

    public Long getStarNum() {
        return starNum;
    }

    public void setStarNum(Long starNum) {
        this.starNum = starNum;
    }

    public String getImWw() {
        return imWw;
    }

    public void setImWw(String imWw) {
        this.imWw = imWw;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public List<SimpleGoodsInfoVO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<SimpleGoodsInfoVO> goodsList) {
        this.goodsList = goodsList;
    }
}
