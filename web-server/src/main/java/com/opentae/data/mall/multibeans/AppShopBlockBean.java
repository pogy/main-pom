package com.opentae.data.mall.multibeans;

import com.opentae.core.mybatis.config.Column;

import javax.persistence.Transient;

/**
 * 类名：AppShopBlockBean
 * 类路径：com.opentae.data.mall.multibeans.AppShopBlockBean
 * 创建者：王浩翔
 * 创建时间：2017-09-01 9:51
 * 项目：main-pom
 * 描述：app档口信息
 */
public class AppShopBlockBean {
    //店铺ID
    @Column("shigu_shop.shop_id")
    private Long shopId;
    //档口
    @Column("shigu_shop.shop_num")
    private String shopNum;
    //联系电话
    @Column("shigu_shop.telephone")
    private String telephone;
    //旺旺
    @Column("shigu_shop.im_aliww")
    private String imAliww;
    //QQ号
    @Column("shigu_shop.im_qq")
    private String imQq;
    //主营类目
    @Column("shigu_shop.main_bus")
    private String mainCase;
    //分站
    @Column("shigu_shop.web_site")
    private String webSite;
    //市场
    @Column("shigu_market.market_name")
    private String market;
    //商品数 从ShopCdn拿
    @Transient
    private Integer itemNum;
    //星星数 从缓存拿
    @Transient
    private String starNum;
    ////店铺头像 未实现
    //private String shopHeadUrl;
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getStarNum() {
        return starNum;
    }

    public void setStarNum(String starNum) {
        this.starNum = starNum;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getImAliww() {
        return imAliww;
    }

    public void setImAliww(String imAliww) {
        this.imAliww = imAliww;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getMainCase() {
        return mainCase;
    }

    public void setMainCase(String mainCase) {
        this.mainCase = mainCase;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
