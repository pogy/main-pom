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

    public String getAppHeadImgSuf() {
        return appHeadImgSuf;
    }

    public void setAppHeadImgSuf(String appHeadImgSuf) {
        this.appHeadImgSuf = appHeadImgSuf;
    }

    public String getAppImgSearchSuf() {
        return appImgSearchSuf;
    }

    public void setAppImgSearchSuf(String appImgSearchSuf) {
        this.appImgSearchSuf = appImgSearchSuf;
    }
}
