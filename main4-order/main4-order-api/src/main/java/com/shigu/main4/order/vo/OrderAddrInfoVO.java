package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：OrderAddrInfoVO
 * @文件路径：com.shigu.main4.order.vo.OrderAddrInfoVO
 * @内容摘要：订单详情中的--收货人信息
 * @编码作者：gzy
 * @创建日期：2017/7/21 10:44
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class OrderAddrInfoVO implements Serializable{
    private Long orderId;//订单编号

    private String name;//收货人姓名

    private String phone;//收货人电话

    private String address;//收货人地址

    public Long getOrderId () {
        return orderId;
    }

    public void setOrderId (Long orderId) {
        this.orderId = orderId;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }
}
