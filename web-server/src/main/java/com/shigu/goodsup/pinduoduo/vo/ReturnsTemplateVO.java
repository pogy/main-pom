package com.shigu.goodsup.pinduoduo.vo;

import java.io.Serializable;

/**
 * Created by gtx on 2018/6/18.
 *
 * @author gtx
 * @since
 */
public class ReturnsTemplateVO implements Serializable {
    /**
     * 发货承诺
     */
    private Integer delivery;
    /**
     * 7天无理由退换货
     */
    private Integer returns;
    /**
     * 假一赔十
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
