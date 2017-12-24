package com.openJar.requests.imgs;


import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.imgs.JdUpImgResponse;

import java.util.List;

/**
 * 上传图片到京东
 * Created by zhaohongbo on 17/1/18.
 */
public class JdUpImgRequest extends Request<JdUpImgResponse> {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 图片链接
     */
    private List<String> imgUrls;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String restApiUrl() {
        return JdImgEnum.REST+"uptoitemimg.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"uptoitemimg.json";
    }
}
