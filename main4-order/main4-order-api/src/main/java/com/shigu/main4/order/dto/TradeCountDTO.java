package com.shigu.main4.order.dto;

import java.io.Serializable;

/**
 * 类名：TradeCountDTO
 * 类路径：com.shigu.main4.order.dto.TradeCountDTO
 * 创建者：王浩翔
 * 创建时间：2017-10-26 9:58
 * 项目：main-pom
 * 描述：推送到redis
 */
public class TradeCountDTO implements Serializable {
    public static final String TRADE_COUNT_REDIS_QUEUE_ = "trade_count_redis_queue_";
    //商品id
    private Long goodsId;
    //售出数量
    private Integer num;

    /**
     * 对销量进行累加
     * @param num
     */
    public void addNum(Integer num) {
        this.num += num;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


}
