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
    private String expressName;
    private String expressCode;
    private String packageCode;

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

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

    public String getPackageCode () {
        return packageCode;
    }

    public void setPackageCode (String packageCode) {
        this.packageCode = packageCode;
    }
}
