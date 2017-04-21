package com.shigu.seller.bo;

/**
 * Created by wxc on 2017/3/22.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class AuctionApplyBo {

    private Long shopId;

    private String lxtel;

    private String lxuser;

    private Long id;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getLxtel() {
        return lxtel;
    }

    public void setLxtel(String lxtel) {
        this.lxtel = lxtel;
    }

    public String getLxuser() {
        return lxuser;
    }

    public void setLxuser(String lxuser) {
        this.lxuser = lxuser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
