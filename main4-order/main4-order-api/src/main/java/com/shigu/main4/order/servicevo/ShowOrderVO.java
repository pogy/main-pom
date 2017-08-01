package com.shigu.main4.order.servicevo;

import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.zfenums.MainOrderStatusEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @类编号
 * @类名称：ShowOrderVO
 * @文件路径：com.shigu.main4.order.servicevo.ShowOrderVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/21 13:37
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class ShowOrderVO implements Serializable {

    private Long orderId;
    /**
     * 商品总金额
     */
    private Long orderPrice;
    /**
     * 快递费
     */
    private Long postPrice;
    /**
     * 服务费
     */
    private Long serverPrice;
    /**
     * 订单状态，1，2，3，4,5; 1等待付款, 2等待配货, 3已发货, 4交易完成, 5交易取消
     */
    private MainOrderStatusEnum mainState;
    /**
     * 是否淘宝订单
     */
    private  Boolean isTbOrder;
    /**
     * 站点
     */
    private String webSite;
    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 子单数据
     */
    private List<SubOrderInfoVO> childOrders;

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 快递费
     */
    public Long getPostPrice() {
        return this.postPrice;
    }

    /**
     * 设置 快递费
     */
    public void setPostPrice(Long postPrice) {
        this.postPrice = postPrice;
    }

    /**
     * 获取 服务费
     */
    public Long getServerPrice() {
        return this.serverPrice;
    }

    /**
     * 设置 服务费
     */
    public void setServerPrice(Long serverPrice) {
        this.serverPrice = serverPrice;
    }

    /**
     * 获取 订单状态，1，2，3，4,5; 1等待付款, 2等待配货, 3已发货, 4交易完成, 5交易取消
     */
    public MainOrderStatusEnum getMainState() {
        return this.mainState;
    }

    /**
     * 设置 订单状态，1，2，3，4,5; 1等待付款, 2等待配货, 3已发货, 4交易完成, 5交易取消
     */
    public void setMainState(MainOrderStatusEnum mainState) {
        this.mainState = mainState;
    }


    /**
     * 获取 站点
     */
    public String getWebSite() {
        return this.webSite;
    }

    /**
     * 设置 站点
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
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
     * 获取 子单数据
     */
    public List<SubOrderInfoVO> getChildOrders() {
        return this.childOrders;
    }

    /**
     * 设置 子单数据
     */
    public void setChildOrders(List<SubOrderInfoVO> childOrders) {
        this.childOrders = childOrders;
    }

    /**
     * 获取 商品总金额
     */
    public Long getOrderPrice() {
        return this.orderPrice;
    }

    /**
     * 设置 商品总金额
     */
    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * 获取 是否淘宝订单
     */
    public Boolean getIsTbOrder() {
        return this.isTbOrder;
    }

    /**
     * 设置 是否淘宝订单
     */
    public void setIsTbOrder(Boolean isTbOrder) {
        this.isTbOrder = isTbOrder;
    }
}
