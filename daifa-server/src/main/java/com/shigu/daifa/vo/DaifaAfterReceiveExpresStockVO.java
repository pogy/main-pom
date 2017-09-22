package com.shigu.daifa.vo;/**
 * Created by pc on 2017-09-21.
 *
 * @author pc
 * @description
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */

import java.util.List;

/**
 *Created By pc on 2017-09-21/17:42
 *
 */
public class DaifaAfterReceiveExpresStockVO {
    /**
     * 包裹id(received_express_id)
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
    private Boolean isMatchingOrder;
    /**
     * 匹配时间
     */
    private String matchingTime;
    /**
     * 包裹备注
     */
    private String packageRemark;

    private List<DaifaSaleAfterVO> orders;

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

    public List<DaifaSaleAfterVO> getOrders() {
        return orders;
    }

    public void setOrders(List<DaifaSaleAfterVO> orders) {
        this.orders = orders;
    }

    /**
     * 获取 是否匹配订单
     */
    public Boolean getIsMatchingOrder() {
        return this.isMatchingOrder;
    }

    /**
     * 设置 是否匹配订单
     */
    public void setIsMatchingOrder(Boolean isMatchingOrder) {
        this.isMatchingOrder = isMatchingOrder;
    }
}