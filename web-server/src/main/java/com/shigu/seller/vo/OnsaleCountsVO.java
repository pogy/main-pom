package com.shigu.seller.vo;

/**
 * 出售中的统计
 * Created by zhaohongbo on 17/3/9.
 */
public class OnsaleCountsVO {
    /** 出售中的商品数量 */
    private Integer sale;

    /** 仓库中宝贝 */
    private Integer store;

    /** 推荐宝贝数量 */
    private Integer tj;

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Integer getTj() {
        return tj;
    }

    public void setTj(Integer tj) {
        this.tj = tj;
    }
}
