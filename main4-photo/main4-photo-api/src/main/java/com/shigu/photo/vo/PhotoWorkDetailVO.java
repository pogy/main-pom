package com.shigu.photo.vo;

import java.io.Serializable;

/**
 * 路径: com.shigu.photo.vo.PhotoWorkDetailVO
 * 工程: main-pom
 * 时间: 18-4-25 下午5:24
 * 创建人: wanghaoxiang
 * 描述: 作品详情
 */
public class PhotoWorkDetailVO extends PhotoWorksVO implements Serializable {

    // 价格显示字符串（私聊/价格）
    private String priceStr;

    // 风格现实字符串
    private String stylesStr;

    // 图片集
    private String imgs;

    // 点击量
    private Long clicks;

    // 作者头像
    private String authHeadImg;

    // 作者微信
    private String authCodeImg;

    // 作者联系手机号
    private String authContactPhone;

    // 作者作品数量
    private Long worksCount;

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public String getStylesStr() {
        return stylesStr;
    }

    public void setStylesStr(String stylesStr) {
        this.stylesStr = stylesStr;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    public String getAuthHeadImg() {
        return authHeadImg;
    }

    public void setAuthHeadImg(String authHeadImg) {
        this.authHeadImg = authHeadImg;
    }

    public String getAuthCodeImg() {
        return authCodeImg;
    }

    public void setAuthCodeImg(String authCodeImg) {
        this.authCodeImg = authCodeImg;
    }

    public String getAuthContactPhone() {
        return authContactPhone;
    }

    public void setAuthContactPhone(String authContactPhone) {
        this.authContactPhone = authContactPhone;
    }

    public Long getWorksCount() {
        return worksCount;
    }

    public void setWorksCount(Long worksCount) {
        this.worksCount = worksCount;
    }
}
