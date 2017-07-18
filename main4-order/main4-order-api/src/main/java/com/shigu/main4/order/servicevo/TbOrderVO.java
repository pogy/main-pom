package com.shigu.main4.order.servicevo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @类编号
 * @类名称：TbOrderVO
 * @文件路径：com.shigu.main4.order.vo.TbOrderVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/14 15:02
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class TbOrderVO implements Serializable{
    /**
     * 淘宝主单ID
     * PS:转json的时候建议将Long转String,防止数值偏移
     */
    private Long tid;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 最后一次在星座网下单时间
     */
    private Date lastTradeTime;
    /**
     * 利润
     */
    private String profits;
    /**
     * 省
     */
    private String receiverState;
    /**
     * 市
     */
    private String receiverCity;
    /**
     * 区
     */
    private String receivarDistrict;
    /**
     * 详细地址,包含街道
     */
    private String receiverAddress;
    /**
     * 收件人
     */
    private String receiverName;
    /**
     * 手机
     */
    private String receiverMobile;
    /**
     * 电话
     */
    private String receiverPhone;
    /**
     * 是否已关联商品
     */
    private boolean canOrder;
    /**
     * 子单数据
     */
    private List<SubTbOrderVO> childOrders;

    /**
     * 淘宝主单ID
     * PS:转json的时候建议将Long转String,防止数值偏移
     */
    public Long getTid() {
        return this.tid;
    }

    /**
     * 淘宝主单ID
     * PS:转json的时候建议将Long转String,防止数值偏移
     */
    public void setTid(Long tid) {
        this.tid = tid;
    }

    /**
     * 获取 支付时间
     */
    public Date getPayTime() {
        return this.payTime;
    }

    /**
     * 设置 支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取 最后一次在星座网下单时间
     */
    public Date getLastTradeTime() {
        return this.lastTradeTime;
    }

    /**
     * 设置 最后一次在星座网下单时间
     */
    public void setLastTradeTime(Date lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    }

    /**
     * 获取 利润
     */
    public String getProfits() {
        return this.profits;
    }

    /**
     * 设置 利润
     */
    public void setProfits(String profits) {
        this.profits = profits;
    }

    /**
     * 获取 省
     */
    public String getReceiverState() {
        return this.receiverState;
    }

    /**
     * 设置 省
     */
    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    /**
     * 获取 市
     */
    public String getReceiverCity() {
        return this.receiverCity;
    }

    /**
     * 设置 市
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    /**
     * 获取 区
     */
    public String getReceivarDistrict() {
        return this.receivarDistrict;
    }

    /**
     * 设置 区
     */
    public void setReceivarDistrict(String receivarDistrict) {
        this.receivarDistrict = receivarDistrict;
    }

    /**
     * 获取 详细地址,包含街道
     */
    public String getReceiverAddress() {
        return this.receiverAddress;
    }

    /**
     * 设置 详细地址,包含街道
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * 获取 收件人
     */
    public String getReceiverName() {
        return this.receiverName;
    }

    /**
     * 设置 收件人
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 获取 手机
     */
    public String getReceiverMobile() {
        return this.receiverMobile;
    }

    /**
     * 设置 手机
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    /**
     * 获取 电话
     */
    public String getReceiverPhone() {
        return this.receiverPhone;
    }

    /**
     * 设置 电话
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * 获取 是否已关联商品
     */
    public boolean isCanOrder() {
        return this.canOrder;
    }

    /**
     * 设置 是否已关联商品
     */
    public void setCanOrder(boolean canOrder) {
        this.canOrder = canOrder;
    }

    /**
     * 获取 子单数据
     */
    public List<SubTbOrderVO> getChildOrders() {
        return this.childOrders;
    }

    /**
     * 设置 子单数据
     */
    public void setChildOrders(List<SubTbOrderVO> childOrders) {
        this.childOrders = childOrders;
    }
}
