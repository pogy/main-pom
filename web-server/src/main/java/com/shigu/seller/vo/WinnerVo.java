package com.shigu.seller.vo;

/**
 * Created by wxc on 2017/3/22.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class WinnerVo {

    /**
     * 序号
     */
    private Long num;
    /**
     * 市场
     */
    private String marketText;
    /**
     * 店铺
     */
    private String storeNum;
    /**
     * 联系人
     */
    private String lxuser;
    /**
     * 电话
     */
    private String lxtel;
    /**
     * 店ID
     */
    private Long shopId;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getMarketText() {
        return marketText;
    }

    public void setMarketText(String marketText) {
        this.marketText = marketText;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getLxuser() {
        return lxuser;
    }

    public void setLxuser(String lxuser) {
        this.lxuser = lxuser;
    }

    public String getLxtel() {
        return lxtel;
    }

    public void setLxtel(String lxtel) {
        this.lxtel = lxtel;
    }
}
