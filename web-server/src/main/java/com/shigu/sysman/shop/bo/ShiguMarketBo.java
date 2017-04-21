package com.shigu.sysman.shop.bo;


/**
 * 市场BO
 *
 */
public class ShiguMarketBo {

    /** 市场ID */
    private Long marketId;

    /** 楼层ID */
    private Long floorId;

    /** 站点 */
    private String webSite;

    /** 多单绑定 */
    private Boolean multiBand = false;

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Boolean getMultiBand() {
        return multiBand;
    }

    public void setMultiBand(Boolean multiBand) {
        this.multiBand = multiBand;
    }
}
