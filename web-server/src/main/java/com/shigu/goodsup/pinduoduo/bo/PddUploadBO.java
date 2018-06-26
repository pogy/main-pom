package com.shigu.goodsup.pinduoduo.bo;

import java.io.Serializable;

/**
 * Created by gtx on 2018/6/26.
 *
 * @author gtx
 * @since
 */
public class PddUploadBO implements Serializable{
    /**
     * 标题
     */
    private String title;
    /**
     * 商品描述 字数限制：20-500
     */
    private String sellPoint;
    /**
     * 叶子类目ID
     */
    private Long cid;
    /**
     * 非必填 商品短标题（仅在部分活动中生效），字数限制为4-20字
     */
    private String smallTitle;
    /**
     * 市场价格 单位元
     */
    private String marketPrice;
    /**
     *承诺发货时间 0 24小时 1 48小时
     */
    private Integer delivery;
    /**
     * 物流运费模板ID
     */
    private Long postage_id;
    /**
     * 团购人数
     */
    private Integer grouponer;
    /**
     * 单次限量
     */
    private Integer singleLimit;
    /**
     * 限购次数
     */
    private Integer purchaseLimit;
    /**
     * 是否7天无理由退换货
     */
    private Integer returns;
    /**
     * 是否支持假一赔十\
     */
    private Integer artificial;
    /**
     * 商品goods外部编码
     */
    private String outerId;
    /**
     * 高清缩略图
     */
    private String hdThumbUrl;
    /**
     * 普通缩略图
     */
    private String thumbUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getSmallTitle() {
        return smallTitle;
    }

    public void setSmallTitle(String smallTitle) {
        this.smallTitle = smallTitle;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Long getPostage_id() {
        return postage_id;
    }

    public void setPostage_id(Long postage_id) {
        this.postage_id = postage_id;
    }

    public Integer getGrouponer() {
        return grouponer;
    }

    public void setGrouponer(Integer grouponer) {
        this.grouponer = grouponer;
    }

    public Integer getSingleLimit() {
        return singleLimit;
    }

    public void setSingleLimit(Integer singleLimit) {
        this.singleLimit = singleLimit;
    }

    public Integer getPurchaseLimit() {
        return purchaseLimit;
    }

    public void setPurchaseLimit(Integer purchaseLimit) {
        this.purchaseLimit = purchaseLimit;
    }

    public Integer getReturns() {
        return returns;
    }

    public void setReturns(Integer returns) {
        this.returns = returns;
    }

    public Integer getArtificial() {
        return artificial;
    }

    public void setArtificial(Integer artificial) {
        this.artificial = artificial;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }
}
