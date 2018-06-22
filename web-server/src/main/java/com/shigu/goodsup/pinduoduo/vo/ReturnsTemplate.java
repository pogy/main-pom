package com.shigu.goodsup.pinduoduo.vo;

import java.io.Serializable;

/**
 * Created by gtx on 2018/6/18.
 *
 * @author gtx
 * @since
 */
public class ReturnsTemplate implements Serializable {
    /**
     * 发货承诺 0 24小时 1 48小时
     */
    private Integer delivery;
    /**
     * 7天无理由退换货 0 否 1 是
     */
    private Integer returns;
    /**
     * 假一赔十 0 否 1 是
     */
    private Integer artificial;

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
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
}
