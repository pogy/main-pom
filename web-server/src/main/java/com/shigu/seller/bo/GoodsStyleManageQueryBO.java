package com.shigu.seller.bo;

import java.io.Serializable;

/**
 * 路径:com.shigu.seller.bo.GoodsStyleManageQueryBO
 * 工程:main-pom
 * 时间:18-1-25下午6:12
 * 创建人:wanghaoxiang
 * 描述：商家商品管理查询bo
 */
public class GoodsStyleManageQueryBO implements Serializable {
    //当前查询的类目
    private Long spid;

    public Long getSpid() {
        return spid;
    }

    public void setSpid(Long spid) {
        this.spid = spid;
    }
}
