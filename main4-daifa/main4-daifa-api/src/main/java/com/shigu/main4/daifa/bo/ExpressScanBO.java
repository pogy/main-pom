package com.shigu.main4.daifa.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：ExpressScanBO
 * @文件路径：com.shigu.main4.daifa.bo.ExpressScanBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/15 12:26
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class ExpressScanBO implements Serializable{

    private static final long serialVersionUID = 8943958156594342413L;

    /**
     * 快递单号
     */
    String expressCode;

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }
}
