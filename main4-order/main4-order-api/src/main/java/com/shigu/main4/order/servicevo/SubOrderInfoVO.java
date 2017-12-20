package com.shigu.main4.order.servicevo;

import java.io.Serializable;

/**
 * 子订单信息
 * Created by zhaohongbo on 17/7/14.
 */
public class SubOrderInfoVO implements Serializable{
    private Long orderId;
    /**
     * 子单ID
     */
    private Long subOrderId;
    /**
     * 售前退款ID
     */
    private Long preSaleRefundId;
    /**
     * 退换货ID
     */
    private Long afterSaleRefundId;
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 图片地址
     */
    private String imgsrc;
    /**
     * 标题
     */
    private String title;
    /**
     * 颜色
     */
    private String color;
    /**
     * 尺码
     */
    private String size;
    /**
     * 货号(商家编码?)
     */
    private String goodsNo;
    /**
     * 单价：接口传出来的数值
     */
    private Long price;
    /**
     * 商品数
     */
    private Integer num;
    /**
     * 售前(发货前)退款数
     */
    private Integer tkNum;
    /**
     * 售后退款数量
     */
    private Integer shTkNum;
    /**
     * 退款数量(已退和已申请退款的数量)
     */
    private Integer refundNum;
    /**
     * 售前(发货前)退款状态
     */
    private Integer tkState;
    /**
     * 售后状态 0无，2已退款，3已换货, 4退款中, 5换货中, 6退款拒绝, 7换货拒绝
     */
    private Integer shState;

    /**
     * 获取 商品ID
     */
    public Long getGoodsId() {
        return this.goodsId;
    }

    /**
     * 设置 商品ID
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取 图片地址
     */
    public String getImgsrc() {
        return this.imgsrc;
    }

    /**
     * 设置 图片地址
     */
    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    /**
     * 获取 标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取 颜色
     */
    public String getColor() {
        return this.color;
    }

    /**
     * 设置 颜色
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取 尺码
     */
    public String getSize() {
        return this.size;
    }

    /**
     * 设置 尺码
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * 获取 货号(商家编码?)
     */
    public String getGoodsNo() {
        return this.goodsNo;
    }

    /**
     * 设置 货号(商家编码?)
     */
    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    /**
     * 获取 单价：接口传出来的数值
     */
    public Long getPrice() {
        return this.price;
    }

    /**
     * 设置 单价：接口传出来的数值
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 获取 商品数
     */
    public Integer getNum() {
        return this.num;
    }

    /**
     * 设置 商品数
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取 售前(发货前)退款数
     */
    public Integer getTkNum() {
        return this.tkNum;
    }

    /**
     * 设置 售前(发货前)退款数
     */
    public void setTkNum(Integer tkNum) {
        this.tkNum = tkNum;
    }

    /**
     * 获取 售后退款数量
     */
    public Integer getShTkNum() {
        return this.shTkNum;
    }

    /**
     * 设置 售后退款数量
     */
    public void setShTkNum(Integer shTkNum) {
        this.shTkNum = shTkNum;
    }

    /**
     * 获取 退款数量(已退和已申请退款的数量)
     */
    public Integer getRefundNum() {
        return this.refundNum;
    }

    /**
     * 设置 退款数量(已退和已申请退款的数量)
     */
    public void setRefundNum(Integer refundNum) {
        this.refundNum = refundNum;
    }

    /**
     * 获取 售前(发货前)退款状态
     */
    public Integer getTkState() {
        return this.tkState;
    }

    /**
     * 设置 售前(发货前)退款状态
     */
    public void setTkState(Integer tkState) {
        this.tkState = tkState;
    }

    /**
     * 获取 售后状态 0无，2已退款，3已换货, 4退款中, 5换货中, 6退款拒绝, 7换货拒绝
     */
    public Integer getShState() {
        return this.shState;
    }

    /**
     * 设置 售后状态 0无，2已退款，3已换货, 4退款中, 5换货中, 6退款拒绝, 7换货拒绝
     */
    public void setShState(Integer shState) {
        this.shState = shState;
    }

    /**
     * 获取 子单ID
     */
    public Long getSubOrderId() {
        return this.subOrderId;
    }

    /**
     * 设置 子单ID
     */
    public void setSubOrderId(Long subOrderId) {
        this.subOrderId = subOrderId;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 售前退款ID
     */
    public Long getPreSaleRefundId() {
        return this.preSaleRefundId;
    }

    /**
     * 设置 售前退款ID
     */
    public void setPreSaleRefundId(Long preSaleRefundId) {
        this.preSaleRefundId = preSaleRefundId;
    }

    /**
     * 获取 退换货ID
     */
    public Long getAfterSaleRefundId() {
        return this.afterSaleRefundId;
    }

    /**
     * 设置 退换货ID
     */
    public void setAfterSaleRefundId(Long afterSaleRefundId) {
        this.afterSaleRefundId = afterSaleRefundId;
    }
}
