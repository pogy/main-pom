package com.shigu.main4.pay.requests;

import java.io.Serializable;

/**
 * 类名：XzbUserDisposeLimitRequest
 * 类路径： com.shigu.main4.pay.requests.XzbUserDisposeLimitRequest
 * 创建者： whx
 * 创建时间： 8/10/18 4:33 PM
 * 项目： main-pom
 * 描述： 查询用户每月提现限制
 */
public class XzbUserDisposeLimitRequest implements Serializable {

    /**
     * 星座网用户id
     */
    private Long xzUserId;

    public Long getXzUserId() {
        return xzUserId;
    }

    public void setXzUserId(Long xzUserId) {
        this.xzUserId = xzUserId;
    }
}
