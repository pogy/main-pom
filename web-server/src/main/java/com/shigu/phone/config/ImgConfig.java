package com.shigu.phone.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created By pc on 2017-10-27/11:25
 */
@Component
public class ImgConfig {
    /**
     * 手机端用户头像缩略后缀
     */
    @Value("${img.appHeadImgSuf}")
    private String appHeadImgSuf;

     /**
     * 手机端图搜缩略后缀
     */
    @Value("${img.appImgSearchSuf}")
    private String appImgSearchSuf;
    /**
     * 手机端图片详情ali taobao CDD图片缩略后缀
     */
    @Value("${img.appItemDetailAlicdnSuf}")
    private String appItemDetailAlicdnSuf;
    /**
     * 手机端图片详情oss图片缩略后缀
     */
    @Value("${img.appItemDetailImgSuf}")
    private String appItemDetailImgSuf;

    public String getAppHeadImgSuf() {
        return appHeadImgSuf;
    }

    public String getAppImgSearchSuf() {
        return appImgSearchSuf;
    }

    public String getAppItemDetailAlicdnSuf() {
        return appItemDetailAlicdnSuf;
    }

    public String getAppItemDetailImgSuf() {
        return appItemDetailImgSuf;
    }
}
