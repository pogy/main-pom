package com.shigu.main4.daifa.beans;

import com.opentae.core.mybatis.config.Column;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pc on 2017-08-11.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class GgoodsForPrint implements Serializable{
    @Transient
    private static final long serialVersionUID = 4094549609371998769L;
    @Column("daifa_ggoods.create_date")
    private String createDate;//创建时间 2017-10-11
    @Column("daifa_ggoods.take_goods_id")
    private Long takeGoodsId;//daifaggoods主键
    @Column("daifa_ggoods.goods_code")
    private String goodsCode;//货号
    @Column("daifa_ggoods.store_goods_code")
    private String storeGoodsCode;//商家编码
    @Column("daifa_ggoods.prop_str")
    private String propStr;//颜色尺码
    @Column("daifa_ggoods.single_pi_price")
    private String singlePiPrice;
    @Column("daifa_ggoods.store_num")
    private String storeNum;//档口号
    @Column("daifa_ggoods.df_trade_id")
    private Long dfTradeId;//订单id
    @Column("daifa_ggoods.df_order_id")
    private Long dfOrderId;//子弹id
    @Column("daifa_ggoods.print_barcode_status")
    private Integer printBarcodeStatus;//打印拿货码打印状态 1未打印2已打印
    @Column("daifa_ggoods.print_batch")
    private String printBatch;//打印批次
    @Column("daifa_order.bar_code_key_num")
    private String barCodeKeyNum;//子弹编号
    @Column("daifa_trade.receiver_name")
    private String recieverName;//收货人姓名
    @Column("daifa_trade.bar_code_key")
    private String barCodeKey;//主单编号
    @Column("daifa_trade.create_time")
    private Date createTime;//订单创建时间
    @Column("daifa_trade.buyer_nick")
    private String buyerNick;//买家昵称
    @Column("daifa_trade.goods_num")
    private Integer goodsNum;//商品数
    @Column("daifa_trade.express_name")
    private String expressName;
    @Column("daifa_trade.seller_id")
    private Long dfSellerId;
    @Column("daifa_trade.buyer_id")
    private Long buyerId;

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    public String getPropStr() {
        return propStr;
    }

    public void setPropStr(String propStr) {
        this.propStr = propStr;
    }

    public String getSinglePiPrice() {
        return singlePiPrice;
    }

    public void setSinglePiPrice(String singlePiPrice) {
        this.singlePiPrice = singlePiPrice;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public Long getDfTradeId() {
        return dfTradeId;
    }

    public void setDfTradeId(Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public Long getDfOrderId() {
        return dfOrderId;
    }

    public void setDfOrderId(Long dfOrderId) {
        this.dfOrderId = dfOrderId;
    }

    public String getBarCodeKeyNum() {
        return barCodeKeyNum;
    }

    public void setBarCodeKeyNum(String barCodeKeyNum) {
        this.barCodeKeyNum = barCodeKeyNum;
    }

    public String getRecieverName() {
        return recieverName;
    }

    public void setRecieverName(String recieverName) {
        this.recieverName = recieverName;
    }

    public String getBarCodeKey() {
        return barCodeKey;
    }

    public void setBarCodeKey(String barCodeKey) {
        this.barCodeKey = barCodeKey;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public String getCreateDate() {
        return createDate;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getPrintBarcodeStatus() {
        return printBarcodeStatus;
    }

    public void setPrintBarcodeStatus(Integer printBarcodeStatus) {
        this.printBarcodeStatus = printBarcodeStatus;
    }

    public Long getTakeGoodsId() {
        return takeGoodsId;
    }

    public void setTakeGoodsId(Long takeGoodsId) {
        this.takeGoodsId = takeGoodsId;
    }

    public String getPrintBatch() {
        return printBatch;
    }

    public void setPrintBatch(String printBatch) {
        this.printBatch = printBatch;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public Long getDfSellerId() {
        return this.dfSellerId;
    }

    public void setDfSellerId(Long dfSellerId) {
        this.dfSellerId = dfSellerId;
    }
}
