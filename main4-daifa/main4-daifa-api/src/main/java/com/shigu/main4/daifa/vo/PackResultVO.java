package com.shigu.main4.daifa.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 扫描发货时,返回的结果信息
 * Created by zhaohongbo on 17/8/9.
 */
public class PackResultVO implements Serializable {
    private Long sendId;
    private String goodsInfo;

    public Long getSendId() {
        return this.sendId;
    }

    public void setSendId(Long sendId) {
        this.sendId = sendId;
    }

    public String getGoodsInfo() {
        return this.goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }
}
