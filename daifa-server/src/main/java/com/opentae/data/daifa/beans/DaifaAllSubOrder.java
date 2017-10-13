package com.opentae.data.daifa.beans;

import com.opentae.core.mybatis.config.Column;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by pc on 2017-08-14.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class DaifaAllSubOrder implements Serializable{
    @Transient
    private static final long serialVersionUID = -4039183803628953148L;
    @Column("daifa_order.df_order_id")
    private Long childOrderId;//代发子单id

    @Column("daifa_order.order_code")
    private String orderCode;//订单子订单ID
    @Column("daifa_order.order_partition_id")
    private String orderPartitionId;//折单ID



    @Column("daifa_order.pic_path")
    private String imgSrc;//商品图片
    @Column("daifa_order.title")
    private String title;//商品标题
    @Column("daifa_order.prop_str")
    private String goodsProperty;//商品属性 颜色 尺码
    @Column("daifa_order.goods_code")
    private String goodsNo;//商品货号
    @Column("daifa_order.single_price")
    private String piPrice;//商品批发价
    @Column("daifa_order.single_pi_price")
    private String payPrice;//商品实际支付价
    @Column("daifa_order.goods_num")
    private Integer num;//商品数量
    @Column("daifa_order.single_services_fee")
    private String childServersFee;//子单服务费用
    @Column("daifa_order.order_remark")
    private String childRemark;//子弹备注
    @Column("daifa_order.allocat_status")
    private Integer allotState;//分配状态 1待分配2已分配
    @Column("daifa_order.take_goods_status")
    private Integer takeGoodsState;//拿货状态 0拿货中 1已拿到 2缺货
    @Column("DATE_FORMAT(daifa_order.have_goods_date,'%Y-%m-%d %H:%i:%s')")
    private String haveGoodsTime;//有货时间
    @Column("daifa_order.delist_is")
    private Boolean noSaleIs;//是否下架true不卖了下架 false还在卖 注：该处为是否标记下架
    @Column("daifa_order.refund_status")
    private Integer refundStatus;
    @Column("daifa_order.return_goods_status")
    private Integer returnGoodsStatus;//退货状态@1等待退货2已退货3退货失败
    @Column("daifa_order.change_status")
    private Integer changeStatus;//换货状态'1申请换货2已换货3换货失败发回4换货失败不发回'
    @Column("daifa_order.store_goods_code")
    private String storeGoodsCode; //商家编码


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(Long childOrderId) {
        this.childOrderId = childOrderId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    public String getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(String payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getChildServersFee() {
        return childServersFee;
    }

    public void setChildServersFee(String childServersFee) {
        this.childServersFee = childServersFee;
    }

    public String getChildRemark() {
        return childRemark;
    }

    public void setChildRemark(String childRemark) {
        this.childRemark = childRemark;
    }

    public Integer getAllotState() {
        return allotState;
    }

    public void setAllotState(Integer allotState) {
        this.allotState = allotState;
    }

    public Integer getTakeGoodsState() {
        return takeGoodsState;
    }

    public void setTakeGoodsState(Integer takeGoodsState) {
        this.takeGoodsState = takeGoodsState;
    }

    public String getHaveGoodsTime() {
        return haveGoodsTime;
    }

    public void setHaveGoodsTime(String haveGoodsTime) {
        this.haveGoodsTime = haveGoodsTime;
    }

    public Boolean getNoSaleIs () {
        return noSaleIs;
    }

    public void setNoSaleIs (Boolean noSaleIs) {
        this.noSaleIs = noSaleIs;
    }

    public Integer getReturnGoodsStatus() {
        return returnGoodsStatus;
    }

    public void setReturnGoodsStatus(Integer returnGoodsStatus) {
        this.returnGoodsStatus = returnGoodsStatus;
    }

    public Integer getChangeStatus() {
        return changeStatus;
    }

    public void setChangeStatus(Integer changeStatus) {
        this.changeStatus = changeStatus;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getStoreGoodsCode() {
        return storeGoodsCode;
    }

    public void setStoreGoodsCode(String storeGoodsCode) {
        this.storeGoodsCode = storeGoodsCode;
    }

    public String getOrderCode () {
        return orderCode;
    }

    public void setOrderCode (String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderPartitionId () {
        return orderPartitionId;
    }

    public void setOrderPartitionId (String orderPartitionId) {
        this.orderPartitionId = orderPartitionId;
    }
}
