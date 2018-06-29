package com.shigu.goodsup.pinduoduo.bo;


import org.apache.commons.lang3.StringUtils;
import java.io.Serializable;
import java.nio.charset.Charset;

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
     * 是否支持假一赔十
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
    /**
     * 主图
     */
    private String mainImg;
    /**
     * 面料含量
     */
    private String fabricContentCode;
    /**
     * 面料
     */
    private String goodsFabricCode;

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

    public String getHdThumbUrl() {
        return hdThumbUrl;
    }

    public void setHdThumbUrl(String hdThumbUrl) {
        this.hdThumbUrl = hdThumbUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public String getFabricContentCode() {
        return fabricContentCode;
    }

    public void setFabricContentCode(String fabricContentCode) {
        this.fabricContentCode = fabricContentCode;
    }

    public String getGoodsFabricCode() {
        return goodsFabricCode;
    }

    public void setGoodsFabricCode(String goodsFabricCode) {
        this.goodsFabricCode = goodsFabricCode;
    }

    public void canUpload(){
        if (StringUtils.isBlank(title)) {
            throw new IllegalArgumentException("商品标题不能为空");
        }
        if (StringUtils.isBlank(sellPoint)) {
            throw new IllegalArgumentException("商品描述不能为空");
        }
        if (cid == null) {
            throw new IllegalArgumentException("请选择类目");
        }
        if (StringUtils.isNotBlank(smallTitle)) {
            int length = smallTitle.getBytes(Charset.forName("GBK")).length;
            if (length < 4 || length > 20) {
                throw new IllegalArgumentException("短标题限制4-20字");
            }
        }else {
            smallTitle = null;
        }
        if (StringUtils.isBlank(marketPrice)) {
            throw new IllegalArgumentException("请填写市场价");
        }

        try {
            Double.parseDouble(marketPrice);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("请填写正确的市场价");
        }

        if (delivery == null || (delivery != 0 && delivery != 1)) {
            throw new IllegalArgumentException("请选择发货时间承诺时间");
        }
        if (postage_id == null) {
            throw new IllegalArgumentException("请选择运费模板");
        }

        if (grouponer == null || grouponer <=0 ) {
            throw new IllegalArgumentException("请填写正确的团购人数");
        }
        if (singleLimit == null || singleLimit <= 0) {
            throw new IllegalArgumentException("请填写正确的单次限量人数");
        }
        if (purchaseLimit == null || purchaseLimit <=0 ) {
            throw new IllegalArgumentException("请填写正确的限购次数");
        }
        if (returns == null || (returns != 0 && returns != 1)) {
            throw new IllegalArgumentException("请选择是否支持退换货承诺");
        }

        if (artificial == null || (artificial != 0 && artificial != 1)) {
            throw new IllegalArgumentException("请选择是否支持假一赔十");
        }
        if (StringUtils.isBlank(hdThumbUrl)) {
            throw new IllegalArgumentException("请上传高清缩略图");
        }
        if (StringUtils.isBlank(thumbUrl)) {
            throw new IllegalArgumentException("请上传普通缩略图");
        }
        if (StringUtils.isBlank(mainImg)) {
            throw new IllegalArgumentException("请上传商品主图");
        }

    }

}
