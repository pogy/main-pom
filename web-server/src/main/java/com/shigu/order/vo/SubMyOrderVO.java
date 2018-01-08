package com.shigu.order.vo;

import com.opentae.core.mybatis.config.Column;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class SubMyOrderVO {
    /**
     * 子单id
     */
    @Column("item_order_sub.soid")
    private Long childOrderId;

    /**
     * 	商品Id
     */
    @Column("item_order_sub.goods_id")
    private Long goodsId;
    /**
     * 商品标题
     */
    @Column("item_order_sub.title")
    private String title;
    /**
     * 商品图片链接
     */
    @Column("item_order_sub.pic_url")
    private String imgsrc;
    /**
     * 商品颜色
     */
    @Column("item_order_sub.color")
    private String color;
    /**
     * 	商品尺码
     */
    @Column("item_order_sub.size")
    private String size;
    /**
     * 	商品货号
     */
    @Column("item_order_sub.goods_no")
    private String goodsNo;
    /**
     * 商品单价
     */
    @Column("convert(item_order_sub.price*0.01,decimal(10,2))")
    private String price;
    /**
     * 	商品数量
     */
    @Column("item_order_sub.num")
    private Integer num;
    /**
     * 缺货数量
     */
    @Column("item_order_sub.out_of_stok")
    private Integer stockoutNum;


    /**
     * 已拿货数量
     */
    private Integer haveTakeGoodsNum;

    /**
     * 有货时间
     */
    @Column("item_order_sub.out_of_stok_reason")
    private String haveGoodsTime;

    private List<AfterSaleVO> afterSales;

    private Boolean hasAfter;

    private Integer refundCount;

    /**
     * 获取 子单id
     */
    public Long getChildOrderId() {
        return this.childOrderId;
    }

    /**
     * 设置 子单id
     */
    public void setChildOrderId(Long childOrderId) {
        this.childOrderId = childOrderId;
    }

    /**
     * 获取 	商品Id
     */
    public Long getGoodsId() {
        return this.goodsId;
    }

    /**
     * 设置 	商品Id
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取 商品标题
     */
    public String getTitle() {
        //TODO powell important 111
        if(StringUtils.isNotBlank(title)){
            title= KeyWordsUtil.duleKeyWords(title);
        }
        return this.title;
    }

    /**
     * 设置 商品标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取 商品图片链接
     */
    public String getImgsrc() {
        return this.imgsrc;
    }

    /**
     * 设置 商品图片链接
     */
    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    /**
     * 获取 商品颜色
     */
    public String getColor() {
        return this.color;
    }

    /**
     * 设置 商品颜色
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取 	商品尺码
     */
    public String getSize() {
        return this.size;
    }

    /**
     * 设置 	商品尺码
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * 获取 	商品货号
     */
    public String getGoodsNo() {
        return this.goodsNo;
    }

    /**
     * 设置 	商品货号
     */
    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    /**
     * 获取 商品单价
     */
    public String getPrice() {
        return this.price;
    }

    /**
     * 设置 商品单价
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 获取 	商品数量
     */
    public Integer getNum() {
        return this.num;
    }

    /**
     * 设置 	商品数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    public List<AfterSaleVO> getAfterSales() {
        return afterSales;
    }

    public void setAfterSales(List<AfterSaleVO> afterSales) {
        this.afterSales = afterSales;
    }


    public Integer getStockoutNum() {
        return stockoutNum;
    }

    public void setStockoutNum(Integer stockoutNum) {
        this.stockoutNum = stockoutNum;
    }

    public Boolean getHasAfter() {
        return this.hasAfter;
    }

    public void setHasAfter(Boolean hasAfter) {
        this.hasAfter = hasAfter;
    }

    public Integer getRefundCount() {
        return this.refundCount;
    }

    public void setRefundCount(Integer refundCount) {
        this.refundCount = refundCount;
    }

    public String getHaveGoodsTime() {
        return haveGoodsTime;
    }

    public void setHaveGoodsTime(String haveGoodsTime) {
        this.haveGoodsTime = haveGoodsTime;
    }
    public Integer getHaveTakeGoodsNum() {
        return haveTakeGoodsNum;
    }

    public void setHaveTakeGoodsNum(Integer haveTakeGoodsNum) {
        this.haveTakeGoodsNum = haveTakeGoodsNum;
    }
}
