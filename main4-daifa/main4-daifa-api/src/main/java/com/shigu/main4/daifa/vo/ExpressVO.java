package com.shigu.main4.daifa.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：ExpressVO
 * @文件路径：com.shigu.main4.daifa.vo.ExpressVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/8/9 16:43
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class ExpressVO implements Serializable {

    private Long tid;//代发交易ID
    private Long expressId;//快递ID
    private String expressCode;//快递单号
    private String markDestination;//三段码
    private String packageName;//集包地

    public Long getTid () {
        return tid;
    }

    public void setTid (Long tid) {
        this.tid = tid;
    }

    public Long getExpressId () {
        return expressId;
    }

    public void setExpressId (Long expressId) {
        this.expressId = expressId;
    }

    public String getExpressCode () {
        return expressCode;
    }

    public void setExpressCode (String expressCode) {
        this.expressCode = expressCode;
    }

    public String getMarkDestination () {
        return markDestination;
    }

    public void setMarkDestination (String markDestination) {
        this.markDestination = markDestination;
    }

    public String getPackageName () {
        return packageName;
    }

    public void setPackageName (String packageName) {
        this.packageName = packageName;
    }
}
