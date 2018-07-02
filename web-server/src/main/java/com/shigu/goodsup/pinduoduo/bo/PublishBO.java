package com.shigu.goodsup.pinduoduo.bo;

/**
 * Created by gtx on 2018/6/18.
 *
 * @author gtx
 * @since
 */
public class PublishBO {
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 类目id
     */
    private Long cid;
    /**
     * 是否上传过
     */
    private Integer yesrepeat;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getYesrepeat() {
        return yesrepeat;
    }

    public void setYesrepeat(Integer yesrepeat) {
        this.yesrepeat = yesrepeat;
    }
}
