package com.shigu.order.vo;

import com.opentae.core.mybatis.config.Column;

public class SubMyOrderVO {
    /**
     * 子单id
     */
    @Column("item_order_sub.soid")
    private Long childOrderId;

    /**
     * 售前id
     */
    @Column("item_order_refund.refund_id")
    private Long sqRefundId;
    /**
     * 	售后id
     */
    @Column("item_order_refund2.refund_id")
    private Long shRefundId;
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
     * 退款数量
     */
    @Column("item_order_refund.number")
    private Integer tkNum;
    /**
     * 售后退款数量
     */
    @Column("item_order_refund2.number")
    private Integer shTkNum;
    /**
     * 退款状态 0无，1:申请中,2:成功,3:拒绝
     */
    @Column("IF(item_order_refund.status=2,1,0)")
    private Integer tkState;
    /**
     * 	售后状态 0无，1售后处理中，2已退款，3已换货, 4退款中, 5换货中
     */
    @Column("IF(item_order_refund2.type=2,IF(item_order_refund2.status=2,2,IF(item_order_refund2.status=4,6,4)),IF(item_order_refund2.status=2,3,IF(item_order_refund2.status=4,7,5)))")
    private Integer shState;

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

    /**
     * 获取 退款数量
     */
    public Integer getTkNum() {
        return this.tkNum;
    }

    /**
     * 设置 退款数量
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
     * 获取 退款状态 0无，1退款成功(对应tkNum)
     */
    public Integer getTkState() {
        return this.tkState;
    }

    /**
     * 设置 退款状态 0无，1退款成功(对应tkNum)
     */
    public void setTkState(Integer tkState) {
        this.tkState = tkState;
    }

    /**
     * 获取 	售后状态 0无，1售后处理中，2已退款，3已换货, 4退款中, 5换货中
     */
    public Integer getShState() {
        return this.shState;
    }

    /**
     * 设置 	售后状态 0无，1售后处理中，2已退款，3已换货, 4退款中, 5换货中
     */
    public void setShState(Integer shState) {
        this.shState = shState;
    }

    /**
     * 获取 售前id
     */
    public Long getSqRefundId() {
        return this.sqRefundId;
    }

    /**
     * 设置 售前id
     */
    public void setSqRefundId(Long sqRefundId) {
        this.sqRefundId = sqRefundId;
    }

    /**
     * 获取 	售后id
     */
    public Long getShRefundId() {
        return this.shRefundId;
    }

    /**
     * 设置 	售后id
     */
    public void setShRefundId(Long shRefundId) {
        this.shRefundId = shRefundId;
    }
}
