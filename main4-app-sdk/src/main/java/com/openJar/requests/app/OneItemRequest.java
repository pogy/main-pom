package com.openJar.requests.app;

import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.OneItemResponse;

/**
 * 类名：OneItemRequest
 * 类路径：com.openJar.requests.app.OneItemRequest
 * 创建者：王浩翔
 * 创建时间：2017-08-29 12:55
 * 项目：main-pom
 * 描述：app端单商品信息请求
 */
public class OneItemRequest extends Request<OneItemResponse> {
    //todo
    //单商品信息请求url
    private final String url = "xxxxsxxxx.json";
    //商品id
    private Long itemId;
    //分站标志
    private String webSite;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @Override
    public String restApiUrl() {
        return HostEnum.APP_REST_HOST + url;
    }

    @Override
    public String testApiUrl() {
        return HostEnum.APP_TEST_HOST + url;
    }
}
