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
    private Long tbId;
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
     * 详细地址,包含街道
     */
    private String address;
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
    public Long getTbId() {
        return this.tbId;
    }

    /**
     * 淘宝主单ID
     * PS:转json的时候建议将Long转String,防止数值偏移
     */
    public void setTbId(Long tbId) {
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
     * 获取 详细地址,包含街道
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * 设置 详细地址,包含街道
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
}
