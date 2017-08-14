package com.shigu.main4.vo;

import com.shigu.main4.common.vo.ShiguTags;

import java.io.Serializable;
import java.util.List;

/**
 * 开店申请,要修改的
 * Created by zhaohongbo on 17/3/14.
 */
public class ShopApplyModify implements Serializable {

    private String mainBus;

    private String shopNum;

    private String telephone;

    private String imWx;

    private String imQq;

    private String email;

    private List<ShiguTags> tags;

    public String getMainBus() {
        return mainBus;
    }

    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getImWx() {
        return imWx;
    }

    public void setImWx(String imWx) {
        this.imWx = imWx;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ShiguTags> getTags() {
        return tags;
    }

    public void setTags(List<ShiguTags> tags) {
        this.tags = tags;
    }
}
