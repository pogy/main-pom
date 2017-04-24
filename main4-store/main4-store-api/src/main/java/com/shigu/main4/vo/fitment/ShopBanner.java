package com.shigu.main4.vo.fitment;

import com.alibaba.fastjson.annotation.JSONField;
import com.shigu.main4.enums.FitmentModuleType;
import com.shigu.main4.vo.FitmentModule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * banner 配置区
 * Created by Administrator on 2017/4/18 0018.
 */
public class ShopBanner extends FitmentModule {

    /**
     * 图设置
     */
    private BannerImage storeImg = new BannerImage();

    /**
     * 导航设置
     */
    private BannerNav storeNav = new BannerNav();

    /**
     * 自定义导航内容
     */
    private List<BannerAuto> storeNavAuto = new ArrayList<>();

    @JSONField(serialize = false)
    private BannerOption bannerOption = new BannerOption();

    @Override
    public Integer getModuleType() {
        return FitmentModuleType.Banner.value;
    }

    public BannerImage getStoreImg() {
        return storeImg;
    }

    public void setStoreImg(BannerImage storeImg) {
        this.storeImg = storeImg;
    }

    public BannerNav getStoreNav() {
        return storeNav;
    }

    public void setStoreNav(BannerNav storeNav) {
        this.storeNav = storeNav;
    }

    public List<BannerAuto> getStoreNavAuto() {
        return storeNavAuto;
    }

    public void setStoreNavAuto(List<BannerAuto> storeNavAuto) {
        this.storeNavAuto = storeNavAuto;
    }

    public BannerOption getBannerOption() {
        return bannerOption;
    }

    public void setBannerOption(BannerOption bannerOption) {
        this.bannerOption = bannerOption;
    }
}
