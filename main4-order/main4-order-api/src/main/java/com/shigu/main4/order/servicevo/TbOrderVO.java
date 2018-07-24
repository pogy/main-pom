package com.shigu.main4.order.servicevo;

import java.io.Serializable;
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
    private String tbId;
    /**
     * 星座网用户ID
     */
    private Long xzUserId;
    /**
     * 支付时间
     */
    private String time;
    /**
     * 最后一次下单时间
     */
    private String lastTime;
    /**
     * 利润
     */
    private String profits;
    /**
     * 详细地址,包含省市区街道收货人信息
     */
    private String address;
    /**
     * 卖家备注旗帜（与淘宝网上订单的卖家备注旗帜对应，只有卖家才能查看该字段）红、黄、绿、蓝、紫 分别对应 1、2、3、4、5
     */
    private Long flagState;
    /**
     * 街道+地址
     */
    private String simpleAddress;
    /**
     * 省
     */
    private String prov;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String town;
    /**
     * 收件人
     */
    private String receiverName;
    /**
     * 号码
     */
    private String receiverPhone;
    /**
     * 是否可下单
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
    public String getTbId() {
        return this.tbId;
    }

    /**
     * 淘宝主单ID
     * PS:转json的时候建议将Long转String,防止数值偏移
     */
    public void setTbId(String tbId) {
        this.tbId = tbId;
    }

    /**
     * 获取 支付时间
     */
    public String getTime() {
        return this.time;
    }

    /**
     * 设置 支付时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取 最后一次下单时间
     */
    public String getLastTime() {
        return this.lastTime;
    }

    /**
     * 设置 最后一次下单时间
     */
    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
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
     * 获取 详细地址,包含省市区街道收货人信息
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * 设置 详细地址,包含省市区街道收货人信息
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取 是否可下单
     */
    public boolean isCanOrder() {
        return this.canOrder;
    }

    /**
     * 设置 是否可下单
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

    /**
     * 获取 省
     */
    public String getProv() {
        return this.prov;
    }

    /**
     * 设置 省
     */
    public void setProv(String prov) {
        this.prov = prov;
    }

    /**
     * 获取 市
     */
    public String getCity() {
        return this.city;
    }

    /**
     * 设置 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取 区
     */
    public String getTown() {
        return this.town;
    }

    /**
     * 设置 区
     */
    public void setTown(String town) {
        this.town = town;
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
     * 获取 号码
     */
    public String getReceiverPhone() {
        return this.receiverPhone;
    }

    /**
     * 设置 号码
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * 获取 街道+地址
     */
    public String getSimpleAddress() {
        return this.simpleAddress;
    }

    /**
     * 设置 街道+地址
     */
    public void setSimpleAddress(String simpleAddress) {
        this.simpleAddress = simpleAddress;
    }

    /**
     * 获取 星座网用户ID
     */
    public Long getXzUserId() {
        return this.xzUserId;
    }

    /**
     * 设置 星座网用户ID
     */
    public void setXzUserId(Long xzUserId) {
        this.xzUserId = xzUserId;
    }

    /**
     * 获取 卖家备注旗帜（与淘宝网上订单的卖家备注旗帜对应，只有卖家才能查看该字段）红、黄、绿、蓝、紫 分别对应 1、2、3、4、5
     */
    public Long getFlagState() {
        return this.flagState;
    }

    /**
     * 设置 卖家备注旗帜（与淘宝网上订单的卖家备注旗帜对应，只有卖家才能查看该字段）红、黄、绿、蓝、紫 分别对应 1、2、3、4、5
     */
    public void setFlagState(Long flagState) {
        this.flagState = flagState;
    }
}
