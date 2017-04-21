package com.shigu.seller.bo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 发布宝贝的参数
 * Created by zhaohongbo on 17/3/15.
 */
public class GoodsSendBO implements Serializable{

    @NotNull(message = "缺少cid参数")
    private Long cid;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
}
