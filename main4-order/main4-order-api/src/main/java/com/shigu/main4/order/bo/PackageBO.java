package com.shigu.main4.order.bo;

import java.io.Serializable;

/**
 * 包材参数
 * Created by zhaohongbo on 17/6/2.
 */
public class PackageBO implements Serializable{
    /**
     * 材质ID
     */
    private Long metarialId;
    /**
     * 数量
     */
    private Integer num;

    public Long getMetarialId() {
        return metarialId;
    }

    public void setMetarialId(Long metarialId) {
        this.metarialId = metarialId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
