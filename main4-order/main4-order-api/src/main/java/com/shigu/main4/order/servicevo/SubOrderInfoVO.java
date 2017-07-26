package com.shigu.main4.order.servicevo;

import com.shigu.main4.order.enums.AfterSaleStatusEnum;
import com.shigu.main4.order.enums.RefundTypeEnum;
import com.shigu.main4.order.enums.SubOrderStatus;

import java.io.Serializable;

/**
 * 子订单信息
 * Created by zhaohongbo on 17/7/14.
 */
public class SubOrderInfoVO implements Serializable{
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 子单ID
     */
    private Long childOrderId;
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

    /** 单价：前端要展现的字符串 */
    private String price;
    /**单价：接口传出来的数值*/
    private Long priceLong;
    /**子单中商品总数 */
    private Integer num;
    /** 退款数量 */
    private Integer tkNum;
    /** 售后退款数量 **/
    private Integer  shTkNum;

    /**
     * 子单状态, 0初始状态，1已退，2已发
     */
    private Integer subOrderStatus;

    private SubOrderStatus subStatusenum;
    /**
     * 退换货ID
     */
    private Long refundId;
    /**
     * 退款数量(已退和已申请退款的数量)
     */
    private Integer refundNum;
    /** 前端： 退款状态，0无，1退款成功  */
    private Integer tkState;
    /** 接口传出来的枚举型 */
    private RefundTypeEnum tkStateEnum;
    /**  前端：售后状态,  0无，1售后处理中，2已退款，3已换货, 4退款中, 5换货中 */
    private Integer shState;
    /** 接口传出来的枚举型 */
    private AfterSaleStatusEnum shStateEnum;

    /**
     * 获取 订单ID
     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * 设置 订单ID
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 子单ID
     */
    public Long getChildOrderId() {
        return this.childOrderId;
    }

    /**
     * 设置 子单ID
     */
    public void setChildOrderId(Long childOrderId) {
        this.childOrderId = childOrderId;
    }



    /**
     * 获取 单价
     */
    public String getPrice() {
        return this.price;
    }

    /**
     * 设置 单价
     */
    public void setPrice(String price) {
        this.price = price;
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
     * 子单状态, 0初始状态，1已退，2已发
     */

    public Integer getSubOrderStatus() {
        return subOrderStatus;
    }

    public void setSubOrderStatus(Integer subOrderStatus) {
        this.subOrderStatus = subOrderStatus;
    }

    /**
     * 获取 退换货ID
     */
    public Long getRefundId() {
        return this.refundId;
    }

    /**
     * 设置 退换货ID
     */
    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public String getImgsrc () {
        return imgsrc;
    }

    public void setImgsrc (String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getColor () {
        return color;
    }

    public void setColor (String color) {
        this.color = color;
    }

    public String getSize () {
        return size;
    }

    public void setSize (String size) {
        this.size = size;
    }

    public Integer getNum () {
        return num;
    }

    public void setNum (Integer num) {
        this.num = num;
    }

    public Integer getTkNum () {
        return tkNum;
    }

    public void setTkNum (Integer tkNum) {
        this.tkNum = tkNum;
    }

    public Integer getShTkNum () {
        return shTkNum;
    }

    public void setShTkNum (Integer shTkNum) {
        this.shTkNum = shTkNum;
    }


    public Long getPriceLong () {
        return priceLong;
    }

    public void setPriceLong (Long priceLong) {
        this.priceLong = priceLong;
    }

    public SubOrderStatus getSubStatusenum () {
        return subStatusenum;
    }

    public void setSubStatusenum (SubOrderStatus subStatusenum) {
        this.subStatusenum = subStatusenum;
    }

    /**
     * 获取 退款状态，0无，1申请，2自动
     */
    public Integer getTkState() {
        return this.tkState;
    }

    /**
     * 设置 退款状态，0无，1申请，2自动
     */
    public void setTkState(Integer tkState) {
        this.tkState = tkState;
    }

    /**
     * 获取 售后状态, 0无，1售后处理中，2已退款，3已换货
     */
    public Integer getShState() {
        return this.shState;
    }

    /**
     * 设置 售后状态, 0无，1售后处理中，2已退款，3已换货
     */
    public void setShState(Integer shState) {
        this.shState = shState;
    }

    public RefundTypeEnum getTkStateEnum() {
        return this.tkStateEnum;
    }

    public void setTkStateEnum(RefundTypeEnum tkStateEnum) {
        this.tkStateEnum = tkStateEnum;
    }

    public AfterSaleStatusEnum getShStateEnum() {
        return this.shStateEnum;
    }

    public void setShStateEnum(AfterSaleStatusEnum shStateEnum) {
        this.shStateEnum = shStateEnum;
    }
}
