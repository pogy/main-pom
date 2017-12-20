package com.shigu.main4.daifa.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-6-7.
 */
public class QueryPostCodeVO implements Serializable {

    private String  jsonData;
    /**
     * 快递单号
     */
    private String postCode;
    /**
     * 大头笔
     */
    private String markDestination;
    /**
     * 始发地区域编码
     */
    private String originCode;
    /**
     * 始发地/始发网点
     */
    private String originName;
    /**
     * 目的地区域编码
     */
    private String destinatioCode;
    /**
     * 目的地/到达网点
     */
    private String destinatioName;
    /**
     * 分拣编码
     */
    private String sortingCode;
    /**
     * 集包编码
     */
    private String packageCode;
    /**
     * 集包地
     */
    private String packageName;

    /**
     * 获取 快递单号
     */
    public String getPostCode() {
        return this.postCode;
    }

    /**
     * 设置 快递单号
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * 获取 大头笔
     */
    public String getMarkDestination() {
        return this.markDestination;
    }

    /**
     * 设置 大头笔
     */
    public void setMarkDestination(String markDestination) {
        this.markDestination = markDestination;
    }

    /**
     * 获取 始发地区域编码
     */
    public String getOriginCode() {
        return this.originCode;
    }

    /**
     * 设置 始发地区域编码
     */
    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    /**
     * 获取 始发地/始发网点
     */
    public String getOriginName() {
        return this.originName;
    }

    /**
     * 设置 始发地/始发网点
     */
    public void setOriginName(String originName) {
        this.originName = originName;
    }

    /**
     * 获取 目的地区域编码
     */
    public String getDestinatioCode() {
        return this.destinatioCode;
    }

    /**
     * 设置 目的地区域编码
     */
    public void setDestinatioCode(String destinatioCode) {
        this.destinatioCode = destinatioCode;
    }

    /**
     * 获取 目的地/到达网点
     */
    public String getDestinatioName() {
        return this.destinatioName;
    }

    /**
     * 设置 目的地/到达网点
     */
    public void setDestinatioName(String destinatioName) {
        this.destinatioName = destinatioName;
    }

    /**
     * 获取 分拣编码
     */
    public String getSortingCode() {
        return this.sortingCode;
    }

    /**
     * 设置 分拣编码
     */
    public void setSortingCode(String sortingCode) {
        this.sortingCode = sortingCode;
    }

    /**
     * 获取 集包编码
     */
    public String getPackageCode() {
        return this.packageCode;
    }

    /**
     * 设置 集包编码
     */
    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    /**
     * 获取 集包地
     */
    public String getPackageName() {
        return this.packageName;
    }

    /**
     * 设置 集包地
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getJsonData () {
        return jsonData;
    }

    public void setJsonData (String jsonData) {
        this.jsonData = jsonData;
    }
}
