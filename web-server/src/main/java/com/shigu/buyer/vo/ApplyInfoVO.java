package com.shigu.buyer.vo;

import com.shigu.main4.common.vo.ShiguTags;
import com.shigu.main4.vo.ShopApplyDetail;

import java.io.Serializable;
import java.util.List;

/**
 * 申请信息
 * Created by zhaohongbo on 17/3/18.
 */
public class ApplyInfoVO implements Serializable{
    /**
     * 不通过原因
     */
    private String applyFail;
    /**
     * 主营类目
     */
    private String mainCate;
    /**
     * 档口号
     */
    private String storeNum;
    /**
     * 是否有淘宝,1有
     */
    private String hasTaobaoStore;
    /**
     * 淘宝店链接
     */
    private String tbStoreUrl;
    /**
     * 店铺名
     */
    private String tbStoreName;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 微信
     */
    private String wx;
    /**
     * QQ号
     */
    private String qq;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 城市名
     */
    private String cityName;
    /**
     * 市场名
     */
    private String marketName;
    /**
     * 楼层号
     */
    private String marketFloorNum;
    /**
     * 服务级别
     */
    private String serverLevel;

    public ApplyInfoVO(ShopApplyDetail detail) {
        setApplyFail(detail.getReason());
        setCityName(detail.getWebSite());
        setEmail(detail.getEmail());
        setHasTaobaoStore(detail.getTbNick()==null||"".equals(detail.getTbNick())?"":"1");
        setMainCate(detail.getMainBus());
        setMarketFloorNum(detail.getFloor());
        setMarketName(detail.getMarket());
        setQq(detail.getImQq());
        setStoreNum(detail.getShopNum());
        setTbStoreName(detail.getTbNick());
        setWx(detail.getImWx());
        setTel(detail.getTelephone());
        setTbStoreUrl(detail.getTbUrl());
        String tagsstr="0";
        List<ShiguTags> taglist=detail.getTagsList();
        if(taglist!=null)
        for(ShiguTags st:taglist){
            if (st != null) {
                if(tagsstr.equals("0")){

                    tagsstr=st.getValue();
                }else{
                    tagsstr+=","+st.getValue();
                }
            }
        }
        setServerLevel(tagsstr);
    }

    public String getApplyFail() {
        return applyFail;
    }

    public void setApplyFail(String applyFail) {
        this.applyFail = applyFail;
    }

    public String getMainCate() {
        return mainCate;
    }

    public void setMainCate(String mainCate) {
        this.mainCate = mainCate;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getHasTaobaoStore() {
        return hasTaobaoStore;
    }

    public void setHasTaobaoStore(String hasTaobaoStore) {
        this.hasTaobaoStore = hasTaobaoStore;
    }

    public String getTbStoreUrl() {
        return tbStoreUrl;
    }

    public void setTbStoreUrl(String tbStoreUrl) {
        this.tbStoreUrl = tbStoreUrl;
    }

    public String getTbStoreName() {
        return tbStoreName;
    }

    public void setTbStoreName(String tbStoreName) {
        this.tbStoreName = tbStoreName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMarketFloorNum() {
        return marketFloorNum;
    }

    public void setMarketFloorNum(String marketFloorNum) {
        this.marketFloorNum = marketFloorNum;
    }

    public String getServerLevel() {
        return serverLevel;
    }

    public void setServerLevel(String serverLevel) {
        this.serverLevel = serverLevel;
    }
}
