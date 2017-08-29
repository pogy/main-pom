package com.openJar.requests.app;

import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.ShopSearchResponse;

/**
 * 类名：ShopSearchRequest
 * 类路径：com.openJar.requests.app.ShopSearchRequest
 * 创建者：王浩翔
 * 创建时间：2017-08-29 12:21
 * 项目：main-pom
 * 描述：app端档口搜索请求
 */
public class ShopSearchRequest extends Request<ShopSearchResponse> {
    //todo
    //档口搜索请求url
    private final String url = "xxxxxxxx.json";
    //关键词
    private String keyword;
    //分站标识
    private String webSite;
    //页码，默认1开始
    private Integer index;
    //页长
    private Integer size;

    //app端/wap端标志
    private HostEnum host = HostEnum.APP_HOST;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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
