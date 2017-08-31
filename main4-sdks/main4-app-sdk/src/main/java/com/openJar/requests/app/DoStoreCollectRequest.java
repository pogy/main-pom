package com.openJar.requests.app;

import com.openJar.requests.Request;
import com.openJar.responses.app.DoStoreCollectResponse;

/**
 * Created by jmb on 2017/8/31.
 * Path com.openJar.requests.app.DoStoreCollectResponse
 */
public class DoStoreCollectRequest extends Request<DoStoreCollectResponse> {
    //收藏ID
    private Long collectId;
    //收藏or取消收藏
    private Boolean yesOrNo;
    //用户ID	必须
    private Long userId;
    //临时授权码
    private String token;

    public Long getStore_id() {
        return Store_id;
    }

    public void setStore_id(Long store_id) {
        Store_id = store_id;
    }

    private Long Store_id;

    public Long getCollectId() { return collectId; }

    public void setCollectId(Long collectId) { this.collectId = collectId; }

    public Boolean getYesOrNo() { return yesOrNo; }

    public void setYesOrNo(Boolean yesOrNo) { this.yesOrNo = yesOrNo; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public String getToken() { return token; }

    public void setToken(String token) { this.token = token; }
}
