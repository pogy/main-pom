package com.shigu.goodsup.pinduoduo.vo;

import java.io.Serializable;

/**
 * Created by gtx on 2018/6/21.
 * 利润模板
 * @author gtx
 * @since
 */
public class ProfitTemplate implements Serializable {

    private static final long serialVersionUID = 2198793093165832732L;
    /**
     * 类型 1 固定利润 2 批发价百分比
     */
    private Integer type;
    /**
     * 利润
     */
    private Integer profit;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }
}
