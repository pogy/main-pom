package com.openJar.requests.app;

import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ImgSearchResponse;

/**
 * 类名：ImgSearchRequest
 * 类路径：com.openJar.requests.app.ImgSearchRequest
 * 创建者：王浩翔
 * 创建时间：2017-08-29 13:27
 * 项目：main-pom
 * 描述：app端图搜请求
 */
public class ImgSearchRequest extends Request<ImgSearchResponse> {
    //todo
    //图搜url
    private final String url = "xxx.json";
    //图片链接 必须
    private String imgurl;
    //分站标识
    private String webSite;
    //app端/wap端标志
    private HostEnum host = HostEnum.APP_HOST;

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public void setHost(HostEnum host) {
        this.host = host;
    }

    @Override
    public String restApiUrl() {
        return host.getRestUrl() + url;
    }

    @Override
    public String testApiUrl() {
        return host.getTestUrl() + url;
    }
}
