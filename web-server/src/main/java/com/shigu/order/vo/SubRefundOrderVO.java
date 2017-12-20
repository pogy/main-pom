package com.shigu.order.vo;

public class SubRefundOrderVO {
    /**
     * 	退换货子单id
     */
    private Long childOrderId;
    /**
     * 退换货商品图片地址
     */
    private String childOrderImgSrc;
    /**
     * 退换货商品货号
     */
    private String childOrderCode;
    /**
     * 退换货商品颜色
     */
    private String childOrderColor;
    /**
     * 子单商品数
     */
    private Integer childOrderNum;
    /**
     * 退换货商品尺码
     */
    private String childOrderSize;
    /**
     * 退款商品单价
     */
    private String refundGoodsPrice;
    /**
     * 最多可退货件数
     */
    private Integer refundNumber;
    /**
     * 可退的其他金额(快递费,服务费),
     * 除了当前子单外,没有存在未完全退完的子单时,
     * 返回该值
     */
    private String otherRefundPrice;

    public Integer getChildOrderNum() {
        return childOrderNum;
    }

    public void setChildOrderNum(Integer childOrderNum) {
        this.childOrderNum = childOrderNum;
    }

    /**
     * 获取 	退换货子单id
     */
    public Long getChildOrderId() {
        return this.childOrderId;
    }

    /**
     * 设置 	退换货子单id
     */
    public void setChildOrderId(Long childOrderId) {
        this.childOrderId = childOrderId;
    }

    /**
     * 获取 退换货商品图片地址
     */
    public String getChildOrderImgSrc() {
        return this.childOrderImgSrc;
    }

    /**
     * 设置 退换货商品图片地址
     */
    public void setChildOrderImgSrc(String childOrderImgSrc) {
        this.childOrderImgSrc = childOrderImgSrc;
    }

    /**
     * 获取 退换货商品货号
     */
    public String getChildOrderCode() {
        return this.childOrderCode;
    }

    /**
     * 设置 退换货商品货号
     */
    public void setChildOrderCode(String childOrderCode) {
        this.childOrderCode = childOrderCode;
    }

    /**
     * 获取 退换货商品颜色
     */
    public String getChildOrderColor() {
        return this.childOrderColor;
    }

    /**
     * 设置 退换货商品颜色
     */
    public void setChildOrderColor(String childOrderColor) {
        this.childOrderColor = childOrderColor;
    }

    /**
     * 获取 退换货商品尺码
     */
    public String getChildOrderSize() {
        return this.childOrderSize;
    }

    /**
     * 设置 退换货商品尺码
     */
    public void setChildOrderSize(String childOrderSize) {
        this.childOrderSize = childOrderSize;
    }

    /**
     * 获取 退款商品单价
     */
    public String getRefundGoodsPrice() {
        return this.refundGoodsPrice;
    }

    /**
     * 设置 退款商品单价
     */
    public void setRefundGoodsPrice(String refundGoodsPrice) {
        this.refundGoodsPrice = refundGoodsPrice;
    }

    /**
     * 获取 最多可退货件数
     */
    public Integer getRefundNumber() {
        return this.refundNumber;
    }

    /**
     * 设置 最多可退货件数
     */
    public void setRefundNumber(Integer refundNumber) {
        this.refundNumber = refundNumber;
    }

    /**
     * 可退的其他金额(快递费,服务费),
     * 除了当前子单外,没有存在未完全退完的子单时,
     * 返回该值
     */
    public String getOtherRefundPrice() {
        return this.otherRefundPrice;
    }

    /**
     * 可退的其他金额(快递费,服务费),
     * 除了当前子单外,没有存在未完全退完的子单时,
     * 返回该值
     */
    public void setOtherRefundPrice(String otherRefundPrice) {
        this.otherRefundPrice = otherRefundPrice;
    }
}
