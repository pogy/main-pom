package com.shigu.main4.pay.requests;

import java.io.Serializable;

/**
 * 类名：XzbUserBalanceRequest
 * 类路径： com.shigu.main4.pay.requests.XzbUserBalanceRequest
 * 创建者： whx
 * 创建时间： 8/8/18 3:20 PM
 * 项目： main-pom
 * 描述：
 */
public class XzbUserBalanceRequest implements Serializable {

    // 星座网用户id
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
