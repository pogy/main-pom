package com.openJar.requests.app;

import com.openJar.requests.Request;
import com.openJar.responses.app.DoStoreCollectResponse;

import javax.validation.constraints.NotNull;

/**
 * Created by jmb on 2017/8/31.
 * Path com.openJar.requests.app.DoStoreCollectResponse
 */
public class DoStoreCollectRequest extends Request<DoStoreCollectResponse> {
    //收藏ID
    @NotNull(message = "shopId is null")
    private Long shopId;
    //收藏or取消收藏
    @NotNull(message = "yesOrNo is null")
    private Boolean yesOrNo;
    //用户ID	必须
    @NotNull(message = "userId is null")
    private Long userId;
    //临时授权码
    @NotNull(message = "token is null")
    private String token;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Boolean getYesOrNo() { return yesOrNo; }

    public void setYesOrNo(Boolean yesOrNo) { this.yesOrNo = yesOrNo; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public String getToken() { return token; }

    public void setToken(String token) { this.token = token; }

    @Override
    public String restApiUrl() {
        return null;
    }

    @Override
    public String testApiUrl() {
        return null;
    }
}
