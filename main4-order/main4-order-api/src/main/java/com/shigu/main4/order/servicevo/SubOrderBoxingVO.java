package com.shigu.main4.order.servicevo;

/**
 * com.opentae.data.mall.beans.ItemOrderSub的包装类
 * Created by wanghaoxiang on 2017/8/2 0002.
 */
public class SubOrderBoxingVO {
    /**
     * soid
     */
    private Long soid;

    /**
     * 订单号
     */
    private Long oid;

    /**
     * 产品ID
     */
    private Long pid;

    /**
     * sku信息
     */
    private Long skuId;

    /**
     * 件数
     */
    private Integer num;

    /**
     * 到货数量
     */
    private Integer distributionNum;

    /**
     * 应付总额
     */
    private Long shouldPayMoney;

    /**
     * 实付
     */
    private Long payMoney;

    /**
     * 实退
     */
    private Long refundMoney;

    /**
     * 0初始状态，1已退，2已发
     */
    private Integer status;

    /**
     * 备注
     */
    private String mark;

    /**
     * 交易信息ID
     */
    private Long logisticsId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品链接
     */
    private String picUrl;

    /**
     * 分站
     */
    private String webSite;

    /**
     *
     */
    private String title;

    /**
     * 单价
     */
    private Long price;

    /**
     * 重量
     */
    private Long weight;

    /**
     * 尺码
     */
    private String size;

    /**
     * 颜色
     */
    private String color;

    /**
     * 货号
     */
    private String goodsNo;

    public void setSoid(Long soid) {
        this.soid = soid;
    }

    public Long getSoid() {
        return this.soid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOid() {
        return this.oid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getPid() {
        return this.pid;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSkuId() {
        return this.skuId;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setDistributionNum(Integer distributionNum) {
        this.distributionNum = distributionNum;
    }

    public Integer getDistributionNum() {
        return this.distributionNum;
    }

    public void setShouldPayMoney(Long shouldPayMoney) {
        this.shouldPayMoney = shouldPayMoney;
    }

    public Long getShouldPayMoney() {
        return this.shouldPayMoney;
    }

    public void setPayMoney(Long payMoney) {
        this.payMoney = payMoney;
    }

    public Long getPayMoney() {
        return this.payMoney;
    }

    public void setRefundMoney(Long refundMoney) {
        this.refundMoney = refundMoney;
    }

    public Long getRefundMoney() {
        return this.refundMoney;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return this.mark;
    }

    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }

    public Long getLogisticsId() {
        return this.logisticsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() {
        return this.goodsId;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getWebSite() {
        return this.webSite;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getWeight() {
        return this.weight;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return this.size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsNo() {
        return this.goodsNo;
    }
}
