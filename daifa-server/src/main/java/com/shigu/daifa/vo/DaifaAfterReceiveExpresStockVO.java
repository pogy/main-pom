package com.shigu.daifa.vo;/**
 * Created by pc on 2017-09-21.
 *
 * @author pc
 * @description
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */

import com.opentae.data.daifa.beans.DaifaAfterSale;

/**
 *Created By pc on 2017-09-21/17:42
 *
 */
public class DaifaAfterReceiveExpresStockVO {
    /**
     * 包裹id
     */
    private String packageId;
    /**
     * 快递名称
     */
    private String postName;
    /**
     * 快递单号
     */
    private String postCode;
    /**
     * 发货人手机号码
     */
    private String telephone;
    /**
     * 是否匹配订单
     */
    private boolean isMatchingOrder;
    /**
     * 匹配时间
     */
    private String matchingTime;
    /**
     * 包裹备注
     */
    private String packageRemark;

    private DaifaAfterSale orders;


    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isMatchingOrder() {
        return isMatchingOrder;
    }

    public void setMatchingOrder(boolean matchingOrder) {
        isMatchingOrder = matchingOrder;
    }

    public String getMatchingTime() {
        return matchingTime;
    }

    public void setMatchingTime(String matchingTime) {
        this.matchingTime = matchingTime;
    }

    public String getPackageRemark() {
        return packageRemark;
    }

    public void setPackageRemark(String packageRemark) {
        this.packageRemark = packageRemark;
    }
}