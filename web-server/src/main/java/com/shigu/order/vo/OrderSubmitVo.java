package com.shigu.order.vo;

import com.shigu.main4.order.vo.CartVO;
import com.shigu.order.OrderSubmitType;

import java.util.List;

/**
 * 提交订单时对进货车数据的一个封装
 * Created by bugzy on 2017/6/21 0021.
 */
public class OrderSubmitVo {

    private OrderSubmitType submitType;

    /**
     * 地址信息
     */
    private String address;

    /**
     * 原单号
     */
    private String outerOrderNo;

    /**
     * 产品信息
     */
    private List<CartVO> products;

    private Long userId;

    private Long senderId;
    /**
     * 淘宝地址信息
     */
    private TbOrderAddressInfoVO tbOrderAddressInfo;



    public OrderSubmitType getSubmitType() {
        return submitType;
    }

    public void setSubmitType(OrderSubmitType submitType) {
        this.submitType = submitType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOuterOrderNo() {
        return outerOrderNo;
    }

    public void setOuterOrderNo(String outerOrderNo) {
        this.outerOrderNo = outerOrderNo;
    }

    public List<CartVO> getProducts() {
        return products;
    }

    public void setProducts(List<CartVO> products) {
        this.products = products;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 淘宝地址信息
     */
    public TbOrderAddressInfoVO getTbOrderAddressInfo() {
        return this.tbOrderAddressInfo;
    }

    /**
     * 设置 淘宝地址信息
     */
    public void setTbOrderAddressInfo(TbOrderAddressInfoVO tbOrderAddressInfo) {
        this.tbOrderAddressInfo = tbOrderAddressInfo;
    }

    public Long getSenderId() {
        return this.senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }
}
