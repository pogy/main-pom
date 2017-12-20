package com.shigu.order.vo;

import com.shigu.main4.order.servicevo.OrderDetailTotalVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import com.shigu.main4.order.vo.OrderAddrInfoVO;
import com.shigu.main4.order.vo.OrderDetailExpressVO;

import java.util.List;

/**
 * @类编号
 * @类名称：OrderDetailVO
 * @文件路径：com.shigu.main4.order.servicevo.OrderDetailVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/21 11:13
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class MyOrderDetailVO {

    private String[] orderStateText;//订单状态文字描述：'提交订单', '买家付款', '商品配货', '交易完成'

    private Long orderCreateTime;//创建时间YYYY-MM-dd HH:mm:ss

    private Long orderId;//订单编号

    private String orderDealTime;//成交时间

    private OrderAddrInfoVO orderAddrInfo;//收货人信息

    private OrderDetailExpressVO express;//快递信息

    private List<SubMyOrderVO> childOrders;//订单子单

    private OrderDetailTotalVO total;//总计

    private  Integer  orderStateNum;//当前订单处于哪种状态，为1,2,3,4,5; 1提交订单，2待配货，3已发货，4交易完成，5取消订单

    private String[] orderStateTime;//订单状态时间，每条状态对应一条时间，当前处于第几种状态刚返回几条时间值，多条用逗号分隔。 状态为5返回两条时间值

    public String[] getOrderStateText () {
        return orderStateText;
    }

    public void setOrderStateText (String[] orderStateText) {
        this.orderStateText = orderStateText;
    }

    public Long getOrderCreateTime () {
        return orderCreateTime;
    }

    public void setOrderCreateTime (Long orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Long getOrderId () {
        return orderId;
    }

    public void setOrderId (Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDealTime () {
        return orderDealTime;
    }

    public void setOrderDealTime (String orderDealTime) {
        this.orderDealTime = orderDealTime;
    }

    public OrderAddrInfoVO getOrderAddrInfo () {
        return orderAddrInfo;
    }

    public void setOrderAddrInfo (OrderAddrInfoVO orderAddrInfo) {
        this.orderAddrInfo = orderAddrInfo;
    }

    public OrderDetailExpressVO getExpress () {
        return express;
    }

    public void setExpress (OrderDetailExpressVO express) {
        this.express = express;
    }

    public List<SubMyOrderVO> getChildOrders () {
        return childOrders;
    }

    public void setChildOrders (List<SubMyOrderVO> childOrders) {
        this.childOrders = childOrders;
    }

    public OrderDetailTotalVO getTotal () {
        return total;
    }

    public void setTotal (OrderDetailTotalVO total) {
        this.total = total;
    }

    public Integer getOrderStateNum () {
        return orderStateNum;
    }

    public void setOrderStateNum (Integer orderStateNum) {
        this.orderStateNum = orderStateNum;
    }

    public String[] getOrderStateTime () {
        return orderStateTime;
    }

    public void setOrderStateTime (String[] orderStateTime) {
        this.orderStateTime = orderStateTime;
    }
}
