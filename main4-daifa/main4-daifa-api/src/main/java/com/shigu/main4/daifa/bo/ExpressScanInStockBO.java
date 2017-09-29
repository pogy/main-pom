package com.shigu.main4.daifa.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：ExpressScanInStockBO
 * @文件路径：com.shigu.main4.daifa.bo.ExpressScanInStockBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/15 12:32
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class ExpressScanInStockBO implements Serializable{
    private String expressName;
    private String expressCode;
    private String stockLocation;
    private String sendPhone;

    public String getExpressName() {
        return this.expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressCode() {
        return this.expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

    public String getStockLocation() {
        return this.stockLocation;
    }

    public void setStockLocation(String stockLocation) {
        this.stockLocation = stockLocation;
    }

    public String getSendPhone() {
        return this.sendPhone;
    }

    public void setSendPhone(String sendPhone) {
        this.sendPhone = sendPhone;
    }
}
