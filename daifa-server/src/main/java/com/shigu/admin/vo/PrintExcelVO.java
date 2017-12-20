package com.shigu.admin.vo;

import com.createExcel.confs.CellIndex;
import com.createExcel.confs.CellTitle;
import com.opentae.core.mybatis.config.Column;

public class PrintExcelVO {

    @CellIndex("0")
    @CellTitle("代发订单编号")
    @Column("daifa_order.df_trade_id")
    private Long dfTradeId;

    @CellIndex("1")
    @CellTitle("订单编号")
    @Column("daifa_order.trade_code")
    private String tradeCode;

    @CellIndex("2")
    @CellTitle("代发子单号")
    @Column("daifa_order.df_order_id")
    private Long dfOrderId;

    @CellIndex("3")
    @CellTitle("订单子单号")
    @Column("daifa_order.order_code")
    private String orderCode;

    @CellIndex("4")
    @CellTitle("折单号")
    @Column("daifa_order.order_partition_id")
    private String orderCodeSplit;

    @CellIndex("5")
    @CellTitle("市场")
    @Column("daifa_order.market_name")
    private String marketName;

    @CellIndex("6")
    @CellTitle("楼层")
    @Column("daifa_order.floor_name")
    private String floorName;

    @CellIndex("7")
    @CellTitle("档口")
    @Column("daifa_order.store_num")
    private String shopNum;

    @CellIndex("8")
    @CellTitle("货号")
    @Column("daifa_order.goods_code")
    private String goodsCode;

    @CellIndex("9")
    @CellTitle("商家编号")
    @Column("daifa_order.store_goods_code")
    private String storeGoodsCode;

    @CellIndex("10")
    @CellTitle("数量")
    @Column("daifa_order.goods_num")
    private Integer num;

    @CellIndex("11")
    @CellTitle("颜色尺码")
    @Column("daifa_order.prop_str")
    private String propStr;

    @CellIndex("12")
    @CellTitle("拿货状态")
    @Column("daifa_order.take_goods_status")
    private Integer takeGoodsStatus;

    @CellIndex("13")
    @CellTitle("退款状态")
    @Column("daifa_order.refund_status")
    private Integer refundStatus;

    public Integer getTakeGoodsStatus() {
        return takeGoodsStatus;
    }

    public void setTakeGoodsStatus(Integer takeGoodsStatus) {
        this.takeGoodsStatus = takeGoodsStatus;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }
    public Long getDfTradeId() {
        return dfTradeId;
    }

    public void setDfTradeId(Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public Long getDfOrderId() {
        return dfOrderId;
    }

    public void setDfOrderId(Long dfOrderId) {
        this.dfOrderId = dfOrderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderCodeSplit() {
        return orderCodeSplit;
    }

    public void setOrderCodeSplit(String orderCodeSplit) {
        this.orderCodeSplit = orderCodeSplit;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getStoreGoodsCode() {
        return storeGoodsCode;
    }

    public void setStoreGoodsCode(String storeGoodsCode) {
        this.storeGoodsCode = storeGoodsCode;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPropStr() {
        return propStr;
    }

    public void setPropStr(String propStr) {
        this.propStr = propStr;
    }
}
